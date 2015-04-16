package dataserver;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.RXTXCommDriver;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.TooManyListenersException;

import org.hibernate.Transaction;

import model.Attribuer;
import model.Autoriser;
import model.Code;
import model.Historique;
import model.Salle;
import dao.AttribuerDAO;
import dao.AutoriserDAO;
import dao.BDDUtils;
import dao.CodeDAO;
import dao.HistoriqueDAO;
import dao.SalleDAO;

public class SerialManager extends Thread implements SerialPortEventListener{

	private CommPortIdentifier portId;
	private BufferedReader fluxLecture;
	private BufferedWriter fluxEcriture;
	private boolean running;

	//for containing the ports that will be found
	private Enumeration ports = null;
	//map the port names to CommPortIdentifiers
	private HashMap portMap = new HashMap();

	//this is the object that contains the opened port
//	private CommPortIdentifier selectedPortIdentifier = null;
	private SerialPort serialPort = null;

	//input and output streams for sending and receiving data
	//    private InputStream input = null;
	//    private OutputStream output = null;

	//just a boolean flag that i use for enabling
	//and disabling buttons depending on whether the program
	//is connected to a serial port or not
	//    private boolean bConnected = false;

	//the timeout value for connecting with the port
	final static int TIMEOUT = 2000;

	//some ascii values for for certain things
	final static int SPACE_ASCII = 32;
	final static int DASH_ASCII = 45;
	final static int NEW_LINE_ASCII = 10;

	//a string for recording what goes on in the program
	//this string is written to the GUI
	String logText = "";


	public SerialManager(){}

	/**
	 * Constructeur qui r�cup�re l'identifiant du port et lance l'ouverture.
	 */
	public void initialisation() {
		String port = searchForPorts();
		//initialisation du driver
		//A MODIFIER POUR LINUX
		RXTXCommDriver driver = new RXTXCommDriver();
		driver.initialize();

		//r�cup�ration de l'identifiant du port
		try {
			portId = CommPortIdentifier.getPortIdentifier(port);
		} catch (NoSuchPortException e) {
		}

		//ouverture du port
		try {
			serialPort = (SerialPort) portId.open("ModeEvenement", 2000);
		} catch (PortInUseException e) {
		}

		//r�cup�ration du flux
		try {
			fluxLecture =
					new BufferedReader(
							new InputStreamReader(serialPort.getInputStream()));
		} catch (IOException e) {
		}

		try {
			fluxEcriture = 
					new BufferedWriter(
							new OutputStreamWriter(serialPort.getOutputStream()));
		}catch (IOException e) {
			// TODO: handle exception
		}


		//ajout du listener
		try {
			serialPort.addEventListener(this);
		} catch (TooManyListenersException e) {
		}

		//param�trage du port
		serialPort.notifyOnDataAvailable(true);
		try {
			serialPort.setSerialPortParams(
					9600,
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);
		} catch (UnsupportedCommOperationException e) {
		}
		System.out.println("port ouvert, attente de lecture");


	}

	public String searchForPorts()
	{
		ports = CommPortIdentifier.getPortIdentifiers();

		while (ports.hasMoreElements())
		{
			CommPortIdentifier curPort = (CommPortIdentifier)ports.nextElement();

			//get only serial ports
			if (curPort.getPortType() == CommPortIdentifier.PORT_SERIAL)
			{
				return curPort.getName();
			}
			return "";
		}
		return "";
	}

	@Override
	public void run() {
		initialisation();
		running = true;
		while (running) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		}
		//fermeture du flux et port
		try {
			fluxLecture.close();
		} catch (IOException e) {
		}
		serialPort.close();
	}



	/**
	 * M�thode de gestion des �v�nements.
	 */
	public void serialEvent(SerialPortEvent event) {
		if (event.getEventType() == SerialPortEvent.DATA_AVAILABLE)
		{
			try
			{
				String retour = fluxLecture.readLine();
				System.out.println(retour);
				String codeValue = retour.substring(0, 10).toUpperCase();
				String salleNum = retour.substring(10).toUpperCase();
				System.out.println("valueCode : " +codeValue+ " numSalle : " +salleNum);
				verificationAcces(codeValue, salleNum);
			}
			catch (Exception e)
			{
				logText = "Failed to read data. (" + e.toString() + ")";

			}
		}
	}

	private void verificationAcces(String codeValue, String salleNum) {
		Transaction tx = null;
		boolean isActive = BDDUtils.getTransactionStatus();
		try {
			tx = BDDUtils.beginTransaction(isActive);
			Code c = CodeDAO.findByValue(codeValue);
			if(c != null) {
				Salle s = SalleDAO.findByNumSalle(salleNum);
				if(s != null) {
					List<Attribuer> la = AttribuerDAO.getAttribuersByCodeId(c.getId());
					if(la != null && !la.isEmpty()) {
						for (Attribuer attribuer : la) {
							if(attribuer.getDate_fin() == null || attribuer.getDate_fin().after(Calendar.getInstance())){
								List<Autoriser> lau = AutoriserDAO.getAutorisersByDroitId(attribuer.getId().getUtilisateur().getDroit().getId());
								if(lau != null && !lau.isEmpty()) {
									for (Autoriser autoriser : lau) {
										if(autoriser.getId().getSalle().getId() == s.getId()) {
											HistoriqueDAO.insert(new Historique(Calendar.getInstance(), attribuer.getId().getUtilisateur(), c, s));
											try {
												fluxEcriture.write("OPEN\r");
												fluxEcriture.flush();
											} catch (IOException e1) {
												e1.printStackTrace();
											}
											break;
										}
									}
								}
							}
						}
					}
				}
			}
			tx.commit();
		}catch(Exception ex) {
			System.out.println("Hibernate failure : "+ ex.getMessage());
			BDDUtils.rollback(isActive, tx);
		}
	}



	public void stopThread() {
		running = false;
	}

}
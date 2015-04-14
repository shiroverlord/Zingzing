package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import model.Connexion;
import model.Genre;
import model.TypeUtilisateur;
import model.Utilisateur;

public class ClientSingleton {
	private static ClientSingleton clientSingleton = null;
	private static RmiInterface iRMISingleton = null;
	
	private static TimerTask connectTimer = null;
	private static Timer t = new Timer();

	private static boolean isConnected = false;

	private ClientSingleton() {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			connect();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		startConnectionChecker();
	}

	private void startConnectionChecker() {
		if(connectTimer == null) {
			connectTimer = new TimerTask() {
				@Override
				public void run() {
					try {
						if(!isConnected) {
							System.out.println("Connexion au serveur Data");
							connect();
						}
					} catch (Exception e) {
						System.out.println(e.toString() + " -> Serveur Data non atteignable - Tentative de connexion ...");
					}
				}
			};
			t.scheduleAtFixedRate(connectTimer, 0, 4000l);
		}
	}

	public static boolean connect() throws MalformedURLException, RemoteException, NotBoundException {
		Remote r = Naming.lookup(RmiInterface.RMI_URL);
		if (r instanceof RmiInterface) {
			iRMISingleton = (RmiInterface) r;
			isConnected = true;
		}
		return isConnected;
	}	
	
	public static ClientSingleton getInstance() {
		if(clientSingleton == null) {
			clientSingleton = new ClientSingleton();
		}
		return clientSingleton;
	}
	
	public String getTestString() {
		String result = null;
		try {
			result = iRMISingleton.getTestString();
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getTestString();
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getTestString(): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public List<Utilisateur> getAllUsers() {
		List<Utilisateur> result = null;
		try {
			result = iRMISingleton.getAllUsers();
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getAllUsers();
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getAllUser(): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public Utilisateur getUserById(Long id) {
		Utilisateur result = null;
		try {
			result = iRMISingleton.getUserById(id);
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getUserById(id);
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getUserById(): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public List<Connexion> getAllConnexions() {
		List<Connexion> result = null;
		try {
			result = iRMISingleton.getAllConnexions();
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getAllConnexions();
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getAllConnexions(): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public Connexion getConnexionById(Long id) {
		Connexion result = null;
		try {
			result = iRMISingleton.getConnexionById(id);
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getConnexionById(id);
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getConnexionById(): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public List<TypeUtilisateur> getAllTypeUtilisateurs() {
		List<TypeUtilisateur> result = null;
		try {
			result = iRMISingleton.getAllTypeUtilisateurs();
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getAllTypeUtilisateurs();
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getAllTypeUtilisateurs(): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public TypeUtilisateur getTypeUtilisateurById(Long id) {
		TypeUtilisateur result = null;
		try {
			result = iRMISingleton.getTypeUtilisateurById(id);
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getTypeUtilisateurById(id);
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getTypeUtilisateurById(): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public List<Genre> getAllGenres() {
		List<Genre> result = null;
		try {
			result = iRMISingleton.getAllGenres();
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getAllGenres();
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getAllGenres(): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public Genre getGenreById(Long id) {
		Genre result = null;
		try {
			result = iRMISingleton.getGenreById(id);
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getGenreById(id);
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getGenreById(): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public static boolean isConnected() {
		return isConnected;
	}
}

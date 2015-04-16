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

import model.Attribuer;
import model.Autoriser;
import model.Code;
import model.Droit;
import model.Historique;
import model.Salle;
import model.Section;
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
							System.out.println("Section au serveur Data");
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
			System.out.println("Serveur Data non atteignable - iRMISingleton.getAllUsers(): "+e);
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
			System.out.println("Serveur Data non atteignable - iRMISingleton.getUserById(Long id): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public Utilisateur getUserByIdFull(Long id) {
		Utilisateur result = null;
		try {
			result = iRMISingleton.getUserByIdFull(id);
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getUserByIdFull(id);
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getUserByIdFull(Long id): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public List<Section> getAllSections() {
		List<Section> result = null;
		try {
			result = iRMISingleton.getAllSections();
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getAllSections();
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getAllSections(): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public Section getSectionById(Long id) {
		Section result = null;
		try {
			result = iRMISingleton.getSectionById(id);
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getSectionById(id);
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getSectionById(Long id): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public List<Droit> getAllDroits() {
		List<Droit> result = null;
		try {
			result = iRMISingleton.getAllDroits();
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getAllDroits();
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getAllDroits(): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public Droit getDroitById(Long id) {
		Droit result = null;
		try {
			result = iRMISingleton.getDroitById(id);
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getDroitById(id);
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getDroitById(Long id): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public List<Salle> getAllSalles() {
		List<Salle> result = null;
		try {
			result = iRMISingleton.getAllSalles();
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getAllSalles();
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getAllSalles(): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public Salle getSalleById(Long id) {
		Salle result = null;
		try {
			result = iRMISingleton.getSalleById(id);
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getSalleById(id);
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getSalleById(Long id): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public static boolean isConnected() {
		return isConnected;
	}
	
	public List<Code> getAllCodes() {
		List<Code> result = null;
		try {
			result = iRMISingleton.getAllCodes();
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getAllCodes();
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getAllCodes(): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public Code getCodeById(Long id) {
		Code result = null;
		try {
			result = iRMISingleton.getCodeById(id);
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getCodeById(id);
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getCodeById(Long id): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public List<Attribuer> getAllAttribuers() {
		List<Attribuer> result = null;
		try {
			result = iRMISingleton.getAllAttribuers();
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getAllAttribuers();
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getAllAttribuers(): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public List<Attribuer> getAttribuerByUtilisateurId(Long idUtilisateur) {
		List<Attribuer> result = null;
		try {
			result = iRMISingleton.getAttribuerByUtilisateurId(idUtilisateur);
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getAttribuerByUtilisateurId(idUtilisateur);
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getAttribuerByUtilisateurId(Long idUtilisateur): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public List<Attribuer> getAttribuerByCodeId(Long idCode) {
		List<Attribuer> result = null;
		try {
			result = iRMISingleton.getAttribuerByCodeId(idCode);
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getAttribuerByCodeId(idCode);
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getAttribuerByCodeId(Long idCode): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public List<Autoriser> getAllAutorisers() {
		List<Autoriser> result = null;
		try {
			result = iRMISingleton.getAllAutorisers();
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getAllAutorisers();
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getAllAutorisers(): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public List<Autoriser> getAutoriserByDroitId(Long idDroit) {
		List<Autoriser> result = null;
		try {
			result = iRMISingleton.getAutoriserByDroitId(idDroit);
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getAutoriserByDroitId(idDroit);
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getAutoriserByDroitId(Long idDroit): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public List<Autoriser> getAutoriserBySalleId(Long idSalle) {
		List<Autoriser> result = null;
		try {
			result = iRMISingleton.getAutoriserBySalleId(idSalle);
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getAutoriserBySalleId(idSalle);
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getAutoriserBySalleId(Long idSalle): "+e);
			isConnected = false;
		}
		return result;
	}
	public List<Historique> getAllHistoriques() {
		List<Historique> result = null;
		try {
			result = iRMISingleton.getAllHistoriques();
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getAllHistoriques();
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getAllHistoriques(): "+e);
			isConnected = false;
		}
		return result;
	}
	
	public Historique getHistoriqueById(Long id) {
		Historique result = null;
		try {
			result = iRMISingleton.getHistoriqueById(id);
		} 
		catch(NoSuchObjectException e) {
			try {
				connect();
				result = iRMISingleton.getHistoriqueById(id);
			} catch (Exception e1) {
				System.out.println("Serveur Data non atteignable : "+e1);
				isConnected = false;
			}
		}
		catch (Exception e) {
			System.out.println("Serveur Data non atteignable - iRMISingleton.getHistoriqueById(Long id): "+e);
			isConnected = false;
		}
		return result;
	}
}

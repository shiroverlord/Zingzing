package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.Connexion;
import model.Genre;
import model.TypeUtilisateur;
import model.Utilisateur;

public interface RmiInterface extends Remote {
	public static final int RMI_PORT = 1099;
	public static final String RMI_HOST = "localhost";
	public static final String RMI_NAME = "dataserverRMI";
	public static final String RMI_URL = "rmi://"+RMI_HOST+":"+RMI_PORT+"/"+RMI_NAME;
	
	public String getTestString() throws RemoteException;
	
	public List<Utilisateur> getAllUsers() throws RemoteException;
	public Utilisateur getUserById(Long id) throws RemoteException;
	public boolean insertUser(Utilisateur user) throws RemoteException;
	public boolean updateUser(Utilisateur user) throws RemoteException;
	
	public List<Connexion> getAllConnexions() throws RemoteException;
	public Connexion getConnexionById(Long id) throws RemoteException;
	
	public List<TypeUtilisateur> getAllTypeUtilisateurs() throws RemoteException;
	public TypeUtilisateur getTypeUtilisateurById(Long id) throws RemoteException;
	
	public List<Genre> getAllGenres() throws RemoteException;
	public Genre getGenreById(Long id) throws RemoteException;
	
	
}

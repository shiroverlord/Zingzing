package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import model.Connexion;
import model.Genre;
import model.TypeUtilisateur;
import model.Utilisateur;
import dao.ConnexionDAO;
import dao.GenreDAO;
import dao.TypeUtilisateurDAO;
import dao.UtilisateurDAO;

public class RmiImplementation extends UnicastRemoteObject implements RmiInterface, Serializable {
	private static final long serialVersionUID = 3179780543561837022L;

	public RmiImplementation() throws RemoteException {
		super(RmiInterface.RMI_PORT);//RmiInterface.RMI_PORT
	}

	@Override
	public String getTestString() throws RemoteException {
		return "test";
	}

	@Override
	public List<Utilisateur> getAllUsers() throws RemoteException {
		return UtilisateurDAO.getAllUsers();
	}

	@Override
	public Utilisateur getUserById(Long id) throws RemoteException {
		return UtilisateurDAO.findById(id);
	}

	@Override
	public boolean insertUser(Utilisateur user) throws RemoteException {
		return UtilisateurDAO.insert(user);
	}

	@Override
	public boolean updateUser(Utilisateur user) throws RemoteException {
		return UtilisateurDAO.update(user);
	}

	@Override
	public Connexion getConnexionById(Long id) throws RemoteException {
		return ConnexionDAO.findById(id);
	}

	@Override
	public TypeUtilisateur getTypeUtilisateurById(Long id) throws RemoteException {
		return TypeUtilisateurDAO.findById(id);
	}

	@Override
	public Genre getGenreById(Long id) throws RemoteException {
		return GenreDAO.findById(id);
	}

	@Override
	public List<Connexion> getAllConnexions() throws RemoteException {
		return ConnexionDAO.getAllConnexions();
	}

	@Override
	public List<TypeUtilisateur> getAllTypeUtilisateurs() throws RemoteException {
		return TypeUtilisateurDAO.getAllTypeUtilisateurs();
	}

	@Override
	public List<Genre> getAllGenres() throws RemoteException {
		return GenreDAO.getAllGenres();
	}
}

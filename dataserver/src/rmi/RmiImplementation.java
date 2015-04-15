package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import model.Attribuer;
import model.Autoriser;
import model.Code;
import model.Droit;
import model.Historique;
import model.Salle;
import model.Section;
import model.Utilisateur;
import dao.AttribuerDAO;
import dao.AutoriserDAO;
import dao.CodeDAO;
import dao.DroitDAO;
import dao.HistoriqueDAO;
import dao.SalleDAO;
import dao.SectionDAO;
import dao.UtilisateurDAO;

public class RmiImplementation extends UnicastRemoteObject implements RmiInterface, Serializable {
	private static final long serialVersionUID = 3179780543561837022L;

	public RmiImplementation() throws RemoteException {
		super(RmiInterface.RMI_PORT);//RmiInterface.RMI_PORT
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
	public boolean deleteUser(Utilisateur user) throws RemoteException {
		return UtilisateurDAO.delete(user);
	}

	@Override
	public List<Droit> getAllDroits() throws RemoteException {
		return DroitDAO.getAllDroits();
	}

	@Override
	public Droit getDroitById(Long id) throws RemoteException {
		return DroitDAO.findById(id);
	}

	@Override
	public boolean insertDroit(Droit droit) throws RemoteException {
		return DroitDAO.insert(droit);
	}

	@Override
	public boolean updateDroit(Droit droit) throws RemoteException {
		return DroitDAO.update(droit);
	}

	@Override
	public List<Code> getAllCodes() throws RemoteException {
		return CodeDAO.getAllCodes();
	}

	@Override
	public Code getCodeById(Long id) throws RemoteException {
		return CodeDAO.findById(id);
	}

	@Override
	public boolean insertCode(Code code) throws RemoteException {
		return CodeDAO.insert(code);
	}

	@Override
	public boolean updateCode(Code code) throws RemoteException {
		return CodeDAO.update(code);
	}

	@Override
	public List<Section> getAllSections() throws RemoteException {
		return SectionDAO.getAllSections();
	}

	@Override
	public Section getSectionById(Long id) throws RemoteException {
		return SectionDAO.findById(id);
	}

	@Override
	public boolean insertSection(Section section) throws RemoteException {
		return SectionDAO.insert(section);
	}

	@Override
	public boolean updateSection(Section section) throws RemoteException {
		return SectionDAO.update(section);
	}

	@Override
	public List<Salle> getAllSalles() throws RemoteException {
		return SalleDAO.getAllSalles();
	}

	@Override
	public Salle getSalleById(Long id) throws RemoteException {
		return SalleDAO.findById(id);
	}

	@Override
	public boolean insertSalle(Salle salle) throws RemoteException {
		return SalleDAO.insert(salle);
	}

	@Override
	public boolean updateSalle(Salle salle) throws RemoteException {
		return SalleDAO.update(salle);
	}

	@Override
	public List<Attribuer> getAllAttribuers() throws RemoteException {
		return AttribuerDAO.getAllAttribuers();
	}

	@Override
	public boolean insertAttribuer(Attribuer attribuer) throws RemoteException {
		return AttribuerDAO.insert(attribuer);
	}

	@Override
	public boolean updateAttribuer(Attribuer attribuer) throws RemoteException {
		return AttribuerDAO.update(attribuer);
	}

	@Override
	public List<Attribuer> getAttribuerByUtilisateurId(Long idUtilisateur) throws RemoteException {
		return AttribuerDAO.getAttribuersByUtilisateurId(idUtilisateur);
	}

	@Override
	public List<Attribuer> getAttribuerByCodeId(Long idCode) throws RemoteException {
		return AttribuerDAO.getAttribuersByCodeId(idCode);
	}

	@Override
	public List<Autoriser> getAllAutorisers() throws RemoteException {
		return AutoriserDAO.getAllAutorisers();
	}

	@Override
	public List<Autoriser> getAutoriserByDroitId(Long idDroit) throws RemoteException {
		return AutoriserDAO.getAutorisersByDroitId(idDroit);
	}

	@Override
	public List<Autoriser> getAutoriserBySalleId(Long idSalle) throws RemoteException {
		return AutoriserDAO.getAutorisersBySalleId(idSalle);
	}

	@Override
	public boolean insertAutoriser(Autoriser autoriser) throws RemoteException {
		return AutoriserDAO.insert(autoriser);
	}

	@Override
	public boolean updateAutoriser(Autoriser autoriser) throws RemoteException {
		return AutoriserDAO.update(autoriser);
	}

	@Override
	public List<Historique> getAllHistoriques() throws RemoteException {
		return HistoriqueDAO.getAllHistoriques();
	}

	@Override
	public Historique getHistoriqueById(Long id) throws RemoteException {
		return HistoriqueDAO.findById(id);
	}

	@Override
	public boolean insertHistorique(Historique historique) throws RemoteException {
		return HistoriqueDAO.insert(historique);
	}

	@Override
	public boolean updateHistorique(Historique historique) throws RemoteException {
		return HistoriqueDAO.update(historique);
	}
}

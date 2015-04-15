package dao;

import java.util.List;

import model.Autoriser;

import org.hibernate.Query;
import org.hibernate.Transaction;

public class AutoriserDAO {

	public static Autoriser findByIds(Long idDroit, Long idSalle) {
		Autoriser a = null;
		Transaction tx = null;
		boolean isActive = BDDUtils.getTransactionStatus();
		try {
			tx = BDDUtils.beginTransaction(isActive);
			Query q = null;
			q = BDDUtils.getCurrentSession().createQuery(
					"SELECT a FROM Autoriser a " +
					"WHERE a.autoriserId.linkedDroit.id = :idDroit " +
					"AND a.autoriserId.linkedSalle.id = :idSalle");
			q.setParameter("idDroit", idDroit);
			q.setParameter("id_salle", idSalle);
			a = (Autoriser) q.uniqueResult();
			BDDUtils.commit(isActive, tx);
		}
		catch(Exception ex) {
			System.out.println("Hibernate failure : "+ ex.getMessage());
			BDDUtils.rollback(isActive, tx);
		}
		return a;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Autoriser> getAutorisersByDroitId(Long idDroit) {
		List<Autoriser> la = null;
		Transaction tx = null;
		boolean isActive = BDDUtils.getTransactionStatus();
		try {
			tx = BDDUtils.beginTransaction(isActive);
			Query q = null;
			q = BDDUtils.getCurrentSession().createQuery(
					"SELECT a FROM Autoriser a " +
					"WHERE a.autoriserId.linkedDroit.id = :idDroit");
			q.setParameter("idDroit", idDroit);
			la = (List<Autoriser>) q.list();
			BDDUtils.commit(isActive, tx);
		}
		catch(Exception ex) {
			System.out.println("Hibernate failure : "+ ex.getMessage());
			BDDUtils.rollback(isActive, tx);
		}
		return la;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Autoriser> getAutorisersBySalleId(Long idSalle) {
		List<Autoriser> la = null;
		Transaction tx = null;
		boolean isActive = BDDUtils.getTransactionStatus();
		try {
			tx = BDDUtils.beginTransaction(isActive);
			Query q = null;
			q = BDDUtils.getCurrentSession().createQuery(
					"SELECT a FROM Autoriser a " +
					"WHERE a.autoriserId.linkedSalle.id = :idSalle");
			q.setParameter("idSalle", idSalle);
			la = (List<Autoriser>) q.list();
			BDDUtils.commit(isActive, tx);
		}
		catch(Exception ex) {
			System.out.println("Hibernate failure : "+ ex.getMessage());
			BDDUtils.rollback(isActive, tx);
		}
		return la;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Autoriser> getAllAutorisers() {
		List<Autoriser> la = null;
		Transaction tx = null;
		boolean isActive = BDDUtils.getTransactionStatus();
		try {
			tx = BDDUtils.beginTransaction(isActive);
			Query q = null;
			q = BDDUtils.getCurrentSession().createQuery("SELECT a FROM Autoriser a");
			la = (List<Autoriser>) q.list();
			BDDUtils.commit(isActive, tx);
		}
		catch(Exception ex) {
			System.out.println("Hibernate failure : "+ ex.getMessage());
			BDDUtils.rollback(isActive, tx);
		}
		return la;
	}
	
	public static boolean insert(Autoriser a) {
		Transaction tx = null;
		boolean isActive = BDDUtils.getTransactionStatus();
		try {
			tx = BDDUtils.beginTransaction(isActive);
			BDDUtils.getCurrentSession().save(a);
			BDDUtils.commit(isActive, tx);
		}
		catch(Exception ex) {
			System.out.println("Hibernate failure : "+ ex.getMessage());
			BDDUtils.rollback(isActive, tx);
			return false;
		}
		return true;
	}
	
	public static boolean update(Autoriser a) {
		Transaction tx = null;
		boolean isActive = BDDUtils.getTransactionStatus();
		try {
			tx = BDDUtils.beginTransaction(isActive);
			BDDUtils.getCurrentSession().update(a);
			BDDUtils.commit(isActive, tx);
		}
		catch(Exception ex) {
			System.out.println("Hibernate failure : "+ ex.getMessage());
			BDDUtils.rollback(isActive, tx);
			return false;
		}
		return true;
	}
	
	public static boolean delete(Autoriser a) {
		Transaction tx = null;
		boolean isActive = BDDUtils.getTransactionStatus();
		try {
			tx = BDDUtils.beginTransaction(isActive);
			BDDUtils.getCurrentSession().delete(a);
			BDDUtils.commit(isActive, tx);
		}
		catch(Exception ex) {
			System.out.println("Hibernate failure : "+ ex.getMessage());
			BDDUtils.rollback(isActive, tx);
			return false;
		}
		return true;
	}
}

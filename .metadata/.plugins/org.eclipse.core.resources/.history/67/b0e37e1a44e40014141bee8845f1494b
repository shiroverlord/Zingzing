package dao;

import java.util.List;

import model.Historique;

import org.hibernate.Query;
import org.hibernate.Transaction;

public class HistoriqueDAO {

	public static Historique findById(Long id) {
		Historique s = null;
		Transaction tx = null;
		boolean isActive = BDDUtils.getTransactionStatus();
		try {
			tx = BDDUtils.beginTransaction(isActive);
			Query q = null;
			q = BDDUtils.getCurrentSession().createQuery(
					"SELECT s FROM Historique s " +
					"WHERE s.id = :id");
			q.setParameter("id", id);
			s = (Historique) q.uniqueResult();
			BDDUtils.commit(isActive, tx);
		}
		catch(Exception ex) {
			System.out.println("Hibernate failure : "+ ex.getMessage());
			BDDUtils.rollback(isActive, tx);
		}
		return s;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Historique> getAllHistoriques() {
		List<Historique> ls = null;
		Transaction tx = null;
		boolean isActive = BDDUtils.getTransactionStatus();
		try {
			tx = BDDUtils.beginTransaction(isActive);
			Query q = null;
			q = BDDUtils.getCurrentSession().createQuery("SELECT s FROM Historique s");
			ls = (List<Historique>) q.list();
			BDDUtils.commit(isActive, tx);
		}
		catch(Exception ex) {
			System.out.println("Hibernate failure : "+ ex.getMessage());
			BDDUtils.rollback(isActive, tx);
		}
		return ls;
	}
	
	public static boolean insert(Historique s) {
		Transaction tx = null;
		boolean isActive = BDDUtils.getTransactionStatus();
		try {
			tx = BDDUtils.beginTransaction(isActive);
			BDDUtils.getCurrentSession().save(s);
			BDDUtils.commit(isActive, tx);
		}
		catch(Exception ex) {
			System.out.println("Hibernate failure : "+ ex.getMessage());
			BDDUtils.rollback(isActive, tx);
			return false;
		}
		return true;
	}
	
	public static boolean update(Historique s) {
		Transaction tx = null;
		boolean isActive = BDDUtils.getTransactionStatus();
		try {
			tx = BDDUtils.beginTransaction(isActive);
			BDDUtils.getCurrentSession().update(s);
			BDDUtils.commit(isActive, tx);
		}
		catch(Exception ex) {
			System.out.println("Hibernate failure : "+ ex.getMessage());
			BDDUtils.rollback(isActive, tx);
			return false;
		}
		return true;
	}
	
	public static boolean delete(Historique s) {
		Transaction tx = null;
		boolean isActive = BDDUtils.getTransactionStatus();
		try {
			tx = BDDUtils.beginTransaction(isActive);
			BDDUtils.getCurrentSession().delete(s);
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

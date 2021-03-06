package dao;

import java.util.List;

import model.Section;

import org.hibernate.Query;
import org.hibernate.Transaction;

public class SectionDAO {

	public static Section findById(Long id) {
		Section s = null;
		Transaction tx = null;
		boolean isActive = BDDUtils.getTransactionStatus();
		try {
			tx = BDDUtils.beginTransaction(isActive);
			Query q = null;
			q = BDDUtils.getCurrentSession().createQuery(
					"SELECT s FROM Section s " +
					"WHERE s.id = :id");
			q.setParameter("id", id);
			s = (Section) q.uniqueResult();
			BDDUtils.commit(isActive, tx);
		}
		catch(Exception ex) {
			System.out.println("Hibernate failure : "+ ex.getMessage());
			BDDUtils.rollback(isActive, tx);
		}
		return s;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Section> getAllSections() {
		List<Section> ls = null;
		Transaction tx = null;
		boolean isActive = BDDUtils.getTransactionStatus();
		try {
			tx = BDDUtils.beginTransaction(isActive);
			Query q = null;
			q = BDDUtils.getCurrentSession().createQuery("SELECT s FROM Section s");
			ls = (List<Section>) q.list();
			BDDUtils.commit(isActive, tx);
		}
		catch(Exception ex) {
			System.out.println("Hibernate failure : "+ ex.getMessage());
			BDDUtils.rollback(isActive, tx);
		}
		return ls;
	}
	
	public static boolean insert(Section s) {
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
	
	public static boolean update(Section s) {
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
	
	public static boolean delete(Section s) {
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

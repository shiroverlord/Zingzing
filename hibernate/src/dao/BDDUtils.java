package dao;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class BDDUtils {

	public static String CONFIG_FILE = System.getProperty("user.dir") + "/hibernate.cfg.xml";
	protected static SessionFactory sessionFactory;
	
	private static void buildSessionFactory() {
		if (sessionFactory==null) {
			Configuration config = new Configuration().configure(new File(CONFIG_FILE));
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			sessionFactory = config.buildSessionFactory(ssr);
		}
	}

	protected static Session getCurrentSession() throws HibernateException {
		return getSessionFactory().getCurrentSession();
	}

	protected static SessionFactory getSessionFactory() throws HibernateException {
		if(sessionFactory == null) {
			buildSessionFactory();
		}
		return sessionFactory;
	}

	public static boolean getTransactionStatus() throws HibernateException {
		return getCurrentSession().getTransaction().isActive();
	}
	
	public static Transaction beginTransaction(boolean isActive) throws HibernateException {
		if(!isActive) {
			return getSessionFactory().getCurrentSession().beginTransaction();
		}
		return null;
	}
	
	public static void commit(boolean isActive, Transaction tx) throws HibernateException {
		if(!isActive) {
			tx.commit();
		}
	}
	
	public static void rollback(boolean isActive, Transaction tx) throws HibernateException {
		if(!isActive && tx != null) {
			tx.rollback();
		}
	}
}

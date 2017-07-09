package demo;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.itsci.fingerprint.model.*;

public class HibernateConnection {
	public static SessionFactory sessionFactory;

	public static SessionFactory doHibernateConnection() {
		Properties database = new Properties();
		database.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		database.setProperty("hibernate.connection.username", "root");
		database.setProperty("hibernate.connection.password", "complete12demon");
		database.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3307/fingerprint2560?characterEncoding=UTF-8");
		database.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		Configuration cfg = new Configuration().setProperties(database).addPackage("com.itsci.fingerprint.model")
				.addAnnotatedClass(Past.class).addAnnotatedClass(Person.class).addAnnotatedClass(FingerprintData.class)
				.addAnnotatedClass(Major.class).addAnnotatedClass(Faculty.class).addAnnotatedClass(Parent.class).addAnnotatedClass(Student.class);

		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		sessionFactory = cfg.buildSessionFactory(ssrb.build());
		return sessionFactory;
	}

}

package com.cuong;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory	sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			SessionFactory session = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			return session;
		}
		catch(Exception e) {
			System.out.printf("Loi: %s", e.getMessage());
			StandardServiceRegistryBuilder.destroy(registry);
		}
		return null;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

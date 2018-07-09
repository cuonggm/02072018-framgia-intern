package com.cuong;

import java.util.Set;
import org.hibernate.Session;

public class PersonManager {
	public static void main(String[] argv) {
		PersonManager manager = new PersonManager();
		
//		manager.addNewPerson(23, "Cuong", "Giap Minh");
		
//		manager.addEmailAdress(1, "cuonggm48@gmail.com");
//		manager.addEmailAdress(1, "cuonggm482@gmail.com");
//		manager.addEmailAdress(1, "cuonggm483@gmail.com");
//		manager.addEmailAdress(1, "cuonggm484@gmail.com");
		
		manager.getEmailAddresses(1);
		
	}
	
	public long addNewPerson(int age, String firstName, String lastName) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Person p = new Person();
		p.setAge(age);
		p.setFirstName(firstName);
		p.setLastName(lastName);
		session.save(p);
		session.getTransaction().commit();
		return p.getId();
	}
	
	public void addEventToPerson(long personId, long eventId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Person p = session.load(Person.class, personId);
		Event e = session.load(Event.class, eventId);
		p.getEvents().add(e);
		session.getTransaction().commit();
	}
	
	public void addEmailAdress(long personId, String email) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Person p = (Person) session.load(Person.class, personId);
		p.getEmailAddresses().add(email);
		session.getTransaction().commit();
	}
	
	public void getEmailAddresses(long personId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Person p = (Person) session.load(Person.class, personId);
		Set<String> emails = p.getEmailAddresses();
		if(!emails.isEmpty()) {
			System.out.printf("%d\n", emails.size());
			for(String e : emails) {
				System.out.println(e);
			}
		}
		session.getTransaction().commit();
	}
}

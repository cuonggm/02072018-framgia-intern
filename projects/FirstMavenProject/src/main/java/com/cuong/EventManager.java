package com.cuong;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

public class EventManager {
	
	public long addNewEvent(String title, Date theDate) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Event event = new Event();
		event.setTitle(title);
		event.setDate(theDate);
		session.save(event);
		session.getTransaction().commit();
		return event.getId();
	}
	
	public void showAllEvents() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Event> result = session.createQuery("from Event").list();
		session.getTransaction().commit();
		for(Event e : result) {
			System.out.printf("id=%d, title=%s, date=%s\n", e.getId(), e.getTitle(), e.getDate());
		}
	}
}

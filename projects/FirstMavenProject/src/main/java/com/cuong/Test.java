package com.cuong;

import java.util.Date;

public class Test {
	public static void main(String[] argv) {
		System.out.println("Start");
		
		PersonManager pManager = new PersonManager();
		EventManager eManager = new EventManager();
		
		long pId = pManager.addNewPerson(1, "Cuong", "Giap Minh");
		long eId = eManager.addNewEvent("Di choi voi gau", new Date());
		pManager.addEventToPerson(pId, eId);
		
		System.out.println("End");
	}
}

package servletsForHomework;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
// import javax.application.Application;

public class FirstConcurrentHashMap /* extends Application */ {

	public static void printUser (User user) {
		System.out.println(user.id);
		System.out.println(user.firstName);
		System.out.println(user.lastName);
		System.out.println(user.username);
		System.out.println(user.password);
		System.out.println(user.dob);
		System.out.println("+++++++++++++++");
		
	}
	
	public static void main(String[] args) {

		Date d1 = new Date(3/12/1999);
		Date d2 = new Date(8/07/1999);
		Date d3 = new Date(2/02/1999);
		Date d4 = new Date(10/11/1999);
		Date d5 = new Date(19/02/1999);
		
		
		User u1 =  new User(1,"Mike", "Jones", "mjones", "pw1", d1);
		User u2 =  new User(2,"Alan", "Smith", "asmith", "pw2", d2);
		User u3 =  new User(5,"Pegg", "Antte", "pannte", "pw3", d3);
		User u4 =  new User(87,"Jeff", "Miler", "jmiler", "pw4", d4);
		User u5 =  new User(64,"Hall", "Themm", "hthemm", "pw5", d5);
		
 		// ConcurrentHashMap
		Map<String, User> myMap = new ConcurrentHashMap<String, User>();
		
		myMap.put("1", u1);
		myMap.put("2", u2);
		myMap.put("3", u3);
		myMap.put("4", u4);
		myMap.put("5", u5);
		
		System.out.println("***********************************");
		System.out.println("ConcurrentHashMap before iterator: ");
		for (String k : myMap.keySet()) {
			printUser(myMap.get(k));
		}
		Iterator<String> it = myMap.keySet().iterator();

		while (it.hasNext()) {
			String key = it.next();
			if (key.equals("3")) {
				myMap.put(key + "new", new User(666, "Freddie", "DeDeville", "FreddieDD", "pw666", new Date()));
			} else if (key.equals("5")) {
				myMap.put(key, new User(5, "This", "Dummy", "tdummy", "pw5.1", new Date(03/04/2000)));
			}
		}
		
		
		// CRUD
		// Create   .put
		// Replace  .replace
		// Update	.replace
		// Delete	.remove
		
//		myMap.
		
		System.out.println("***********************************");
		System.out.println("ConcurrentHashMap after iterator: ");
		for (String k : myMap.keySet()) {
			printUser(myMap.get(k));
		}

//		// HashMap
//		Map<String, User> myMap2 = new HashMap<String, User>();
//		myMap2.put("1", u1);
//		myMap2.put("2", u2);
//		myMap2.put("3", u3);
//		myMap2.put("4", u4);
//		myMap2.put("5", u5);

		System.out.println("***********************************");
//		System.out.println("HashMap before iterator: ");
//		for (String k : myMap2.keySet()) {
//			printUser(myMap2.get(k));
//		}
//		Iterator<String> it1 = myMap2.keySet().iterator();
//
//		while (it1.hasNext()) {
//			String key = it1.next();
//			if (key.equals("3"))
//				myMap2.put(key + "new", new User(666, "Freddie", "DeDeville", "FreddieDD", "pw666", new Date()));
//		}
//		
//		System.out.println("***********************************");
//		System.out.println("HashMap after iterator: ");
//		for (String k : myMap2.keySet()) {
//			printUser(myMap2.get(k));
//		}
	}

}

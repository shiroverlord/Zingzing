package test;

import rmi.ClientSingleton;

public class Main {
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("java.security.policy", "client.policy");
		ClientSingleton clientS = ClientSingleton.getInstance();
		if(clientS != null) {
			System.out.println("Test Connexions = " + clientS.getAllConnexions());
			
			System.out.println("Test TypeUtilisateurs = " + clientS.getAllTypeUtilisateurs());
			
			System.out.println("Test Genres = " + clientS.getAllGenres());
			
			System.out.println("Test Utilisateurs = " + clientS.getAllUsers());
		}
	}
}
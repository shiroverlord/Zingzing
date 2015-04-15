package test;

import rmi.ClientSingleton;

public class Main {
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("java.security.policy", "client.policy");
		ClientSingleton clientS = ClientSingleton.getInstance();
		if(clientS != null) {
			System.out.println("Test Section = " + clientS.getAllSections());
			
			System.out.println("Test Salle = " + clientS.getAllSalles());
			
			System.out.println("Test Droit = " + clientS.getAllDroits());
			
			System.out.println("Test Code = " + clientS.getAllCodes());
			
			System.out.println("Test Attribuer = " + clientS.getAllAttribuers());
			
			System.out.println("Test Autoriser = " + clientS.getAllAutorisers());
			
			System.out.println("Test Utilisateurs = " + clientS.getAllUsers());
			
			System.out.println("Test Historique = " + clientS.getAllHistoriques());
		}
	}
}
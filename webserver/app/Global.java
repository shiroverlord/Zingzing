

import play.Application;
import play.GlobalSettings;
import play.Logger;
import rmi.ClientSingleton;

public class Global extends GlobalSettings {
	@Override
	public void beforeStart(Application app) {
		Logger.info("server play before start");
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("java.security.policy", "client.policy");
		if (System.getSecurityManager() == null) {      
			System.setSecurityManager(new SecurityManager());    
		}
		controllers.Application.clientRMI = ClientSingleton.getInstance();
	}

	@Override
	public void onStart(Application app) {
		Logger.info("server play starting");
	}

	@Override
	public void onStop(Application app) {
		Logger.info("server play stopping");
	}
}

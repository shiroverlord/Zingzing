/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package heavyApp;

import rmi.ClientSingleton;

/**
 *
 * @author valga_000
 */


public class SourceIHM {

	public static ClientSingleton client = ClientSingleton.getInstance();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Link link = new Link();
        
        IHM ihm = new IHM(link);
        ihm.setVisible(true);
    }
    
}

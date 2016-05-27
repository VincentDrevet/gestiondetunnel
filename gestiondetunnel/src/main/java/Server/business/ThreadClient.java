/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.business;

import Server.dao.FactoryVoiture;
import Server.dao.FileAttenteUtils;
import Server.dao.VoitureUtils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vauban
 */
public class ThreadClient implements Runnable{
    
    
     private ServerSocket serverSocket;
    private Socket socket;

    
    
    
    public ThreadClient(Socket socket) {
        
        
        
        
        this.socket = socket;
        
    }
    
    
       @Override
    public void run() {
    
        System.out.println("nouveau client");
        
         try {
             BufferedReader buffer = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    
             //Creation d'un flux binaire
             DataOutputStream dos = new DataOutputStream(this.socket.getOutputStream());
             dos.writeUTF("Bonjour merci de saisir votre immatriculation");
             
             String immatriculation = buffer.readLine();
             Voiture nouvelleVoiture = FactoryVoiture.creeVoiture(immatriculation);
             
             
             FileAttenteUtils.ajouterVoiture(nouvelleVoiture);
      
             
             
         } catch (IOException ex) {
             Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         
         
         
         
        
        
    }
    
}





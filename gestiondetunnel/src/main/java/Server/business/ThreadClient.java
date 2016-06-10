/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.business;

import static Server.Main.allThread;
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
public class ThreadClient extends Thread {
    
    
     private ServerSocket serverSocket;
    private Socket socket;
    private int idThread;

    public int getIdThread() {
        return idThread;
    }

    public void setIdThread(int idThread) {
        this.idThread = idThread;
    }

    
   
    
    public ThreadClient(Socket socket) {

        this.socket = socket;
      
    }
    
//    public void start(){
//        System.out.println("debut start");
//        this.run();
//        System.out.println("Fin start");
//    }
    public void passage() throws InterruptedException 
    {
        
        DataOutputStream dos;
         try {
             dos = new DataOutputStream(this.socket.getOutputStream());
             dos.writeUTF("C'est à votre tour, vous entrer dans le tunnel");
            this.sleep(15000);
            dos.writeUTF("Vous sortez du tunnel, Bonne Journée");
            
         } catch (IOException ex) {
             Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
    }
       @Override
    public void run() {
    
        System.out.println("nouveau client");
        
         try {
             BufferedReader buffer = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    
             //Creation d'un flux binaire
             DataOutputStream dos = new DataOutputStream(this.socket.getOutputStream());
             dos.writeUTF("Bonjour merci de saisir votre immatriculation");
             dos.flush();
             String immatriculation = buffer.readLine();
             
             Voiture nouvelleVoiture = FactoryVoiture.creeVoiture(immatriculation);
             
             
             FileAttente fileAttenteChoisis;
            fileAttenteChoisis = FileAttenteUtils.ajouterVoiture(nouvelleVoiture);
             
             dos.writeUTF("Votre immatriculation est : "+nouvelleVoiture.getPlaqueImmatriculation() + "Et votre place dans votre file est : "+fileAttenteChoisis.getNombreVoiture()+". Merci d'attendre votre tour ...");
             dos.flush();
             System.out.println("enregistrement plaque");
       
                this.setIdThread(nouvelleVoiture.getId());
             allThread.put(this.getIdThread(), this);
             
         } catch (IOException ex) {
             Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         
         
         
         
        
        
    }
    
}





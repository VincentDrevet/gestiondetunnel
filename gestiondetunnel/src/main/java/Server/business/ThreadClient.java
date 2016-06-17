/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.business;

import Server.Main;
import static Server.Main.allThread;
import Server.dao.FactoryVoiture;
import Server.dao.FileAttenteUtils;
import Server.dao.HistoriqueUtils;
import Server.dao.VoitureUtils;
import java.io.BufferedReader;
import java.io.DataInputStream;
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
    public void passage() throws InterruptedException 
    {
        
        DataOutputStream dos;
         try {
             dos = new DataOutputStream(this.socket.getOutputStream());
             dos.writeUTF("C'est à votre tour, vous entrer dans le tunnel");
             HistoriqueUtils.getHistorique(idThread).setDateEntreeTunnel(new java.util.Date());
             HistoriqueUtils.getHistorique(idThread).setEtatEnCours(3);
//            this.sleep(45000);
//            dos.writeUTF("Vous sortez du tunnel, Bonne Journée");
//            this.socket.close();
         } catch (IOException ex) {
             Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
    }
       @Override
    public void run() {
    
        System.out.println("nouveau client");
        
         try {
             
//          
//             BufferedReader buffer = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
              
            DataInputStream dis = new DataInputStream(this.socket.getInputStream());
             //Creation d'un flux binaire
             DataOutputStream dos = new DataOutputStream(this.socket.getOutputStream());
             dos.writeUTF("Bonjour merci de saisir votre immatriculation");
             dos.flush();
             // Création de l'historique
             Historique nouvelleHistorique = new Historique();
             nouvelleHistorique.setDateConnexion(new java.util.Date());
             nouvelleHistorique.setEtatEnCours(1);
             
             // Demande de l'immatriculation
             String immatriculation = dis.readUTF();
             Voiture nouvelleVoiture = FactoryVoiture.creeVoiture(immatriculation);
             // Modif de l'historique
             nouvelleHistorique.setDateArriveFile(new java.util.Date());
             nouvelleHistorique.setVoiture(nouvelleVoiture);
             nouvelleHistorique.setId(nouvelleVoiture.getId());
             nouvelleHistorique.setEtatEnCours(2);
             // Stokage de l'historique
             Main.allHistorique.put(nouvelleHistorique.getId(), nouvelleHistorique);
             
             FileAttente fileAttenteChoisis;
            fileAttenteChoisis = FileAttenteUtils.ajouterVoiture(nouvelleVoiture);
             
             dos.writeUTF(" Votre immatriculation est : "+nouvelleVoiture.getPlaqueImmatriculation() + "Vous êtes dans la file : "+fileAttenteChoisis.getId()+" et votre place dans la file est : "+fileAttenteChoisis.getNombreVoiture()+". Merci d'attendre votre tour ...");
             dos.flush();
             System.out.println("enregistrement plaque");
       
                this.setIdThread(nouvelleVoiture.getId());
             allThread.put(this.getIdThread(), this);
             
         } catch (IOException ex) {
             Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         
         
         
         
        
        
    }
    
}





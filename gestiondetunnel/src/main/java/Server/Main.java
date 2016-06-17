/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Server.business.FileAttente;
import Server.business.Historique;
import Server.business.ThreadAdmin;
import Server.business.ThreadPrincipal;
import Server.business.ThreadClient;
import Server.business.ThreadFileAttente;
import Server.business.Voiture;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vauban
 */
public class Main {
    
            public static Map allThread = new HashMap<Integer, ThreadClient>();
            public static Map allListAttente = new HashMap<Integer, FileAttente>();
            public static Map allHistorique = new HashMap<Integer, Historique>();
            public static void main(String[] args){
   
            
                
                //demande de saisie nombre files
            Voiture.idMax = 0;
            System.out.println("Merci de saisir le nombre de files à activer");
            Scanner entree = new Scanner(System.in);
            int nombreFile = entree.nextInt();
            
            
            //Creation des files + enregistrement dans une hashmaps
            for(int i = 0; i<nombreFile;i++)
            {
                FileAttente nvFile = new FileAttente(i);
                allListAttente.put(nvFile.getId(), nvFile);
            }
            
            //affectation d'un socket au thread "Fileattente" et demarrage
            Socket socketFileAttente = new Socket();
            ThreadFileAttente threadFileAttente;
            threadFileAttente = new ThreadFileAttente(socketFileAttente);
            threadFileAttente.start(); 
            
            //creation du thread administration
            ThreadAdmin threadAdmin;
            threadAdmin = new ThreadAdmin();
            threadAdmin.start();
            
            //initialisation du socket principal
             ServerSocket serverSocket;
             try {
                 
                 serverSocket = new ServerSocket(60000);
                 while(true){
                         
// Ajout d'un client
                    try {
                        ThreadClient threadEcoute;
                        threadEcoute = new ThreadClient(serverSocket.accept());
                        threadEcoute.start();
                    } catch (IOException ex) {
                        Logger.getLogger(ThreadPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                 }
                 
                    
                     
                     
                 //erreur
             } catch (IOException ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             
             
         }
}

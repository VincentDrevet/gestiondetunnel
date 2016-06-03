/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Server.business.FileAttente;
import Server.business.ThreadPrincipal;
import Server.business.ThreadClient;
import Server.business.ThreadFileAttente;
import Server.business.Voiture;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vauban
 */
public class Main {
    
            public static FileAttente file1 = new FileAttente(1);
            public static FileAttente file2 = new FileAttente(2);
            public static FileAttente file3 = new FileAttente(3);
            public static FileAttente file4 = new FileAttente(4);
            
         public static void main(String[] args){
   
             Voiture.idMax = 0;
            System.out.println("test");
            Socket socketFileAttente = new Socket();
//            ThreadFileAttente threadFileAttente;
//            threadFileAttente = new ThreadFileAttente(socketFileAttente);
//            threadFileAttente.start(); 
                     
            
             ServerSocket serverSocket;
             try {
                 
                 serverSocket = new ServerSocket(60000);
//                 Socket communication = new Socket();
                
                 
//                 Thread threadEcoute = new Thread(serverSocket,serverSocket.accept());
//                 threadEcoute.run();
                 while(true){
                         
// Ajout d'un client
                    ThreadClient threadEcoute;
                    try {
                        threadEcoute = new ThreadClient(serverSocket.accept());
                        threadEcoute.start();
                    } catch (IOException ex) {
                        Logger.getLogger(ThreadPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 
                 //Thread thread2 = new Thread(serverSocket);
                //Thread thread3 = new Thread(serverSocket);
                 //Thread thread4 = new Thread(serverSocket);
                 
                 //Thread thread2 = new Thread(serverSocket);
                //Thread thread3 = new Thread(serverSocket);
                 //Thread thread4 = new Thread(serverSocket);
                 
                 }
                 
                    
                     
                     
                 
             } catch (IOException ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             
             
             
             
             
         }
}

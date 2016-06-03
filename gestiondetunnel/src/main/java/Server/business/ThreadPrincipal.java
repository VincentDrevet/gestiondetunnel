/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.business;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vauban
 */
public class ThreadPrincipal implements Runnable {

    private ServerSocket serverSocket;
    private Socket socket;

    
    
    
    public ThreadPrincipal(ServerSocket serverSocket, Socket socket) {
        this.serverSocket = serverSocket;
        this.socket = socket;
        
    }

    
    @Override
    public void run() {
        
        
        
        System.out.println("Lancement thread principal");
            
//         ThreadFileAttente threadFileAttente;
//         try {
//                threadFileAttente = new ThreadFileAttente(this.serverSocket.accept());
//                 threadFileAttente.run();
//            } catch (IOException ex) {
//                Logger.getLogger(Thread.class.getName()).log(Level.SEVERE, null, ex);
//            }     
        
        
            while(true){
                     
                    
                     
                     ThreadClient threadEcoute;
            try {
                threadEcoute = new ThreadClient(this.serverSocket.accept());
                 threadEcoute.run();
            } catch (IOException ex) {
                Logger.getLogger(ThreadPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            
            System.out.println("test");
                 
                 //Thread thread2 = new Thread(serverSocket);
                //Thread thread3 = new Thread(serverSocket);
                 //Thread thread4 = new Thread(serverSocket);
                 
            }
                 
            
        
        
        
        
        
        
        
        
    }
    
    
   
        
        
    
}

    
    
    
    
    
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Server.business.Thread;

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
    
    
    
         public static void main(String[] args){
   
             
             
             
             
             
            System.out.println("test");
             ServerSocket serverSocket;
             try {
                 
                 serverSocket = new ServerSocket(60000);
                 Socket communication = new Socket();
                
                 
                 Thread threadEcoute = new Thread(serverSocket,serverSocket.accept());
                 threadEcoute.run();
                 while(true){
                     
                 
                 
                 //Thread thread2 = new Thread(serverSocket);
                //Thread thread3 = new Thread(serverSocket);
                 //Thread thread4 = new Thread(serverSocket);
                 
                 }
                 
                 
             } catch (IOException ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             
             
             
             
             
         }
}
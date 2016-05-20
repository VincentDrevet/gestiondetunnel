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
public class Thread implements Runnable {

    private ServerSocket serverSocket;
    private Socket socket;

    
    
    
    public Thread(ServerSocket serverSocket, Socket socket) {
        this.serverSocket = serverSocket;
        this.socket = socket;
        
    }
    
    

    
    
    
    
    
    
    @Override
    public void run() {
        
        
        
        System.out.println("testrun");
        
            Socket socketClient = new Socket();
            
            ThreadClient threadClient = new ThreadClient(socketClient);
            threadClient.run();
            
        
        
        
        
        
        
        
        
        
    }
    
    
   
        
        
    
}

    
    
    
    
    
    


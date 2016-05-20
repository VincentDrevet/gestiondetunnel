/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.business;

import java.net.ServerSocket;
import java.net.Socket;

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
        
        
        
    }
    
}





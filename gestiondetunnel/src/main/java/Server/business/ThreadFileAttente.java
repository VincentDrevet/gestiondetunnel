/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.business;

import Server.dao.FactoryVoiture;
import Server.dao.FileAttenteUtils;
import Server.dao.TacheTimer;
import Server.dao.VoitureUtils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import Server.business.FileAttente;

/**
 *
 * @author vauban
 */
public class ThreadFileAttente extends Thread {
          
     private ServerSocket serverSocket;
    private Socket socket;

    
    public ThreadFileAttente(Socket accept){
       
   
        
        this.socket = socket;
        
    
    }
      @Override
    public void run() {

           System.out.println("La file d'attente démarre");
           Timer timer = new Timer();
//           Timer timer2 = new Timer();
           TacheTimer timerDesTache = new TacheTimer();
           timer.schedule(timerDesTache,0,30000);
//           timer.schedule(timerDesTache,30000,30000);

           
        
    }
    
}

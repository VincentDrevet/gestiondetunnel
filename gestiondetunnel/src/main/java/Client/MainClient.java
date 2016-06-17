/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Thread.sleep;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vauban
 */
public class MainClient {
    
    
    public static void main(String[] args) throws InterruptedException{
        
        
        Socket socket;
        BufferedReader in;
        
        System.out.println("Merci de saisir l'adresse IP du serveur");
        Scanner entree = new Scanner(System.in);
        String Ip = entree.nextLine();
//        String Ip = "127.0.0.1";
        System.out.println("Merci de saisir le port du serveur");
        int port = entree.nextInt();
//        int port = 60000;
        
        
        try {
            socket = new Socket(InetAddress.getByName(Ip),port);
            
            
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            System.out.println(dis.readUTF());
            Scanner entree2 = new Scanner(System.in);
            String immatriculation = entree2.nextLine();
            
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                        
            dos.writeUTF(immatriculation);
            dos.flush();
//            while(!socket.isClosed())
//            {
            String string = dis.readUTF();
            System.out.println(string);
            String string2 = dis.readUTF();
            System.out.println(string2);
            sleep(60000);
            System.out.println("Vous sortez du tunnel, Bonne Journée");
//                if(integ == 1)
//                {
//                    System.out.println("rage");
//                    
//                    socket.close();
//                }
                
//            System.out.println("ICI");
//            sleep(60000);
//            System.out.println("Vous sortez du tunnel, Bonne Journée");
            
           
        } 
        catch (IOException ex) {
            
            Logger.getLogger(MainClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    
    
    
    }
    
    
    
  

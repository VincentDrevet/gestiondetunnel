/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.dao;

import static Server.Main.allThread;
import Server.business.Voiture;
import Server.business.FileAttente;
import Server.business.ThreadClient;
import Server.dao.FileAttenteUtils;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vauban
 */

public class TacheTimer extends TimerTask{

    
    
   
    
    @Override
    public void run(){
        
        //action du timer de supprimer une voiture d'une file
        FileAttente fileAReduire = FileAttenteUtils.fileAttenteGrande();
        if(fileAReduire.getNombreVoiture()>0)
        {
            int idVoitureSupprimer;
            idVoitureSupprimer = FileAttenteUtils.supprimerPremiereVoiture(fileAReduire);
            
            ThreadClient threadDuClient = (ThreadClient) allThread.get(idVoitureSupprimer);
            try {
                threadDuClient.passage();
            } catch (InterruptedException ex) {
            Logger.getLogger(TacheTimer.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
       else
        {
            System.out.println("Il n'y a pas de voiture");
        }
        
        
        
    }
    public TacheTimer(){
        
    }
    
    
    
    
    
    
    
    
}

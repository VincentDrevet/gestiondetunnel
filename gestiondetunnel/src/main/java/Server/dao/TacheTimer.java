/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.dao;

import Server.business.Voiture;
import Server.business.FileAttente;
import Server.dao.FileAttenteUtils;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

/**
 *
 * @author vauban
 */

public class TacheTimer extends TimerTask{

    
    
    
    
    @Override
    public void run(){
        
        FileAttente fileAReduire = FileAttenteUtils.fileAttenteGrande();
        FileAttenteUtils.supprimerPremiereVoiture(fileAReduire);
        
        
    }
    public TacheTimer(){
        
    }
    
    
    
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.dao;

import Server.Main;
import Server.business.FileAttente;
import Server.business.Voiture;

/**
 *
 * @author vauban
 */
public class FileAttenteUtils {
    
    
    
    public static void ajouterVoiture(Voiture nouvelleVoiture){
        
        FileAttente bonneFile;
        
        if(Main.file1.getNombreVoiture()>Main.file2.getNombreVoiture())
        {
           bonneFile = Main.file2;
        }
        else
        {
            bonneFile = Main.file1;
        }
        if(bonneFile.getNombreVoiture()>Main.file3.getNombreVoiture())
        {
            bonneFile = Main.file3;
        }
        if(bonneFile.getNombreVoiture()>Main.file4.getNombreVoiture())
        {
            bonneFile = Main.file4;
        }
        
        bonneFile.getVoitureDansLaFile().put(nouvelleVoiture.getPlaqueImmatriculation(), nouvelleVoiture);
    }
    
}

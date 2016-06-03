/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.dao;

import Server.Main;
import Server.business.FileAttente;
import Server.business.Voiture;
import java.util.Map;
import java.util.Set;

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
        
        Map<Integer, Voiture> nouvelleFile;
        nouvelleFile = bonneFile.getVoituresDansLaFile();
        nouvelleFile.put(nouvelleVoiture.getId(), nouvelleVoiture);
        bonneFile.setVoituresDansLaFile(nouvelleFile);
        
    }
    
    public static FileAttente fileAttenteGrande(){
        
        FileAttente bonneFile;
        
        if(Main.file1.getNombreVoiture()>Main.file2.getNombreVoiture())
        {
           bonneFile = Main.file1;
        }
        else
        {
            bonneFile = Main.file2;
        }
        if(bonneFile.getNombreVoiture()<Main.file3.getNombreVoiture())
        {
            bonneFile = Main.file3;
        }
        if(bonneFile.getNombreVoiture()<Main.file4.getNombreVoiture())
        {
            bonneFile = Main.file4;
        }
        
        return bonneFile;
        
    }
    
    public static void supprimerPremiereVoiture(FileAttente fileAttenteAReduire){
        Map<Integer,Voiture> nouvelleFile = fileAttenteAReduire.getVoituresDansLaFile();
        nouvelleFile.remove(FileAttenteUtils.premierVoiture(fileAttenteAReduire));
        fileAttenteAReduire.setVoituresDansLaFile(nouvelleFile);
    }
    public static Voiture premierVoiture(FileAttente fileAttente)
    {
        Voiture premiereVoiture = null;
        boolean test = false;
        int i = 0;
        while(!test)
        {
            if(fileAttente.getVoituresDansLaFile().containsKey(i))
            {
                test = true;
                premiereVoiture = fileAttente.getVoituresDansLaFile().get(i);
            }
            else
            {
                i++;
            }
            if(i == 99)
            {
                test = true;
            }
        }
        return premiereVoiture;
        
    }
}

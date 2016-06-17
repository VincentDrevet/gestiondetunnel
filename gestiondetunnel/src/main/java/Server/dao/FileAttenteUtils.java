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
    
    
    
    public static FileAttente ajouterVoiture(Voiture nouvelleVoiture){
        
        FileAttente bonneFile = fileAttentePetite();
        
        
        Map<Integer, Voiture> nouvelleFile;
        nouvelleFile = bonneFile.getVoituresDansLaFile();
        nouvelleFile.put(nouvelleVoiture.getId(), nouvelleVoiture);
        bonneFile.setVoituresDansLaFile(nouvelleFile);
        return bonneFile;
    }
    
     public static FileAttente fileAttentePetite(){
        
        FileAttente bonneFile = (FileAttente) Main.allListAttente.get(0);
        for(Object fileAttente : Main.allListAttente.values())
        {
             FileAttente laFile = (FileAttente) fileAttente;
            int i = bonneFile.getNombreVoiture();
           
            if(((FileAttente) fileAttente).getNombreVoiture()<bonneFile.getNombreVoiture())
            {
                bonneFile = (FileAttente) fileAttente;
            }
        }        
        return bonneFile;
        
    }
    
    public static FileAttente fileAttenteGrande(){
        
        FileAttente bonneFile = (FileAttente) Main.allListAttente.get(0);
        for(Object fileAttente : Main.allListAttente.values())
        {
             FileAttente laFile = (FileAttente) fileAttente;
            int i = bonneFile.getNombreVoiture();
           
            if(((FileAttente) fileAttente).getNombreVoiture()>bonneFile.getNombreVoiture())
            {
                bonneFile = (FileAttente) fileAttente;
            }
        }        
        return bonneFile;
        
    }
    
    public static int supprimerPremiereVoiture(FileAttente fileAttenteAReduire){
        Map<Integer,Voiture> nouvelleFile = fileAttenteAReduire.getVoituresDansLaFile();
        Voiture voitureASupprimer = FileAttenteUtils.premierVoiture(fileAttenteAReduire);
        int idVoitureSupprimer = voitureASupprimer.getId();
        nouvelleFile.remove(idVoitureSupprimer);
        fileAttenteAReduire.setVoituresDansLaFile(nouvelleFile);
        return idVoitureSupprimer;
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
                System.out.println("Pas trouver de premier voiture");
                test = true;
            }
        }
        return premiereVoiture;
        
    }
}

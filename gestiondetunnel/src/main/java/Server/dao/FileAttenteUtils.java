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
        
        FileAttente bonneFile = fileAttenteGrande();
        
        
        Map<Integer, Voiture> nouvelleFile;
        nouvelleFile = bonneFile.getVoituresDansLaFile();
        nouvelleFile.put(nouvelleVoiture.getId(), nouvelleVoiture);
        bonneFile.setVoituresDansLaFile(nouvelleFile);
        System.out.println(bonneFile.getNombreVoiture()+" voiture dans la file "+bonneFile.getId());
        return bonneFile;
    }
    
    public static FileAttente fileAttenteGrande(){
        
        FileAttente bonneFile = (FileAttente) Main.allListAttente.get(0);
        for(Object fileAttente : Main.allListAttente.values())
        {
            int i = bonneFile.getNombreVoiture();
//            FileAttente laFile = (FileAttente) fileAttente;
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
                System.out.println(premiereVoiture);
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

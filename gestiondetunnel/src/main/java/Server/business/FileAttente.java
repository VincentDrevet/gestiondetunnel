/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.business;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vauban
 */
public class FileAttente {
    
    
    
    private int id;
    private Map<Integer, Voiture> voituresDansLaFile;

    public void setVoituresDansLaFile(Map<Integer, Voiture> voitureDansLaFile) {
        this.voituresDansLaFile = voitureDansLaFile;
    }

    public Map<Integer, Voiture> getVoituresDansLaFile() {
        return voituresDansLaFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    
    public FileAttente(int id) {
        this.id = id;
        this.voituresDansLaFile = new HashMap<>();
    }
    
    public int getNombreVoiture()
    {
        System.out.println(this.voituresDansLaFile);
        return this.voituresDansLaFile.size();
    }
    
    
    
}

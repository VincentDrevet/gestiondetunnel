/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.business;

import java.util.Map;

/**
 *
 * @author vauban
 */
public class FileAttente {
    
    
    
    private int id;
    private Map<String, Voiture> voitureDansLaFile;

    public void setVoitureDansLaFile(Map<String, Voiture> voitureDansLaFile) {
        this.voitureDansLaFile = voitureDansLaFile;
    }

    public Map<String, Voiture> getVoitureDansLaFile() {
        return voitureDansLaFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    
    public FileAttente(int id) {
        this.id = id;
    }
    
    public int getNombreVoiture()
    {
        return this.voitureDansLaFile.size();
    }
    
    
    
}

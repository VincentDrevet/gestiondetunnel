/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author vauban
 */
public class Voiture {
    
    private int id;
    private String plaqueImmatriculation;

    
    
    
    
    
    /**
     * Getter et setter
     * @return 
     */
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaqueImmatriculation() {
        return plaqueImmatriculation;
    }

    public void setPlaqueImmatriculation(String plaqueImmatriculation) {
        this.plaqueImmatriculation = plaqueImmatriculation;
    }

    
    
    
    //Constructeur plein
    
    public Voiture(int id, String plaqueImmatriculation) {
        this.id = id;
        this.plaqueImmatriculation = plaqueImmatriculation;
    }
    
    
    
    
    
    
    
    
    
    
    
}

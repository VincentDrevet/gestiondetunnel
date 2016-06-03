/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.business;

/**
 *
 * @author vauban
 */
public class Voiture {
    
    private int id;
    private String plaqueImmatriculation;

    public static int idMax;

    public static int getIdMax() {
        return idMax;
    }

    public static void setIdMax(int idMax) {
        Voiture.idMax = idMax;
    }
    
    
    
    
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
    
//    public Voiture(int id, String plaqueImmatriculation) {
//        this.id = id;
//        this.plaqueImmatriculation = plaqueImmatriculation;
//    }

    public Voiture(String plaqueImmatriculation) {
        this.plaqueImmatriculation = plaqueImmatriculation;
        this.id= idMax;
        idMax++;
    }
    
    
    
    
    
    
    
    
    
    
    
}

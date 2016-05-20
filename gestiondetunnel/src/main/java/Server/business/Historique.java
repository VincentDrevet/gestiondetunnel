/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.business;

import java.util.Date;

/**
 *
 * @author vauban
 */
public class Historique {
    
    
    private int id;
    private Date dateConnexion;
    private Date dateEntreeTunnel;
    private Date dateArriveFile;
    private int etatEnCours;

    public Date getDateConnexion() {
        return dateConnexion;
    }

    public void setDateConnexion(Date dateConnexion) {
        this.dateConnexion = dateConnexion;
    }

    public Date getDateEntreeTunnel() {
        return dateEntreeTunnel;
    }

    public void setDateEntreeTunnel(Date dateEntreeTunnel) {
        this.dateEntreeTunnel = dateEntreeTunnel;
    }

    public Date getDateArriveFile() {
        return dateArriveFile;
    }

    public void setDateArriveFile(Date dateArriveFile) {
        this.dateArriveFile = dateArriveFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEtatEnCours() {
        return etatEnCours;
    }

    public void setEtatEnCours(int etatEnCours) {
        this.etatEnCours = etatEnCours;
    }
    
    
    
    

    public Historique(int id, Date dateConnexion, Date dateEntreeTunnel, Date dateArriveFile, int etatEnCours) {
        this.id = id;
        this.dateConnexion = dateConnexion;
        this.dateEntreeTunnel = dateEntreeTunnel;
        this.dateArriveFile = dateArriveFile;
        this.etatEnCours = etatEnCours;
    }
    
    
    
    
    
    
    
    
    
    
    
}

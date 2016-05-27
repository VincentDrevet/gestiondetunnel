/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.dao;

import Server.business.Voiture;

/**
 *
 * @author vauban
 */
public class FactoryVoiture {
    
    public static Voiture creeVoiture(String immatriculation)
    {
        Voiture nouvelleVoiture = new Voiture(immatriculation);
        return nouvelleVoiture;
    }
    
}

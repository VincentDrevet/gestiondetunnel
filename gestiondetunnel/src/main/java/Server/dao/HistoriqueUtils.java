/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.dao;

import Server.Main;
import Server.business.Historique;

/**
 *
 * @author vauban
 */
public class HistoriqueUtils {
    
    public static Historique getHistorique(int idVoiture)
    {
        return (Historique) Main.allHistorique.get(idVoiture);
    }
    
}

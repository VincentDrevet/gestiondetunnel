/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.business;

import Server.Main;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author vauban
 */
public class ThreadAdmin extends Thread{
    
    public void run()
    {
        System.out.println("Admin lancer");
        Boolean deconnection = false;
        while(!deconnection)
        {
            System.out.println("Que souhaitez vous faire?");
            Scanner entree = new Scanner(System.in);
            String commande = entree.nextLine();
             if(commande.equalsIgnoreCase("Sauvegarder Historique"))
             {
                 System.out.println("Sauvegarde en cours");
                 Date date = new java.util.Date();
                 File f = new File ("historique"+date.getTime()+".csv");
 
                try
                {
                    FileWriter fw = new FileWriter (f);

                    for (Object historique : Main.allHistorique.values())
                    {
                        Historique historique2 = (Historique) historique;
                        fw.write(String.valueOf(historique2.getId()));
                        fw.write (";");
                        fw.write(historique2.getVoiture().toString());
                        fw.write (";");
                        fw.write(String.valueOf(historique2.getEtatEnCours()));
                        fw.write (";");
                        fw.write(historique2.getDateConnexion().toString());
                        fw.write (";");
                        fw.write(historique2.getDateArriveFile().toString());
                        fw.write (";");
                        if(historique2.getDateEntreeTunnel() == null)
                        {
                            fw.write("");
                        }
                        else
                        {
                            fw.write(historique2.getDateEntreeTunnel().toString());
                        }
                        fw.write (";\n");
                    }
                    fw.close();
                }
                catch (IOException exception)
                {
                    System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
                }
             }
             else if(commande.equalsIgnoreCase("Voir Historique"))
             {
                 System.out.println("Voici l'historique : ");
                 System.out.println(Main.allHistorique.toString());
             }
             else if(commande.equalsIgnoreCase("Fermer Serveur"))
             {
                 System.out.println("Fermeture");
                 System.exit(0);
             }
        }
    }
    public ThreadAdmin()
    {
        
    }
}

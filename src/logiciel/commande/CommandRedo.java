package logiciel.commande;

import logiciel.controleur.GestionnaireCommande;

/******************************************************
 Cours:   LOG121
 Session: H2023
 Groupe:  04
 Projet: Laboratoire #2
 Auteurs: Jonathan Savard, Samuel Velasco, Annie Tremblay

 Charge de laboratoire: Bilal Alchalibi
 Nom du fichier: CommandRedo.java
 Date creee: 2023-03-22
 Date dern. modif. 2023-04-04
 ***************************************************
 Historique des modifications
 ***************************************************
 2023-03-22 Creation de la classe
 2023-04-04 Implementation de la classe
 *******************************************************/


/**
 * Commande qui permet de reinitialiser letat du logiciel avant que lutilisateur puisse cliquer sur undo
 */

public class CommandRedo implements Commande{
    @Override
    public void execute() {

        GestionnaireCommande gc = GestionnaireCommande.getInstance();

        gc.getCps().getBack();


    }
}

package logiciel.commande;

/******************************************************
 Cours:   LOG121
 Session: H2023
 Groupe:  04
 Projet: Laboratoire #2
 Auteurs: Jonathan Savard, Samuel Velasco, Annie Tremblay

 Charge de laboratoire: Bilal Alchalibi
 Nom du fichier: CommandeUndo.java
 Date creee: 2023-03-22
 Date dern. modif. 2023-04-04
 ***************************************************
 Historique des modifications
 ***************************************************
 2023-03-22 Creation de la classe
 2023-04-04 Implementation de la classe
 *******************************************************/

import logiciel.controleur.GestionnaireCommande;

public class CommandUndo implements Commande {

    /**
     * Commande qui permet de defaire laction effectuee par lutilisateur
     */
    @Override
    public void execute() {

        GestionnaireCommande gc = GestionnaireCommande.getInstance();

        gc.getCps().restore();
    }
}

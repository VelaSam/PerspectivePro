package logiciel.commande;

import logiciel.controleur.GestionnaireCommande;
import logiciel.modele.CurrentProjectState;

public class CommandUndo implements Commande {

    @Override
    public void execute() {

        GestionnaireCommande gc = GestionnaireCommande.getInstance();

        gc.getCps().restore();
    }
}

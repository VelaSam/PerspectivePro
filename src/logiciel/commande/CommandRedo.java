package logiciel.commande;

import logiciel.controleur.GestionnaireCommande;

public class CommandRedo implements Commande{
    @Override
    public void execute() {

        GestionnaireCommande gc = GestionnaireCommande.getInstance();

        gc.getCps().getBack();


    }
}

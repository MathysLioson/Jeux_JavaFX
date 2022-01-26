package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import modele.personnage.Joueur;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Cette classe permet de compter les pièces ramassées par le joueur.
 */
public class ControllerPieces {
    String p="nb";

    @FXML
    public Label piece;

    /**
     * change le nombre de piece récupéré par le joueur.
     *
     * @param j Joueur sur lequel on récupère les pièces de celui-çi.
     */
    public void setLabelText(Joueur j) {
        System.out.println("CONTROLLER SET LABEL CALLED");
        p=j.getStrPieces();
        piece.setText(p);
    }


}
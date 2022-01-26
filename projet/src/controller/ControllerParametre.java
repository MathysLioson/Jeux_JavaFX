package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import modele.personnage.Joueur;
import vue.menuPrincipal.MainMenu;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Controller de la page paramètre qui permet d'exécuter des actions
 * en fonctions du bouton utilisé.
 */
public class ControllerParametre implements Initializable {
    @FXML
    private Button menu;
    @FXML
    private Label toucheAttaque;
    @FXML
    private Label toucheDroite;
    @FXML
    private Label toucheGauche;
    @FXML
    private Label toucheSaut;
    
    /**
     * Bouton qui permet de réouvrir le menu principal.
     *
     * @param actionEvent action du bouton
     */
    public void actionMenu(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.close();
        MainMenu menu=new MainMenu();
        menu.start(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Joueur j = new Joueur(0,0,0,0);
        toucheAttaque.setText(""+j.getToucheJoueur("attaque"));
        toucheDroite.setText(""+j.getToucheJoueur("droite"));
        toucheGauche.setText(""+j.getToucheJoueur("gauche"));
        toucheSaut.setText(""+j.getToucheJoueur("saut"));
    }
}

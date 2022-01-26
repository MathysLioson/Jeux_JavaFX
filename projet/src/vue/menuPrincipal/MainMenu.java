package vue.menuPrincipal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vue.menuPrincipal.createMenuContent;

/**
 * Cette classe permet de lancer notre menu.
 */
public class MainMenu extends Application {

    /**
     * Cette méthode permet de faire la mise en forme de notre menu
     * et l'afficher.
     *
     * @param scene affiche le menu.
     */
    @Override
    public void start(Stage scene) {
        createMenuContent menu= new createMenuContent();
        Scene scene1 = new Scene(menu.createContent());
        scene.setTitle("Honor Knight");
        scene.setResizable(false);
        scene.setScene(scene1);
        scene.show();
    }
}

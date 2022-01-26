package vue.gameOverMenu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vue.menuPrincipal.createMenuContent;

/**
 * Affiche un écran de game over quand le joueur décède.
 */
public class GameOver extends Application {

    /**
     Cette méthode permet de faire la mise en forme de notre fenêtre game over
     * et l'afficher.
     *
     * @param scene son contenu dans la scene qui lui est donné.
     */
    @Override
    public void start(Stage scene) {

        createMenuContent menu= new createMenuContent();
        Scene scene1 = new Scene(menu.createContent());
        scene.setTitle("Honor Knight");
        scene.setScene(scene1);
        scene.show();
    }
}

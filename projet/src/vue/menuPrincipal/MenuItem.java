package vue.menuPrincipal;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.MainGame;


/**
 * Cette classe permet de créer les items qui vont nous servir de bouton
 * pour notre menu avec une mise en forme et une animation.
 */
public class MenuItem extends StackPane {

    /**
     * On crée pour chaque item du menu un rectangle transparent avec so texte à l'intérieur
     * et on crée un fondu pour la mise en forme de notre bouton.
     * On crée des animations pour nos items en fonction de la position de la souris.
     *
     * @param name Nom des différents items de notre menu.
     */
    public MenuItem (String name){
        LinearGradient gradient = new LinearGradient(0,0,1,0,true, CycleMethod.NO_CYCLE,new Stop[]{
                new Stop(0, Color.DARKVIOLET),
                new Stop(0.1, Color.BLACK),
                new Stop(0.9, Color.BLACK),
                new Stop(1, Color.DARKVIOLET)
        });

        Rectangle bg = new Rectangle(200,60);
        bg.setOpacity(0.4);

        Text text = new Text(name);
        text.setFill(Color.DARKGRAY);
        text.setFont(Font.font("Consolas", FontWeight.SEMI_BOLD, 22));

        setAlignment(Pos.CENTER);
        getChildren().addAll(bg,text);

        setOnMouseEntered(event ->{
            bg.setFill(gradient);
            text.setFill(Color.WHITE);
        });
        setOnMouseExited(event ->{
            bg.setFill(Color.BLACK);
            text.setFill(Color.DARKGRAY);
        });
        setOnMousePressed(event ->{
            bg.setFill(Color.DARKVIOLET);

        });
        setOnMouseReleased(event ->{
            bg.setFill(gradient);
        });
    }
}

package vue.menuPrincipal;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Cette classe permet de créer un titre pour un Menu.
 */
public class TitreMenu extends StackPane {

    /**
     * Le constructeur de centre classe permet de réaliser la mise en forme
     * d'un titre avec un titre et une mise en forme.
     *
     * @param name Nom donné en paramètres pour mettre ce nom en titre.
     */
    public TitreMenu(String name){
        Rectangle bg = new Rectangle(600,80);
        bg.setStroke(Color.BLACK);
        bg.setStrokeWidth(2);
        bg.setFill(null);

        Text text = new Text(name);
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Consolas", FontWeight.SEMI_BOLD, 60));

        setAlignment(Pos.CENTER);
        getChildren().addAll(bg,text);
    }
}
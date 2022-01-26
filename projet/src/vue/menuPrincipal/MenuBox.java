package vue.menuPrincipal;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


/**
 * Cette classe permet pour chaque menu items crée de les stocker avec cette classe
 * en colonne avec une séparation entre eux pour la mise en forme.
 */
public class MenuBox extends VBox {
    /**
     * Le constructeur de cette classe permet de stocker les différents items
     * pour la mise en forme.
     * @param items boutons
     */
    public MenuBox(MenuItem... items){
        getChildren().add(createSeparator());
        for (MenuItem item : items){
            getChildren().addAll(item, createSeparator());
        }
    }

    /**
     * Cette méthode permet de créer une ligne qui fera office de séparateur
     * entre les items.
     * @return séparateur
     */
    private Line createSeparator(){
        Line sep = new Line();
        sep.setEndX(200);
        sep.setStroke(Color.DARKGRAY);
        return sep;
    }


}
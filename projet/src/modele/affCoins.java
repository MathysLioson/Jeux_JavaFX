package modele;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class affCoins extends StackPane {
    String p;

    public void affCoins(String str) {
        p=str;
        Rectangle bg = new Rectangle(300,200);
        bg.setStroke(Color.BLACK);
        bg.setStrokeWidth(2);
        bg.setFill(null);

        Text text = new Text(p);
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Tw Cen MT Con", FontWeight.SEMI_BOLD, 20));

        setAlignment(Pos.CENTER);
        getChildren().addAll(bg,text);
    }
    public void changetxt(String str){
        this.p=str;
        Rectangle bg = new Rectangle(300,200);
        bg.setStroke(Color.BLACK);
        bg.setStrokeWidth(2);
        bg.setFill(null);

        Text text = new Text(p);
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Tw Cen MT Con", FontWeight.SEMI_BOLD, 20));

        setAlignment(Pos.CENTER);
        getChildren().addAll(bg,text);
    }
}

package modele;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import vue.monde.Monde;

/**
 * Classe qui permet de créer des blocs en leur attribuent des coordonnées
 */
public class Createur {
    /**
     * Métode permettent de créer des blocs de texture
     * @param x coordonnée en x du bloc
     * @param y coordonnée en y du bloc
     * @param w largeur de notre bloc
     * @param h hauteur de notre bloc
     * @param img lien vers l'image(tile) du bloc que l'on veut utiliser
     * @param monde Zone dans la quel on va créer le bloc
     * @return retourne une imageview placé dans une zone
     */
    public Node CreerTexture(int x, int y, int w, int h, String img, Monde monde){
        Image tiles = new Image(getClass().getResourceAsStream(img));
        ImageView image = new ImageView(tiles);

        image.setFitWidth(w);
        image.setFitHeight(h);
        image.setTranslateX(x);
        image.setTranslateY(y);

        image.getProperties().put("alive", true);
        monde.gameRoot.getChildren().add(image);

        return image;
    }

}

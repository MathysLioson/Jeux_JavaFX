package vue.vuePersonnage;

import javafx.scene.image.ImageView;
import modele.personnage.Ennemi;
import vue.monde.Monde;

import java.util.Observable;
import java.util.Observer;

/**
 * La classe VueEnnemi permet d'afficher l'ennemi dans le monde.
 * Cette classe va permettre de gerer les annimations de l'ennemi avec des ImageView.
 */
public class VueEnnemi extends Ennemi {

    private ImageView base =  new ImageView(right00);

    public ImageView spriteEnnemi;

    /**
     * Constructeur de la vue d'un ennemi.
     * Cette méthode permet d'affecter les differents paramètres passé en paramètres
     * à nos ennemis.
     *
     * @param x       coordonnée d'apparition de la vue d'un ennemi sur l'axe X.
     * @param y       coordonnée d'apparition de la vue d'un ennemi sur l'axe X.
     * @param hauteur Hauteur de la vue d'un ennemi en pixel.
     * @param largeur Largeur de la vue d'un ennemi en pixel.
     */
    public VueEnnemi(int x, int y, int hauteur, int largeur) {
        super(x, y, hauteur, largeur);
    }

    /**
     * La méthode initVueEnnemi permet d'initialiser la vue d'un ennemi dans le monde.
     *
     * @param monde Monde dans le quel se retrouve l'ennemi.
     */
    public void initEnnemi(Monde monde){
        spriteEnnemi=base;
        spriteEnnemi.setFitWidth(hauteur);
        spriteEnnemi.setFitHeight(largeur);
        spriteEnnemi.setTranslateX(x);
        spriteEnnemi.setTranslateY(y);
        monde.gameRoot.getChildren().add(spriteEnnemi);

    }

    /**
     * Cette méthode permet d'animer un ennemi.
     * Ainsi cette méthode va remplacer les images d'un ennemi en fonction
     * de sa direction.
     *
     * @param e Ennemi auquel on va récupérer sa direction.
     */
    public void annimationEnnemi(Ennemi e) {
        switch (e.direction) {
            case "left":
                if (e.spriteNum == 1) {
                    spriteEnnemi.setImage(left0);
                }
                if (e.spriteNum == 2) {
                    spriteEnnemi.setImage(left1);
                }
                if (e.spriteNum == 3) {
                    spriteEnnemi.setImage(left2);
                }
                if (e.spriteNum == 4) {
                    spriteEnnemi.setImage(left3);
                }
                break;
            case "right":
                if (e.spriteNum == 1) {
                    spriteEnnemi.setImage(right00);
                }
                if (e.spriteNum == 2) {
                    spriteEnnemi.setImage(right11);
                }
                if (e.spriteNum == 3) {
                    spriteEnnemi.setImage(right2);
                }
                if (e.spriteNum == 4) {
                    spriteEnnemi.setImage(right3);
                }
                break;
        }
    }


}

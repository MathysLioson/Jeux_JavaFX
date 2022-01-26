package vue.vuePersonnage;
import modele.personnage.Joueur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modele.personnage.Joueur;
import vue.monde.Monde;

import java.util.Observable;
import java.util.Observer;


/**
 * La classe VueJoueur permet d'afficher le joueur dans le monde.
 * Cette classe va permettre de gerer les annimations du joueur avec des ImageView
 * ainsi que sa barre de vie.
 */
public class VueJoueur extends Joueur {

    private ImageView base =  new ImageView(breath0);
    private ImageView baseAttaque =  new ImageView(slash1);

    public ImageView spriteJoueur;
    public ImageView spriteAttaqueJoueur;
    private ImageView barreDeVie = new ImageView(coeur6);

    /**
     * Constructeur de la vue du joueur.
     * Cette méthode permet d'affecter les differents paramètres passé en paramètres
     * à notre joueur.
     *
     * @param x       coordonnée d'apparition de la vue du joueur sur l'axe X.
     * @param y       coordonnée d'apparition de la vue du joueur sur l'axe X.
     * @param hauteur Hauteur de la vue du joueur en pixel.
     * @param largeur Largeur de la vue du joueur en pixel.
     */
    public VueJoueur(int x, int y, int hauteur, int largeur) {
        super(x, y, hauteur, largeur);
    }

    /**
     * La méthode initVueJoueur permet d'initialiser la vue du joueur dans le monde.
     *
     * @param monde Monde dans le quel se retrouve le joueur.
     */
    public void initVueJoueur(Monde monde){
        spriteAttaqueJoueur=baseAttaque;
        spriteJoueur=base;

        spriteAttaqueJoueur.setVisible(true);

        spriteAttaqueJoueur.setFitWidth(70);
        spriteAttaqueJoueur.setFitHeight(70);
        spriteAttaqueJoueur.setTranslateX(x+50);
        spriteAttaqueJoueur.setTranslateY(y-10);

        spriteJoueur.setFitWidth(hauteur);
        spriteJoueur.setFitHeight(largeur);
        spriteJoueur.setTranslateX(x);
        spriteJoueur.setTranslateY(y);

        barreDeVie.setFitWidth(150);
        barreDeVie.setFitHeight(50);

        barreDeVie.setX(25);
        barreDeVie.setY(25);

        monde.uiRoot.getChildren().add(barreDeVie);
        monde.gameRoot.getChildren().addAll(spriteJoueur,spriteAttaqueJoueur);
    }

    /**
     * Cette méthode permet d'annimer l'attaque d'un joueur.
     * Ainsi cette méthode va remplacer les images des attaques en fonction
     * de la direction du joueur.
     * Elle va aussi va remplacer les images de l'attaque pour annimer l'attaque.
     *
     * @param j Joueur auquel on va récuperer sa direction et son état d'attaque avec isAttack.
     */
    public void annimationAttaqueJoueur(Joueur j){
        if(j.isAttack==true) {

            switch (j.directionAttaque) {
                case "right":
                    if (j.spriteNumAttaque == 0 ) {
                        spriteAttaqueJoueur.setVisible(true);
                    }
                    if (j.spriteNumAttaque == 1 && j.enAttack==true && j.nbsprite==1) {
                        spriteAttaqueJoueur.setImage(slash1);
                        spriteAttaqueJoueur.setTranslateX(spriteJoueur.getTranslateX() + 35);
                        spriteAttaqueJoueur.setTranslateY(spriteJoueur.getTranslateY()+10);
                        j.nbsprite=0;
                    }
                    if (j.spriteNumAttaque == 2 && j.enAttack==true && j.nbsprite==2) {
                        spriteAttaqueJoueur.setImage(slash2);
                        spriteAttaqueJoueur.setTranslateX(spriteJoueur.getTranslateX() + 35);
                        spriteAttaqueJoueur.setTranslateY(spriteJoueur.getTranslateY()+10);
                        j.nbsprite=0;

                    }
                    if (j.spriteNumAttaque == 3 && j.enAttack==true && j.nbsprite==3) {
                        spriteAttaqueJoueur.setImage(slash3);
                        spriteAttaqueJoueur.setTranslateX(spriteJoueur.getTranslateX() + 35);
                        spriteAttaqueJoueur.setTranslateY(spriteJoueur.getTranslateY()+10);
                        j.nbsprite=0;

                    }
                    if (j.spriteNumAttaque == 4 && j.enAttack==true && j.nbsprite==4) {
                        spriteAttaqueJoueur.setImage(slash4);
                        spriteAttaqueJoueur.setTranslateX(spriteJoueur.getTranslateX() + 35);
                        spriteAttaqueJoueur.setTranslateY(spriteJoueur.getTranslateY()+10);
                        j.nbsprite=0;

                    }
                    break;

                case "left":
                    if (j.spriteNumAttaque == 0 ) {
                        spriteAttaqueJoueur.setVisible(true);
                    }
                    if (j.spriteNumAttaque == 1 && j.enAttack==true && j.nbsprite==1) {
                        spriteAttaqueJoueur.setImage(reverseSlash1);
                        spriteAttaqueJoueur.setTranslateX(spriteJoueur.getTranslateX() - 35);
                        spriteAttaqueJoueur.setTranslateY(spriteJoueur.getTranslateY()+10);
                        j.nbsprite=0;
                    }
                    if (j.spriteNumAttaque == 2 && j.enAttack==true && j.nbsprite==2) {
                        spriteAttaqueJoueur.setImage(reverseSlash2);
                        spriteAttaqueJoueur.setTranslateX(spriteJoueur.getTranslateX() - 35);
                        spriteAttaqueJoueur.setTranslateY(spriteJoueur.getTranslateY()+10);
                        j.nbsprite=0;

                    }
                    if (j.spriteNumAttaque == 3 && j.enAttack==true && j.nbsprite==3) {
                        spriteAttaqueJoueur.setImage(reverseSlash3);
                        spriteAttaqueJoueur.setTranslateX(spriteJoueur.getTranslateX() - 35);
                        spriteAttaqueJoueur.setTranslateY(spriteJoueur.getTranslateY()+10);
                        j.nbsprite=0;

                    }
                    if (j.spriteNumAttaque == 4 && j.enAttack==true && j.nbsprite==4) {
                        spriteAttaqueJoueur.setImage(reverseSlash4);
                        spriteAttaqueJoueur.setTranslateX(spriteJoueur.getTranslateX() - 35);
                        spriteAttaqueJoueur.setTranslateY(spriteJoueur.getTranslateY()+10);
                        j.nbsprite=0;

                    }
                    break;

            }
        }else {
            spriteAttaqueJoueur.setVisible(false);
            return;
        }
   }

    /**
     * Cette méthode permet d'annimer le joueur.
     * Ainsi cette méthode va remplacer les images du joueur en fonction
     * de sa direction.
     *
     * @param j Joueur auquel on va récuperer sa direction.
     */
    public void annimationJoueur(Joueur j) {
        switch (j.direction){
            case "left":
                if(j.spriteNum==1){
                    spriteJoueur.setImage(left0);
                }
                if(j.spriteNum==2){
                    spriteJoueur.setImage(left1);
                }
                if(j.spriteNum==3){
                    spriteJoueur.setImage(left2);
                }
                if(j.spriteNum==4){
                    spriteJoueur.setImage(left3);
                }
                break;
            case "right":
                if(j.spriteNum==1){
                    spriteJoueur.setImage(right00);
                }
                if(j.spriteNum==2){
                    spriteJoueur.setImage(right11);
                }
                if(j.spriteNum==3){
                    spriteJoueur.setImage(right2);
                }
                if(j.spriteNum==4){
                    spriteJoueur.setImage(right3);
                }
                break;
            case "static":
                if(j.spriteNumStatic==1){
                    spriteJoueur.setImage(breath0);
                }
                if(j.spriteNumStatic==2){
                    spriteJoueur.setImage(breath1);
                }
                break;
            case "staticLeft":
                if(j.spriteNumStatic==1){
                    spriteJoueur.setImage(leftBreath0);
                }
                if(j.spriteNumStatic==2){
                    spriteJoueur.setImage(leftBreath1);
                }
                break;
            case "saut": //modifier afin que l'annimation se fassent quand le modele.joueur et en phase montante et décendante.
                if(j.spriteNum==1){
                    spriteJoueur.setImage(preSaut);
                }
                if(j.spriteNum==2){
                    spriteJoueur.setImage(monter);
                }
                if(j.spriteNum==3){
                    spriteJoueur.setImage(descente);
                }

                if(j.spriteNum==4){
                    spriteJoueur.setImage(aterrisage);
                }
                break;
        }
    }

    /**
     * Cette méthode va permettre de mettre à jour la barra de vie du joueur
     * en fonction de la vie actuel du joueur.
     *
     */
    public void healthRefresh(){
        switch(this.hp){
            case 120:
                barreDeVie.setImage(coeur6);
                break;
            case 100:
                barreDeVie.setImage(coeur5);
                break;
            case 80:
                barreDeVie.setImage(coeur4);
                break;
            case 60:
                barreDeVie.setImage(coeur3);
                break;
            case 40:
                barreDeVie.setImage(coeur2);
                break;
            case 20:
                barreDeVie.setImage(coeur1);
                break;
            case 0:
                barreDeVie.setImage(coeur0);
                return;

        }
        return;
    }

}

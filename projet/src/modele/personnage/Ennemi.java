package modele.personnage;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import vue.monde.Monde;
import vue.vuePersonnage.VueEnnemi;

/**
 * Cette classe permettant de créer un ennemi.
 */
public class Ennemi extends Personnage {
    
    private boolean canJump = true;
    private Point2D playerVelocity = new Point2D(0,0);
    public int x;
    private int x1;
    private int x2;
    public int y;
    public int hauteur;
    public int largeur;
    private boolean alive=true;
    public String direction;

    public Image left0 = new Image(getClass().getResourceAsStream("/tiles/ennemiTile/reverseSerpent1.png"));
    public Image left1 = new Image(getClass().getResourceAsStream("/tiles/ennemiTile/reverseSerpent1.png"));
    public Image left2 =  new Image(getClass().getResourceAsStream("/tiles/ennemiTile/reverseSerpent2.png"));
    public Image left3 =  new Image(getClass().getResourceAsStream("/tiles/ennemiTile/reverseSerpent4.png"));
    public Image right00 =  new Image(getClass().getResourceAsStream("/tiles/ennemiTile/serpent1.png"));
    public Image right11 =  new Image(getClass().getResourceAsStream("/tiles/ennemiTile/serpent1.png"));
    public Image right2 =  new Image(getClass().getResourceAsStream("/tiles/ennemiTile/serpent2.png"));
    public Image right3 =  new Image(getClass().getResourceAsStream("/tiles/ennemiTile/serpent4.png"));

    /**
     * Constructeur de l'ennemi.
     * Cette méthode permet d'affecter les différents paramètres passés en paramètres
     * à notre ennemi.
     *
     * @param x       coordonnée d'apparition de l'ennemi sur l'axe X.
     * @param y       coordonnée d'apparition de l'ennemi sur l'axe X.
     * @param hauteur Hauteur de l'ennemi en pixel.
     * @param largeur Largeur de l'ennemi en pixel.
     */
    public Ennemi(int x, int y, int hauteur, int largeur){
        direction="right";
        this.x=x;
        this.y=y;
        this.hauteur=hauteur;
        this.largeur=largeur;
        x1 = x;
        x2 = x + 200;

    }

    /**
     * Méthode qui permet de déplacer l'ennemi sur l'axe X automatiquement
     * et qui gère les collisions.
     *
     * @param value distance de parcours.
     * @param monde Monde dans lequel se situe les ennemis.
     * @param vue   ImageView de l'ennemi qui va être déplacé.
     */
    private void moveEnnemiX(int value, Monde monde, VueEnnemi vue){
        boolean movingRight = value > 0;
        for (int i = 0; i < Math.abs(value); i++){
            for(Node platform : monde.platforms) {
                if (vue.spriteEnnemi.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    if (movingRight) {
                        if (vue.spriteEnnemi.getTranslateX() + 60 == platform.getTranslateX()) {
                            return;
                        }
                    } else {
                        if (vue.spriteEnnemi.getTranslateX() + 60 == platform.getTranslateX() + 80) {
                            return;
                        }
                    }
                }
            }
            vue.spriteEnnemi.setTranslateX(vue.spriteEnnemi.getTranslateX() + (movingRight ? 1 : -1));
        }
    }

    /**
     * Méthode qui permet de déplacé l'ennemi sur l'axe Y automatiquement
     * et qui gère les collisions.
     *
     * @param value distance parcourut en hauteur.
     * @param monde Monde dans lequel se situe les joueurs
     * @param vue ImageView du joueur qui va être déplacé.
     */
    private void moveEnnemiY(int value,Monde monde, VueEnnemi vue){
        boolean movingDown = value > 0;

        for (int i = 0 ; i < Math.abs(value); i++){
            for(Node platform : monde.platforms){
                if(vue.spriteEnnemi.getBoundsInParent().intersects(platform.getBoundsInParent())){
                    if(movingDown){
                        if(vue.spriteEnnemi.getTranslateY()+80 == platform.getTranslateY()){
                            vue.spriteEnnemi.setTranslateY(vue.spriteEnnemi.getTranslateY()-1);
                            canJump = true;
                            return;
                        }
                    }
                    else{
                        if(vue.spriteEnnemi.getTranslateY()== platform.getTranslateY()+80){
                            return;
                        }
                    }
                }
            }

            vue.spriteEnnemi.setTranslateY(vue.spriteEnnemi.getTranslateY()+(movingDown ? 1 : -1));
        }
    }

    /**
     * Méthode qui va permettre de faire déplacer l'ennemi.
     *
     * @param monde Zone dans la quel est utilisé l'ennemi.
     * @param vue Vue de l'ennemi qui est déplacé.
     */
    public void deplacementEnnemi(Monde monde, VueEnnemi vue) {

        if (direction == "left") {
            if (vue.spriteEnnemi.getTranslateX() <= x2 && vue.spriteEnnemi.getTranslateX() > x1) {
                moveEnnemiX(-2, monde, vue);
            }else direction = "right";
        }

        if (direction == "right") {
            if (vue.spriteEnnemi.getTranslateX() >= x1 && vue.spriteEnnemi.getTranslateX() < x2) {
                moveEnnemiX(2, monde, vue);
            } else direction = "left";
        }

        spriteCounter ++;
        if(spriteCounter>=10){
            if(spriteNum==1){
                spriteNum=2;
            }else if(spriteNum==2){
                spriteNum=3;
            }else if(spriteNum==3){
                spriteNum=4;
            }else if(spriteNum==4){
                spriteNum=1;
            }
            spriteCounter=0;
        }
    }

    /**
     * Méthode qui gère la gravité de l'ennemi.
     * Elle est executée en continu dans la méthode update du Gamepanel.
     *
     * @param monde monde dans le quel l'ennemi est situé.
     * @param vue Vue de l'ennemi sur lequel est exécutée la gravité.
     */
    public void gravite(Monde monde, VueEnnemi vue){
        if(playerVelocity.getY()<10){
            playerVelocity = playerVelocity.add(0,1);
        }
        moveEnnemiY((int)playerVelocity.getY(),monde,vue);
    }

    /**
     * Permet de savoir si le serpent est en vie.
     * @return un booléen true s'il est en vie et false sinon
     */
    public boolean isAlive(){
        return this.alive;
    }


    /**
     * Met alive a false ce qui tue le serpent.
     */
    public void killEnnemi(){
        alive = false;
    }
}

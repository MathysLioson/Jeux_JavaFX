package modele.personnage;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import vue.monde.Monde;
import vue.vuePersonnage.VueJoueur;


/**
 * Cette classe permettant de créer un joueur.
 */
public class Joueur extends Personnage {
    private Point2D playerVelocity = new Point2D(0, 0);
    private boolean canJump = true;
    private int delaiAttaque = 1;
    private int pieces = 0;

    public int x;
    public int y;
    public int hauteur;
    public int largeur;
    public int hp = 120;
    public int nbsprite=0;
    public boolean isAttack = false;
    public Boolean enAttack = false;
    public String direction;
    public String directionAttaque;

    // Tiles des déplacements à gauches
    public Image left0 = new Image(getClass().getResourceAsStream("/tiles/player/leftwalk0.png"));
    public Image left1 = new Image(getClass().getResourceAsStream("/tiles/player/leftWalk1.png"));
    public Image left2 = new Image(getClass().getResourceAsStream("/tiles/player/leftWalk2.png"));
    public Image left3 = new Image(getClass().getResourceAsStream("/tiles/player/leftWalk3.png"));
    // Tiles des déplacements à droite
    public Image right00 = new Image(getClass().getResourceAsStream("/tiles/player/walk0.png"));
    public Image right11 = new Image(getClass().getResourceAsStream("/tiles/player/walk1.png"));
    public Image right2 = new Image(getClass().getResourceAsStream("/tiles/player/walk2.png"));
    public Image right3 = new Image(getClass().getResourceAsStream("/tiles/player/walk3.png"));
    // Tiles de l'annimation static
    public Image breath0 = new Image(getClass().getResourceAsStream("/tiles/player/breath0.png"));
    public Image breath1 = new Image(getClass().getResourceAsStream("/tiles/player/breath1.png"));
    public Image leftBreath0 = new Image(getClass().getResourceAsStream("/tiles/player/leftBreath0.png"));
    public Image leftBreath1 = new Image(getClass().getResourceAsStream("/tiles/player/leftBreath1.png"));
    //Tiles sauts
    public Image preSaut = new Image(getClass().getResourceAsStream("/tiles/player/preSaut.png"));
    public Image monter = new Image(getClass().getResourceAsStream("/tiles/player/monter.png"));
    public Image descente = new Image(getClass().getResourceAsStream("/tiles/player/descente.png"));
    public Image aterrisage = new Image(getClass().getResourceAsStream("/tiles/player/atterissage.png"));
    // Tiles des Coeurs
    public Image coeur0 = new Image(getClass().getResourceAsStream("/tiles/player/coeur0.png"));
    public Image coeur1 = new Image(getClass().getResourceAsStream("/tiles/player/coeur1.png"));
    public Image coeur2 = new Image(getClass().getResourceAsStream("/tiles/player/coeur2.png"));
    public Image coeur3 = new Image(getClass().getResourceAsStream("/tiles/player/coeur3.png"));
    public Image coeur4 = new Image(getClass().getResourceAsStream("/tiles/player/coeur4.png"));
    public Image coeur5 = new Image(getClass().getResourceAsStream("/tiles/player/coeur5.png"));
    public Image coeur6 = new Image(getClass().getResourceAsStream("/tiles/player/coeur6.png"));
    //Tiles animation de l'attaque à droite
    public Image slash1 = new Image(getClass().getResourceAsStream("/tiles/Attaque/slash0.png"));
    public Image slash2 = new Image(getClass().getResourceAsStream("/tiles/Attaque/slash1.png"));
    public Image slash3 = new Image(getClass().getResourceAsStream("/tiles/Attaque/slash2.png"));
    public Image slash4 = new Image(getClass().getResourceAsStream("/tiles/Attaque/slash3.png"));
    //Tiles animation de l'attaque à gauche
    public Image reverseSlash1 = new Image(getClass().getResourceAsStream("/tiles/Attaque/reverseSlash0.png"));
    public Image reverseSlash2 = new Image(getClass().getResourceAsStream("/tiles/Attaque/reverseSlash1.png"));
    public Image reverseSlash3 = new Image(getClass().getResourceAsStream("/tiles/Attaque/reverseSlash2.png"));
    public Image reverseSlash4 = new Image(getClass().getResourceAsStream("/tiles/Attaque/reverseSlash3.png"));


    /**
     * Constructeur du joueur.
     * Cette méthode permet d'affecter les différents paramètres passés en paramètres
     * à notre joueur.
     *
     * @param x       coordonnée d'apparition du joueur sur l'axe X.
     * @param y       coordonnée d'apparition du joueur sur l'axe X.
     * @param hauteur Hauteur du joueur en pixel.
     * @param largeur Largeur du joueur en pixel.
     */
    public Joueur(int x, int y, int hauteur, int largeur) {
        direction = "static";
        directionAttaque = "right";
        this.x = x;
        this.y = y;
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    /**
     * Permet d'ajouter une piece au joueur.
     *
     * @return une piece.
     */
    public int gainPiece() {
        this.pieces = pieces + 1;
        System.out.println(""+pieces);
        return pieces;
    }

    /**
     * Transforme le nombre de piece en string afin qu'elles puissent être utilisé en fxml.
     *
     * @return un nombre de pieces.
     */
    public String getStrPieces() {
        String s = String.valueOf(this.pieces);
        return s;
    }

    /**
     * Permet d'infliger des dégâts au joueur.
     *
     * @return nb de hp restant.
     */
    public int prendreDegat() {
        this.hp = hp - 10;
        return hp;
    }

    /**
     * Méthode qui permet de déplacer le joueur sur l'axe X
     * et qui gère les collisions.
     *
     * @param value Distance de parcours.
     * @param monde Monde dans lequel se situe le joueur.
     * @param vue   ImageView du joueur qui va être déplacé.
     */
    private void movePlayerX(int value, Monde monde, VueJoueur vue) {
        boolean movingRight = value > 0;
        for (int i = 0; i < Math.abs(value); i++) {
            for (Node platform : monde.platforms) {
                if (vue.spriteJoueur.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    if (movingRight) {
                        if (vue.spriteJoueur.getTranslateX() + 60 == platform.getTranslateX()) {
                            return;
                        }
                    } else {
                        if (vue.spriteJoueur.getTranslateX() + 60 == platform.getTranslateX() + 90) {
                            return;
                        }
                    }
                }
            }
            vue.spriteJoueur.setTranslateX(vue.spriteJoueur.getTranslateX() + (movingRight ? 1 : -1));
        }
    }

    /**
     * Méthode qui permet de déplacé le joueur sur l'axe Y
     * et qui gère les collisions.
     *
     * @param value distance parcourut en hauteur.
     * @param monde Monde dans lequel se situe le joueur
     * @param vue ImageView du joueur qui va être déplacé.
     */
    private void movePlayerY(int value, Monde monde, VueJoueur vue) {
        boolean movingDown = value > 0;
        for (int i = 0; i < Math.abs(value); i++) {
            for (Node platform : monde.platforms) {
                if (vue.spriteJoueur.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    if (movingDown) {
                        if (vue.spriteJoueur.getTranslateY() + 80 == platform.getTranslateY()) {
                            vue.spriteJoueur.setTranslateY(vue.spriteJoueur.getTranslateY() - 1);
                            canJump = true;
                            return;
                        }
                    } else {
                        if (vue.spriteJoueur.getTranslateY() == platform.getTranslateY() + 80) {
                            return;
                        }
                    }
                }
            }
            vue.spriteJoueur.setTranslateY(vue.spriteJoueur.getTranslateY() + (movingDown ? 1 : -1));
        }
    }

    public KeyCode getToucheJoueur(String touche){
        if(touche=="attaque"){
            return KeyCode.E;
        }
        if(touche=="gauche"){
            return KeyCode.Q;

        }
        if(touche=="droite"){
            return KeyCode.D;

        }
        if(touche=="saut"){
            return KeyCode.SPACE;

        }
        return KeyCode.A;
    }

    /**
     * Méthode qui va permettre de faire déplacer l'ennemi en récupérant les actions entré au clavier.
     *
     * @param monde Zone dans la quel est utilisé le joueur.
     * @param vue Vue du joueur qui est déplacé.
     */
    public void deplacementJoueur(Monde monde, VueJoueur vue) {

        if (isPressed(KeyCode.SPACE, monde) || isPressed(KeyCode.UP, monde) || isPressed(KeyCode.Q, monde) || isPressed(KeyCode.LEFT, monde) || isPressed(KeyCode.D, monde) || isPressed(KeyCode.RIGHT, monde)) {

            if ((isPressed(KeyCode.SPACE, monde) || isPressed(KeyCode.UP, monde)) && vue.spriteJoueur.getTranslateY() >= 5) {
                jumpPlayer();
            }
            if ((isPressed(KeyCode.Q, monde) || isPressed(KeyCode.LEFT, monde)) && vue.spriteJoueur.getTranslateX() + 40 <= monde.levelWidth - 5) {
                direction = "left";
                movePlayerX(-5, monde, vue);
            }
            if (isPressed(KeyCode.D, monde) || isPressed(KeyCode.RIGHT, monde) && vue.spriteJoueur.getTranslateX() + 40 <= monde.levelWidth - 5) {
                direction = "right";
                movePlayerX(5, monde, vue);
            }
            spriteCounter++;
            if (spriteCounter >= 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3) {
                    spriteNum = 4;
                } else if (spriteNum == 4) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        } else if (isPressed(KeyCode.SPACE, monde) == false || isPressed(KeyCode.UP, monde) == false || isPressed(KeyCode.Q, monde) == false || isPressed(KeyCode.LEFT, monde) == false || isPressed(KeyCode.D, monde) == false || isPressed(KeyCode.RIGHT, monde) == false) {
            if (direction == "right") {
                direction = "static";
            }
            if (direction == "left") {
                direction = "staticLeft";
            }

            spriteCounterStatic++;
            if (spriteCounterStatic >= 20) {
                if (spriteNumStatic == 1) {
                    spriteNumStatic = 2;
                } else if (spriteNumStatic == 2) {
                    spriteNumStatic = 1;
                }
                spriteCounterStatic = 0;
            }
        }
    }

    /**
     * Permet de savoir si une touche est appuyé ou non.
     * @param key touche qui est appuyé.
     * @param monde Monde dans lequel est utilisé la touche.
     * @return un booléen
     */
    private boolean isPressed(KeyCode key, Monde monde) {
        return monde.keys.getOrDefault(key, false);
    }
    /**
     * Exécute un saut sur le joueur.
     */
    private void jumpPlayer() {
        if (canJump) {
            direction="saut";
            playerVelocity = playerVelocity.add(0, -28);
            canJump = false;
        }
    }

    /**
     * Méthode qui gère la gravité du joueur.
     * Elle est exécutée en continu dans la méthode update du Gamepanel.
     *
     * @param monde monde dans le quel le joueur est situé.
     * @param vue Vue du joueur sur lequel est exécutée la gravité.
     */
    public void gravite(Monde monde, VueJoueur vue) {
        if (playerVelocity.getY() < 10) {
            playerVelocity = playerVelocity.add(0, 1);
        }
        movePlayerY((int) playerVelocity.getY(), monde, vue);
    }

    /**
     * Observe les déplacements du joueur et met un focus sur celui-çi
     * afin de pouvoir suivre ses déplacements.
     *
     * @param monde monde dans le quel est le joueur.
     * @param vue Vue du joueur qui est suivi.
     */
    public void observer(Monde monde, VueJoueur vue) {
        vue.spriteJoueur.translateXProperty().addListener((obs, old, newValue) -> {
            int offset = newValue.intValue();
            monde.gameRoot.setLayoutX(-(offset - 600));

        });
        vue.spriteJoueur.translateYProperty().addListener((obs, old, newValue) -> {
            int offsetY = newValue.intValue();
                monde.gameRoot.setLayoutY(-(offsetY - 525));
        });
    }

    /**
     * Gèrent l'attaque qu'effectue le joueur.
     *
     * @param monde monde dans le quel le joueur attaque.
     * @param vue Vue du joueur qui attaque.
     */
    public void attaque(Monde monde, VueJoueur vue) {

        if (spriteAttaque > 0 && spriteAttaque <= 4) {

            isAttack = true;
            spriteNumAttaque++;
        }

        if (spriteNumAttaque == 5 && spriteNumAttaque > 1) {

            if (spriteAttaque == 1) {
                enAttack=true;
                nbsprite=2;
                spriteAttaque = 2;


            } else if (spriteAttaque == 2) {
                enAttack=true;
                nbsprite=3;

                spriteAttaque = 3;

            } else if (spriteAttaque == 3) {
                enAttack=true;
                nbsprite=4;

                spriteAttaque = 4;


            } else if (spriteAttaque == 4) {
                enAttack=true;
                nbsprite=0;

                spriteAttaque = 0;


                isAttack = false;
            }
            spriteNumAttaque = 0;
        }
        if (delaiAttaque < 25 && delaiAttaque >= 1) {
            delaiAttaque++;
            return;
        }

        if (isPressed(KeyCode.E, monde) && spriteAttaque == 0) {
            if(direction=="right"||direction=="static") {
                directionAttaque = "right";
            }
            if(direction=="left"||direction=="staticLeft") {
                directionAttaque = "left";
            }
            spriteAttaque = 1;
            nbsprite=1;
            enAttack=true;
            delaiAttaque = 1;

        }

    }
}


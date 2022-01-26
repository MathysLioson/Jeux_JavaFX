package main;

import javafx.scene.Node;
import modele.personnage.Ennemi;
import javafx.scene.Scene;
import modele.personnage.Joueur;
import javafx.stage.Stage;
import vue.monde.Monde;
import vue.vuePersonnage.VueEnnemi;
import vue.vuePersonnage.VueJoueur;


import java.util.ArrayList;
import java.util.Iterator;
// pour la javadoc respecter l'arborescence
// faire la javadoc tool javadoc
// pour le jar allez dans setting artefect, choisir jar et from module ..., choisir la classe principale



/**
 * Cette classe permet de gérer les vues et les modèles de notre jeu.
 * C'est içi qu'on gère l'apparition du joueur, l'initialisation de la vue et des personnages,
 * les touches pour les déplacements, la construction du monde et la boucle de jeu.
 */
public class GamePanel {

    private Scene mainScene;
    private Stage mainStage;

    private int spawnX=825; // Le point x d'apparition de notre joueur
    private int spawnY=700; // Le point y d'apparition de notre joueur

    public int delaiAttaqueEnnemi = 0;
    public int fermeture =0 ;
    public int p=0, d=0;

    public ArrayList<VueEnnemi> listeEnnemi = new ArrayList<VueEnnemi>();

    Monde monde= new Monde();

    Joueur joueur =new Joueur(spawnX,spawnY,80,80);
    VueJoueur vueJoueur = new VueJoueur(joueur.x, joueur.y, joueur.hauteur, joueur.largeur);

    Ennemi e1 =new Ennemi(1000,815,80,80);
    VueEnnemi vueE1 = new VueEnnemi(e1.x, e1.y, e1.hauteur,e1.largeur);

    Ennemi e2 =new Ennemi(2300,815,80,80);
    VueEnnemi vueE2 = new VueEnnemi(e2.x, e2.y, e2.hauteur,e2.largeur);

    Ennemi e3 =new Ennemi(2800,600,80,80);
    VueEnnemi vueE3 = new VueEnnemi(e3.x, e3.y, e3.hauteur,e3.largeur);

    Ennemi e4=new Ennemi(3500,600,80,80);
    VueEnnemi vueE4 = new VueEnnemi(e4.x, e4.y, e4.hauteur,e4.largeur);

    Ennemi e5 =new Ennemi(4100,600,80,80);
    VueEnnemi vueE5 = new VueEnnemi(e5.x, e5.y, e5.hauteur,e5.largeur);

    Ennemi e6 =new Ennemi(4200,600,80,80);
    VueEnnemi vueE6 = new VueEnnemi(e6.x, e6.y, e6.hauteur,e6.largeur);

    Ennemi e7 =new Ennemi(5000,600,80,80);
    VueEnnemi vueE7 = new VueEnnemi(e7.x, e7.y, e7.hauteur,e7.largeur);

    Ennemi e8 =new Ennemi(5500,600,80,80);
    VueEnnemi vueE8 = new VueEnnemi(e8.x, e8.y, e8.hauteur,e8.largeur);

    Ennemi e9 =new Ennemi(6000,600,80,80);
    VueEnnemi vueE9 = new VueEnnemi(e9.x, e9.y, e9.hauteur,e9.largeur);

    /**
     * Le Gamepanel est le point central de notre programme.
     * Il permet d'instancier un monde et de gérer les interactions de celui-ci.
     */
    public GamePanel()  {
        monde.initContent();

        //music.music();
        mainScene = new Scene(monde.appRoot,1280, 768);
        mainStage = new Stage();

        mainStage.setScene(mainScene);

        mainScene.setOnKeyPressed(event -> monde.keys.put(event.getCode(), true));
        mainScene.setOnKeyReleased(event -> monde.keys.put(event.getCode(), false));

        vueJoueur.initVueJoueur(monde);

        vueE1.initEnnemi(monde);
        initListeEnnemi(vueE1);

        vueE2.initEnnemi(monde);
        initListeEnnemi(vueE2);

        vueE3.initEnnemi(monde);
        initListeEnnemi(vueE3);

        vueE4.initEnnemi(monde);
        initListeEnnemi(vueE4);

        vueE5.initEnnemi(monde);
        initListeEnnemi(vueE5);

        vueE6.initEnnemi(monde);
        initListeEnnemi(vueE6);

        vueE7.initEnnemi(monde);
        initListeEnnemi(vueE7);

        vueE8.initEnnemi(monde);
        initListeEnnemi(vueE8);

        vueE9.initEnnemi(monde);
        initListeEnnemi(vueE9);


    }
    // fonction éxecuté dans le thread

    /**
     * Méthode utilisée dans notre thread qui tourne en boucle.
     * Elle permet de mettre à jour toutes les actions des personnages.
     */
    public void frame() {

        //focus
        joueur.observer(monde,vueJoueur);

        //déplacement
        joueur.deplacementJoueur(monde,vueJoueur);

        e1.deplacementEnnemi(monde,vueE1);
        e2.deplacementEnnemi(monde,vueE2);
        e3.deplacementEnnemi(monde,vueE3);
        e4.deplacementEnnemi(monde,vueE4);
        e5.deplacementEnnemi(monde,vueE5);
        e6.deplacementEnnemi(monde,vueE6);
        e7.deplacementEnnemi(monde,vueE7);
        e8.deplacementEnnemi(monde,vueE8);
        e9.deplacementEnnemi(monde,vueE9);

        replaceJoueur(monde,vueJoueur);

        //attaque
        joueur.attaque(monde,vueJoueur);

        //annimationjoueur
        vueJoueur.annimationJoueur(joueur);
        vueJoueur.annimationAttaqueJoueur(joueur);

        vueE1.annimationEnnemi(e1);
        vueE2.annimationEnnemi(e2);
        vueE3.annimationEnnemi(e3);
        vueE4.annimationEnnemi(e4);
        vueE5.annimationEnnemi(e5);
        vueE6.annimationEnnemi(e6);
        vueE7.annimationEnnemi(e7);
        vueE8.annimationEnnemi(e8);
        vueE9.annimationEnnemi(e9);

        //System.out.println("x : "+e1.spriteEnnemi.getTranslateX());

        //Gravité
        joueur.gravite(monde,vueJoueur);

        e1.gravite(monde,vueE1);
        e2.gravite(monde,vueE2);
        e3.gravite(monde,vueE3);
        e4.gravite(monde,vueE4);
        e5.gravite(monde,vueE5);
        e6.gravite(monde,vueE6);
        e7.gravite(monde,vueE7);
        e8.gravite(monde,vueE8);
        e9.gravite(monde,vueE9);
        //Ramassage des pièces
        coinRefresh(monde, vueJoueur);

        //dégat ennemi
        ennemiRefresh(monde, vueJoueur);

        //point de vie
        vueJoueur.healthRefresh();

        //fermeture = vueJoueur.healthRefresh(monde);
        gameOverCloseW(fermeture);
    }

    /**
     * Permet de savoir quand ouvrir la fenêtre du game over.
     *
     * @param c Paramètre qui permet de savoir si le joueur est mort.
     * @return retourne false si le joueur est en vie et true s'il est mort.
     */
    public Boolean gameOverCloseW(int c){
        if (c==1){
            return true;
        }
        return false;
    }

    /**
     * Permet d'obtenir le stage.
     *
     * @return Retourne le stage de gamepanel
     */
    public Stage getMainStage() {
        return mainStage;
    }

    /**
     * Met à jour l'état des pièces.
     * Elles disparaissent si, au fur et à mesure, que le joueur les ramasses.
     *
     * @param monde zone dans la quels les pièces apparaissent.
     * @param j joueur qui ramasse les pièces.
     */
    public void coinRefresh(Monde monde, VueJoueur j){
        for (Node coin : monde.coins){
            if(j.spriteJoueur.getBoundsInParent().intersects(coin.getBoundsInParent())){
                coin.getProperties().put("alive", false);
                p=j.gainPiece();
            }
        }

        for(Iterator<Node> it = monde.coins.iterator(); it.hasNext();){
            Node coin = it.next();
            if(!(Boolean)coin.getProperties().get("alive")){
                it.remove();
                coin.setVisible(false);
            }
        }

    }

    /**
     * Replace le joueur au début du niveau ou au point de contrôle le plus proche récemment utilisé.
     *
     * @param monde zone ou circule le joueur
     * @param joueur Joueur concerné
     */
    public void replaceJoueur(Monde monde, VueJoueur joueur){
        for (Node water : monde.waterBlocks) {
            if (joueur.spriteJoueur.getBoundsInParent().intersects(water.getBoundsInParent())) {
                joueur.prendreDegat();
                joueur.spriteJoueur.setTranslateX(spawnX);
                joueur.spriteJoueur.setTranslateY(spawnY - 150);

            }
        }
    }

    /**
     * Méthode permet de mettre à jour l'état d'un ennemi et de le faire disparaitre
     * s'il s'est fait tuer par le joueur.
     * Cette méthode permet aussi de réaliser les dégâts sur le joueur s'il s'approche trop près du serpent.
     *
     * @param monde zone ou circule le serpent.
     * @param j joueur avec lequel il peut entrer en contact.
     */
    public void ennemiRefresh(Monde monde, VueJoueur j){
        if(delaiAttaqueEnnemi==0){
            for (VueEnnemi e : listeEnnemi){ //sprite épée =======\
                if(e.spriteEnnemi.getBoundsInParent().intersects(j.spriteJoueur.getBoundsInParent())){
                    //e.killEnnemi();
                    d=j.prendreDegat();
                    System.out.println("hp : "+d);
                }
            }
            for (VueEnnemi e : listeEnnemi){ //sprite épée =======\
                if(e.spriteEnnemi.getBoundsInParent().intersects(j.spriteAttaqueJoueur.getBoundsInParent())){
                    e.killEnnemi();
                }
            }

            for(Iterator<VueEnnemi> it = listeEnnemi.iterator(); it.hasNext();){
                VueEnnemi e = it.next();
                if(e.isAlive()==false){
                    it.remove();
                    e.spriteEnnemi.setVisible(false);
                }
            }
        }
        delaiAttaqueEnnemi++;
        if(delaiAttaqueEnnemi==20){
            delaiAttaqueEnnemi=0;
        }
    }
    /**
     * Cette méthode permet d'affecter les ennemis a la liste des ennemis.
     *
     * @param e Ennemi à rajouter dans la liste.
     */
    public void initListeEnnemi (VueEnnemi e){
        this.listeEnnemi.add(e);
    }
}

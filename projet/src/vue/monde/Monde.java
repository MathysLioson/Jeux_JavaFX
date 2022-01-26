package vue.monde;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import modele.Createur;
import modele.Map1;
import vue.vuePersonnage.VueEnnemi;

/**
 * Cette classe permet la création d'un monde avec la MAP1 située dans le package modele.
 * C'est içi qu'on crées les plans de notre jeu.
 * On affecte aussi les diférentes tailles des blocs et éléments de notre jeu.
 * On crée les différents éléments graphiques de notre jeu afin de les affiché avec la vue dédié.
 */
public class Monde {

    Image image = new Image(getClass().getResourceAsStream("/images/background.png"));

    private int tailleBlock = 60;
    private int taillePlatformBlock = 60;
    private int taillePieceBlock = 48;
    public int levelWidth;

    private ImageView backgroundMonde = new ImageView(image);

    private Createur createur = new Createur();

    public Pane appRoot = new Pane();
    public Pane gameRoot = new Pane();
    public Pane uiRoot = new Pane(); // interface Utilisateur barre de vie etc..

    public AnchorPane piece;

    public ArrayList<Node> platforms = new ArrayList<Node>();
    public ArrayList<Node> waterBlocks = new ArrayList<Node>();
    private ArrayList<Node> decors = new ArrayList<Node>();
    public ArrayList<Node> coins = new ArrayList<Node>();
    private ArrayList<Node> quit = new ArrayList<Node>();
    private ArrayList<VueEnnemi> listeEnnemi = new ArrayList<VueEnnemi>();
    public HashMap<KeyCode, Boolean> keys= new HashMap<KeyCode, Boolean>();


    /**
     * Cette méthode va permettre d'initialiser le contenu de notre monde.
     * On va affecter la taille du background puis charger l'affichage des pièces en FXML.
     * Ensuite pour tout les caractères contenu dans MAP1, on va les remplacer dans le monde
     * par des blocs "physiques".
     */
    public void initContent() {
        backgroundMonde.setFitWidth(1280);
        backgroundMonde.setFitHeight(900);
        try {
            piece = FXMLLoader.load(getClass().getResource("/fxml/piece.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.levelWidth = Map1.MAP1[0].length() * taillePlatformBlock;

        for (int i = 0; i<Map1.MAP1.length; i++){
            String line = Map1.MAP1[i];
            for (int j = 0; j< line.length(); j++){
                switch (line.charAt(j)){
                    case '0':
                        break;
                    case '1':
                        Node platform1 = createur.CreerTexture(j*tailleBlock, i*tailleBlock,taillePlatformBlock,taillePlatformBlock, "/tiles/platforme/terre.png", this);
                        this.platforms.add(platform1);
                        break;
                    case 'G':
                        Node plateformeTerreG = createur.CreerTexture(j*tailleBlock, i*tailleBlock,taillePlatformBlock,taillePlatformBlock, "/tiles/platforme/terreGauche.png", this);
                        this.platforms.add(plateformeTerreG);
                        break;
                    case 'D':
                        Node plateformeTerreD = createur.CreerTexture(j*tailleBlock, i*tailleBlock,taillePlatformBlock,taillePlatformBlock, "/tiles/platforme/terreDroite.png", this);
                        this.platforms.add(plateformeTerreD);
                        break;
                    case 'V':
                        Node remplissage = createur.CreerTexture(j*tailleBlock, i*tailleBlock,taillePlatformBlock,taillePlatformBlock, "/tiles/platforme/remplissage.png", this);
                        this.platforms.add(remplissage);
                        break;
                    case 'O':
                        Node minerauxO = createur.CreerTexture(j*tailleBlock, i*tailleBlock,taillePlatformBlock,taillePlatformBlock, "/tiles/platforme/minerauxO.png", this);
                        this.platforms.add(minerauxO);
                        break;
                    case 'A':
                        Node verticaleG = createur.CreerTexture(j*tailleBlock, i*tailleBlock,taillePlatformBlock,taillePlatformBlock, "/tiles/platforme/verticaleG.png", this);
                        this.platforms.add(verticaleG);
                        break;
                    case 'E':
                        Node verticaleD = createur.CreerTexture(j*tailleBlock, i*tailleBlock,taillePlatformBlock,taillePlatformBlock, "/tiles/platforme/verticaleD.png", this);
                        this.platforms.add(verticaleD);
                        break;
                    case 'B':
                        Node cornerG = createur.CreerTexture(j*tailleBlock, i*tailleBlock,taillePlatformBlock,taillePlatformBlock, "/tiles/platforme/cornerG.png", this);
                        this.platforms.add(cornerG);
                        break;
                    case 'C':
                        Node cornerD = createur.CreerTexture(j*tailleBlock, i*tailleBlock,taillePlatformBlock,taillePlatformBlock, "/tiles/platforme/cornerD.png", this);
                        this.platforms.add(cornerD);
                        break;
                    case '2':
                        Node waterBlock = createur.CreerTexture(j*tailleBlock, i*tailleBlock,taillePlatformBlock,taillePlatformBlock, "/tiles/eau/eau1.png", this);
                        this.waterBlocks.add(waterBlock);
                        break;
                    case '3':
                        Node waterBlock2 = createur.CreerTexture(j*tailleBlock, i*tailleBlock,taillePlatformBlock,taillePlatformBlock, "/tiles/eau/eau2.png", this);
                        this.waterBlocks.add(waterBlock2);
                        break;
                    case '#':
                        Node barierreInvisible = createur.CreerTexture(j*tailleBlock, i*tailleBlock,taillePlatformBlock,taillePlatformBlock, "", this);
                        this.platforms.add(barierreInvisible);
                        break;
                    case 'o':
                        Node coin = createur.CreerTexture(j*tailleBlock, i*tailleBlock,taillePieceBlock,taillePieceBlock, "/tiles/coin/coin_01.png", this);
                        this.coins.add(coin);
                        break;
                    case 'p':
                        Node fleur = createur.CreerTexture(j*tailleBlock, i*tailleBlock,taillePlatformBlock,taillePlatformBlock, "/tiles/decoration/jaune.png", this);
                        this.decors.add(fleur);
                        break;
                    case 'q':
                        Node cailloux1 = createur.CreerTexture(j*tailleBlock, i*tailleBlock,taillePlatformBlock,taillePlatformBlock, "/tiles/decoration/cailloux1.png", this);
                        this.decors.add(cailloux1);
                        break;
                }
            }
        }

        this.appRoot.getChildren().addAll(this.backgroundMonde, this.gameRoot,this.uiRoot,this.piece);
    }


}
package vue.menuPrincipal;

import controller.ControllerParametre;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.MainGame;
import java.io.IOException;

/**
 * Cette classe permet de créer les différents button de notre menu en javaFx
 */
public class createMenuContent {

    private Image image = new Image(getClass().getResourceAsStream("/images/menu.png"));
    private ImageView backgroundMonde = new ImageView(image);
    private Pane parametre = new Pane();
    private Pane fxparametre = new Pane();

    /**
     * Constructeur qui permet de créer un menu et qui nous redirige e
     * @return retourne le parent de Createcontent
     */
    public Parent createContent(){
        Pane root = new Pane();
        try {
            fxparametre= FXMLLoader.load(getClass().getResource("/fxml/parametre.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        root.setPrefSize(1280,720);

        backgroundMonde.setFitWidth(1280);
        backgroundMonde.setFitHeight(768);

        root.getChildren().add(backgroundMonde);


        TitreMenu title = new TitreMenu("HONOR KNIGHT");
        title.setTranslateX(350);
        title.setTranslateY(200);

        MenuItem jouer;
        MenuItem param;
        MenuItem quit;
        MenuBox vbox = new MenuBox(
                jouer = new MenuItem("JOUER"),
                param = new MenuItem("PARAMETRES"),
                quit = new MenuItem("QUITTER")
        );

        jouer.setOnMousePressed(e->{
            MainGame starter = null;
            starter = new MainGame();
            Stage stage = (Stage) backgroundMonde.getScene().getWindow();
            stage.close();
            starter.start(stage);
        });
        param.setOnMousePressed(e->{

            Stage stage = (Stage) backgroundMonde.getScene().getWindow();
            stage.close();
            ControllerParametre controle= new ControllerParametre();
            parametre.getChildren().add(backgroundMonde);
            parametre.getChildren().add(fxparametre);
            Scene parame=new Scene(parametre);

            stage.setScene(parame);

            stage.show();
        });

        quit.setOnMousePressed(e->{
            Stage stage = (Stage)this.backgroundMonde.getScene().getWindow();
            stage.close();
        });
        vbox.setTranslateX(530);
        vbox.setTranslateY(300);

        root.getChildren().addAll(title,vbox);

        return root;
    }
}

package main;

import com.sun.javafx.application.PlatformImpl;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


import javax.sound.sampled.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Classe qui permet de lancer la fenêtre de notre jeu et de lancer le thread.
 * Elle permet aussi de lancer la musique de fond du jeu.
 */
public class MainGame extends Application implements Runnable {
    private boolean running = false;

    GamePanel gp = new GamePanel();

    private Thread thread; // création du thread
    private PlatformImpl Plaform;

    URL url;
    {
        try {
            url = new URL(getClass().getResource("/sounds/LongAwayHome.wav").toExternalForm());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    AudioInputStream audioInput;
    {
        try {
             audioInput = AudioSystem.getAudioInputStream(url);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Clip clip;
    {
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cette méthode permet de faire la mise en forme de notre jeu
     * et l'afficher.
     *
     * @param scene affiche notre jeu
     */
    @Override
    public void start(Stage scene) {
        try {
            clip.open(audioInput);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        clip.start();

        scene = gp.getMainStage();
        scene.setResizable(false);
        scene.setTitle("Honor Knight");
        scene.show();
        startGame();

        System.out.println("Game is running: " + running);

        //Ferme le jeu quand on ferme la fenêtre
        scene.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                running = false;
                System.exit(1);
            }
        });
    }

    //Le thread

    /**
     * Cette méthode, c'est le thread qui tourne en continu quand on lance le jeu.
     */
    public void run() {
        final double FPS = 60;

        double Drawinterval = 1000000000/FPS;
        double delta = 0;

        long lastTime = System.nanoTime();
        long currentTime;

        int frameCount = 0;

        long timer = 0;

        while (running) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / Drawinterval;
            timer +=(currentTime - lastTime);
            lastTime = currentTime;

            //gp.modele.joueur.getStrPieces();
            if(delta >= 1) {
                gp.frame();
                if(gp.fermeture==1){
                    running=false;
                    //lanceGameOver(gp.getMainStage());
                }
                frameCount++;
                delta--;
            }

            //FPS counter
            if(timer >= 1000000000) {

                //System.out.println("Fps : " + frameCount);
                frameCount = 0;
                timer = 0;
            }
        }
    }

    /**
     * Lance l'affichage de la fenêtre game over.
     *
     * @param stage Prend le stage actuel en paramètre afin de le changer.
     */
    public void lanceGameOver(Stage stage){
        stage.close();
    }

    /**
     * Lance le thread qui va s'exécuter en continu.
     */
    public synchronized void startGame() {
        if(running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

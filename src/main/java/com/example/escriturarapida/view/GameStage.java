package com.example.escriturarapida.view;

import com.example.escriturarapida.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.escriturarapida.Main.stageWindow;


public class GameStage extends Stage {
    public GameStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(Path.EscrituraRapidaGameView)
        );


        Parent root = loader.load();
        Scene scene = new Scene(root);
        setResizable(false);
        setTitle("Escritura Rápida");
        setScene(scene);
        show();

    }
}

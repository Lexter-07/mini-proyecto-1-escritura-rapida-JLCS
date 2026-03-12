package com.example.escriturarapida.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class GameStage extends Stage {
    public GameStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(Path.EscrituraRapidaGameView)
        );

        Parent root = loader.load();
        Scene scene = new Scene(root);
        setScene(scene);

        show();

    }
}

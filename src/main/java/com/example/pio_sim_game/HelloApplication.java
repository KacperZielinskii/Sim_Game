package com.example.pio_sim_game;

//Do usuniecia

import com.example.pio_sim_game.controllers.ColorController;
import com.example.pio_sim_game.controllers.GameController;
import com.example.pio_sim_game.controllers.MenuController;
import com.example.pio_sim_game.models.GameModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader menuLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/SIMMenu.fxml"));
        Scene menuScene = new Scene(menuLoader.load(), 1280, 800);
        MenuController menuController = menuLoader.getController();

        FXMLLoader colorLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/colorSelection.fxml"));
        Scene colorScene = new Scene(colorLoader.load(), 1280, 800);
        ColorController colorController = colorLoader.getController();

        FXMLLoader gameLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/game-view.fxml"));
        Scene gameScene = new Scene(gameLoader.load(), 1280, 800);
        GameController gameController = gameLoader.getController();

        GameModel gameModel = new GameModel();
        colorController.initModel(gameModel);
        gameController.initModel(gameModel);

        menuController.setNextScene(colorScene);
        colorController.setNextScene(gameScene);

        stage.setTitle("Sim Game");
        stage.setScene(menuScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
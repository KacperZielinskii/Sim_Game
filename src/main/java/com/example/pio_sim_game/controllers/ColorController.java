package com.example.pio_sim_game.controllers;

import com.example.pio_sim_game.models.GameModel;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ColorController {

    private GameModel model;
    private Scene scene;

    public void initModel(GameModel model) {
        this.model = model;
    }

    public void setNextScene(Scene scene) {
        this.scene = scene;
    }
    @FXML
    private void GoToGame(ActionEvent event)
    {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}

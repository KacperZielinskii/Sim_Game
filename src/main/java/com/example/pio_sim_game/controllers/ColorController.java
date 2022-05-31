package com.example.pio_sim_game.controllers;

import com.example.pio_sim_game.models.GameModel;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.stage.Stage;

public class ColorController {

    private GameModel model;
    private Scene scene;

    @FXML private ColorPicker playerColor1;
    @FXML private ColorPicker playerColor2;

    public void initModel(GameModel model) {
        this.model = model;

        playerColor1.valueProperty().bind(this.model.playerColor1Property());
        playerColor2.valueProperty().bind(this.model.playerColor2Property());

        //Nazwy graczy
    }

    public void setNextScene(Scene scene) {
        this.scene = scene;
    }
    @FXML
    private void GoToGame(ActionEvent event)
    {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        //initGame
    }
}

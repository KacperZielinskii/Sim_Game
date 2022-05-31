package com.example.pio_sim_game.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    private Scene scene;

    public void setNextScene(Scene scene) {
        this.scene = scene;
    }
    @FXML
    private void GoToColorPicking(ActionEvent event)
    {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void EndGame()
    {
        System.exit(0);
    }
}

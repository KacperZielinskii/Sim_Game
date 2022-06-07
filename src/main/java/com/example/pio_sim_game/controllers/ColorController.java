package com.example.pio_sim_game.controllers;

import com.example.pio_sim_game.models.GameModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColorController {

    private GameModel model;
    private Scene scene;

    @FXML private ColorPicker playerColor1;
    @FXML private ColorPicker playerColor2;
    @FXML private Label errorMsg;

    public void initModel(GameModel model) {
        this.model = model;
    }

    public void setNextScene(Scene scene) {
        this.scene = scene;
    }
    @FXML
    private void GoToGame(ActionEvent event)
    {
        if(!validateColors(toRGBCode(playerColor1.getValue()), toRGBCode(playerColor2.getValue()))) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            this.model.setColors(toRGBCode(playerColor1.getValue()), toRGBCode(playerColor2.getValue()));
        }
        else {
            errorMsg.setText("Wybrano takie same kolory!");
        }
    }

    private String toRGBCode(Color color) {
        return String.format( "#%02X%02X%02X",
                (int)( color.getRed() * 255 ),
                (int)( color.getGreen() * 255 ),
                (int)( color.getBlue() * 255 ) );
    }

    private boolean validateColors(String color1, String color2) {
        if(color1.equals(color2)) {
            return true;
        }
        return false;
    }
}

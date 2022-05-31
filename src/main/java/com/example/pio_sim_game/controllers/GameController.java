package com.example.pio_sim_game.controllers;

import com.example.pio_sim_game.models.GameModel;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class GameController {

    private GameModel model;
    @FXML private Label playerName1;
    @FXML private Label playerName2;
    @FXML private Pane playerColor1;
    @FXML private Pane playerColor2;
    @FXML private Label playerScore1;
    @FXML private Label playerScore2;

    private ArrayList<Line> lines;

    public void initialize() {
        //todo pobranie linii z fxml
    }

    public void initModel(GameModel model) {
        this.model = model;

        playerScore1.textProperty().bind(this.model.playerScore1Property());
        playerScore2.textProperty().bind(this.model.playerScore2Property());
    }

    @FXML
    private void onResetButtonClick(Event event) {

    }

    @FXML
    private void onCloseButtonClick(Event event) {

    }
}

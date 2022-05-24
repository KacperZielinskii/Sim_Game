package com.example.pio_sim_game.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class GameController {
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

    @FXML
    private void onResetButtonClick(Event event) {

    }

    @FXML
    private void onCloseButtonClick(Event event) {

    }
}

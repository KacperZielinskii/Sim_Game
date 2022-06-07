package com.example.pio_sim_game.controllers;

import com.example.pio_sim_game.models.GameModel;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class GameController {

    private GameModel model;
    @FXML private Label playerScore1;
    @FXML private Label playerScore2;
    @FXML private Pane game;

    private ArrayList<Line> lines;

    public void initialize() {
        lines = new ArrayList<Line>();
        for(int i = 0; i < 15; i++) {
            lines.add((Line)game.getChildren().get(i));
        }

        for(int i = 0; i < 15; i++) {
            int finalI = i;
            game.getChildren().get(i).addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    int id = finalI;
                    int currentPlayerID = model.getCurrentPlayerID();
                    if(model.isEmpty(id))
                    {
                        if (currentPlayerID == 1)
                        {
                            ((Line) mouseEvent.getSource()).setStyle("-fx-stroke: " + model.getColor1());
                        } else
                        {
                            ((Line) mouseEvent.getSource()).setStyle("-fx-stroke: " + model.getColor2());
                        }
                        if(model.round(id)) {
                            for(int i = 0; i < 15; i++) {
                                lines.get(i).setStyle("-fx-stroke: " + model.getDefaultColor());
                            }
                            model.reset();
                        }
                        mouseEvent.consume();
                    }
                }
            });
        }
    }

    public void initModel(GameModel model) {
        this.model = model;

        playerScore1.textProperty().bind(this.model.playerScore1Property());
        playerScore2.textProperty().bind(this.model.playerScore2Property());
    }

    @FXML
    private void onResetButtonClick(Event event) {
        model.reset();
        model.resetScore();
    }

    @FXML
    private void onCloseButtonClick(Event event) {
        System.exit(0);
    }
}

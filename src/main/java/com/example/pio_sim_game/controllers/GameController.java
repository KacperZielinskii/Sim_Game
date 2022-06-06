package com.example.pio_sim_game.controllers;

import com.example.pio_sim_game.classes.Point;
import com.example.pio_sim_game.models.GameModel;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
    @FXML private Pane game;

    //private ArrayList<Node> lines;

    public void initialize() {
        ArrayList<Node> lines = new ArrayList<Node>();
        for(int i = 0; i < 15; i++) {
            if(game.getChildren().get(i) instanceof Line) {
                lines.add(game.getChildren().get(i));
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
                                ((Line) mouseEvent.getSource()).setStyle("-fx-stroke: red");
                            } else
                            {
                                ((Line) mouseEvent.getSource()).setStyle("-fx-stroke: blue");
                            }
                            model.round(id);
                            mouseEvent.consume();
                        }
                    }
                });
            }
        }
    }

    public void initModel(GameModel model) {
        this.model = model;

        ArrayList<Line> lines = new ArrayList<Line>();
        for(int i = 0; i < 15; i++) {
            lines.add((Line)game.getChildren().get(i));
        }
        model.initLineObjects(lines);

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

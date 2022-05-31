package com.example.pio_sim_game.models;

import javafx.beans.property.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class GameModel {
    private ObjectProperty<Color> playerColor1;
    private ObjectProperty<Color> playerColor2;
    private StringProperty playerScore1;
    private StringProperty playerScore2;

    public GameModel() {
        playerColor1 = new SimpleObjectProperty<Color>();
        playerColor2 = new SimpleObjectProperty<Color>();
        playerScore1 = new SimpleStringProperty();
        playerScore2 = new SimpleStringProperty();
    }

    public Color getPlayerColor1() {
        return playerColor1.get();
    }

    public ObjectProperty<Color> playerColor1Property() {
        return playerColor1;
    }

    public Color getPlayerColor2() {
        return playerColor2.get();
    }

    public ObjectProperty<Color> playerColor2Property() {
        return playerColor2;
    }

    public String getPlayerScore1() {
        return playerScore1.get();
    }

    public StringProperty playerScore1Property() {
        return playerScore1;
    }

    public String getPlayerScore2() {
        return playerScore2.get();
    }

    public StringProperty playerScore2Property() {
        return playerScore2;
    }

    public void setPlayerColor1(Color playerColor1) {
        this.playerColor1.set(playerColor1);
    }

    public void setPlayerColor2(Color playerColor2) {
        this.playerColor2.set(playerColor2);
    }
}

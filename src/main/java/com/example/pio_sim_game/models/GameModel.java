package com.example.pio_sim_game.models;

import com.example.pio_sim_game.classes.MyLine;
import com.example.pio_sim_game.classes.Player;
import com.example.pio_sim_game.classes.Point;
import javafx.beans.property.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class GameModel {

    private Player p1;
    private Player p2;
    private int currentPlayerID;
    private Point points[];

    private ObjectProperty<Color> playerColor1;
    private ObjectProperty<Color> playerColor2;
    private StringProperty playerScore1;
    private StringProperty playerScore2;

    private int score1;
    private int score2;

    private ArrayList<MyLine> myLines;

    public GameModel() {
        myLines = new ArrayList<MyLine>();

        myLines.add(new MyLine(new Point(0), new Point(5), 0));
        myLines.add(new MyLine(new Point(0), new Point(1), 1));
        myLines.add(new MyLine(new Point(5), new Point(4), 2));
        myLines.add(new MyLine(new Point(4), new Point(3), 3));
        myLines.add(new MyLine(new Point(3), new Point(2), 4));
        myLines.add(new MyLine(new Point(1), new Point(2), 5));
        myLines.add(new MyLine(new Point(5), new Point(2), 6));
        myLines.add(new MyLine(new Point(0), new Point(4), 7));
        myLines.add(new MyLine(new Point(5), new Point(1), 8));
        myLines.add(new MyLine(new Point(5), new Point(3), 9));
        myLines.add(new MyLine(new Point(0), new Point(3), 10));
        myLines.add(new MyLine(new Point(0), new Point(2), 11));
        myLines.add(new MyLine(new Point(1), new Point(4), 12));
        myLines.add(new MyLine(new Point(2), new Point(4), 13));
        myLines.add(new MyLine(new Point(1), new Point(3), 14));

        initPoints();
        score1 = 0;
        score2 = 0;

        playerColor1 = new SimpleObjectProperty<Color>();
        playerColor2 = new SimpleObjectProperty<Color>();
        playerScore1 = new SimpleStringProperty();
        playerScore2 = new SimpleStringProperty();

        playerScore1.set("0");
        playerScore2.set("0");
    }

    public void initLineObjects(ArrayList<Line> lines) {
        for(int i = 0; i < 15; i++) {
            myLines.get(i).setLineObject(lines.get(i));
        }
    }

    private void initPoints()
    {
        points = new Point[6];
        for (int i = 0; i < 6; i++)
        {
            points[i] = new Point(i);
        }
    }

    public int getCurrentPlayerID() {
        return currentPlayerID;
    }

    public void round(int id) {
        if(currentPlayerID == 1) {
            currentPlayerID = 2;
        }
        else {
            currentPlayerID = 1;
        }

        boolean res = checkTriangles(myLines.get(id).getPoint1(), myLines.get(id).getPoint2(), currentPlayerID);

        if(res) {
            if(currentPlayerID == 2) {
                score2 = score2 + 1;
                playerScore2.set("" + score2);
            }
            else {
                score1 = score1 + 1;
                playerScore1.set("" + score1);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            reset();
        }
    }

    public void reset() {
        currentPlayerID = 1;
        for(int i = 0; i < 15; i++) {
            myLines.get(i).reset();
        }
        for(int i = 0; i < 6; i++) {
            points[i].reset();
        }
    }

    public void resetScore() {
        score1 = 0;
        score2 = 0;
        playerScore1.set("" + score1);
        playerScore2.set("" + score2);
    }

    public boolean checkTriangles(Point fir, Point sec, int player)
    {
        connectThePoints(fir, sec, player);
        for (int i = 0; i < 6; i++)
        {
            boolean isTriangle = points[i].getConnection()[fir.getPoint()]&&points[i].getConnection()[sec.getPoint()];
            boolean samePlayer = points[i].getPlayerID()[fir.getPoint()]==player&&points[i].getPlayerID()[sec.getPoint()]==player;
            if (!(i == fir.getPoint()) || !(i == sec.getPoint()))
            {
                if(isTriangle && samePlayer)
                {
                    System.out.println("Gracz: " + player);
                    return true;
                }
            }
        }
        return false;
    }

    private void connectThePoints(Point fir, Point sec, int player)
    {
        points[fir.getPoint()].getConnection()[sec.getPoint()] = true;
        points[sec.getPoint()].getConnection()[fir.getPoint()] = true;

        points[fir.getPoint()].getPlayerID()[sec.getPoint()] = player;
        points[sec.getPoint()].getPlayerID()[fir.getPoint()] = player;
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

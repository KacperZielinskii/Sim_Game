package com.example.pio_sim_game.models;

import com.example.pio_sim_game.classes.MyLine;
import com.example.pio_sim_game.classes.Point;
import javafx.beans.property.*;

import java.util.ArrayList;

public class GameModel {
    private int currentPlayerID;
    private Point points[];
    private StringProperty playerScore1;
    private StringProperty playerScore2;

    private int score1;
    private int score2;
    private String color1;
    private String color2;
    private String defaultColor;

    private ArrayList<MyLine> myLines;

    public GameModel() {
        myLines = new ArrayList<MyLine>();

        myLines.add(new MyLine(new Point(0), new Point(5)));
        myLines.add(new MyLine(new Point(0), new Point(1)));
        myLines.add(new MyLine(new Point(5), new Point(4)));
        myLines.add(new MyLine(new Point(4), new Point(3)));
        myLines.add(new MyLine(new Point(3), new Point(2)));
        myLines.add(new MyLine(new Point(1), new Point(2)));
        myLines.add(new MyLine(new Point(5), new Point(2)));
        myLines.add(new MyLine(new Point(0), new Point(4)));
        myLines.add(new MyLine(new Point(5), new Point(1)));
        myLines.add(new MyLine(new Point(5), new Point(3)));
        myLines.add(new MyLine(new Point(0), new Point(3)));
        myLines.add(new MyLine(new Point(0), new Point(2)));
        myLines.add(new MyLine(new Point(1), new Point(4)));
        myLines.add(new MyLine(new Point(2), new Point(4)));
        myLines.add(new MyLine(new Point(1), new Point(3)));

        initPoints();
        score1 = 0;
        score2 = 0;

        defaultColor = "#ABA6BF";

        playerScore1 = new SimpleStringProperty();
        playerScore2 = new SimpleStringProperty();

        playerScore1.set("0");
        playerScore2.set("0");
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

    public boolean round(int id) {
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
            return true;
        }
        return false;
    }

    public void reset() {
        currentPlayerID = 1;
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
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEmpty(int id)
    {
        Point fir = myLines.get(id).getPoint1();
        Point sec = myLines.get(id).getPoint2();
        return !(points[fir.getPoint()].getConnection()[sec.getPoint()] && points[sec.getPoint()].getConnection()[fir.getPoint()]);
    }

    private void connectThePoints(Point fir, Point sec, int player)
    {
        points[fir.getPoint()].getConnection()[sec.getPoint()] = true;
        points[sec.getPoint()].getConnection()[fir.getPoint()] = true;

        points[fir.getPoint()].getPlayerID()[sec.getPoint()] = player;
        points[sec.getPoint()].getPlayerID()[fir.getPoint()] = player;
    }

    public void setColors(String color1, String color2) {
        this.color1 = color1;
        this.color2 = color2;
    }

    public StringProperty playerScore1Property() {
        return playerScore1;
    }

    public StringProperty playerScore2Property() {
        return playerScore2;
    }

    public String getColor1() {
        return color1;
    }

    public String getColor2() {
        return color2;
    }

    public String getDefaultColor() {
        return defaultColor;
    }
}

package com.example.pio_sim_game.classes;

import javafx.scene.shape.Line;

public class MyLine {
    int lineID;
    int ownerID;
    String colorHex;
    Point point1;
    Point point2;
    Line line;

    public MyLine(Point p1, Point p2, int lineID){
        this.lineID = lineID;
        point1=p1;
        point2=p2;
        colorHex="d3d3d3ff";
    }

    public void setLine(String hex, int id) {
        ownerID=id;
        colorHex=hex;
    }

    public void setLineObject(Line line) {
        this.line = line;
    }

    public void reset() {
        line.setStyle("-fx-stroke: #" + colorHex);
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }
}

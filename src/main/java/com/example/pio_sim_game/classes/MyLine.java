package com.example.pio_sim_game.classes;

public class MyLine {
    private Point point1;
    private Point point2;

    public MyLine(Point p1, Point p2){
        point1=p1;
        point2=p2;
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }
}

package com.example.pio_sim_game.classes;

public class Line {
    int ownerID;
    String colorHex;
    Point point1;
    Point point2;
    boolean isSet;

    Line(Point p1, Point p2){
        isSet=false;
        point1=p1;
        point2=p2;
        colorHex="d3d3d3ff";
    }

    void setLine(String hex, int id) {
        ownerID=id;
        colorHex=hex;
        isSet=true;
    }
}

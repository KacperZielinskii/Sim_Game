package com.example.pio_sim_game.classes;

public class Point {
    private int point;
    private boolean connection[];
    private int playerID[];

    public Point(int id)
    {
        point = id;
        connection = new boolean[6];
        playerID = new int[6];
        for(int i=0; i<6; i++)
        {
            connection[i] = false;
        }
    }

    public int getPoint() {
        return point;
    }

    public boolean[] getConnection() {
        return connection;
    }

    public int[] getPlayerID() {
        return playerID;
    }

    public void reset() {
        for(int i = 0; i < 6; i++) {
            connection[i] = false;
            playerID[i] = 0;
        }
    }
}

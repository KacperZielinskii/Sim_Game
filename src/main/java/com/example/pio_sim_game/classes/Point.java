package com.example.pio_sim_game.classes;

public class Point
{
    int point;
    boolean connection[];
    int playerID[];

    Point()
    {
        connection = new boolean[6];
        playerID = new int[6];
        for(int i=0; i<6; i++)
        {
            connection[i] = false;
        }
    }
}

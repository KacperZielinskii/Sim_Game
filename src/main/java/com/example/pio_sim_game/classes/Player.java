package com.example.pio_sim_game.classes;

public class Player
{
    private Integer ID;
    private String color;

    Player(Integer ID, String color)
    {
        this.ID = ID;
        this.color = color;
    }

    public Integer getID()
    {
        return ID;
    }

    public String getColor()
    {
        return color;
    }

}

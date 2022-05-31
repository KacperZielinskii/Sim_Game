package com.example.pio_sim_game.classes;

public class GameSupport
{
    private Player p1;
    private Player p2;
    private Point points[];

    GameSupport()
    {
        initPlayers();
        initPoints();
    }

    private void initPlayers()
    {
        //TODO
    }

    private void initPoints()
    {
        points = new Point[6];
        for (int i = 0; i < 6; i++)
        {
            points[i] = new Point();
            points[i].point = i;
        }
    }

    public void checkTriangles(Point fir, Point sec, int player)
    {
        connectThePoints(fir, sec, player);
        for (int i = 0; i < 6; i++)
        {
            boolean isTriangle = points[i].connection[fir.point]&&points[i].connection[sec.point];
            boolean samePlayer = points[i].playerID[fir.point]==player&&points[i].playerID[sec.point]==player;
            if (!(i == fir.point) || !(i == sec.point))
            {
                if(isTriangle && samePlayer)
                {
                    endGame(player);
                }
            }
        }
    }

    private void connectThePoints(Point fir, Point sec, int player)
    {
        points[fir.point].connection[sec.point] = true;
        points[sec.point].connection[fir.point] = true;

        points[fir.point].playerID[sec.point] = player;
        points[sec.point].playerID[fir.point] = player;
    }

    private void endGame(int lostPlayer)
    {
        //TODO
    }

}

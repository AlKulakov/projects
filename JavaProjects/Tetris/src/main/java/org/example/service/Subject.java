package org.example.service;

import org.example.model.Coord;
import org.example.model.Figure;
import org.example.ui.Config;

public class Subject {
    private Figure figure;
    private Coord coord;
    public Subject(){
        figure = Figure.getRandom();
        coord = new Coord(Config.WIDTH / 2 - 2, figure.top.y - figure.bot.y-1);
    }
    public Figure getFigure(){
        return figure;
    }
    public Coord getCoord(){
        return coord;
    }
    private boolean canMoveFigure(Figure figure, int sx, int sy){
        if (coord.x + sx + figure.top.x < 0) return false;
        if(coord.x + sx + figure.bot.x >= Config.WIDTH) return false;
        //if (coord.y + sy + figure.top.y < 0) return false;
        if(coord.y + sy + figure.bot.y >= Config.HEIGHT) return false;
        return true;
    }
    public void moveFigure(int sx, int sy){
        if(canMoveFigure(figure, sx, sy)){
            coord = coord.plus(sx, sy);
        }
    }
    public void turnFigure(int direction){
        Figure rotated = direction == 1 ? figure.turnRight() : figure.turnLeft();
        if(canMoveFigure(rotated, 0,0)) {
            figure = rotated;
        }
        if(canMoveFigure(rotated, 1,0)) {
            figure = rotated;
            moveFigure(1, 0);
        }
        if(canMoveFigure(rotated, -1,0)) {
            figure = rotated;
            moveFigure(-1, 0);
        }
        else
        if(canMoveFigure(rotated, 0,-1)) {
            figure = rotated;
            moveFigure(0, -1);
        }
    }
}

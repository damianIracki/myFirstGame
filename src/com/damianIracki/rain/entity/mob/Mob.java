package com.damianIracki.rain.entity.mob;

import com.damianIracki.rain.entity.Entity;
import com.damianIracki.rain.graphics.Sprite;

public abstract class Mob extends Entity {

    protected Sprite sprite;
    protected int direction = 0;   //0 - NORTH, 1 - EAST, 2 - SOUTH, 3 - WEST
    protected boolean moving = false;

    public void move(int xChange, int yChange){
        if(xChange > 0)
            direction = 1;
        if(xChange < 0)
            direction = 3;
        if(yChange > 0)
            direction = 2;
        if(yChange < 0)
            direction = 1;

        if(!collision()){
            x += xChange;
            y += yChange;
        }
        //x = -1, 0 1
    }

    public void update(){

    }

    private boolean collision(){
        return false;
    }

    public void render(){

    }
}

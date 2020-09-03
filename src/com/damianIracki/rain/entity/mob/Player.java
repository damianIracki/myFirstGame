package com.damianIracki.rain.entity.mob;

import com.damianIracki.rain.graphics.Screen;
import com.damianIracki.rain.graphics.Sprite;
import com.damianIracki.rain.input.Keyboard;

public class Player extends Mob {

    private Keyboard input;


    public Player(Keyboard input){
        this.input = input;
    }

    public Player(int x, int y, Keyboard input){
        this.x = x;
        this.y = y;
        this.input = input;
    }

    public void update(){
        int xA = 0;
        int yA = 0;
        if(input.up) yA--;
        if(input.down) yA++;
        if(input.left) xA--;
        if(input.right) xA++;

        if(xA != 0 || yA != 0){
            move(xA, yA);
        }
    }

    public void render(Screen screen ){
        int xx = x - 16;
        int yy = y  - 16;
        screen.renderPlayer(xx, yy, Sprite.player0);
        screen.renderPlayer(xx + 16, yy, Sprite.player1);
        screen.renderPlayer(xx, yy + 16, Sprite.player2);
        screen.renderPlayer(xx + 16, yy + 16, Sprite.player3);


    }
}

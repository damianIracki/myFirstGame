package com.damianIracki.rain.entity.mob;

import com.damianIracki.rain.graphics.Screen;
import com.damianIracki.rain.graphics.Sprite;
import com.damianIracki.rain.input.Keyboard;

public class Player extends Mob {

    private Keyboard input;
    private Sprite sprite;

    public Player(Keyboard input){
        this.input = input;
        sprite = Sprite.playerBackward;
    }

    public Player(int x, int y, Keyboard input){
        this.x = x;
        this.y = y;
        this.input = input;
        sprite = Sprite.playerBackward;
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
        if(direction == 0)
            sprite = Sprite.playerForward;
        if(direction == 1)
            sprite = Sprite.playerRight;
        if(direction == 2)
            sprite = Sprite.playerBackward;
        if(direction == 3)
            sprite = Sprite.playerLeft;

        screen.renderPlayer(x - 16, y - 16, sprite);
    }
}

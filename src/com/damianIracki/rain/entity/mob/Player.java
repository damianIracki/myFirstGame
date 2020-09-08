package com.damianIracki.rain.entity.mob;

import com.damianIracki.rain.graphics.Screen;
import com.damianIracki.rain.graphics.Sprite;
import com.damianIracki.rain.input.Keyboard;

public class Player extends Mob {

    private Keyboard input;
    private Sprite sprite;
    private int animation = 0;
    private boolean walking;

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
        if(animation < 7500)
            animation++;
        else
            animation = 0;
        if(input.up) yA--;
        if(input.down) yA++;
        if(input.left) xA--;
        if(input.right) xA++;

        if(xA != 0 || yA != 0){
            move(xA, yA);
            walking = true;
        } else {
            walking = false;
        }
    }

    public void render(Screen screen ){
        int flip = 0;
        if(direction == 0) {
            sprite = Sprite.playerForward;
            if(walking){
                if(animation % 20 > 10){
                    sprite = Sprite.playerForwardMove1;
                } else {
                    sprite = Sprite.playerForwardMove2;
                }
            }
        }
        if(direction == 1) {
            sprite = Sprite.playerSide;
            if (walking) {
                if (animation % 20 > 10) {
                    sprite = Sprite.playerSideMove1;
                } else {
                    sprite = Sprite.playerSide;
                }
            }
        }
        if(direction == 2) {
            sprite = Sprite.playerBackward;
            if(walking){
                if(animation % 20 > 10){
                    sprite = Sprite.playerBackwardMove1;
                } else {
                    sprite = Sprite.playerBackwardMove2;
                }
            }
        }
        if(direction == 3) {
            sprite = Sprite.playerSide;
            flip = 1;
            sprite = Sprite.playerSide;
            if (walking) {
                if (animation % 20 > 10) {
                    sprite = Sprite.playerSideMove1;
                } else {
                    sprite = Sprite.playerSide;
                }
            }
        }

        screen.renderPlayer(x - 16, y - 16, sprite, flip);
    }
}

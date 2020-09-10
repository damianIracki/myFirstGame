package com.damianIracki.rain.graphics;

import java.awt.*;

public class Sprite {

    public final int SIZE;
    private int x, y;
    public int[] pixels;
    private SpriteSheet sheet;

    public static Sprite grass = new Sprite(16, 1, 2, SpriteSheet.tiles);
    public static Sprite flower = new Sprite(16, 0, 2, SpriteSheet.tiles);
    public static Sprite tree = new Sprite(16, 2, 2, SpriteSheet.tiles);
    public static Sprite rock = new Sprite(16, 3, 2, SpriteSheet.tiles);

    public static Sprite swamp = new Sprite(16, 0, 1, SpriteSheet.tiles);
    public static Sprite swampFlower = new Sprite(16, 1, 1, SpriteSheet.tiles);
    public static Sprite swampTree = new Sprite(16, 2, 1, SpriteSheet.tiles);

    public static Sprite desert = new Sprite(16, 0, 3, SpriteSheet.tiles);
    public static Sprite desert2 = new Sprite(16, 1, 3, SpriteSheet.tiles);
    public static Sprite desertCactus = new Sprite(16, 2, 3, SpriteSheet.tiles);

    public static Sprite dust = new Sprite(16, 0, 4, SpriteSheet.tiles);
    public static Sprite dustRock = new Sprite(16, 1, 4, SpriteSheet.tiles);
    public static Sprite dustTree = new Sprite(16, 2, 4, SpriteSheet.tiles);

    public static Sprite street = new Sprite(16, 3, 0, SpriteSheet.tiles);
    public static Sprite streetCorner = new Sprite(16, 4, 0, SpriteSheet.tiles);
    public static Sprite street4Split = new Sprite(16, 5, 0, SpriteSheet.tiles);
    public static Sprite street3Split = new Sprite(16, 6, 0, SpriteSheet.tiles);




    public static Sprite voidSprite = new Sprite(16, 0x1B87E0);


    //Player sprites here:
    public static Sprite playerBackward = new Sprite(32, 0, 4, SpriteSheet.tiles);
    public static Sprite playerForward = new Sprite(32, 0, 5, SpriteSheet.tiles);
    public static Sprite playerSide = new Sprite(32, 0, 7, SpriteSheet.tiles);

    public static Sprite playerForwardMove1 = new Sprite(32, 1, 5, SpriteSheet.tiles);
    public static Sprite playerForwardMove2 = new Sprite(32, 3, 5, SpriteSheet.tiles);

    public static Sprite playerBackwardMove1 = new Sprite(32, 1, 4, SpriteSheet.tiles);
    public static Sprite playerBackwardMove2 = new Sprite(32, 3, 4, SpriteSheet.tiles);

    public static Sprite playerSideMove1 = new Sprite(32, 1, 7, SpriteSheet.tiles);

    public Sprite(int size, int x, int y, SpriteSheet sheet){

        SIZE = size;
        pixels = new int [SIZE * SIZE];
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;
        load();
    }

    public Sprite(int size, int color){
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        setColor(color);
    }

    private void setColor(int color) {
        for (int i = 0; i < SIZE * SIZE; i++){
            pixels[i] = color;
        }
    }

    private void load() {
        for(int y = 0; y < SIZE; y++){
            for (int x = 0; x < SIZE; x++){
                pixels[x+y*SIZE] = sheet.pixels[(x + this.x) + (y + this.y)*sheet.SIZE];
            }
        }
    }
}

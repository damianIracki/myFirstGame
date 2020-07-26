package com.damianIracki.rain.graphics;

import java.util.Random;

public class Screen {

    private int width, height;
    public int[] pixels;

    public  final int MAP_SIZE  = 8;
    public  final int MAP_SIZE_MASK  = MAP_SIZE - 1;

    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

    private Random random = new Random();

    public Screen (int width, int height){
        this.width = width;
        this.height = height;

        pixels = new int[width * height];

        for(int i = 0; i < MAP_SIZE * MAP_SIZE; i++){
            tiles[i] = random.nextInt(0xffffff);        //każdy pixel dostanie randomowy kolor
        }
    }

    public void clear(){
        for (int i = 0; i < pixels.length; i++){
            pixels[i] = 0;
        }
    }

    public void render(int xOffset, int yOffset){

        for(int y = 0; y < height; y++){
            int yPixel = y + yOffset;
            if(yPixel < 0 || yPixel >= height) continue;
            for(int x = 0; x < width; x++){
                int xPixel = x + xOffset;
                if(xPixel < 0 || xPixel >= width) continue;
                pixels[xPixel + yPixel * width] = Sprite.grass.pixels[(x&15)+(y&15)*Sprite.grass.SIZE];
            }
        }
    }
}

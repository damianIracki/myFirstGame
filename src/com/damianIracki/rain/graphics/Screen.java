package com.damianIracki.rain.graphics;

import com.damianIracki.rain.entity.mob.Player;
import com.damianIracki.rain.levels.tiles.Tile;

import java.util.Random;

public class Screen {

    public  int width, height;
    public int[] pixels;

    public int xOffset, yOffset;

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


    public void renderTile(int xPosition, int yPosition, Tile tile){
        yPosition -= yOffset;
        xPosition -= xOffset;
        for(int y = 0; y < tile.sprite.SIZE; y++){
            int yAbsolution = y + yPosition;
            for(int x = 0; x < tile.sprite.SIZE; x++){
                int xAbsolution = x + xPosition;
                if(xAbsolution < -tile.sprite.SIZE || xAbsolution >= width || yAbsolution < 0 || yAbsolution >= height)
                    break;
                if(xAbsolution < 0 )
                    xAbsolution = 0;

                pixels[xAbsolution + yAbsolution * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];    //któy pixel na ekrania ma się wyrenderowac = który pixel ze spritu ma zostać wybrany
            }
        }
    }

    public void renderPlayer(int xPosition, int yPosition, Sprite sprite, int flip){
        yPosition -= yOffset;
        xPosition -= xOffset;
        for(int y = 0; y < 32; y++){
            int yAbsolution = y + yPosition;
            int ySprite = y;
            if(flip == 2  || flip == 3){
                ySprite = 31 - y;
            }
            for(int x = 0; x < 32; x++){
                int xAbsolution = x + xPosition;
                int xSprite = x;
                if(flip == 1 || flip == 3){
                    xSprite = 31 - x;
                }
                if(xAbsolution < -32 || xAbsolution >= width || yAbsolution < 0 || yAbsolution >= height)
                    break;
                if(xAbsolution < 0 )
                    xAbsolution = 0;
                int color = sprite.pixels[xSprite + ySprite * 32];
                if(color != 0xFFFF00FF)
                    pixels[xAbsolution + yAbsolution * width] = color;
            }
        }
    }

    public void setOffset(int xOffset, int yOffset){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

}

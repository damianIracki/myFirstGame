package com.damianIracki.rain.levels.tiles;

import com.damianIracki.rain.graphics.Screen;
import com.damianIracki.rain.graphics.Sprite;

public class Tile {

    public int xCorner, yCorner;
    public Sprite sprite;

    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile voidTile = new VoidTile(Sprite.voidSprite);

    public Tile(Sprite sprite){
        this.sprite = sprite;
    }

    public void render(int xCorner, int yCorner, Screen screen){

    }

    public boolean solid(){
        return false;
    }
}

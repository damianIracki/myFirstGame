package com.damianIracki.rain.levels;

import com.damianIracki.rain.graphics.Screen;
import com.damianIracki.rain.levels.tiles.Tile;

public class Level {

    protected int width;
    protected int height;
    protected int[] tiles;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new int [width * height];
        generateLevel();
    }

    public Level(String path){
        loadLevel(path);
    }

    protected void generateLevel() {

    }

    private void loadLevel(String path) {

    }

    public void update(){

    }

    private void time(){

    }

    public void render(int xScroll, int yScroll, Screen screen){
        screen.setOffset(xScroll, yScroll);
        int x0 = xScroll >> 4;
        int xEnd = (xScroll + screen.width + 16) >> 4;
        int y0 =  yScroll >> 4;
        int yEnd = (yScroll + screen.height + 16) >> 4;

        for(int y = y0; y < yEnd; y++){
            for (int x = x0; x < xEnd; x++){
                getTile(x, y).render(x, y,  screen);
            }
        }
    }

    public Tile getTile(int x, int y){
        if(x < 0 || y < 0 || x >= width || y >= height){
            return Tile.voidTile;
        }
        if(tiles[x+y*width] == 0){
            return Tile.grass;
        }
        return Tile.voidTile;
    }
}

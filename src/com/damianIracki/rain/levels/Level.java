package com.damianIracki.rain.levels;

import com.damianIracki.rain.graphics.Screen;
import com.damianIracki.rain.levels.tiles.Tile;

public class Level {

    protected int width;
    protected int height;
    protected int[] tilesInt;
    protected int[] tiles;

    public static Level spawn = new SpawnLevel("/levels/spawnLvl.png");

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tilesInt = new int [width * height];
        generateLevel();
    }

    public Level(String path){
        loadLevel(path);
        generateLevel();
    }

    protected void generateLevel() {

    }

    protected void loadLevel(String path) {

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
        if(tiles[x+y*width] == Tile.COLOR_DESERT) return Tile.desertTile;
        if(tiles[x+y*width] == Tile.COLOR_DESERT_CACTUS) return Tile.desertCactusTile;
        if(tiles[x+y*width] == Tile.COLOR_GRASS) return Tile.grass;
        if(tiles[x+y*width] == Tile.COLOR_GRASS_ROCK) return Tile.rock;
        if(tiles[x+y*width] == Tile.COLOR_GRASS_FLOWER) return Tile.flower;
        if(tiles[x+y*width] == Tile.COLOR_GRASS_TREE) return Tile.tree;
        if(tiles[x+y*width] == Tile.COLOR_STREET_4_SPLIT) return Tile.street4SplitTile;

        return Tile.voidTile;
    }
}

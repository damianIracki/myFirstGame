package com.damianIracki.rain.levels;

import com.damianIracki.rain.graphics.Screen;

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
        int x0 = xScroll >> 4;
        int xEnd = (xScroll + screen.width) >> 4;
        int y0 =  yScroll >> 4;
        int yEnd = (yScroll + screen.height) >> 4;
    }
}

package com.damianIracki.rain.levels;

import com.damianIracki.rain.levels.tiles.GrassTile;
import com.damianIracki.rain.levels.tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpawnLevel extends Level{


    private int[] levelPixels;

    public SpawnLevel(String path) {
        super(path);
    }

    protected void loadLevel(String path) {
        try{
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            int width = image.getWidth();
            int height = image.getHeight();
            tiles = new Tile[width * height];
            levelPixels = new int[width * height];
            image.getRGB(0, 0, width, height, levelPixels, 0, width);
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Exception! Could not load level file!");
        }
    }


    protected void generateLevel() {
        for(int i = 0; i < levelPixels.length; i++){
            if(levelPixels[i] == 0xFF00FF00){
                tiles[i] = Tile.grass;
            } else if(levelPixels[i] == 0xFFFFFF00){
                tiles[i] = Tile.flower;
            } else if(levelPixels[i] == 0xFF7F7F00){
                tiles[i] = Tile.rock;
            }
        }
    }


}

package com.damianIracki.rain.levels;

import com.damianIracki.rain.levels.tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpawnLevel extends Level{

    public SpawnLevel(String path) {
        super(path);
    }

    protected void loadLevel(String path) {
        try{
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            int width = this.width = image.getWidth();
            int height = this.height = image.getHeight();
            tiles = new int[width * height];
            image.getRGB(0, 0, width, height, tiles, 0, width);
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Exception! Could not load level file!");
        }
    }


    protected void generateLevel() {

    }
}

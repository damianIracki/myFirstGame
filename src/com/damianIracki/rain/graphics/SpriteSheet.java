package com.damianIracki.rain.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {

    private String imagePath;
    public final int SIZE;
    public int[] pixels;

    public static SpriteSheet tiles = new SpriteSheet("/textures/spritesheet.png", 256);

    public SpriteSheet (String path, int size){
        this.imagePath = path;
        SIZE = size;
        pixels = new int[size * size];
        loadImage();
    }

    private void loadImage() {
        try {
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(imagePath));
            int imageWidth = image.getWidth();
            int imageHeight = image.getHeight();
            image.getRGB(0, 0, imageWidth, imageHeight, pixels, 0, imageWidth);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

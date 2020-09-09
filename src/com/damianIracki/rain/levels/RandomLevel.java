package com.damianIracki.rain.levels;

import java.util.Random;

public class RandomLevel extends Level {

    private static final Random RANDOM = new Random();


    public RandomLevel(int width, int height) {
        super(width, height);
    }

    @Override
    protected void generateLevel(){
        for(int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                tilesInt[x+y*width] = RANDOM.nextInt(4);

            }
        }
    }
}

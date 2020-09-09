package com.damianIracki.rain.levels.tiles;

import com.damianIracki.rain.graphics.Screen;
import com.damianIracki.rain.graphics.Sprite;

public class FlowerTile extends Tile {

    public FlowerTile(Sprite flower) {
        super(flower);
    }

    @Override
    public void render(int xCorner, int yCorner, Screen screen) {
        screen.renderTile(xCorner << 4, yCorner << 4, this);
    }
}

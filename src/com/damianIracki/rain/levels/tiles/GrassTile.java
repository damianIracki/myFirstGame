package com.damianIracki.rain.levels.tiles;

import com.damianIracki.rain.graphics.Screen;
import com.damianIracki.rain.graphics.Sprite;

public class GrassTile extends Tile {

    public GrassTile(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void render(int xCorner, int yCorner, Screen screen) {
        screen.renderTile(xCorner, yCorner, this);
    }


}

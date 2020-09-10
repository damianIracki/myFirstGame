package com.damianIracki.rain.levels.tiles.swampTiles;

import com.damianIracki.rain.graphics.Screen;
import com.damianIracki.rain.graphics.Sprite;
import com.damianIracki.rain.levels.tiles.Tile;

public class SwampTile extends Tile {
    public SwampTile(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void render(int xCorner, int yCorner, Screen screen) {
        screen.renderTile(xCorner << 4, yCorner << 4, this);
    }
}

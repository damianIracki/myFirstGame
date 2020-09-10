package com.damianIracki.rain.levels.tiles.streetTiles;

import com.damianIracki.rain.graphics.Screen;
import com.damianIracki.rain.graphics.Sprite;
import com.damianIracki.rain.levels.tiles.Tile;

public class Street3SplitTile extends Tile {
    public Street3SplitTile(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void render(int xCorner, int yCorner, Screen screen) {
        screen.renderTile(xCorner << 4, yCorner << 4, this);
    }
}

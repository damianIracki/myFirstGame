package com.damianIracki.rain.levels.tiles.dustTiles;

import com.damianIracki.rain.graphics.Screen;
import com.damianIracki.rain.graphics.Sprite;
import com.damianIracki.rain.levels.tiles.Tile;

public class DustTreeTile extends Tile {
    public DustTreeTile(Sprite sprite) {
        super(sprite);
    }
    @Override
    public void render(int xCorner, int yCorner, Screen screen) {
        screen.renderTile(xCorner << 4, yCorner << 4, this);
    }

    @Override
    public boolean solid() {
        return true;
    }
}

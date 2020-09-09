package com.damianIracki.rain.levels.tiles;

import com.damianIracki.rain.graphics.Screen;
import com.damianIracki.rain.graphics.Sprite;

public class RockTile extends Tile {
    public RockTile(Sprite rock) {
        super(rock);
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

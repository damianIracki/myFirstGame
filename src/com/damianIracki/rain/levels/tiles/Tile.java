package com.damianIracki.rain.levels.tiles;

import com.damianIracki.rain.graphics.Screen;
import com.damianIracki.rain.graphics.Sprite;
import com.damianIracki.rain.levels.tiles.desertTile.DesertCactusTile;
import com.damianIracki.rain.levels.tiles.desertTile.DesertTile;
import com.damianIracki.rain.levels.tiles.dustTiles.DustRockTile;
import com.damianIracki.rain.levels.tiles.dustTiles.DustTile;
import com.damianIracki.rain.levels.tiles.dustTiles.DustTreeTile;
import com.damianIracki.rain.levels.tiles.grassTiles.FlowerTile;
import com.damianIracki.rain.levels.tiles.grassTiles.GrassTile;
import com.damianIracki.rain.levels.tiles.grassTiles.RockTile;
import com.damianIracki.rain.levels.tiles.grassTiles.TreeTile;
import com.damianIracki.rain.levels.tiles.streetTiles.Street3SplitTile;
import com.damianIracki.rain.levels.tiles.streetTiles.Street4SplitTile;
import com.damianIracki.rain.levels.tiles.streetTiles.StreetCornerTile;
import com.damianIracki.rain.levels.tiles.streetTiles.StreetTile;
import com.damianIracki.rain.levels.tiles.swampTiles.SwampFlowerTile;
import com.damianIracki.rain.levels.tiles.swampTiles.SwampTile;
import com.damianIracki.rain.levels.tiles.swampTiles.SwampTreeTile;

public class Tile {

    public static final int COLOR_GRASS = 0xFF4CFF00;
    public static final int COLOR_GRASS_TREE = 0xFF7F3300;
    public static final int COLOR_GRASS_FLOWER = 0xFFFF6A00;
    public static final int COLOR_GRASS_ROCK = 0xFF404040;
    public static final int COLOR_STREET_4_SPLIT = 0xFF808080;
    public static final int COLOR_DESERT = 0xFFFFD800;
    public static final int COLOR_DESERT_CACTUS = 0xFFB6FF00;

    public int xCorner, yCorner;
    public Sprite sprite;

    //grass tiles:
    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile flower = new FlowerTile(Sprite.flower);
    public static Tile rock = new RockTile(Sprite.rock);
    public static Tile voidTile = new VoidTile(Sprite.voidSprite);
    public static Tile tree = new TreeTile(Sprite.tree);

    //street tiles:
    public static Tile streetTile = new StreetTile(Sprite.street);
    public static Tile streetCornerTile = new StreetCornerTile(Sprite.streetCorner);
    public static Tile street4SplitTile = new Street4SplitTile(Sprite.street4Split);
    public static Tile street3SplitTile = new Street3SplitTile(Sprite.street3Split);

    //swamp tiles:
    public static Tile swampTile = new SwampTile(Sprite.swamp);
    public static Tile swampFlowerTile = new SwampFlowerTile(Sprite.swampFlower);
    public static Tile swampTreeTile = new SwampTreeTile(Sprite.swampTree);

    //desert tiles:
    public static Tile desertTile = new DesertTile(Sprite.desert);
    public static Tile desert2Tile = new DesertTile(Sprite.desert2);
    public static Tile desertCactusTile = new DesertCactusTile(Sprite.desertCactus);

    //dust tiles:
    public static Tile dustTile = new DustTile(Sprite.dust);
    public static Tile dustRockTile = new DustRockTile(Sprite.dustRock);
    public static Tile dustTreeTile = new DustTreeTile(Sprite.dustTree);

    public Tile(Sprite sprite){
        this.sprite = sprite;
    }

    public void render(int xCorner, int yCorner, Screen screen){

    }

    public boolean solid(){
        return false;
    }
}

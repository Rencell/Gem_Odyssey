package Utils;

import java.awt.geom.Rectangle2D;

import Main.Game;

public class HelperMethods {
	
	
	public static boolean canMoveHere(float x, float y, int width, int height, int[][] lvlData){
		//if the hitbox's height is higher than block, should give it an offset
		
		if(!isSolid(x, y, lvlData))
			if(!isSolid(x + width, y, lvlData))
				if(!isSolid(x , y + height, lvlData))
					if(!isSolid(x + width, y + height, lvlData))
						return true;
		return false;
		
	}
	
	private static boolean isSolid(float x, float y, int[][] lvlData) {
		int maxWidth = lvlData[0].length * Game.TILES_SIZE;
		if(x < 0 || x >= maxWidth) 
			return true;
		
		if(y < 0 || y >= Game.GAME_HEIGHT ) 
			return true;
		
		float indexX = x / Game.TILES_SIZE;
		float indexY = y / Game.TILES_SIZE;
		
		int value = lvlData[(int)indexY][(int)indexX];
		
		//value != 31 && value != 32 && value != 34  && value != 35
		if(value >= 40 || value <= 0 || (value != 31 && value != 32 && value != 34  && value != 35 && value != 33 && value != 27)) {
			return true;
		}
		return false;
		
	}
	//Function Do: it don't let the player exceed its position against the wall
	public static float getEntityToWall(Rectangle2D.Float hitbox, float xSpeed) {
		
		//gets the current Tile
		int currentTile = (int)hitbox.x / Game.TILES_SIZE;
		//if player go to right it subtract the hitbox's width to the current tile
		if(xSpeed > 0) {
			int tilepos = currentTile * Game.TILES_SIZE; 
			int xOffSet = (int)(Game.TILES_SIZE - hitbox.width);
			return tilepos + xOffSet - 1;
		}else
			return currentTile * Game.TILES_SIZE;
		
	}
	
	public static float getEntityToBelowOrAboveFloor(Rectangle2D.Float hitbox, float airspeed) {

		//gets the current Tile
		int currentTile = (int)Math.round(hitbox.y / Game.TILES_SIZE);
		//if player go to right it subtract the hitbox's width to the current tile
		if(airspeed > 0) {
			int tilepos = (int)(currentTile * Game.TILES_SIZE); 
			int yOffSet = (int)(Game.TILES_SIZE - hitbox.height);

			return tilepos + yOffSet - 1;
		}else {
			return currentTile * Game.TILES_SIZE;
		}
	}
	
	public static boolean CheckEntityOnFloor(Rectangle2D.Float hitbox, int[][] lvldata) {
		if(!isSolid(hitbox.x, hitbox.y + hitbox.height + 2, lvldata))
			if(!isSolid(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 2, lvldata))
				return false;
		
		
		return true;
	}
	public static boolean isFloor(Rectangle2D.Float hitbox, float speed, int[][] lvldata) {
		
		return isSolid(hitbox.x + speed, hitbox.y + hitbox.height + 1, lvldata);
	}
}

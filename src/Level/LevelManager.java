package Level;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Main.Game;
import Utils.LoadSave;

public class LevelManager {
	private Game game;
	private BufferedImage[] levelSprite;
	private level Level;
	public LevelManager(Game game){
		this.game = game;
		loadLevelImgs();
		Level = new level(LoadSave.getLevelIndex());
	}
	private void loadLevelImgs() {
		BufferedImage img = LoadSave.getSprite(LoadSave.LEVEL_TILE);
		levelSprite = new BufferedImage[40];
		
		for(int j = 0; j < 6; j++) {
			for(int i = 0; i < 6; i++) {
				int index = j * 6 + i;
				levelSprite[index] = img.getSubimage(i * 64	, j * 64, 64, 64);
			}
		}
	}
	
	public void draw(Graphics g, int xlvlOffset) {
		for(int j = 0; j < Game.TILES_HEIGHT; j++) {
			for(int i = 0; i < Level.getLevelData()[0].length; i++) {
				int index = Level.getSpriteIndex(j, i);
				g.drawImage(levelSprite[index],  (i * Game.TILES_SIZE) - xlvlOffset, j * Game.TILES_SIZE, Game.TILES_SIZE, Game.TILES_SIZE, null);
			}
		}
	}
	public level getLevel() {
		return Level;
	}
}

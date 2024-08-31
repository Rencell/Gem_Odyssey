package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import Entities.EnemyManager;
import GameState.Playing;
import GameState.gamestate;
import Main.Game;
import Utils.LoadSave;

public class GameOverOverlay {
	private Playing playing;
	private BufferedImage img;
	private int bgX, bgY, bgW, bgH;
	private EnemyManager enemymanager;
	private GameOverButton[] gameoverbutton =  new GameOverButton[2];
	public GameOverOverlay(Playing playing, EnemyManager enemymanager){
		this.playing = playing;
		this.enemymanager = enemymanager;
		loadImgs();
		loadbutton();
	}
	private void loadImgs() {
		img = LoadSave.getSprite(LoadSave.GAME_OVER);
		bgW = (int)(img.getWidth() * Game.SCALE);
		bgH = (int)(img.getHeight() * Game.SCALE);
		bgX = Game.GAME_WIDTH / 2 - bgW / 2;
		bgY = Game.GAME_HEIGHT / 2 - bgH / 2;
	}
	
	private void loadbutton() {
		gameoverbutton[0] = new GameOverButton(Game.GAME_WIDTH / 2, 345, 0);
		gameoverbutton[1] = new GameOverButton(Game.GAME_WIDTH / 2, 390, 1);
	}
	public void draw(Graphics g) {
		g.setColor(new Color(0,0,0,0.5f));
		g.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
		g.drawImage(img, bgX, bgY, bgW, bgH, null);
		gameoverbutton[0].draw(g);
		gameoverbutton[1].draw(g);
	}
	
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			
			for(GameOverButton mb: gameoverbutton) {
				if(playing.isIn(e, mb)) {
					if(mb.getRowIndex() == 0) {

						enemymanager.setToggleActive(true);
						playing.resetAll();
						gamestate.state = gamestate.PLAYING;
					}else {

						enemymanager.setToggleActive(false);
						playing.resetAll();
						gamestate.state = gamestate.MENU;
					}
					break;
				}
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		for(GameOverButton mb: gameoverbutton) {
			if(playing.isIn(e, mb)) {
				System.out.println("hello");
				break;
			}
		}
	}
}

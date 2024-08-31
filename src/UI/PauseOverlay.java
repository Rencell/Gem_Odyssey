package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import GameState.Playing;
import GameState.gamestate;
import Main.Game;
import Utils.LoadSave;
public class PauseOverlay {
	private BufferedImage img;
	private int bgX, bgY, bgW, bgH;
	private PauseButton[] pausebutton = new PauseButton[2];
	
	private Playing playing;
	public PauseOverlay(Playing playing){
		this.playing = playing;
		loadImgs();
		loadButtons();
	}
	
	private void loadButtons() {
		pausebutton[0] = new PauseButton(Game.GAME_WIDTH / 2, 325, 0);
		pausebutton[1] = new PauseButton(Game.GAME_WIDTH / 2, 370, 1);
	}

	private void loadImgs() {
		
		img = LoadSave.getSprite(LoadSave.PAUSE_MENU);
		bgW = (int)(img.getWidth() * Game.SCALE);
		bgH = (int)(img.getHeight() * Game.SCALE);
		bgX = Game.GAME_WIDTH / 2 - bgW / 2;
		bgY = Game.GAME_HEIGHT / 2 - bgH / 2;
	}

	public void draw(Graphics g) {
		g.setColor(new Color(0, 0, 0, 170));
		g.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
		g.drawImage(img, bgX, bgY, bgW, bgH, null);
		pausebutton[0].draw(g);
		pausebutton[1].draw(g);
		
	}
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			
			for(PauseButton mb: pausebutton) {
				if(playing.isIn(e, mb)) {
					if(mb.getRowIndex() == 0) {
						playing.setPause(true);
					}else {

						playing.resetAll();
						gamestate.state = gamestate.MENU;
					}
					break;
				}
			}
		}
	}
	
	
}

package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import GameState.gamestate;
import Main.Game;
import Utils.LoadSave;

public class CreditsOverlay {
	private BufferedImage img;
	private int bgX, bgY, bgW, bgH;
	private boolean flag;
	public CreditsOverlay() {
		loadimgs();
	}

	private void loadimgs() {
		img = LoadSave.getSprite(LoadSave.CREDIT);
		bgW = (int)(img.getWidth() * Game.SCALE);
		bgH = (int)(img.getHeight() * Game.SCALE);
		bgX = Game.GAME_WIDTH / 2 - bgW / 2;
		bgY = Game.GAME_HEIGHT / 2 - bgH / 2;
	}
	
	public void draw(Graphics g) {
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
		g.drawImage(img, bgX, bgY, bgW, bgH, null);
		
	}
	public void mouseclicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			
			if(flag) {
				gamestate.state = gamestate.MENU;
				
			}
			flag = !flag;
			
		}
	}
	
	public void setflag(boolean flag) {
		this.flag = flag;
	}
}

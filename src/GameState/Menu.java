package GameState;

import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import GameState.gamestate;
import Main.Game;
import UI.CreditsOverlay;
import UI.MenuButtons;
import Utils.LoadSave;

public class Menu extends State implements StateMethod{
	
	private BufferedImage imgback, imgtitle;
	private MenuButtons[] buttons = new MenuButtons[4];
	private CreditsOverlay credit;
	private boolean flag = true;
	public Menu(Game game) {
		super(game);
		credit = new CreditsOverlay();
		loadButtons();
		loadBackground();
	}
	private void loadBackground() {
		imgback = LoadSave.getSprite(LoadSave.MENU_BACKGROUND);
		imgtitle = LoadSave.getSprite(LoadSave.MENU_TITLE);

	}
	private void loadButtons() {
		buttons[0] = new MenuButtons(Game.GAME_WIDTH / 2, (int) (270 * Game.SCALE), 0, gamestate.PLAYING);
		buttons[1] = new MenuButtons(Game.GAME_WIDTH / 2, (int) (310 * Game.SCALE), 1, gamestate.PLAYING);
		buttons[2] = new MenuButtons(Game.GAME_WIDTH / 2, (int) (350 * Game.SCALE), 2, gamestate.CREDIT);

		buttons[3] = new MenuButtons(Game.GAME_WIDTH / 2, (int) (390 * Game.SCALE), 3, gamestate.QUIT);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(imgback, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
		g.drawImage(imgtitle, 120, 20, (int)(imgtitle.getWidth() * Game.SCALE), (int)(imgtitle.getHeight() * Game.SCALE), null);
		for(MenuButtons mb : buttons) {
			mb.draw(g);
		}
		
	}

	@Override
	public void mouseclicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for(MenuButtons mb: buttons) {
			if(isIn(e, mb)) {
				gamestate.state = mb.applyGameState();
				if(gamestate.state == gamestate.CREDIT) {
					credit.setflag(true);
				}
				break;
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void KeyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
			gamestate.state = gamestate.PLAYING;
	}

	@Override
	public void KeyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

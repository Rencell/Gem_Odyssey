package Controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import GameState.gamestate;
import Main.GamePanel;

public class KeyControl implements KeyListener{
	
	private GamePanel panel;
	public KeyControl(GamePanel panel) {
		this.panel = panel;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
		switch(gamestate.state) {
		case PLAYING:
			panel.getGame().getPlaying().KeyPressed(e);
			break;
		case MENU:
			panel.getGame().getMenu().KeyPressed(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(gamestate.state) {
		case PLAYING:
			panel.getGame().getPlaying().KeyReleased(e);
			break;
		case MENU:
			panel.getGame().getMenu().KeyReleased(e);
			break;
		default:
			break;
		}
	}

	
}

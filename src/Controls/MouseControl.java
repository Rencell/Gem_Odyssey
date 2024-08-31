package Controls;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import GameState.gamestate;
import Main.GamePanel;

public class MouseControl implements MouseListener, MouseMotionListener{
	
	private GamePanel gamepanel;
	public MouseControl(GamePanel gamepanel){
		this.gamepanel = gamepanel;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch(gamestate.state) {
		case PLAYING:
			gamepanel.getGame().getPlaying().mouseclicked(e);
			break;
		case MENU:
			gamepanel.getGame().getMenu().mouseclicked(e);
		case CREDIT:
			gamepanel.getGame().getCredit().mouseclicked(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch(gamestate.state) {
		case PLAYING:
			gamepanel.getGame().getPlaying().mouseReleased(e);
			break;
		case MENU:
			gamepanel.getGame().getMenu().mouseReleased(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

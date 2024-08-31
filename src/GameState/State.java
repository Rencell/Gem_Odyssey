package GameState;

import java.awt.event.MouseEvent;

import Entities.Player;
import Main.Game;
import UI.GameOverButton;
import UI.MenuButtons;
import UI.PauseButton;

public class State {
	protected Game game;
	
	public State(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return game;
		
	}
	
	public boolean isIn(MouseEvent e, MenuButtons mb) {
		
		return mb.getRect().contains(e.getX(), e.getY());
		
	}
	
	public boolean isIn(MouseEvent e, GameOverButton mb) {
		
		return mb.getRect().contains(e.getX(), e.getY());
		
	}
	
	public boolean isIn(MouseEvent e, PauseButton mb) {
		
		return mb.getRect().contains(e.getX(), e.getY());
		
	}
	
	public boolean isIn(MouseEvent e, Player mb) {
		
		return mb.getRect().contains(e.getX(), e.getY());
		
	}
}

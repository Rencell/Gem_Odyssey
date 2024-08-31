package GameState;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface StateMethod {
	public void update();
	public void draw(Graphics g);
	public void mouseclicked(MouseEvent e);
	public void mousePressed(MouseEvent e);
	public void mouseReleased(MouseEvent e);
	public void mouseMoved(MouseEvent e);
	public void KeyPressed(KeyEvent e);
	public void KeyReleased(KeyEvent e);
}

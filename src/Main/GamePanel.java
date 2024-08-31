package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Controls.KeyControl;
import Controls.MouseControl;
import Utils.LoadSave;

import static Main.Game.*;

public class GamePanel extends JPanel{
	
	private Game game;
	private KeyControl keycontrol;
	private MouseControl mousecontrol;
	private int gameX = 0, gameY = 0;
	GamePanel(Game game){
		this.game = game;
		mousecontrol = new MouseControl(this);
		
		addMouseMotionListener(mousecontrol);
		addMouseListener(mousecontrol);
		
		setFocusable(true);
		addKeyListener( new KeyControl(this));	
		setSize();
	}
	private void setSize() {
		Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
		setMinimumSize(size);
		setMaximumSize(size);
		setPreferredSize(size);
	}
	
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.draw(g);
	}
	
	
	
	
	
	public void setX(int x) {
		this.gameX = x; 
	}
	public Game getGame() {
		return game;
		
	}
}

package UI;

import static Utils.Constant.UI.Button.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import GameState.gamestate;
import Utils.LoadSave;

import static Utils.Constant.UI.Button.B_HEIGHT;
import static Utils.Constant.UI.Button.B_WIDTH;

public class MenuButtons {
	private int x, y, RowIndex;
	private int offcenter = B_WIDTH / 2;
	private gamestate game;
	private BufferedImage img,sub;

	private boolean mousepressed;
	private Rectangle bounds;
	public MenuButtons(int x, int y, int RowIndex, gamestate game) {
		this.x = x;
		this.y = y;
		this.RowIndex = RowIndex;
		this.game = game;
		initBounds();
		loadimgs();
	}
	
	private void loadimgs() {
		img = LoadSave.getSprite(LoadSave.MENU_BUTTON_DATA);
		sub = img.getSubimage(0, RowIndex * B_HEIGHT_DEFAULT,B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT);
	}
	private void initBounds() {
		bounds = new Rectangle(x - offcenter, y, B_WIDTH , B_HEIGHT);
	}
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.drawImage(sub, x - offcenter, y, B_WIDTH , B_HEIGHT,null);
	}
	public gamestate applyGameState() {
		return gamestate.state = game;
	}
	
	public Rectangle getRect() {
		return bounds;
	}
	public void setMousePressed(boolean mousepressed) {
		this.mousepressed = mousepressed;
	}
	public boolean isMousePressed() {
		return mousepressed;
	}
}

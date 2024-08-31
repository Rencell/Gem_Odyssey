package UI;

import static Utils.Constant.UI.Button.B_GAMEOVER_HEIGHT;
import static Utils.Constant.UI.Button.B_GAMEOVER_HEIGHT_DEFAULT;
import static Utils.Constant.UI.Button.B_GAMEOVER_WIDTH;
import static Utils.Constant.UI.Button.B_GAMEOVER_WIDTH_DEFAULT;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Utils.LoadSave;

public class PauseButton {
	private int x, y, RowIndex;

	private Rectangle bounds;
	private BufferedImage img,sub;
	
	private int offcenter = (B_GAMEOVER_WIDTH) / 2;
	public PauseButton(int x, int y, int RowIndex) {
		this.x = x;
		this.y = y;
		this.RowIndex = RowIndex;
		
		initBounds();
		loadimgs();
	}
	private void initBounds() {
		bounds = new Rectangle(x - offcenter, y, B_GAMEOVER_WIDTH , B_GAMEOVER_HEIGHT);
	}
	private void loadimgs() {
		
		img = LoadSave.getSprite(LoadSave.PAUSE_BUTTON);
		sub = img.getSubimage(0, RowIndex * B_GAMEOVER_HEIGHT_DEFAULT,B_GAMEOVER_WIDTH_DEFAULT, B_GAMEOVER_HEIGHT_DEFAULT);
		
	}
	public Rectangle getRect() {
		return bounds;
	}
	public void draw(Graphics g) {
		//g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		g.drawImage(sub, x - offcenter , y, B_GAMEOVER_WIDTH , B_GAMEOVER_HEIGHT,null);
	}
	public int getRowIndex() {
		return RowIndex;
	}
}
package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import Entities.Player;
import Main.Game;

public class GameObjects {
	private int x, y, objType;
	private Rectangle2D.Float hitbox;
	
	GameObjects(int x, int y, int objType){
		this.x = x;
		this.y = y;
		this.objType = objType;
	}
	protected void checkInteract(Rectangle2D.Float hitbox, Player player) {
		if(hitbox.intersects(player.getHitbox())) {

			player.changeHealth(-100);
		}
		
	}
	protected void initHitbox(int Width, int Height) {
		hitbox = new Rectangle2D.Float(x, y, (int)(Width * Game.SCALE), (int)(Height * Game.SCALE));
	}
	protected void DrawHitbox(Graphics g) {
		g.setColor(Color.pink);
		g.drawRect((int)hitbox.x, (int)hitbox.y, (int)hitbox.width, (int)hitbox.height);
	}
	
	public Rectangle2D.Float getHitbox(){
		return hitbox;
	}
	
}

package Entities;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public abstract class Entity {
	
	protected float x, y;
	protected int width;
	protected int height;
	protected Rectangle2D.Float hitbox;
	Entity(float x, float y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	protected void initRect(float x, float y, float width, float height) {
		hitbox = new Rectangle2D.Float(x,y,width,height); 
		
	}
	protected void drawHitbox(Graphics e) {
		e.setColor(Color.LIGHT_GRAY);
		e.drawRect((int)hitbox.x, (int)hitbox.y, (int)hitbox.width, (int)hitbox.height);
	}
	
	public Rectangle2D.Float getHitbox(){
		return hitbox;
		
	}
}

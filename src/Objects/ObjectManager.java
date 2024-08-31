package Objects;


import static Utils.Constant.OBJECT.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Entities.Player;
import GameState.Playing;
import Utils.LoadSave;


public class ObjectManager {
	private Playing playing;
	private BufferedImage img, temp;
	private BufferedImage imgSPIKEUP, tempSPIKEUP;
	private ArrayList<Traps> trap = new ArrayList<>();
	
	public ObjectManager(Playing playing) {
		
		this.playing  = playing;
		loadImgs();
		initTrap();
	}
	private void loadImgs() {
		img = LoadSave.getSprite(LoadSave.LAVA_OBJECT);
	}
	private void initTrap() {
		
		trap = LoadSave.getLava();
	}
	public void checkInteract(Player player) {
		for(Traps c: trap) 
			c.checkInteract(c.getHitbox(),player );
		
	}
	public void update(Player player) {
		checkInteract(player);
	}
	public void draw(Graphics g, int xlvlOffset) {
		for(Traps c: trap)  {
			//c.DrawHitbox(g);
			//g.drawImage(img, (int)c.getHitbox().x - xlvlOffset, (int)c.getHitbox().y, LAVA_WIDTH, LAVA_HEIGHT, null);
		}
		
	}
	
}

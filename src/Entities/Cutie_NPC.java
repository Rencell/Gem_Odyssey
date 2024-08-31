
package Entities;
import static Utils.Constant.NPCS.*;
import static Utils.Dialogues.NPCS.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import Utils.LoadSave;
public class Cutie_NPC extends NPC{
	private String hey = "" ;
	private String CUTIE_dialogue[];
	private BufferedImage img[][];
	public int offsetX = 28;
	public int offsetY = 20;
	public Cutie_NPC(float x, float y) {
		super(x, y, CUTIE_WIDTH, CUTIE_HEIGHT, CUTIE);
		initRect(x, y, 45, 45);
		NPCState = IDLE;
		dialogue();
		dialogue = CUTIE_dialogue;
	}
	
	public void loadCUTIE() {
		img = new BufferedImage[1][4];
		BufferedImage temp = LoadSave.getSprite(LoadSave.PLAYER);
		for(int i = 0; i < img.length; i++)
			for(int j = 0; j < img[i].length; j++) {
				img[i][j] = temp.getSubimage(j * CUTIE_DEFAULT_WIDTH, i * CUTIE_DEFAULT_HEIGHT, CUTIE_DEFAULT_WIDTH, CUTIE_DEFAULT_HEIGHT);
			}
	}

	public String[] dialogue() {
		CUTIE_dialogue = CutieDialogue();
		return CUTIE_dialogue;
	}
	
	public void drawCUTIE(Graphics e, int xlvlOffset) {
		e.drawImage(img[getNPCstate()][getaniIndex()], ((int)getHitbox().x - offsetX) - xlvlOffset, (int)getHitbox().y - offsetY, CUTIE_WIDTH, CUTIE_HEIGHT , null);
		//e.setColor(Color.red);
		//e.drawRect((int)getHitbox().x, (int)getHitbox().y,(int)getHitbox().width, (int)getHitbox().height);
		
	}

	public void dialogueNext(MouseEvent e) {
		if(getInterAction()) {
			setClicked(true);
		}
	}
	
	
}

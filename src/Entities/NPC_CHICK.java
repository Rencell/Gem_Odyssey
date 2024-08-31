package Entities;

import static Utils.Constant.NPCS.*;

import static Utils.Dialogues.NPCS.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import Utils.LoadSave;
public class NPC_CHICK extends NPC{

	private String hey = "" ;
	private String CHICK_dialogue[];
	private BufferedImage img[][];
	public int offsetX = 0;
	public int offsetY = 8;
	public NPC_CHICK(float x, float y) {
		super(x, y, CHICK_WIDTH, CHICK_HEIGHT, CHICK);
		initRect(x, y, CHICK_WIDTH, CHICK_HEIGHT);
		NPCState = IDLE;
		dialogue();
		dialogue = CHICK_dialogue;
	}
	
	public void loadCHICK() {
		img = new BufferedImage[1][6];
		BufferedImage temp1 = LoadSave.getSprite(LoadSave.CHICK_NPC);
		for(int i = 0; i < img.length; i++)
			for(int j = 0; j < img[i].length; j++) {
				img[i][j] = temp1.getSubimage(j * CHICK_DEFAULT_WIDTH , i * CHICK_DEFAULT_HEIGHT, CHICK_DEFAULT_WIDTH, CHICK_DEFAULT_HEIGHT);
			}
	}
	private String[] dialogue() {
		CHICK_dialogue = ChickDialogue();
		return CHICK_dialogue;
	}
	
	public void drawCHICK(Graphics e, int xlvlOffset) {
		
		e.drawImage(img[getNPCstate()][getaniIndex()], ((int)getHitbox().x - offsetX) - xlvlOffset, (int)getHitbox().y - offsetY, CHICK_WIDTH, CHICK_HEIGHT , null);
		//e.setColor(Color.white);
		//e.drawRect((int)getHitbox().x, (int)getHitbox().y,(int)getHitbox().width, (int)getHitbox().height);
		
	}
	public void dialogueNext(MouseEvent e) {
		if(getInterAction()) {
			setClicked(true);
		}
	}

}

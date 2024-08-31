package Entities;

import static Utils.Constant.NPCS.*;

import static Utils.Dialogues.NPCS.*;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import Utils.LoadSave;

import static Utils.Dialogues.NPCS.*;
public class NPC_MARTIAL extends NPC{
	
	private String MARTIAL_dialogue[];
	private BufferedImage img[][];
	public int offsetX = 0;
	public int offsetY = 0;
	
	public NPC_MARTIAL(float x, float y) {
		super(x, y, MARTIAL_WIDTH, MARTIAL_HEIGHT, MARTIAL);
		initRect(x, y - 40, MARTIAL_WIDTH, MARTIAL_HEIGHT );
		NPCState = IDLE;
		dialogue();
		dialogue = MARTIAL_dialogue;
	}

	private String[] dialogue() {

		MARTIAL_dialogue = MartialDialogue();
		return MARTIAL_dialogue;
	}
	
	public void loadMARTIAL() {
		img = new BufferedImage[1][4];
		BufferedImage temp1 = LoadSave.getSprite(LoadSave.MARTIAL_NPC);
		for(int i = 0; i < img.length; i++)
			for(int j = 0; j < img[i].length; j++) {
				img[i][j] = temp1.getSubimage(j * MARTIAL_DEFAULT_WIDTH , i * MARTIAL_DEFAULT_HEIGHT, MARTIAL_DEFAULT_WIDTH, MARTIAL_DEFAULT_HEIGHT);
			}
	}
	
	public void drawMARTIAL(Graphics e, int xlvlOffset) {
		
		e.drawImage(img[getNPCstate()][getaniIndex()], ((int)getHitbox().x - offsetX) - xlvlOffset, (int)getHitbox().y - offsetY, MARTIAL_WIDTH, MARTIAL_HEIGHT , null);
		//e.setColor(Color.white);
		//e.drawRect((int)getHitbox().x, (int)getHitbox().y,(int)getHitbox().width, (int)getHitbox().height);
		
	}
	public void dialogueNext(MouseEvent e) {
		if(getInterAction()) {
			setClicked(true);
		}
	}
}

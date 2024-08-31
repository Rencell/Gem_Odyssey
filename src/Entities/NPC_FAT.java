package Entities;

import static Utils.Constant.NPCS.*;

import static Utils.Dialogues.NPCS.*;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import Main.Game;
import Utils.LoadSave;

public class NPC_FAT extends NPC{
	private String FAT_dialogue[];
	private BufferedImage img[][];
	public int offsetX = 32;
	public int offsetY = 42;
	
	public NPC_FAT(float x, float y) {
		super(x, y, FAT_WIDTH, FAT_HEIGHT, FAT);
		initRect(x, y, (int) (32 * Game.SCALE), (int) (32 * Game.SCALE) );
		NPCState = IDLE;
		dialogue();
		dialogue = FAT_dialogue;
	}

	private String[] dialogue() {

		FAT_dialogue = FatDialogue();
		return FAT_dialogue;
	}
	
	public void loadFAT() {
		img = new BufferedImage[1][6];
		BufferedImage temp1 = LoadSave.getSprite(LoadSave.FAT_NPC);
		for(int i = 0; i < img.length; i++)
			for(int j = 0; j < img[i].length; j++) {
				img[i][j] = temp1.getSubimage(j * FAT_DEFAULT_WIDTH , i * FAT_DEFAULT_HEIGHT, FAT_DEFAULT_WIDTH, FAT_DEFAULT_HEIGHT);
			}
	}
	
	public void drawFAT(Graphics e, int xlvlOffset) {
		
		e.drawImage(img[getNPCstate()][getaniIndex()], ((int)getHitbox().x - offsetX) - xlvlOffset, (int)getHitbox().y - offsetY, FAT_WIDTH, FAT_HEIGHT , null);
		//e.setColor(Color.white);
		//e.drawRect((int)getHitbox().x, (int)getHitbox().y,(int)getHitbox().width, (int)getHitbox().height);
		
	}
	public void dialogueNext(MouseEvent e) {
		if(getInterAction()) {
			setClicked(true);
		}
	}
}
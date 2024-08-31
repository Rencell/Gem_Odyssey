package Entities;

import static Utils.Constant.NPCS.BALD;
import static Utils.Constant.NPCS.BALD_DEFAULT_HEIGHT;
import static Utils.Constant.NPCS.BALD_DEFAULT_WIDTH;
import static Utils.Constant.NPCS.BALD_HEIGHT;
import static Utils.Constant.NPCS.BALD_WIDTH;
import static Utils.Constant.NPCS.IDLE;
import static Utils.Dialogues.NPCS.*;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import Utils.LoadSave;

public class NPC_BALD extends NPC{

	private String hey = "" ;
	private String BALD_dialogue[];
	private BufferedImage imgBald[][];
	public int offsetX = 0;
	public int offsetY = 10;
	public NPC_BALD(float x, float y) {
		super(x, y, BALD_WIDTH, BALD_HEIGHT, BALD);
		initRect(x, y, BALD_WIDTH, BALD_HEIGHT);
		NPCState = IDLE;
		dialogue();
		dialogue = BALD_dialogue;
	}
	public void loadBALD() {
		imgBald = new BufferedImage[1][6];
		BufferedImage temp1 = LoadSave.getSprite(LoadSave.BALD_NPC);
		for(int i = 0; i < imgBald.length; i++)
			for(int j = 0; j < imgBald[i].length; j++) {
				imgBald[i][j] = temp1.getSubimage(j * BALD_DEFAULT_WIDTH , i * BALD_DEFAULT_HEIGHT, BALD_DEFAULT_WIDTH, BALD_DEFAULT_HEIGHT);
			}
	}
	public String[] dialogue() {
		BALD_dialogue = BaldDialogue();
		
		return BALD_dialogue;
	}
	public void drawBALD(Graphics e, int xlvlOffset) {
		
		e.drawImage(imgBald[getNPCstate()][getaniIndex()], ((int)getHitbox().x - offsetX) - xlvlOffset, (int)getHitbox().y - offsetY, BALD_WIDTH, BALD_HEIGHT , null);
	}
	public void dialogueNext(MouseEvent e) {
		if(getInterAction()) {
			setClicked(true);
		}
	}
	
}

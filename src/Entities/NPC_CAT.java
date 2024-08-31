package Entities;
import static Utils.Constant.NPCS.*;

import static Utils.Dialogues.NPCS.*;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import Utils.LoadSave;
public class NPC_CAT extends NPC{
	
	private String hey = "" ;
	private String CAT_dialogue[];
	private BufferedImage img[][];
	public int offsetX = 0;
	public int offsetY = 8;
	public NPC_CAT(float x, float y) {
		super(x, y, CAT_WIDTH, CAT_HEIGHT, CAT);
		initRect(x, y, CAT_WIDTH, CAT_HEIGHT);
		NPCState = IDLE;
		dialogue();
		dialogue = CAT_dialogue;
	}
	
	public void loadCAT() {
		img = new BufferedImage[1][10];
		BufferedImage temp1 = LoadSave.getSprite(LoadSave.CAT_NPC);
		for(int i = 0; i < img.length; i++)
			for(int j = 0; j < img[i].length; j++) {
				img[i][j] = temp1.getSubimage(j * CAT_DEFAULT_WIDTH , i * CAT_DEFAULT_HEIGHT, CAT_DEFAULT_WIDTH, CAT_DEFAULT_HEIGHT);
			}
	}
	private String[] dialogue() {
		CAT_dialogue = CatDialogue();
		return CAT_dialogue;
	}
	
	public void drawCAT(Graphics e, int xlvlOffset) {
		
		e.drawImage(img[getNPCstate()][getaniIndex()], ((int)getHitbox().x - offsetX) - xlvlOffset, (int)getHitbox().y - offsetY, CAT_WIDTH, CAT_HEIGHT , null);
		//e.setColor(Color.white);
		//e.drawRect((int)getHitbox().x, (int)getHitbox().y,(int)getHitbox().width, (int)getHitbox().height);
		
	}
	public void dialogueNext(MouseEvent e) {
		if(getInterAction()) {
			setClicked(true);
		}
	}

}

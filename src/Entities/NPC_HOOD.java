package Entities;
import static Utils.Constant.NPCS.*;

import static Utils.Dialogues.NPCS.*;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import Main.Game;
import Utils.LoadSave;
public class NPC_HOOD extends NPC{
	private String HOOD_dialogue[];
	private BufferedImage img[][];
	public int offsetX = 32;
	public int offsetY = 45;
	public NPC_HOOD(float x, float y) {
		super(x, y, HOOD_WIDTH, HOOD_HEIGHT, HOOD);
		initRect(x, y, (int) (32 * Game.SCALE), (int) (32 * Game.SCALE) );
		NPCState = IDLE;
		dialogue();
		dialogue = HOOD_dialogue;
	}
	private String[] dialogue() {

		HOOD_dialogue = HoodDialogue();
		return HOOD_dialogue;
	}
	
	public void loadHOOD() {
		img = new BufferedImage[1][5];
		BufferedImage temp1 = LoadSave.getSprite(LoadSave.HOOD_NPC);
		for(int i = 0; i < img.length; i++)
			for(int j = 0; j < img[i].length; j++) {
				img[i][j] = temp1.getSubimage(j * HOOD_DEFAULT_WIDTH , i * HOOD_DEFAULT_HEIGHT, HOOD_DEFAULT_WIDTH, HOOD_DEFAULT_HEIGHT);
			}
	}
	public void drawHOOD(Graphics e, int xlvlOffset) {
		
		e.drawImage(img[getNPCstate()][getaniIndex()], ((int)getHitbox().x - offsetX) - xlvlOffset, (int)getHitbox().y - offsetY, HOOD_WIDTH, HOOD_HEIGHT , null);
		//e.setColor(Color.white);
		//e.drawRect((int)getHitbox().x, (int)getHitbox().y,(int)getHitbox().width, (int)getHitbox().height);
		
	}
	
	public void dialogueNext(MouseEvent e) {
		if(getInterAction()) {
			setClicked(true);
		}
	}

}

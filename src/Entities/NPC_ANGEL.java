package Entities;

import static Utils.Constant.NPCS.*;

import static Utils.Dialogues.NPCS.*;
import static Utils.Dialogues.NPCS.FatDialogue;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import GameState.Playing;
import Main.Game;
import Utils.LoadSave;

public class NPC_ANGEL extends NPC{
	private String ANGEL_dialogue[];
	private BufferedImage img[][];
	public int offsetX = 65;
	public int offsetY = 100;
	private boolean end = false;
	public NPC_ANGEL(float x, float y) {
		super(x, y, ANGEL_WIDTH, ANGEL_HEIGHT, ANGEL);
		initRect(x, y, (int) (32 * Game.SCALE), (int) (32 * Game.SCALE) );
		NPCState = IDLE;
		dialogue();
		dialogue = ANGEL_dialogue;
	}

	private String[] dialogue() {

		ANGEL_dialogue = AngelDialogue();
		return ANGEL_dialogue;
	}
	
	public void updates(Playing playing) {
		UpdateAnimation();
		if(dialogueIncrement == dialogue.length) {
			System.out.println("potangina angel");
			playing.resetDialogue();
			playing.resetAll();
		}
	}
	
	public void loadANGEL() {
		img = new BufferedImage[1][8];
		BufferedImage temp1 = LoadSave.getSprite(LoadSave.ANGEL_NPC);
		for(int i = 0; i < img.length; i++)
			for(int j = 0; j < img[i].length; j++) {
				img[i][j] = temp1.getSubimage(j * ANGEL_DEFAULT_WIDTH , i * ANGEL_DEFAULT_HEIGHT, ANGEL_DEFAULT_WIDTH, ANGEL_DEFAULT_HEIGHT);
			}
	}
	
	public void drawANGEL(Graphics e, int xlvlOffset) {
		
		e.drawImage(img[getNPCstate()][getaniIndex()], ((int)getHitbox().x - offsetX) - xlvlOffset, (int)getHitbox().y - offsetY, ANGEL_WIDTH, ANGEL_HEIGHT , null);
		//e.setColor(Color.white);
		//e.drawRect((int)getHitbox().x, (int)getHitbox().y,(int)getHitbox().width, (int)getHitbox().height);
		
	}
	public void dialogueNext(MouseEvent e) {
		if(getInterAction()) {
			setClicked(true);
		}
	}
}

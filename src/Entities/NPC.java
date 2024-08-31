package Entities;

import java.awt.Color;
import static Utils.Constant.NPCS.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import Main.Game;


public class NPC extends Entity{
	protected int anitTick = 0, aniIndex, aniSpeed = 25;
	protected int NPCState, NPCtype;
	
	protected boolean interaction = false, end = false, interactionDone = false;
	protected boolean clicked;
	protected int dialogueIncrement =0;
	protected String dialogue[];
	protected int ticks, index;
	protected double speed = 0.4f;
	protected String sub = "";
	public NPC(float x, float y, int width, int height, int NPCtype) {
		super(x, y, width, height);
		this.NPCtype = NPCtype;
		initRect(x, y, width, height);
		
	}
	
	protected void UpdateAnimation() {
		anitTick++;
		
		if(anitTick > aniSpeed) {
			anitTick = 0;
			aniIndex++;
			if(aniIndex == GetSpriteAmount(NPCtype, NPCState))
				aniIndex = 0;
		}
	}
	protected void update() {
		UpdateAnimation();
	}
	protected void checkInteract(Rectangle2D.Float hitbox) {
		if(hitbox.intersects(this.hitbox)) {
			if(!this.end)
				this.interaction = true;
		}
		else {
			this.end = false;
			this.interaction = false;
			this.end = false;
			this.clicked = false;
			this.dialogueIncrement =0;
			this.sub = "";
			this.index = 0;
		}
		
	}
	protected void drawInteraction(Graphics e) {
		int xDialogue =(int)( 20 * Game.SCALE);
		int yDialogue = (int)( 295 * Game.SCALE);
		int widthDialogue = (int)( 800 * Game.SCALE);
		int heightDialogue = (int)( 100 * Game.SCALE);


		e.setColor(new Color(0,0,0,0.7f));
		e.fillRect(xDialogue, yDialogue, widthDialogue, heightDialogue);
		e.setFont(new Font("DePixel", Font.BOLD, (int) (13 * Game.SCALE)));
		e.setColor(Color.white);
		e.drawString(GetNPC_Name(NPCtype), xDialogue + (int)(7 * Game.SCALE), yDialogue + (int)(20 * Game.SCALE));

		e.setColor(Color.red);
		int xText = (int)(345 * Game.SCALE);
		int yText = (int)( 800 * Game.SCALE);
		int font = (int)(27 * Game.SCALE);
		drawMultilineText(e, sub, font,xText, yText);
		if(clicked && end) {
			
			if(dialogueIncrement >= dialogue.length) 
				return;
			
			clicked = false;

			dialogueIncrement++ ;
			interaction = false;
			end = false;
			sub = "";
			if(dialogueIncrement == dialogue.length)
				end = true;
		}
		if (!end) {
			
			ticks++;

			if(ticks > speed) {
				ticks=0;

				sub += dialogue[dialogueIncrement].charAt(index);
				index++;
				if(index > dialogue[dialogueIncrement].length() - 1) {

					end = true;
					index = 0;
					
					if(dialogueIncrement >= dialogue.length) {
						dialogueIncrement = 0;
					}
				}
			}
		}
		
		
	}
	
	private void drawMultilineText(Graphics g, String text, int x, int y, int maxWidth) {
        String[] words = text.split("\\s+");
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            int currentWidth = g.getFontMetrics().stringWidth(currentLine.toString() + " " + word);
            if (currentWidth > maxWidth) {
                g.drawString(currentLine.toString(), x, y);
                y += g.getFontMetrics().getHeight();
                currentLine = new StringBuilder(word);
                
            } else {
                if (currentLine.length() > 0) {
                    currentLine.append(" ");
                }
                currentLine.append(word + "");
            }
        }

        g.drawString(currentLine.toString(), x, y);
    }
	public boolean getInterAction() {
		return interaction;
	}
	public int getNPCstate() {
		return NPCState;
	}
	public int getaniIndex() {
		return aniIndex;
	}
	public String[] getDialogue() {
		return dialogue;
	}
	public void setClicked(boolean b) {
		clicked = b;
	}
}

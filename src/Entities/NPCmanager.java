package Entities;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static Utils.Constant.NPCS.*;

import GameState.Playing;
import Utils.LoadSave;
public class NPCmanager {
	private Playing playing;
	private Cutie_NPC cuties;
	private NPC_BALD bald;
	private NPC_CHICK chick;
	private NPC_CAT cat;
	private NPC_MARTIAL martial;
	private NPC_FAT fat;
	private NPC_HOOD hood;
	private NPC_ANGEL angel;
	public NPCmanager(Playing playing) {
		
		this.playing = playing;

		AddNPCS();
		load_NPC_imgs();
	}
	private void AddNPCS() {
		cuties = LoadSave.getNpc();
		bald = LoadSave.getBald();
		chick = LoadSave.getCHICK();
		cat = LoadSave.getCAT();
		martial = LoadSave.getMARTIAL();
		fat = LoadSave.getFAT();
		hood = LoadSave.getHOOD();
		angel = LoadSave.getANGEL();
	}
	private void load_NPC_imgs() {
		cuties.loadCUTIE();
		bald.loadBALD();
		chick.loadCHICK();
		cat.loadCAT();
		martial.loadMARTIAL();
		fat.loadFAT();
		hood.loadHOOD();
		angel.loadANGEL();
	}
	public void checkInteract(Rectangle2D.Float hitbox) {
		
		cuties.checkInteract(hitbox);
		bald.checkInteract(hitbox);
		chick.checkInteract(hitbox);
		cat.checkInteract(hitbox);
		martial.checkInteract(hitbox);
		fat.checkInteract(hitbox);
		hood.checkInteract(hitbox);
		angel.checkInteract(hitbox);
	}
	public  void update() {
		cuties.update();
		bald.update();
		chick.update();
		cat.update();
		martial.update();
		fat.update();
		hood.update();
		angel.updates(playing);
	}
	public void draw(Graphics e, int xlvlOffset) {
		cuties.drawCUTIE(e, xlvlOffset);
		bald.drawBALD(e, xlvlOffset);
		chick.drawCHICK(e, xlvlOffset);
		cat.drawCAT(e, xlvlOffset);
		martial.drawMARTIAL(e, xlvlOffset);
		fat.drawFAT(e, xlvlOffset);
		hood.drawHOOD(e, xlvlOffset);
		angel.drawANGEL(e, xlvlOffset);
		
		if(cuties.interaction) {
			cuties.drawInteraction(e);
		}
		if(bald.interaction) {
			bald.drawInteraction(e);
		}
		if(chick.interaction) {
			chick.drawInteraction(e);
		}
		if(cat.interaction) {
			cat.drawInteraction(e);
		}
		if(martial.interaction) {
			martial.drawInteraction(e);
		}
		if(fat.interaction) {
			fat.drawInteraction(e);
		}
		if(hood.interaction) {
			hood.drawInteraction(e);
		}
		
		if(angel.interaction) {
			angel.drawInteraction(e);
		}
	}
	public void mouseclicked(MouseEvent e) {
		cuties.dialogueNext(e);
		bald.dialogueNext(e);
		chick.dialogueNext(e);
		cat.dialogueNext(e);
		martial.dialogueNext(e);
		fat.dialogueNext(e);
		hood.dialogueNext(e);
		angel.dialogueNext(e);
	}
	
	
}

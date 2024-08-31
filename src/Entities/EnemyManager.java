package Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GameState.Playing;
import Utils.LoadSave;

import static Utils.Constant.Enemy.*;
public class EnemyManager {

	private Playing playing;
	private ArrayList<FireWorm> fireworms = new ArrayList<>();
	private ArrayList<EvilWizard> evilwizard = new ArrayList<>();
	FireWorm fire;
	private boolean toggleActive = false;
	public EnemyManager(Playing playing) {
		
		
		this.playing = playing;
		loadImgs();
		addEnemies();
	}

	private void addEnemies() {
		fireworms = LoadSave.getFireWorm();
		evilwizard = LoadSave.getEvilWizard();
		evilwizard.size();
	}

	private void loadImgs() {
		
	}
	public void Update(int[][] lvldata, Player player) {
		for(FireWorm F: fireworms)
			if(F.isActive())
				F.Update(lvldata, player);
		for(EvilWizard F: evilwizard)
			if(F.isActive())
				F.Update(lvldata, player);
	}
	public void draw(Graphics g, int lvlOffset) {
		
		g.setColor(Color.white);
		drawFireWorm(g, lvlOffset);
	}

	private void drawFireWorm(Graphics g, int lvlOffset) {
		for(FireWorm F: fireworms) 
			F.drawFireWorm(g, lvlOffset);
		for(EvilWizard F: evilwizard)
			F.drawEvilWizard(g, lvlOffset);
	}
	
	public void checkEnemyHit(Rectangle2D.Float AttackBox) {
		for(FireWorm c: fireworms) {
			if(c.isActive()) {
				if(AttackBox.intersects(c.getHitbox())) {
					c.hurt(GetEnemyDamage(c.enemyType));
					//updateHealthBar();
					return;
				}
			}
		}
		for(EvilWizard F: evilwizard) {
			if(F.isActive()) {
				if(AttackBox.intersects(F.getHitbox())) {
					F.hurt(GetEnemyDamage(F.enemyType));
					//updateHealthBar();
					return;
				}
			}
		}
	}
	
	
	public void resetAll() {
		
		if(toggleActive) {
			for(EvilWizard F: evilwizard) 
				if(F.isActive()) {
					F.resetAll();
				}
			
			for(FireWorm c: fireworms) 
				if(c.isActive()) {
					c.resetAll();
				}
		}else {
			for(EvilWizard F: evilwizard) 
					F.resetAll();
			
			for(FireWorm c: fireworms) 
					c.resetAll();
		}
			
				
	}
	public void setToggleActive(boolean toggleActive) {
		this.toggleActive = toggleActive;
	}
	
}

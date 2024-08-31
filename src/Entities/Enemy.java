package Entities;
import static Utils.Constant.Enemy.*;
import static Utils.HelperMethods.*;

import java.awt.geom.Rectangle2D;

import Main.Game;

import static Utils.Constant.Player.LEFT;
import static Utils.Constant.Player.RIGHT;
public abstract class Enemy extends Entity{
	
	protected int aniIndex, enemystate, enemyType;
	protected int aniTick, aniSpeed = 25;
	protected boolean inAir, firstUpdate = true;
	protected float fallspeed, gravity = 0.004f;
	protected int walkDir = LEFT;
	protected int attackdistance = Game.TILES_SIZE;
	protected float walkSpeed = 0.5f * Game.SCALE;
	protected boolean active = true;
	
	//FLIP
	protected int flipX = width;
	protected int flipW = -1;
	//health
	protected int maxHealth;
	protected int currenthealth;
	protected Rectangle2D.Float AttackBox;
	protected boolean AttackChecked;
	Enemy(float x, float y, int width, int height, int enemyType) {
		super(x, y, width, height);
		this.enemyType = enemyType;
		initRect(x, y, width, height);
		maxHealth = GetMaxHealth(enemyType);
		currenthealth = maxHealth;
	}
	
	protected void changeWalkDir() {
		if(walkDir == RIGHT) {
			walkDir = LEFT;
			flipX = width;
			flipW = -1;
		}
		else {
			walkDir = RIGHT;
			flipX = 0;
			flipW = 1;
		}
	}
	
	protected void initAttackBox(int width, int height) {
		AttackBox = new Rectangle2D.Float(x,y, (int)(width * Game.SCALE), (int) (height * Game.SCALE));
	}
	protected void firstUpdate(int[][] lvldata) {
		if(!CheckEntityOnFloor(hitbox, lvldata)) 
			inAir = true;
		firstUpdate = false;
	}
	protected void checkInAir(int[][] lvldata) {
		if(canMoveHere(hitbox.x, hitbox.y + fallspeed, (int)hitbox.width, (int)hitbox.height, lvldata)) {
			hitbox.y +=fallspeed;
			fallspeed +=gravity;
		}else {
			inAir = false;
			hitbox.y =getEntityToBelowOrAboveFloor(hitbox, fallspeed);
		}
	}
	
	protected boolean EnemyAttacking(Player player) {
		int absvalue = (int) Math.abs(player.getHitbox().x - hitbox.x);
		int absvalueY = (int) Math.abs(player.getHitbox().y - hitbox.y);
		
		return absvalue <= attackdistance && absvalueY <= attackdistance;
	}
	public void checkEnemyHit(Rectangle2D.Float attackBox, Player player) {
		if(AttackBox.intersects(player.hitbox)) 
			player.changeHealth(-GetEnemyDamage(enemyType));
		AttackChecked = true;
	}
	protected void RunOrWalk(int[][] lvldata) {

		
		float xSpeed = 0;
		
		if(walkDir == LEFT) 
			xSpeed = -walkSpeed;
		else
			xSpeed = walkSpeed;
		

		
		if(canMoveHere(hitbox.x + xSpeed, hitbox.y -1, (int)hitbox.width, (int)hitbox.height, lvldata)) {
			if(isFloor(hitbox, xSpeed, lvldata)) {
				hitbox.x += xSpeed;
				return;
			}
		}
		
		changeWalkDir();
	}
	
	protected void hurt(double amount) {
		currenthealth -= amount;
		if(currenthealth <= 0) {
			changeState(DEAD);
		}else
			changeState(HIT);
	}
	protected void changeState(int enemystate) {
		this.enemystate = enemystate;
		aniIndex = 0;
		aniTick =0;
	}
	protected void updateAnimation() {

		aniTick ++;
		if(aniTick >= aniSpeed) {

			aniTick = 0;
			aniIndex++;
			if(aniIndex >= getSprite(enemyType, enemystate)) {
				aniIndex = 0;
				switch(enemystate) {
				case ATTACK, HIT -> enemystate = IDLE;
				case DEAD -> active = false;
			}
			}
		}
	}
	protected void resetAll() {
		hitbox.x = x;
		hitbox.y = y;
		active = true;
		firstUpdate = true;
		currenthealth = maxHealth;
		changeState(IDLE);
	}
	
	public int getEnemyState() {
		return enemystate;
	}
	public int getAniIndex() {
		return aniIndex;
	}
	public int getFlipX() {
		return flipX;
		
	}
	public int getFlipW() {
		return flipW;
		
	}
	public Rectangle2D.Float getAttackBox(){
		return AttackBox;
	}
	public boolean isActive() {
		return active;
	}
	
}

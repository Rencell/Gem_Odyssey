package Entities;

import static Utils.Constant.Enemy.*;
import static Utils.Constant.Player.LEFT;
import static Utils.Constant.Player.RIGHT;
import static Utils.HelperMethods.canMoveHere;
import static Utils.HelperMethods.getEntityToBelowOrAboveFloor;
import static Utils.HelperMethods.isFloor;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;
import java.awt.image.BufferedImage;

import Main.Game;
import Utils.LoadSave;
public class FireWorm extends Enemy{
	

	private BufferedImage[][] FireWorm_Image;
	private int offsetX = 40;
	private int offsetY = 42;
	public FireWorm(float x, float y) {
		super(x, y, FIREWORM_WIDTH, FIREWORM_HEIGHT, FIREWORM);
		initRect(x, y, 32 * Game.SCALE, 30* Game.SCALE);
		initAttackBox(20, 40);
		loadImage();
	}
	
	

	private void loadImage() {
		FireWorm_Image =new BufferedImage[5][9];
		BufferedImage temp = LoadSave.getSprite(LoadSave.FIREWORM_ENEMY);
		
		for(int i = 0; i < FireWorm_Image.length; i++)
			for(int j = 0; j < FireWorm_Image[i].length; j++) {
				FireWorm_Image[i][j] = temp.getSubimage(j * FIREWORM_WIDTH_DEFAULT, i * FIREWORM_HEIGHT_DEFAULT, FIREWORM_WIDTH_DEFAULT, FIREWORM_HEIGHT_DEFAULT);
			}
	}

	public void drawFireWorm(Graphics e, int lvlOffset) {
		if(isActive())
			e.drawImage(FireWorm_Image[getEnemyState()][getAniIndex()], (int)(getHitbox().x - lvlOffset - getOffSetX()) + getFlipX(), (int)getHitbox().y  - getOffSetY(), FIREWORM_WIDTH * getFlipW(), FIREWORM_HEIGHT, null);
		//AttackBox
		//e.drawRect((int)getAttackBox().x - lvlOffset, (int)getAttackBox().y, (int)getAttackBox().height, (int)getAttackBox().width);
		//e.drawRect((int)getHitbox().x, (int)getHitbox().y, (int)getHitbox().width, (int)getHitbox().height);
	}

	public void Update(int[][] lvldata, Player player) {
		updateAnimation();
		FireAttackBox();
		checkFirstUpdate(lvldata,player);
	}
	
	private void FireAttackBox() {
		if(walkDir == RIGHT)
			AttackBox.x = hitbox.x + hitbox.width + (-20 * (int)Game.SCALE);
		else if(walkDir == LEFT)
			AttackBox.x = hitbox.x - hitbox.width - (-5 * (int)Game.SCALE);
		AttackBox.y = hitbox.y + Game.SCALE;
	}
	public void checkHit() {
		
	}
	protected void checkFirstUpdate(int[][] lvldata, Player player) {
		if(firstUpdate) {
			firstUpdate(lvldata);
		}
		
		if(inAir) {
			checkInAir(lvldata);
		}else {

			switch(enemystate) {
			
			case IDLE:
				
				changeState(WALK);
				break;
			case WALK:
				
				RunOrWalk(lvldata);
				if(EnemyAttacking(player)) {
					changeState(ATTACK);
					if(player.getHitbox().x >= hitbox.x) {
						walkDir = RIGHT;

						flipX = 0;
						flipW = 1;
					}else {
						walkDir = LEFT;

						flipX = width;
						flipW = -1;
					}
				}
				break;
			case ATTACK:
				if(aniIndex == 0)
					AttackChecked = false;
				if(aniIndex == 5 && !AttackChecked)
					checkEnemyHit(AttackBox, player);
				break;
			case DEAD:
			}
		}
	}
	
	public int getOffSetX() {
		return offsetX;
		
	}
	public int getOffSetY() {
		return offsetY;
		
	}
	

}

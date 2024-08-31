package Entities;
import static Utils.Constant.Enemy.*;
import static Utils.Constant.Player.LEFT;
import static Utils.Constant.Player.RIGHT;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Main.Game;
import Utils.LoadSave;
public class EvilWizard extends Enemy{
	

	private int offsetX = 90;
	private int offsetY = 110;
	private BufferedImage[][] Evilwizard_Image;
	public EvilWizard(float x, float y) {
		super(x, y, EVILWIZARD_WIDTH, EVILWIZARD_HEIGHT, EVILWIZARD);
		initRect(x, y, 32 * Game.SCALE, 30* Game.SCALE);
		initAttackBox(40, 40);
		loadImage();
	}
	private void loadImage() {
		Evilwizard_Image =new BufferedImage[5][8];
		BufferedImage temp = LoadSave.getSprite(LoadSave.EVILWIZARD_ENEMY);
		
		for(int i = 0; i < Evilwizard_Image.length; i++)
			for(int j = 0; j < Evilwizard_Image[i].length; j++) {
				Evilwizard_Image[i][j] = temp.getSubimage(j * EVILWIZARD_WIDTH_DEFAULT, i * EVILWIZARD_HEIGHT_DEFAULT, EVILWIZARD_WIDTH_DEFAULT, EVILWIZARD_HEIGHT_DEFAULT);
			}
	}
	
	public void drawEvilWizard(Graphics e, int lvlOffset) {
		if(isActive())
			e.drawImage(Evilwizard_Image[getEnemyState()][getAniIndex()], (int)(getHitbox().x -  lvlOffset - getOffSetX()) + getFlipX(), (int)getHitbox().y  - getOffSetY(), EVILWIZARD_WIDTH * getFlipW(), EVILWIZARD_HEIGHT, null);
		//AttackBox
		//e.drawRect((int)getAttackBox().x - lvlOffset, (int)getAttackBox().y, (int)getAttackBox().height, (int)getAttackBox().width);
		//e.drawRect((int)hitbox.x, (int)hitbox.y, (int)hitbox.width, (int)hitbox.height);
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
				if(aniIndex ==  3 || aniIndex ==  4 || aniIndex ==  5 || aniIndex ==  6 && !AttackChecked) 
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

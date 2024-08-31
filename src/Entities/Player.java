package Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import GameState.Playing;
import Main.Game;
import UI.PauseButton;
import Utils.LoadSave;
import static Utils.Constant.Player.*;
import static Utils.HelperMethods.*;

public class Player extends Entity{
	
	private Playing playing;
	private boolean moving = false, attacking = false, jump = false;

	private boolean hit = false, dead = false, deads = false;
	private boolean left,right;
	private BufferedImage mage;
	private BufferedImage pauseButton;
	private int[][] lvldata;
	private BufferedImage[][] Animation;
	private int aniTick, aniSpeed = 25, aniIndex =0;
	private int playerSpeed = (int)(1.8 * Game.SCALE) ;
	private int playerAction = IDLE;
	private int PlayerOffsetX = (int)(18 * Game.SCALE) ;
	private int PlayerOffsetY = (int)(13 * Game.SCALE) ;
	//FLIP
	private int flipX = 0;
	private int flipW = 1;

	//Jumping
	private float airspeed  = 0;
	private float gravity = 0.035f * Game.SCALE;
	private float jumpspeed = -2.25f * Game.SCALE;
	private float fallSpeedAfterCollision = 0.2f * Game.SCALE;
	private boolean inAir = false;
	//status bar

	private BufferedImage health_img;
	private int status_x = (int) (20 * Game.SCALE);
	private int status_y = (int) (10 * Game.SCALE);
	private int status_width = (int) (192 * Game.SCALE) + 40;
	private int status_height = (int) (26 * Game.SCALE);
	//health bar
	private int health_Width = (int)(143 * Game.SCALE)+ 40;
	private int health_Height = (int)(4 * Game.SCALE);
	private int health_x = (int)(35 * Game.SCALE);
	private int health_y = (int)(10 * Game.SCALE);
	//HEALTH
	private int maxhealth = 100;
	private double currenthealth = maxhealth;
	private double healthWidth = health_Width;
	
	private Rectangle2D.Float AttackBox;
	private Rectangle pauseBound;
	//Attacking
	private boolean attackChecked;
	public Player(float x, float y, int width, int height, Playing playing) {
		super(x, y, width, height);

		this.playing = playing;
		this.addPlayerAction(IDLE);
		initRect(x, y, 20 * Game.SCALE, 27 * Game.SCALE);
		loadImgs();
		loadPauseBounds();
		initAttackRect();
	}
	
	private void loadPauseBounds() {
		pauseBound = new Rectangle(Game.GAME_WIDTH - 70 ,20,pauseButton.getWidth(), pauseButton.getHeight());
	}

	private void addPlayerAction(int playerAction) {
		this.playerAction = playerAction;
	}
	public void setLvlData(int[][] lvldata) {
		this.lvldata = lvldata;
		
		if(!CheckEntityOnFloor(hitbox, lvldata));
		inAir = true;
	}
	private void initAttackRect() {
		AttackBox = new Rectangle2D.Float(x,y, (int)(20 * Game.SCALE), (int) (20 * Game.SCALE));
	}
	
	public void loadImgs() {
		pauseButton = LoadSave.getSprite(LoadSave.GAME_PAUSE_BUTTON);
		mage = LoadSave.getSprite(LoadSave.PLAYER);
		Animation = new BufferedImage[7][6];
		
		for(int i = 0 ; i < Animation.length; i++)
			for(int j = 0; j < Animation[i].length; j++) {
				Animation[i][j] = mage.getSubimage(j * 100, i * 100, 97, 90);
			}
		
		health_img = LoadSave.getSprite(LoadSave.HEALTH_BAR);
	}
	public void Update() {

		UpdateHealthbar();
		if(currenthealth <= 0 ) {
			jump = false;
			setDirectionFalse();
			dead = true;
			if(deads) {
				aniIndex = getPlayerAction(DEAD);
				playing.setGameOver(true);
				return;
			}
		}
		PlayerDirection();
		PlayerAttackBox();
		PlayerAttack();
		AniTick();
		if(attacking)
			checkAttack();
		NpcInteraction();
	}
	private void NpcInteraction() {
		playing.checkNpcInteraction(hitbox);
	}

	private void checkAttack() {
		if(attackChecked || aniIndex != 4) 
			return;
		attackChecked = true;
		playing.checkEnemy(AttackBox);
	}

	public void changeHealth(double value) {
		
		currenthealth +=value;
		currenthealth = Math.max(Math.max(value, currenthealth), 0);
		hit = true;
			
	}
	private void PlayerAttackBox() {
		if(left)
			AttackBox.x = hitbox.x + hitbox.width + (5 * (int)Game.SCALE);
		else if(right)
			AttackBox.x = hitbox.x - hitbox.width - (5 * (int)Game.SCALE);
		AttackBox.y = hitbox.y + Game.SCALE;
	}

	private void UpdateHealthbar() {
		//total percent of health_width
		healthWidth = (int) (currenthealth / (float) maxhealth *  health_Width);
		
	}
	private void PlayerAttack() {

		int tempAction = playerAction;

		if(!attacking) {
			if(moving) 
				playerAction = RUNNING;
			else
				playerAction = IDLE;
		}
		if(dead) {
			playerAction = DEAD;
		}else if(hit) {
			playerAction = HIT;
		}
		if(inAir) {
			if(airspeed < 0)
				playerAction = JUMPING;
			else
				playerAction = FALL;
		}
		//System.out.println(playerAction);
		if(attacking) {
			playerAction = ATTACK;
		}
		if(tempAction != playerAction) {
			aniIndex =0;
			aniTick = 0;
		}
	}

	private void PlayerDirection() {
		
			
		moving = false;
		
		if(jump)
			jump();
		
		if(!inAir)
			if((!left && !right) || (left && right)) 
				return;
		float xSpeed = 0;
		if(left) {
			flipX = 0;
			flipW = 1;
			xSpeed = playerSpeed;
		}
		if(right) {
			flipX = width;
			flipW = -1;
			xSpeed = -playerSpeed;
		}
		if(!inAir) {

			if(!CheckEntityOnFloor(hitbox, lvldata)) {
				inAir = true;

				
			}
		}
		
		if(inAir) {
			
			//jumping
			if(canMoveHere(hitbox.x, hitbox.y + airspeed, (int)hitbox.width, (int)hitbox.height, lvldata)) {
				//airspeed depends with gravity

				
				airspeed += gravity;
				hitbox.y += airspeed;
			}
			//hit the ground
			else {
				hitbox.y = getEntityToBelowOrAboveFloor(hitbox, airspeed);
				if(airspeed > 0)
					resetInAir();
				else
					airspeed = fallSpeedAfterCollision;
			}
			updateXPos(xSpeed);
		}else
			updateXPos(xSpeed);
		moving = true;
	}
	
	private void jump() {
		if(inAir)
			return;
		inAir = true;
		airspeed = jumpspeed;
					
	}

	private void resetInAir() {
		inAir = false;
		airspeed = 0;
	}

	private void updateXPos(float xSpeed) {
		if(canMoveHere(hitbox.x + xSpeed, hitbox.y, (int)hitbox.width, (int)hitbox.height, lvldata)) {
			
			hitbox.x += xSpeed;
		}else
			hitbox.x = (getEntityToWall(hitbox, xSpeed));
			
	}
	public void AniTick() {
		aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick =0;
			aniIndex++;
			
			if(aniIndex >= getPlayerAction(playerAction)) {
				if(dead) {
					deads = true;
					return;
				}
				aniIndex =0;
				attacking = false;
				attackChecked =false;
				hit = false;
			}
		}
	}
	public void loadPlayer(Graphics e, int xlvlOffset) {

		//drawHitbox(e);
		e.drawImage(Animation[playerAction][aniIndex], (int)((hitbox.x - PlayerOffsetX) + flipX) - xlvlOffset,(int)(hitbox.y - PlayerOffsetY),width * flipW,height, null);
		loadHealth(e);
		e.drawImage(pauseButton, Game.GAME_WIDTH - 70 ,20,pauseButton.getWidth(), pauseButton.getHeight(), null);
		//loadAttackBox(e, xlvlOffset);
	}
	
	private void loadAttackBox(Graphics e, int xlvlOffset) {
		e.setColor(Color.green);
		e.drawRect((int)AttackBox.x - xlvlOffset, (int)AttackBox.y, (int)AttackBox.width, (int)AttackBox.height);
	}

	private void loadHealth(Graphics e) {
		e.drawImage(health_img, status_x, status_y,status_width, status_height,  null);
		e.setColor(Color.red);
		e.fillRect(status_x + health_x, status_y + health_y, (int)healthWidth , health_Height);
	}

	public void setLeft(boolean left) {
		this.left = left;
	};
	public void setRight(boolean Right) {
		this.right = Right;
	}

	public void setAttack(boolean attacking) {
		this.attacking = attacking;
	}
	public void setJump(boolean jump) {
		this.jump = jump;
	}
	public void setDirectionFalse() {
		left = false;
		right = false;
		attacking = false;
		moving = false;
	}

	public Rectangle2D.Float getHitbox() {
		// TODO Auto-generated method stub
		return hitbox;
	}

	public void resetAll() {
		setDirectionFalse();
		inAir = false;
		attacking  = false;
		moving = false;
		playerAction = IDLE;
		dead = false;
		deads = false;
		hit = false;
		currenthealth = maxhealth;
		
		hitbox.x = x;
		hitbox.y = y;
		
		if(!CheckEntityOnFloor(hitbox, lvldata));
		inAir = true;
	};
	public Rectangle getRect() {
		return pauseBound;
	}
	public void MouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			if(playing.isIn(e, this)) {
				playing.setPause(false);
			}
		}
	}
	
}

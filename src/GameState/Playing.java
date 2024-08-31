package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import Entities.Enemy;
import Entities.EnemyManager;
import Entities.NPCmanager;
import Entities.Player;
import Level.LevelManager;
import Main.Game;
import Objects.ObjectManager;
import UI.GameOverOverlay;
import UI.PauseOverlay;
import Utils.LoadSave;
import static Utils.Dialogues.MainDialogue.*;

public class Playing extends State implements StateMethod{
	

	private Player player;
	private LevelManager Level;
	private EnemyManager enemy;
	private NPCmanager npc;
	private ObjectManager objectmanager;
	private GameOverOverlay gameoveroverlay;
	private PauseOverlay pauseoverlay;
	//
	private int xlvlOffset;
	private int leftBorder = (int)(0.2 * Game.GAME_WIDTH);
	private int rightBorder = (int)(0.5 * Game.GAME_WIDTH);
	private int lvlTilesWide = LoadSave.getLevelIndex()[0].length;
	
	//view max
	private int maxTilesOff = lvlTilesWide - Game.TILES_WIDTH;
	private int maxlvloffset = maxTilesOff * Game.TILES_SIZE;
	
	//background
	BufferedImage img;
	
	//dialogue Tick
	private int diaTick, diaSpeed = 40;
	private int diaIndex = 0;
	private int index;
	private float ticks;
	private float speed = 3.1f;
	private boolean end = false, dialogueEnd = false, mouseclicked = false, gameEndDialog = false;
	protected String sub = "";
	String[] dialog;
	int increment;
	//gameover
	private boolean gameOver = false;
	//pause
	private boolean pause = true;
	public Playing(Game game) {
		super(game);
		initClass();
		loadBackground();
		dialog = getOpeningDialogue();
	}
	
	
	private void loadBackground() {
		img = LoadSave.getSprite(LoadSave.BACKGROUND);
	}


	private void initClass() {

		Level =  new LevelManager(game);
		player = new Player(200,200, (int)(60 * Game.SCALE), (int)(45 * Game.SCALE), this);
		npc = new NPCmanager(this);
		
		enemy = new EnemyManager(this);
		objectmanager = new ObjectManager(this);
		player.setLvlData(Level.getLevel().getLevelData());
		gameoveroverlay = new GameOverOverlay(this, enemy);
		pauseoverlay = new PauseOverlay(this);

	}
	@Override
	public void update() {
		if(dialogueEnd) {

			if(!gameOver && pause) {
				player.Update();
				enemy.Update(Level.getLevel().getLevelData(), player);
				npc.update();
				CheckPassBorder();
				objectmanager.update(player);
			}
		}

		DialogueTick();
	}
	
	private void DialogueTick() {
		if(!gameEndDialog) {
			if(end && mouseclicked) {
				if(!dialogueEnd) {
				diaTick++;
				if(diaTick > diaSpeed) {
					diaTick = 0;
					diaIndex++;
					if(diaIndex >= 10) {
	
						dialogueEnd = true;
						diaIndex= 10;
					}
				}
				}
			}
		}else {
			if(!dialogueEnd) {
				diaTick++;
				if(diaTick > diaSpeed) {
					diaTick = 0;
					diaIndex--;
					if(diaIndex <= 0) {
						dialogueEnd = true;
						diaIndex= 0;
					}
				}
			}
			
		}
		
	}


	private void CheckPassBorder() {
		int playerX = (int) player.getHitbox().x;
		int diff = playerX - xlvlOffset;
		
		
		if(diff > rightBorder)
			//if diff hits 998 it will increment the xlvloffset
			xlvlOffset += diff - rightBorder;
		else if(diff < leftBorder)
			xlvlOffset += diff - leftBorder;
		
		if(xlvlOffset > maxlvloffset)
			xlvlOffset = maxlvloffset	;
		else if (xlvlOffset < 0)
			xlvlOffset = 0;
			
	}
	public void checkEnemy(Rectangle2D.Float attackBox) {
		enemy.checkEnemyHit(attackBox);
	}
	@Override
	public void draw(Graphics g) {
		if(dialogueEnd) {
			
			drawBackground(g);
			Level.draw(g, xlvlOffset);
			player.loadPlayer(g, xlvlOffset);
			enemy.draw(g, xlvlOffset);
			objectmanager.draw(g, xlvlOffset);
			npc.draw(g, xlvlOffset);
			
			if(gameOver) {
				gameoveroverlay.draw(g);
			}
			if(!pause) {
				
				pauseoverlay.draw(g);
			}
		}

		drawOpeningDialogue(g);
	}
	private void drawOpeningDialogue(Graphics g) {
		float total = (10 - diaIndex) * 0.1f;
		g.setColor(new Color(0,0,0,total));
		g.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
		g.setColor(Color.white);
		g.setFont(new Font("DePixel", Font.BOLD, (int) (17 * Game.SCALE)));
		drawMultilineText(g, sub, 40, 100, 1200);
		
		if (!end) {
			ticks++;

			if(ticks > speed) {
				ticks=0;

				sub += dialog[increment].charAt(index);
				index++;
				if(index > dialog[increment].length() - 1) {
					
					end = true;
					
					index = 0;
					
				}
			}
			
		
		}
	}
	
	private void incrementMethod() {
		if(increment == dialog.length - 1)
			return;
		increment++;
		end = false;
		mouseclicked = false;
	}


	public void resetDialogue() {
		this.diaTick = 0;
		this.diaSpeed = 40; 
		this.diaIndex = 10;
		this.index = 0;
		this.ticks = 0;
		this.end = false;
		this.dialogueEnd = false;
		this.mouseclicked = false;
		this.gameEndDialog = true;
		this.increment = 0;
		sub ="";
		dialog = getEndingDialogue();
	}
	private void drawMultilineText(Graphics g, String text, int x, int y, int maxWidth) {
        String[] words = text.split("\\s+");
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            int currentWidth = g.getFontMetrics().stringWidth(currentLine.toString() + " " + word);
            if (currentWidth > maxWidth) {
                g.drawString(currentLine.toString(), x, y);
                y += g.getFontMetrics().getHeight() * 2;
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
	private void drawBackground(Graphics g) {
		g.setColor(new Color(50,52,67));
		g.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
		g.drawImage(img, 0,0,Game.GAME_WIDTH, Game.GAME_HEIGHT , null);
	}
	@Override
	public void mouseclicked(MouseEvent e) {
		
		pauseoverlay.mousePressed(e);
		if(pause) {
			if(end) {
				if(!gameEndDialog) {
					if(e.getButton() == MouseEvent.BUTTON1) {
						mouseclicked = true;
						incrementMethod();
						sub ="";
					}
				}else {
					if(e.getButton() == MouseEvent.BUTTON1) {
						System.out.println("potangina");
						mouseclicked = true;
						sub = "";
						resetDialogue();
						this.diaIndex =0;
						this.gameEndDialog = false;
	
						dialog = getOpeningDialogue();
						gamestate.state = gamestate.MENU;
					}
				}
			}
			if(!gameOver) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					player.MouseClicked(e);
					player.setAttack(true);
					npc.mouseclicked(e);
				}
			}else {
				gameoveroverlay.mousePressed(e);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		gameoveroverlay.mouseReleased(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void KeyPressed(KeyEvent e) {
		if(pause)
		switch (e.getKeyCode()) {
	    case KeyEvent.VK_D:
	        player.setLeft(true);
	        break;
	    case KeyEvent.VK_A:
	        player.setRight(true);
	        break;
	    case KeyEvent.VK_SPACE:
	        player.setJump(true);
	        break;
	    // Add more cases if needed
	}
	}

	@Override
	public void KeyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
	    case KeyEvent.VK_D:
	        player.setLeft(false);
	        break;
	    case KeyEvent.VK_A:
	        player.setRight(false);
	        break;
	    case KeyEvent.VK_SPACE:
	        player.setJump(false);
	        break;
	    case KeyEvent.VK_P,
	 	KeyEvent.VK_ESCAPE:
			if(pause)
				pause= true;
			else
				pause = false;
			pause= !pause;
			break;
	}
	    // Add more cases if needed
	
	}
	
	public void windowlostfocus() {
		player.setDirectionFalse();
	}
	public Player getPlayer() {
		return player;
		
	}
	public EnemyManager getEnemymanager() {
		return enemy;
	}

	public void checkNpcInteraction(Rectangle2D.Float hitbox) {
		npc.checkInteract(hitbox);
	}


	public void setGameOver(boolean gameover) {
		this.gameOver = gameover;
	}


	public void resetAll() {
		gameOver = false;
		pause = true;
		player.resetAll();
		enemy.resetAll();
	}
	public void setPause(boolean pause) {
		this.pause = pause;
	}
}

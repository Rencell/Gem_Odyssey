package Main;

import java.awt.Graphics;

import Entities.Player;
import GameState.Menu;
import GameState.Playing;
import GameState.gamestate;
import Level.LevelManager;
import Level.level;
import UI.CreditsOverlay;

public class Game implements Runnable{
	private GameWindow gamewindow;
	private GamePanel gamepanel;
	private CreditsOverlay credit;
	private Thread thread;
	
	
	private Playing playing;
	private Menu menu;
	//Runnning Game Thread
	private long lasttime;

	int frame = 0;
	int update = 0;
	private final static int FPS = 120;
	private final static int UPS = 200;
	//Game Size
	public final static int TILES_DEFAULT_SIZE = 32;
	public final static float SCALE = 1.5f;
	public final static int TILES_WIDTH = 26;
	public final static int TILES_HEIGHT = 14;
	public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
	public final static int GAME_WIDTH = TILES_WIDTH * TILES_SIZE;
	public final static int GAME_HEIGHT = TILES_HEIGHT * TILES_SIZE;
	
	public Game(){

		initClass();
		gamepanel = new GamePanel(this);
		gamewindow = new GameWindow(gamepanel);
		gamepanel.setFocusable(true);
		StartGame();
		
	}
	
	private void initClass() {
		playing = new Playing(this);
		menu = new Menu(this);
		credit = new CreditsOverlay();
	}

	private void StartGame() {
		thread =  new Thread(this);
		thread.start();
	}
	private void Update() {
		switch(gamestate.state) {
		case PLAYING:
			playing.update();
			playing.getEnemymanager().setToggleActive(false);
			break;
		case MENU:
			menu.update();
			break;
		case CREDIT:
			break;
		case QUIT:
			System.exit(0);
			break;
		default:
			break;
		}
	}
	public void draw(Graphics g) {
		switch(gamestate.state) {
		case PLAYING:
			playing.draw(g);
			break;
		case MENU:
			menu.draw(g);
			break;
			
		case CREDIT:
			credit.draw(g);
			break;
		default:
			break;
		}
	}
	@Override
	public void run() {
		
		double timePerFrame = 1e9 / FPS;
		double timePerUpdate = 1e9 / UPS;
		

		long previousNano = System.nanoTime();
		double deltaU = 0;
		double deltaF = 0;
		int hey = 0;
		
		while(true) {
			
			long currentNano = System.nanoTime();
			deltaU += (currentNano - previousNano) / timePerUpdate;
			
			//Game updates
			if(deltaU >= 1 ) {
				Update();
				deltaU--;
				update++;
			}
			deltaF += (currentNano - previousNano) / timePerFrame;
			
			//Game paint
			if(deltaF >= 1) {
				gamepanel.repaint();
				deltaF--;
				frame++;
			}
			previousNano = currentNano;
			
			//1 sec per Feedback
//			if(System.currentTimeMillis() - lasttime >= 1000) {
//				System.out.println("FPS : " + frame + "|| UPDATE: " + update);
//				lasttime = System.currentTimeMillis();
//				update =0;
//				frame =0;
//			}
		}
		
	}
	public Playing getPlaying() {
		return playing;
	}
	public Menu getMenu() {
		return menu;
	}
	public CreditsOverlay getCredit() {
		return credit;
	}
	public void windowlostfocus() {
		playing.windowlostfocus();
	}

	
}

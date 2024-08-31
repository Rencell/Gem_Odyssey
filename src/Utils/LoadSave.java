package Utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Entities.Cutie_NPC;
import Entities.EvilWizard;
import Entities.FireWorm;
import Entities.NPC_ANGEL;
import Entities.NPC_BALD;
import Entities.NPC_CAT;
import Entities.NPC_CHICK;
import Entities.NPC_FAT;
import Entities.NPC_HOOD;
import Entities.NPC_MARTIAL;
import Main.Game;
import Objects.Traps;

public class LoadSave {
	

	public final static String PLAYER = "player_sprites.png";
	public final static String LEVEL = "long_level.png";
	public final static String LEVEL_TILE = "tilesampleTrans.png";

	public static final String MENU_BACKGROUND = "Background_Menu.jpg";
	public final static String BACKGROUND = "Background.png";

	public static final String GAME_PAUSE_BUTTON = "Game_Pause.png";
	//healthBar
	public final static String HEALTH_BAR = "Health_Bar.png";
	//enemy
	public final static String EVILWIZARD_ENEMY = "evilwizard.png";
	public final static String FIREWORM_ENEMY = "fireworm.png";
	
	//UI
	public static final String MENU_BUTTON_DATA = "Buttons.png";
	public static final String MENU_TITLE = "Menu_Title.png";
	public static final String PAUSE_MENU = "pause.png";
	public static final String GAME_OVER = "dead.png";
	public static final String GAME_OVER_BUTTON = "Exit_Button.png";
	public static final String PAUSE_BUTTON = "Pause_Button.png";
	public static final String CREDIT = "credits.png";
	//Npc
	public final static String BALD_NPC = "Bald_Npc2.png";
	public final static String CHICK_NPC = "Chick_NPC.png";
	public final static String CAT_NPC = "NPC_CAT.png";
	public final static String MARTIAL_NPC = "Martial_Npc.png";
	public final static String FAT_NPC = "PAPA_NPC.png";
	public final static String HOOD_NPC = "Hood_NPC.png";
	public final static String ANGEL_NPC = "Angel_NPC.png";
	//OBJECTS
	public final static String LAVA_OBJECT = "Lava_OBJECT.png";
	public static BufferedImage getSprite(String filename) {
		BufferedImage img  = null;
		InputStream is = LoadSave.class.getResourceAsStream("/" + filename);
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				is.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		return img;
	}
	public static Cutie_NPC getNpc(){

		
		BufferedImage img = getSprite(LEVEL);
		
		Cutie_NPC list =null;
		for(int j =0; j < img.getHeight(); j++) {
			for(int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getBlue();
				if(value == 1)
					list = new Cutie_NPC(i * Game.TILES_SIZE, j * Game.TILES_SIZE);
			}
		}
		return list;
	}
	public static NPC_BALD getBald(){

		
		BufferedImage img = getSprite(LEVEL);
		NPC_BALD list = null;
		for(int j =0; j < img.getHeight(); j++) {
			for(int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getBlue();
				if(value == 0)
					list = new NPC_BALD(i * Game.TILES_SIZE, j * Game.TILES_SIZE);
			}
		}
		return list;
	}
	public static NPC_CAT getCAT(){
	
			
			BufferedImage img = getSprite(LEVEL);
			
			NPC_CAT list =null;
			for(int j =0; j < img.getHeight(); j++) {
				for(int i = 0; i < img.getWidth(); i++) {
					Color color = new Color(img.getRGB(i, j));
					int value = color.getBlue();
					if(value == 3)
						list = new NPC_CAT(i * Game.TILES_SIZE, j * Game.TILES_SIZE);
				}
			}
			return list;
		}
	public static NPC_CHICK getCHICK(){

		
		BufferedImage img = getSprite(LEVEL);
		
		NPC_CHICK list =null;
		for(int j =0; j < img.getHeight(); j++) {
			for(int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getBlue();
				if(value == 2)
					list = new NPC_CHICK(i * Game.TILES_SIZE, j * Game.TILES_SIZE);
			}
		}
		return list;
	}
	
	public static NPC_MARTIAL getMARTIAL(){

		
		BufferedImage img = getSprite(LEVEL);
		
		NPC_MARTIAL list =null;
		for(int j =0; j < img.getHeight(); j++) {
			for(int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getBlue();
				if(value == 4)
					list = new NPC_MARTIAL(i * Game.TILES_SIZE, j * Game.TILES_SIZE);
			}
		}
		return list;
	}
	public static NPC_FAT getFAT(){

		
		BufferedImage img = getSprite(LEVEL);
		
		NPC_FAT list =null;
		for(int j =0; j < img.getHeight(); j++) {
			for(int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getBlue();
				if(value == 5)
					list = new NPC_FAT(i * Game.TILES_SIZE, j * Game.TILES_SIZE);
			}
		}
		return list;
	}
	public static NPC_HOOD getHOOD(){

		
		BufferedImage img = getSprite(LEVEL);
		
		NPC_HOOD list =null;
		for(int j =0; j < img.getHeight(); j++) {
			for(int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getBlue();
				if(value == 6)
					list = new NPC_HOOD(i * Game.TILES_SIZE, j * Game.TILES_SIZE);
			}
		}
		return list;
	}
	public static NPC_ANGEL getANGEL(){

		
		BufferedImage img = getSprite(LEVEL);
		
		NPC_ANGEL list =null;
		for(int j =0; j < img.getHeight(); j++) {
			for(int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getBlue();
				if(value == 7)
					list = new NPC_ANGEL(i * Game.TILES_SIZE, j * Game.TILES_SIZE);
			}
		}
		return list;
	}
	public static ArrayList<FireWorm> getFireWorm(){

		
		BufferedImage img = getSprite(LEVEL);
		ArrayList<FireWorm> list = new ArrayList<>();
		for(int j =0; j < img.getHeight(); j++) {
			for(int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getGreen();
				if(value == 0)
					list.add(new FireWorm(i * Game.TILES_SIZE, j * Game.TILES_SIZE));
			}
		}
		return list;
	}
	
	public static ArrayList<EvilWizard> getEvilWizard(){

		
		BufferedImage img = getSprite(LEVEL);
		ArrayList<EvilWizard> list = new ArrayList<>();
		for(int j =0; j < img.getHeight(); j++) {
			for(int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getGreen();
				if(value == 1)
					list.add(new EvilWizard(i * Game.TILES_SIZE, j * Game.TILES_SIZE));
			}
		}
		return list;
	}
	//Traps
	
	public static ArrayList<Traps> getLava(){

		
		BufferedImage img = getSprite(LEVEL);
		ArrayList<Traps> list = new ArrayList<>();
		for(int j =0; j < img.getHeight(); j++) {
			for(int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getRed();
				if(value == 32 || value == 34 || value == 35 || value == 27 || value == 33)
					list.add(new Traps(i * Game.TILES_SIZE, j * Game.TILES_SIZE));
			}
		}
		return list;
	}

	public static int[][] getLevelIndex(){

		
		BufferedImage img = getSprite(LEVEL);
		int[][] level =  new int[img.getHeight()][img.getWidth()];
		for(int j =0; j < img.getHeight(); j++) {
			for(int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getRed();
				if(value >= 40)
					value = 31;
				level[j][i] = value;
			}
		}
		return level;
	}
	
	
}
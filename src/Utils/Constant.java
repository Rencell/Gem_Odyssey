package Utils;

import Main.Game;

public class Constant {
	public static class NPCS{
		public static final int CUTIE = 255;
		public static final int BALD = 2;
		public static final int CHICK = 3;
		public static final int CAT = 4;
		public static final int MARTIAL = 5;
		public static final int FAT = 6;
		public static final int HOOD = 7;
		public static final int ANGEL = 8;
		
		public static final int IDLE = 0;
		
		public static final int CUTIE_DEFAULT_WIDTH = 100;
		public static final int CUTIE_DEFAULT_HEIGHT = 100;
		
		public static final int CUTIE_WIDTH = (int)(64 * Game.SCALE) ;
		public static final int CUTIE_HEIGHT = (int) (55 * Game.SCALE);
		
		//BALD
		public static final int BALD_DEFAULT_WIDTH = 70;
		public static final int BALD_DEFAULT_HEIGHT = 74;
		
		public static final int BALD_WIDTH = (int)(40 * Game.SCALE) ;
		public static final int BALD_HEIGHT = (int) (40 * Game.SCALE);
		
		//CHICK
		public static final int CHICK_DEFAULT_WIDTH = 32;
		public static final int CHICK_DEFAULT_HEIGHT = 32;
		
		public static final int CHICK_WIDTH = (int)(CHICK_DEFAULT_WIDTH  + 20 * Game.SCALE) ;
		public static final int CHICK_HEIGHT = (int) (CHICK_DEFAULT_HEIGHT + 20 * Game.SCALE);
		

		//CAT
		public static final int CAT_DEFAULT_WIDTH = 50;
		public static final int CAT_DEFAULT_HEIGHT = 50;
		
		public static final int CAT_WIDTH = (int)(CAT_DEFAULT_WIDTH * Game.SCALE) +  (int)(10 * Game.SCALE);
		public static final int CAT_HEIGHT = (int) (CAT_DEFAULT_HEIGHT * Game.SCALE) +  (int)(10 * Game.SCALE);
		
		//MARTIAL
		public static final int MARTIAL_DEFAULT_WIDTH = 100;
		public static final int MARTIAL_DEFAULT_HEIGHT = 100;
		
		public static final int MARTIAL_WIDTH = (int)(MARTIAL_DEFAULT_WIDTH * Game.SCALE) -  (int)(40 * Game.SCALE);
		public static final int MARTIAL_HEIGHT = (int) (MARTIAL_DEFAULT_HEIGHT * Game.SCALE) -  (int)(40 * Game.SCALE);
		
		//FAT
		public static final int FAT_DEFAULT_WIDTH = 80;
		public static final int FAT_DEFAULT_HEIGHT = 80;
		
		public static final int FAT_WIDTH = (int)(FAT_DEFAULT_WIDTH * Game.SCALE);
		public static final int FAT_HEIGHT = (int) (FAT_DEFAULT_HEIGHT * Game.SCALE);
		
		
		//HOOD
		public static final int HOOD_DEFAULT_WIDTH = 81;
		public static final int HOOD_DEFAULT_HEIGHT = 66;
		
		public static final int HOOD_WIDTH = (int)(HOOD_DEFAULT_WIDTH * Game.SCALE);
		public static final int HOOD_HEIGHT = (int) (HOOD_DEFAULT_HEIGHT * Game.SCALE);
		
		//ANGEL
		public static final int ANGEL_DEFAULT_WIDTH = 122;
		public static final int ANGEL_DEFAULT_HEIGHT = 117;
		
		public static final int ANGEL_WIDTH = (int)(ANGEL_DEFAULT_WIDTH * Game.SCALE);
		public static final int ANGEL_HEIGHT = (int) (ANGEL_DEFAULT_HEIGHT * Game.SCALE);
		public static int GetSpriteAmount(int NPC_type, int NPC_state) {
			
			switch(NPC_type) {	
				case CUTIE:
					switch(NPC_state) {
					case IDLE:
						return 4;
					}
				case BALD:
					switch(NPC_state) {
					case IDLE:
						return 6;
					}
				case CHICK:
					switch(NPC_state) {
					case IDLE:
						return 6;
					}
				case CAT:
					switch(NPC_state) {
					case IDLE:
						return 10;
					}
				case MARTIAL:
					switch(NPC_state) {
					case IDLE:
						return 4;
					}
				case FAT:
					switch(NPC_state) {
					case IDLE:
						return 6;
					}
				case HOOD:
					switch(NPC_state) {
					case IDLE:
						return 5;
					}
				case ANGEL:
					switch(NPC_state) {
					case IDLE:
						return 8;
					}
			}
			
			return 0;
		}
		
		public static String GetNPC_Name(int NPC_type) {
			
			switch(NPC_type) {	
				case CUTIE:
					return "Cutie";
				case BALD:
					return "Mr. Bald";
				case CHICK:
					return "Chick-Boi";
				case CAT:
					return "Janice's Cat";
				case MARTIAL:
					return "Martial Guard";
				case FAT:
					return "Papa Fat";
				case HOOD:
					return "Cultist Warden";
				case ANGEL:
					return "Guardian Angel";
			}
			
			return "";
		}
	}
	public static class OBJECT{
		public static final int LAVA = 1;
		public static final int LAVA_DEFAULT_WIDTH = 64;
		public static final int LAVA_DEFAULT_HEIGHT = 64;
		
		public static final int LAVA_WIDTH = (int)(32 * Game.SCALE);
		public static final int LAVA_HEIGHT = (int) (32 *  Game.SCALE);
	}
	public static class UI{
		public static class Button{
			public static final int B_WIDTH_DEFAULT = 300;
			public static final int B_HEIGHT_DEFAULT = 60;
			public static final int B_WIDTH = (int)(B_WIDTH_DEFAULT * Game.SCALE) -  (int)(150 * Game.SCALE);
			public static final int B_HEIGHT = (int)(B_HEIGHT_DEFAULT * Game.SCALE) -  (int)(30 * Game.SCALE);
			
			public static final int B_GAMEOVER_WIDTH_DEFAULT = 140;
			public static final int B_GAMEOVER_HEIGHT_DEFAULT = 30;
			public static final int B_GAMEOVER_WIDTH = (int)(B_GAMEOVER_WIDTH_DEFAULT * Game.SCALE) / 2;
			public static final int B_GAMEOVER_HEIGHT = (int)(B_GAMEOVER_HEIGHT_DEFAULT * Game.SCALE) / 2;
		}
	}
	public static class Enemy{
		public final static int FIREWORM = 0;
		public final static int EVILWIZARD = 1;

		public final static int IDLE = 0;
		public final static int WALK = 1;
		public final static int ATTACK = 2;
		public final static int HIT = 3;
		public final static int DEAD = 4;
		
		public final static int FIREWORM_WIDTH_DEFAULT = 90;
		public final static int FIREWORM_HEIGHT_DEFAULT = 90;
		
		public final static int FIREWORM_WIDTH = (int)(FIREWORM_WIDTH_DEFAULT * Game.SCALE);
		public final static int FIREWORM_HEIGHT = (int)(FIREWORM_HEIGHT_DEFAULT * Game.SCALE);
		
		//EVILWIZARD
		
		public final static int EVILWIZARD_WIDTH_DEFAULT = 150;
		public final static int EVILWIZARD_HEIGHT_DEFAULT = 150;
		
		public final static int EVILWIZARD_WIDTH = (int)(EVILWIZARD_WIDTH_DEFAULT * Game.SCALE);
		public final static int EVILWIZARD_HEIGHT = (int)(EVILWIZARD_HEIGHT_DEFAULT * Game.SCALE);
		
		public static int getSprite(int enemyType, int enemyState) {
			switch(enemyType) {
			case FIREWORM:
					switch(enemyState) {
					case IDLE:
					case WALK:
						return 9;
					case ATTACK:
					case DEAD:
						return 8;
					case HIT:
						return 3;
					default:
						return 0;
					}
			case EVILWIZARD:
					switch(enemyState) {
					case IDLE:
					case WALK:
					case ATTACK:
						return 8;
					case HIT:
						return 4;
					case DEAD:
						return 5;
					default:
						return 0;
					}
			}
			
			return 0;
		}
		public static int GetMaxHealth(int enemytype) {
			switch(enemytype) {
			case FIREWORM:
				return 10;
			
			case EVILWIZARD:
				return 4;
			default:
				return 1;
			}
		}
			
		
		
		public static double GetEnemyDamage(int enemytype) {
			switch(enemytype) {
			case FIREWORM:
				return 5;
			case EVILWIZARD:
				return 0.2;
			default:
				return 1;
			}
			
		}
		
		
	}
	public static class Player{
		public final static int LEFT = 1;
		public final static int RIGHT = 2;
		
		public final static int IDLE = 0;
		public final static int RUNNING = 1;
		public final static int ATTACK = 2;
		public final static int JUMPING = 3;
		public final static int FALL = 4;
		public final static int HIT = 5;
		public final static int DEAD = 6;
		public final static int getPlayerAction(int playerAction) {
			switch(playerAction) {
			case IDLE:
			case HIT:
			case DEAD:
				return 4;

			case FALL:
				return 3;
			case RUNNING:
			case ATTACK:
				return 6;
			default:
				return 0;
			}
		}
	}
}

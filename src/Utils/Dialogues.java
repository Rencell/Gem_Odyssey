package Utils;

public class Dialogues {
	public static class MainDialogue{
		public static String[] getOpeningDialogue(){
			String[] dialogue = new String[2];
			dialogue[0] = "There is a legend about this..  stone, gem, mineral that holds a significant power. "
					+ "Word of mouth says whoever owns this \"rock\" will be granted an enormous power , "
					+ "but that is if only the holder is worthy of this power or else who shall hold it "
					+ "with no worthiness will suffer a fate worse than death";
			
			dialogue[1] = "Legend says the coordinates of this \"thing\" is not a mystery. "
					+ "But only the courages have a possibility to survive a day on this "
					+ "journey, are you willing to take it?";
			return dialogue;
		}
		
		public static String[] getEndingDialogue(){
			String[] dialogue = new String[3];
			dialogue[0] = "Unknown enemy: Hello Anna                                                    -----TO BE CONTINUED...";
			return dialogue;
		}
	}
	public static class NPCS{
		public static String[] CutieDialogue(){
			String[] CUTIE_dialogue;
			
			CUTIE_dialogue = new String[2];
			CUTIE_dialogue[0] = "You really believe in that old legend? I've heard it's just a tale to scare off the foolish.";
			CUTIE_dialogue[1] = "No one's ever returned from that journey, you know.";
			return CUTIE_dialogue;
		}
		
		public static String[] BaldDialogue(){
			String[] BALD_dialogue;
			BALD_dialogue = new String[3];
			BALD_dialogue[0] = "Oh an adventurer?? Seek to see the infamous Gem? I see. ";
			BALD_dialogue[1] = "Are you prepared for the trials ahead?";
			BALD_dialogue[2] = "Don't mind me I'm not in trouble here I'm just farming from the treassure hoarders here continue your journey ahead adventurer.";
			
			return BALD_dialogue;
		}
		
		public static String[] ChickDialogue(){
			String[] CHICK_dialogue;
			CHICK_dialogue = new String[2];
			CHICK_dialogue[0] = "hello Adventurer ! I am Chickin, The helpful guide you need. ";
			CHICK_dialogue[1] = "There are 2 types of enemies here you can kill the easy enemies by hitting them one time critically. ";
			return CHICK_dialogue;
		}
		public static String[] CatDialogue(){
			String[] CAT_dialogue;
			CAT_dialogue = new String[3];
			CAT_dialogue[0] = "Meow! Well, hello there, dear Heroine! Fancy meeting you in this Burning Inferno.";
			CAT_dialogue[1] = "What brings you to Aspire in such greater heights?.";
			CAT_dialogue[2] = "What makes you think you can accomplish in this journey of yours?";
			
			//  
			return CAT_dialogue;
		}
		public static String[] MartialDialogue(){
			String[] MARTIAL_dialogue;
			MARTIAL_dialogue = new String[3];
			MARTIAL_dialogue[0] = "You seek the Stone of Power, do you? ";
			MARTIAL_dialogue[1] = "How did you managed to survive- wait are you that famous traveller everyone was talking about? That explains why.";
			MARTIAL_dialogue[2] = " Go on through your journey best of luck! ";
			return MARTIAL_dialogue;
		}
		public static String[] FatDialogue(){
			String[] FAT_dialogue;
			FAT_dialogue = new String[3];
			FAT_dialogue[0] = "We've known each other for a long time, you've never had this much trouble";
			FAT_dialogue[1] = "This journey may take up a on you. ";
			FAT_dialogue[2] = "You sure you can handle this blud? ";
			return FAT_dialogue;
		}
		public static String[] HoodDialogue(){
			String[] FAT_dialogue;
			FAT_dialogue = new String[3];
			FAT_dialogue[0] = "You have survived adventurer hehehe I saw what you are capable of and it doesn't fit quite the stories I heard from you but nevermind we'll observe what happens. ";
			FAT_dialogue[1] = "Hurry!";
			FAT_dialogue[2] = "Destiny waits at the crossroads, and your footsteps echo in its chambers.";
			return FAT_dialogue;
		}
		public static String[] AngelDialogue(){
			String[] FAT_dialogue;
			FAT_dialogue = new String[4];
			FAT_dialogue[0] = "So, you're the one who seeks the Stone.";
			FAT_dialogue[1] = "Have been waiting for decades now I am He who thy take the gem will be granted not only fortune but unbelievable wealth from whoever wields it. ";
			FAT_dialogue[2] = "The path is treacherous, and the challenges are not for the faint of heart. ";
			FAT_dialogue[3] = "Ahead of me the gem is. Luck of best my dear adventurer.";
			return FAT_dialogue;
		}
	}
}

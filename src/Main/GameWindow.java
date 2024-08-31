package Main;

import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameWindow extends JFrame{
	
	private Image image;
	private ImageIcon imageicon;
	GameWindow(GamePanel gamepanel){
		imageicon = new ImageIcon(getClass().getResource("/GameIcon.png"));
		
		 
		
		this.setIconImage(imageicon.getImage());
		  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(gamepanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Gem Odyssey");
		this.addWindowFocusListener(new WindowFocusListener() {
		@Override
		public void windowLostFocus(WindowEvent e) {
			gamepanel.getGame().windowlostfocus();
		}
		
		@Override
		public void windowGainedFocus(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	}
	
}

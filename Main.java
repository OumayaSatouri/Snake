import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		Frame frame = new Frame();

	}
/*
	//frame: for the window
	//panel: for the snake+aplles
	public static void main(String[] args) {
		JFrame frame = new JFrame("Snake Game"); //1
		Panel panel = new Panel(); //3
		
		//4
		frame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				Panel.onKeyPressed(e.getKeyCode());	
			}
		});
		
		//1
		frame.setContentPane(panel); //3: show square panel
		frame.setSize(13*50, 13*50); //taille: 13 petits carrés de 50
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); //put it in the center
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //quit and free the memory
		frame.setVisible(true);
	}  */ 
}
	

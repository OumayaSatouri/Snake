import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Frame implements KeyListener{
	
	//frame: for the window
	//panel: for the snake+aplles
	
	JFrame frame = new JFrame("Snake Game"); //1
	Panel panel = new Panel(); //3

	public Frame () {
		
		frame.setContentPane(panel); //3: show square panel
		frame.setSize(13*30, 13*30); //taille: 13 petits carrés de 30
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); //put it in the center
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //quit and free the memory
		frame.setVisible(true);
		
		//4
		
  	  	frame.addKeyListener(this); //call the listener

		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		Panel.onKeyPressed(e.getKeyCode());	

	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}   
	
	
}

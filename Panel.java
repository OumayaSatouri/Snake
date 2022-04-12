import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import javax.swing.JPanel;

//import Snake.Main.SnakePart;

public class Panel extends JPanel{
	
	Graphics g;
	//allow to draw onto components that are realized on various devices
	private final int size = 30; //snake size

	private Deque<Snake> snake = new ArrayDeque<>();//able to get first and last element (copy the first put it after + remove last) 
	private Point apple = new Point(0,0); //9
	private Random rand = new Random(); //for apple
	
	private boolean isGrowing = false; //10: to growup
	private boolean gameLost = false;
	
	private int offset = 0; //décalage 
	private static int newDirection = 39; //right
	
	
	public Panel() {
		
		setBackground(Color.BLACK); 

		//pos0 of the snake
		snake.add(new Snake(0, 0, 39)); //instancier// 39:: right
		
		createApple();
		
		
		//2
		//pour que ca se compile en meme temps que la fenetre
		//plusieurs actions en meme temps
		//runnable: ce qui sera executé
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					repaint();
					try {
						Thread.sleep(1000/70); //change!! 1000/60 --> 60 exec /sec
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	
	//9: apple create
	public void createApple() {
		boolean positionAvailable=true; 
		
		//11: create random apples
		do { //while true
			//rand.nextInt(max - min + 1) + min; [0-11]
			apple.x = rand.nextInt(12); //12 cases :taille ecran
			apple.y = rand.nextInt(12);
			for(Snake p : snake) {
				if(p.x == apple.x && p.y == apple.y) { //si mm coord apple et snake
					positionAvailable = false;
					break; //quit
				}
			}
		} while(!positionAvailable);
	}
	
	/**
	 * gameOver method
	 */
	/* 
	public void gameOver() {
		if(gameLost==true) {
			g.setColor(Color.RED);
			g.setFont(new Font("Arial", 50, 50));
			g.drawString("Game Over!", 13*30/2 - g.getFontMetrics().stringWidth("Game Over!")/2, 13*30/2); //13*50/2: middle
			return; //instead of break 
		}
	}
	*/
	
	/*public void moveSnake() {
		Snake head = null;
		offset += 3; //increment decalage: ca definit la vitesse
		if(offset == size) {
			offset = 0; //remettre a 0 quand c'est egale a 30 sinon trop rapide
			
			//8 : avancer +clone
			try {
				head = (Snake) snake.getFirst().clone(); //prend head et faire une copie
				head.move();
				head.dir = newDirection;
				snake.addFirst(head);
				
				if(head.x == apple.x && head.y == apple.y) { //9: si head et apple meme coord
					isGrowing = true;
					createApple();
				}
				if(!isGrowing) //9: s'il n'est pas entrain de grossir
					snake.pollLast(); //remove queue + return
				else
					isGrowing = false;
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Snake head = null;
		
		//12: break gameover
		if(gameLost==true) {
			g.setColor(Color.RED);
			g.setFont(new Font("Arial", 50, 50));
			g.drawString("Game Over!", 13*30/2 - g.getFontMetrics().stringWidth("Game Over!")/2, 13*30/2); //13*50/2: middle
			return; //instead of break 
		}
		
		//moveSnake();
		
		//6
		offset += 3; //increment decalage: ca definit la vitesse
		if(offset == size) {
			offset = 0; //remettre a 0 quand c'est egale a 30 sinon trop rapide
			
			//8 : avancer +clone
			try {
				head = (Snake) snake.getFirst().clone(); //prend head et faire une copie
				head.move();
				head.dir = newDirection;
				snake.addFirst(head);
				
				if(head.x == apple.x && head.y == apple.y) { //9: si head et apple meme coord
					isGrowing = true;
					createApple();
				}
				if(!isGrowing) //9: s'il n'est pas entrain de grossir
					snake.pollLast(); //remove queue + return
				else
					isGrowing = false;
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//9: apple
		g.setColor(Color.green); 
		g.fillOval(apple.x*size + size/4, apple.y*size + size/4, size/2, size/2); //size/2: long et largeur || size/4:: centred
		
		//snake color
		g.setColor(Color.WHITE); 
		
		//5: parcourir le snake 
		for(Snake p : snake) { 
			//10: to fail head==tail 
			//gameOver
			if(offset == 0) {
				if(p != head) { //not head BUT
					if(p.x == head.x && p.y == head.y) {
						gameLost = true; //perdre
					}
				}
			}
			
			/**
			 * 6
			 * traiter les directions
			 * keyboard codes
			 * 37: left
			 * 38: Up
			 * 39: Right
			 * 40: down
			 * graphics.fillRect(x,y,large,height)
			 */
			if(p.dir == 37 || p.dir== 39) { //horizontal
				g.fillRect(p.x * size + ((p.dir== 37) ? -offset : offset), p.y*size, size, size); //offset: décalage
			}
			//vertical decalage
			else {
				g.fillRect(p.x * size, p.y*size + ((p.dir == 38) ? -offset : offset), size, size);
			}
		}
		
		//10: perdu
		g.setColor(Color.WHITE);
		g.drawString("Your Score is : "+(snake.size() -1), 10, 350);
		
	}
	
	//7: keylistener: il ne pourra pas aller dans la dir opposée
	public static void onKeyPressed(int keyCode) {
		if(keyCode >= 37 && keyCode <= 40) {
			if(Math.abs(keyCode - newDirection) != 2) {
				newDirection = keyCode;
			}
		}
	}
	
	
}
	

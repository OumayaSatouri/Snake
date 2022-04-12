import java.awt.Point;
import java.util.Deque;

public class Snake {
	
	//4
	//coord + dir of the snake
	public int x, y, dir;
	
	public Snake(int x, int y, int direction) {
		this.x = x;
		this.y = y;
		this.dir = direction;
	}
	
	//8
	public void move() {
		//vertical dir => X
		if(dir == 37 || dir == 39) {
			x += (dir == 37) ? -1 : 1; //si 37 (left) retour en arriere sinon avance
			if(x > 13) //si depasse--> retour au debut
				x = -1; //OR 00?? !!!!!!!!!!!!!
			else if(x < -1)
				x = 13;
		}
		//Horizental dir =>Y
		else {
			y += (dir == 38) ? -1 : 1;
			if(y > 13)
				y = -1;
			else if(y < -1)
				y = 13;
		}
	}
	
	/**
	 * 4
	 * exact copy of an object with the same arguments
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Snake(x, y, dir);
	}
	
	/*
	public static void moveSnake(Deque<Snake> snake, Point apple ) {
		Snake head = null;
		
		//6
		if(Panel.offset == Panel.WIDTH) {
			Panel.offset = 0; //remettre a 0 quand c'est egale a 50
			
			//8 : avancer +clone
			try {
				head = (Snake) snake.getFirst().clone(); //prend head et faire une copie
				head.move();
				head.dir = Panel.newDirection;
				snake.addFirst(head);
				
				if(head.x == apple.x && head.y == apple.y) { //9: si head et apple meme coord
					Panel.isGrowing = true;
					Panel.createApple();
				}
				if(!Panel.isGrowing) //9: s'il n'est pas entrain de grossir
					snake.pollLast(); //remove queue + return
				else
					Panel.isGrowing = false;
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	*/
}


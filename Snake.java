import java.util.ArrayDeque;
import java.awt.Point;

public class Snake extends ArrayDeque<Point> {

	public Snake(int startX, int startY){
		this.add(new Point(startX, startY));
	}

	// give a direction and whether or not to extend
	// the snake
	public void move(Direction d, boolean extend){
		if(d == Direction.LEFT){
			moveLeft();
		}
		else if(d == Direction.RIGHT){
			moveRight();
		}
		else if(d == Direction.UP){
			moveUp();
		}
		else if(d == Direction.DOWN){
			moveDown();
		}

		if(!extend){
			this.removeLast();
		}
	}

	private void moveLeft(){
		Point oldHead = this.peek();
		Point newHead = new Point(oldHead.x, oldHead.y - 1);

		this.addFirst(newHead);

	}
	
	private void moveRight(){
		Point oldHead = this.peek();
		Point newHead = new Point(oldHead.x, oldHead.y + 1);

		this.addFirst(newHead);

	}

	private void moveUp(){
		Point oldHead = this.peek();
		Point newHead = new Point(oldHead.x - 1, oldHead.y);

		this.addFirst(newHead);

	}

	private void moveDown(){
		Point oldHead = this.peek();
		Point newHead = new Point(oldHead.x + 1, oldHead.y);

		this.addFirst(newHead);

	}
	
}

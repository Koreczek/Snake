package model;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Model {
	static final int size = 20;
	Field[][] grid = new Field[size][size];
	private Snake snake = new Snake();
	private Field food = new Field();
	private int score;
	
	public Model() {
		reset();
	}
	public void reset() { 
		snake.reset();
		score = 0;
		setFood();
	}
	private void setFood() {
		Random generator = new Random();
		int i = generator.nextInt(size);
		int j = generator.nextInt(size);
		for (int k = 0; k < snake.getList().size(); k ++) {;
			if (i == snake.getList().get(k).getx() && j == snake.getList().get(k).gety()) {
				i = generator.nextInt(size);
				j = generator.nextInt(size);
				k = 0;
			}
		}
		food.setposition(i, j);
	}
	public void setSnakeDirection(int d) { 
		snake.setDirection(d);
	}
	public void move() {
		snake.move();
		Field head = snake.getList().getFirst();
		checkColision(head);
		eat(head);
	}
	private void eat(Field head) {
		if(food.isEqual(head)) {
			score += 10;
			snake.addPieceOfSnake(food.getx(), food.gety());
			setFood();
		}
		
	}
	private void checkColision(Field head) {
		// TODO Auto-generated method stub
		
	}
	public LinkedList<Field> getListOfSnakePoints() {
		return snake.getList();
	}
	public Field getFood() { 
		return food;
	}
	public int getSnakeDirection() {
		return snake.getDirection();
	}
}

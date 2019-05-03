package model;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Model {
	public static final int size = 30;
	private Snake snake = new Snake();
	private LinkedList<Field> eatenFood = new LinkedList<Field>(); 
	private Field food = new Field();
	private int score;
	private int pause;
	private boolean gameover;
	
	public Model() {
		reset();
	}
	public void reset() { 
		snake.reset();
		score = 0;
		pause = 0;
		setFood();
		setGameover(false);
		eatenFood.clear();
	}
	private void setFood() {
		Random generator = new Random();
		int i = generator.nextInt(size);
		int j = generator.nextInt(size);
		for (int k = 0; k < snake.getList().size(); k ++) {
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
		if (pause % 2 == 0 && gameover == false) {
			snake.move();
			Field head = snake.getList().getFirst();
			checkColision(head);
			eat(head);
			if(eatenFood.size() != 0 && eatenFood.getFirst().isEqual(snake.getList().getLast())) {
				eatenFood.removeLast();
			}
		}
	}
	private void eat(Field head) {
		if(food.isEqual(head)) {
			Field eatedFood = new Field(food.getx(), food.gety());
			eatenFood.addFirst(eatedFood);
			score += 10;
			snake.addPieceOfSnake(food.getx(), food.gety());
			setFood();
		}
		
	}
	private void checkColision(Field head) {
		for (int k = 1; k < snake.getList().size(); k ++) {
			if (head.isEqual(snake.getList().get(k))) {
				System.out.println(score);
				setGameover(true);
			}
		}
		
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
	public void pause() {
		pause++;
	}
	public boolean isGameover() {
		return gameover;
	}
	public void setGameover(boolean gameover) {
		this.gameover = gameover;
	}
	public LinkedList<Field> getEatenFood() {
		return eatenFood;
	}
}

package model;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Model {
	int size = 20;
	Field[][] grid = new Field[size][size];
	private Snake snake = new Snake();
	Field food = new Field();
	
	public Model() {
		reset();
	}
	public void reset() { 
		snake.reset();
		setFood();
	}
	private void setFood() {
		// TODO Auto-generated method stub		
	}
	public void setSnakeDirection(int d) { 
		snake.setDirection(d);
	}
	public void move() {
		snake.move();
	}
	public LinkedList<Field> getListOfSnakePoints() {
		return snake.getList();
	}
	
}

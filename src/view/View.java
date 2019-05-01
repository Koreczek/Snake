package view;

import model.Model;
import model.Field;
import java.awt.*;
import java.util.LinkedList;

import javax.swing.JFrame;

public class View extends JFrame{
	Model model = new Model();
	private LinkedList<Field> snake;
	public View(Model m) {

		this.setTitle("Snake");
		this.setSize(400, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		model = m;
		snake = model.getListOfSnakePoints();
	}
	public void paint(Graphics g) {
		draw(g);
	}
	private void draw(Graphics g) { 
		updateSnake();
		g.clearRect(0,0,getWidth(),getHeight());
		g.setColor(Color.black);
		for(int index = 0; index < snake.size(); index++) {
			putPoint(g, snake.get(index).getx(), snake.get(index).gety() );
		}
		g.setColor(Color.red);
		putPoint(g, model.getFood().getx(), model.getFood().gety());

	}
	private void putPoint(Graphics g, int x2, int y2) {
		g.fillRect(20*x2,20*y2,20,20);	
	}
	public void updateSnake() {
		this.snake = model.getListOfSnakePoints();
	}
}

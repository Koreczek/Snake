package model;

import java.util.LinkedList;

public class Snake {
	private int direction; //0 - up, 1 - right, 2 - down, 3 - left
	private int sizeofsnake;
	private LinkedList<Field> piecesofsnake = new LinkedList<Field>(); 
	
	private Snake() {
		reset();
	}
	
	private void reset() {
		direction = 1;
		sizeofsnake = 3;
		addPieceOfSnake(8,10);
		addPieceOfSnake(9,10);
		addPieceOfSnake(10,10);
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	public void addPieceOfSnake (int x, int y) {
		Field piecetoadd = new Field(x, y);
		piecesofsnake.addFirst(piecetoadd);
	}
	
	private void removeLastPieceOfSnake() {
		piecesofsnake.removeLast();
	}
	
	public void move() {
		switch(direction) {
		case 0:
			goUp();
			break;
		case 1:
			goRight();
			break;
		case 2:
			godown();
			break;
		case 3:
			goLeft();
			break;
		default:
			break;
		}
	}
	
	private void goUp() {
		Field head = piecesofsnake.getFirst();
		int newx = head.getx();
		int newy = head.gety() - 1;
		addPieceOfSnake(newx, newy);
		removeLastPieceOfSnake();
	}
	private void goRight() {
		Field head = piecesofsnake.getFirst();
		int newx = head.getx() + 1;
		int newy = head.gety();
		addPieceOfSnake(newx, newy);
		removeLastPieceOfSnake();
	}
	private void godown() {
		Field head = piecesofsnake.getFirst();
		int newx = head.getx();
		int newy = head.gety() + 1;
		addPieceOfSnake(newx, newy);
		removeLastPieceOfSnake();
	}
	private void goLeft() {
		Field head = piecesofsnake.getFirst();
		int newx = head.getx() - 1;
		int newy = head.gety();
		addPieceOfSnake(newx, newy);
		removeLastPieceOfSnake();
	}

		
}
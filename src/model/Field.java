package model;

public class Field {
	private int x;
	private int y;
	private int kindOfField; //0 - free, 1 - snake, 2 - food, 3 - wall
	public Field(int x, int y, int kind) {
		setposition(x, y);
		setKindOfField(kind);
	}
	public Field() {
		x = 0;
		y = 0;
		kindOfField = 0;
	}
	public void setposition(int x, int y) { 
		this.x = x;
		this.y = y;			
	}
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
	public int getKindOfField() {
		return kindOfField;
	}
	public void setKindOfField(int kindOfField) {
		this.kindOfField = kindOfField;
	}
}
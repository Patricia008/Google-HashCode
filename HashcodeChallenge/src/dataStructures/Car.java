package dataStructures;

public class Car {
	
	private int rPos;
	private int cPos;
	
	public Car(int rPos, int cPos) {
		super();
		this.rPos = rPos;
		this.cPos = cPos;
	}
	public int getrPos() {
		return rPos;
	}
	public void setrPos(int rPos) {
		this.rPos = rPos;
	}
	public int getcPos() {
		return cPos;
	}
	public void setcPos(int cPos) {
		this.cPos = cPos;
	}
	
	
}

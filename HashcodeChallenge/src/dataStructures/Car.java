package dataStructures;

import java.util.List;

public class Car {
	
	private int rPos;
	private int cPos;
	private List<Route> routes;
	
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
	public List<Route> getRoutes() {
		return routes;
	}
	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}		
	
	public void addtoRoutes(Route route) {
		routes.add(route);
	}
}

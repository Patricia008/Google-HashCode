package dataStructures;
import java.util.ArrayList;

public class Data {
	private int rows;
	private int columns;
	private int noCars;
	private int noRides;
	private int bonusStart;
	private int steps;

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getNoCars() {
		return noCars;
	}

	public void setNoCars(int noCars) {
		this.noCars = noCars;
	}

	public int getNoRides() {
		return noRides;
	}

	public void setNoRides(int noRides) {
		this.noRides = noRides;
	}

	public int getBonusStart() {
		return bonusStart;
	}

	public void setBonusStart(int bonusStart) {
		this.bonusStart = bonusStart;
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	private ArrayList<Route> routes;

	public Data() {
		this.routes = new ArrayList<Route>();
	}

	public void addRoute(Route r) {
		this.routes.add(r);
	}

	public void removeRoute(Route r) {
		this.routes.remove(r);
	}

}

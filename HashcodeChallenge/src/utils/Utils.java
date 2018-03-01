package utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import dataStructures.Car;
import dataStructures.Data;
import dataStructures.Route;

public class Utils {

	public Route getHighestWeight(Car car, ArrayList<Route> routes, Data data) {
        routes.sort(new Comparator<Route>() {
            @Override
            public int compare(Route o1, Route o2) {
                return o1.getWeight() > o2.getWeight() ? 1 : 0;
            }
        });
	    return routes.get(0);
	}

	public double getWeightByTimeToStart(Car car, Route route, Data data, int currentStep, int maxStep) {
        
		double distanceToStart = Math.abs(car.getrPos() - route.getrStart()) + Math.abs(car.getcPos() - route.getcStart());
		double timeToStart = currentStep + distanceToStart;
		boolean possible = timeToStart < route.gettStart() && timeToStart + route.getTimeToTravel() < maxStep;
		if(!possible) {
			return 0;
		}
		return distanceToStart;
	}
	
	public void setWeightsByTimeToStart(Car car, List<Route> routes, Data data, int currentStep, int maxStep) {
		for(Route route: routes) {
			//TODO change get weight function
			route.setWeight(getWeightByTimeToStart(car, route, data, currentStep, maxStep));
		}
	}
	
	public int computeDistance(int r0, int c0, int r1, int c1) {
		return Math.abs(r0 - r1) + Math.abs(c0 - c1);
	}
	
	public Car getRoutesForCar(Car car, List<Route> inputRoutes, Data data) {
		int currentStep = 0;
		while(currentStep < data.getSteps()) {
			Route route = getHighestWeight(car, (ArrayList<Route>)inputRoutes, data);
			inputRoutes.remove(route);
			car.addtoRoutes(route);
			currentStep += computeDistance(car.getrPos(), car.getcPos(), route.getrStart(), route.getcStart()) + route.getLength();
		}
		
		return car;
	}
	
	public List<Car> getRoutesForAllCarsPerCarFirst(List<Car> cars, List<Route> inputRoutes, Data data){
		Iterator<Car> it = cars.iterator();
		while(it.hasNext()) {
			getRoutesForCar(it.next(), inputRoutes, data);
		}
		return cars;
	}
	
	public List<Car> getRoutesForAllCarsManyAtATime(){
		//TODO
		return null;
	}
	
}

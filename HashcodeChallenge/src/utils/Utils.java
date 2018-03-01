package utils;

import java.util.ArrayList;
import java.util.Comparator;
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
	    return null;
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
			route.setWeight(getWeightByTimeToStart(car, route, data, currentStep, maxStep));
		}
	}
}

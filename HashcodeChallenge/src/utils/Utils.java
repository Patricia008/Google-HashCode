package utils;

import java.util.ArrayList;
import java.util.Comparator;

import dataStructures.Car;
import dataStructures.Route;

public class Utils {

	public Route getHighestWeight(Car car, ArrayList<Route> routes, int bonus, int currentStep, int steps) {
        routes.sort(new Comparator<Route>() {
            @Override
            public int compare(Route o1, Route o2) {
                return o1.getWeight() > o2.getWeight() ? 1 : 0;
            }
        });
	    return null;
	}

	public double getWeight(Route route, int bonus, int currentStep, int steps) {
        return route.getLength() + currentStep +
	}
}

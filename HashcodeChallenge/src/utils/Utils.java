package utils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import dataStructures.Car;
import dataStructures.Data;
import dataStructures.Route;

public class Utils {

	public Route getHighestWeight(Car car, Data data, int currentStep) {
		//TODO
		setWeightsByHighestBonus(car, data, currentStep);
        data.getRoutes().sort(new Comparator<Route>() {
            @Override
            public int compare(Route o1, Route o2) {
                return o1.getWeight() < o2.getWeight() ? 1 : 0;
            }
        });
        System.out.println(data.getRoutes().get(0).getWeight());
	    return data.getRoutes().get(0);
	}

	public double getWeightForHighestBonus(Car car, Route route, Data data, int currentStep) {
        
		double distanceToStart = Math.abs(car.getrPos() - route.getrStart()) + Math.abs(car.getcPos() - route.getcStart());
		double timeToStart = currentStep + distanceToStart;
		boolean possible = timeToStart < route.gettStart() && timeToStart + route.getTimeToTravel() < data.getSteps();
		if(!possible) {
			return 0;
		}
		return timeToStart;
	}
	
	public void setWeightsByHighestBonus(Car car, Data data, int currentStep) {
		for(Route route: data.getRoutes()) {
			//TODO change get weight function
			route.setWeight(getWeightByTimeToStart(car, route, data, currentStep));
		}
	}
	
public double getWeightByTimeToStart(Car car, Route route, Data data, int currentStep) {
        
		double distanceToStart = computeDistance(car.getrPos(), car.getcPos(), route.getrStart(), route.getcStart());
		double timeToStart = currentStep + distanceToStart;
		boolean possible = timeToStart < route.gettStart() && timeToStart + route.getTimeToTravel() < data.getSteps();
		if(!possible) {
			return Integer.MAX_VALUE;
		}
		return timeToStart;
	}
	
	public void setWeightsByTimeToStart(Car car, Data data, int currentStep) {
		for(Route route: data.getRoutes()) {
			//TODO change get weight function
			route.setWeight(getWeightByTimeToStart(car, route, data, currentStep));
		}
	}
	
	public int computeDistance(int r0, int c0, int r1, int c1) {
		return Math.abs(r0 - r1) + Math.abs(c0 - c1);
	}
	
	public Car getRoutesForCar(Car car, Data data) {
		int currentStep = 0;
		while(currentStep < data.getSteps() && data.getRoutes().size() > 0) {
			Route route = getHighestWeight(car, data, currentStep);
			data.getRoutes().remove(route);
			car.addtoRoutes(route);
			car.setrPos(route.getrEnd());
			car.setcPos(route.getcEnd());
			currentStep += computeDistance(car.getrPos(), car.getcPos(), route.getrStart(), route.getcStart()) + route.getLength();
		}
		
		return car;
	}
	
	public List<Car> getRoutesForAllCarsPerCarFirst(List<Car> cars, Data data){
		Iterator<Car> it = cars.iterator();
		while(it.hasNext()) {
			getRoutesForCar(it.next(), data);
		}
		return cars;
	}
	
	public List<Car> getForEachRoute(List<Car> cars, Data data){
		while(data.getRoutes().size() > 0) {
			for(Car car: cars) {
				//Route route = getHighestWeight(car, data, currentStep);		
				car.addtoRoutes(data.getRoutes().get(0));
				data.getRoutes().remove(0);
				if (data.getRoutes().size() == 0) {
					break;
				}
			}
		}
		
		return cars;
	}
	
	public List<Car> getRoutesForAllCarsManyAtATime(List<Car> cars, Data data){
		int currentStep = 0;
		while(currentStep < data.getSteps()) {
			for(Car car: cars) {
				Route route = getHighestWeight(car, data, currentStep);
				data.getRoutes().remove(route);
				car.addtoRoutes(route);
				car.setrPos(route.getrEnd());
				car.setcPos(route.getcEnd());
				currentStep += computeDistance(car.getrPos(), car.getcPos(), route.getrStart(), route.getcStart()) + route.getLength();
			}
		}
		
		return cars;
	}
	
}

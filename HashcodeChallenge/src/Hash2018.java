import java.util.ArrayList;
import java.util.List;

import dataStructures.Car;
import dataStructures.Data;
import fileHandlers.InputParser;
import fileHandlers.OutputGenerator;
import utils.Utils;



public class Hash2018 {

	public static void main(String[] args) {

		processFile("resources/a_example");
//		processFile("resources/b_should_be_easy");
//		processFile("resources/c_no_hurry");
//		processFile("resources/d_metropolis");
//		processFile("resources/e_high_bonus");
		
	}

	private static void processFile(String fileName) {
		InputParser parser = new InputParser(fileName + ".in");
	    Data data = parser.parse();
		
		Utils utils = new Utils();
		List<Car> cars = initializeCars(data.getNoCars());
		
		utils.getRoutesForAllCarsPerCarFirst(cars, data);
		
        OutputGenerator generator = new OutputGenerator(fileName + ".out");
        generator.generate((ArrayList<Car>)cars);
	}

	private static List<Car> initializeCars(int n) {
		List<Car> cars = new ArrayList<>();
		for(int i=0; i<n; i++) {
			Car car = new Car(0, 0);
			cars.add(car);
		}
		
		return cars;
	}

}

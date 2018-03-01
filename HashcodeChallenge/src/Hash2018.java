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
		
	}

	private static void processFile(String fileName) {
		InputParser parser = new InputParser(fileName + ".in");
	    Data data = parser.parse();
		
		Utils utils = new Utils();
		List<Car> cars = new ArrayList<>();
		
		utils.getRoutesForAllCarsPerCarFirst(cars, data);
		
        OutputGenerator generator = new OutputGenerator(fileName + ".out");
        generator.generate((ArrayList<Car>)cars);
	}

}

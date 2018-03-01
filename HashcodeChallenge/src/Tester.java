import dataStructures.Car;
import dataStructures.Data;
import dataStructures.Route;
import fileHandlers.InputParser;
import fileHandlers.OutputGenerator;

import java.util.ArrayList;
import java.util.List;

public class Tester
{
    public static void main(String[] args)
    {
        InputParser parser = new InputParser("src/a_example.in");
        Data data = parser.parse();
        System.out.println(data);

        Route r1 = new Route();
        Route r2 = new Route();
        r1.setIndex(0);
        r2.setIndex(1);
        ArrayList<Route> routes = new ArrayList<Route>();
        routes.add(r1);
        routes.add(r2);

        Car c1 = new Car(0,0);
        c1.setRoutes(routes);
        Car c2 = new Car(0,0);
        c2.setRoutes(routes);
        Car c3 = new Car(0,0);
        c3.setRoutes(routes);
        Car c4 = new Car(0,0);
        c4.setRoutes(routes);
        Car c5 = new Car(0,0);
        c5.setRoutes(routes);

        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);
        cars.add(c4);
        cars.add(c5);

        OutputGenerator generator = new OutputGenerator("src/out_a.txt");
        generator.generate(cars);
    }
}

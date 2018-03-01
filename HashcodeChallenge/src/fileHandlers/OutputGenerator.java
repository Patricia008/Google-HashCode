package fileHandlers;

import dataStructures.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OutputGenerator
{
    private String outfile = "";

    public OutputGenerator(String outfile)
    {
        this.outfile = outfile;
    }

    public void generate(ArrayList<Car> cars)
    {
        File file = new File(outfile);
        try
        {
            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

            String line;
            for(Car c : cars)
            {
                List<Route> routes = c.getRoutes();
                line = "" + routes.size();

                for(Route r : routes)
                {
                    line += " " + r.getIndex();
                }

                writer.write(line);
                writer.newLine();
            }

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

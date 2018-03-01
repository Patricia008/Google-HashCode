package fileHandlers;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InputParser
{
    private String filepath = "";

    public InputParser(String filepath)
    {
        this.filepath = filepath;
    }

    public Data parse()
    {
        Data data = new Data();

        try
        {
            FileInputStream inputStream =  new FileInputStream(filepath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            // read parameters
            line = reader.readLine();

            if(line != null)
            {
                String[] parts = line.split(" ");

                // get number of rows R
                data.setRows(Integer.parseInt(parts[0]));

                // get number of columns C
                data.setColumns(Integer.parseInt(parts[1]));

                // get number of cars F
                data.setNoCars(Integer.parseInt(parts[2]));

                // get number of rides N
                data.setNoRides(Integer.parseInt(parts[3]));

                // get start bonus B
                data.setBonusStart(Integer.parseInt(parts[4]));

                // get time T
                data.setSteps(Integer.parseInt(parts[5]));
            }

            while((line = reader.readLine()) != null)
            {
                String pars[] = line.split(" ");
                Route r = new Route();
                r.setrStart(Integer.parseInt(pars[0]));
                r.setcStart(Integer.parseInt(pars[1]));
                r.setrEnd(Integer.parseInt(pars[2]));
                r.setcEnd(Integer.parseInt(pars[3]));
                r.settStart(Integer.parseInt(pars[4]));
                r.settEnd(Integer.parseInt(pars[5]));

                data.addRoute(r);
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}

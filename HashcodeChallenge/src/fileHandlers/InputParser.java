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

    public void parse()
    {
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

            }

            while((line = reader.readLine()) != null)
            {

            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

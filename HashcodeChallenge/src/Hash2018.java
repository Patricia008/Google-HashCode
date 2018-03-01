import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Scanner;

public class Hash2018 {

	private String readFile(String fileName) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(fileName));
		StringBuilder sb = new StringBuilder();
		while (in.hasNext()) {
			sb.append(in.next());
		}
		in.close();
		return sb.toString();
	}

	private void writeToFile(String fileName, String text) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		try (Writer writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"))) {
			writer.write(text);
		}
	}

	public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println("Please provide the right nr. of arguments.");
			return;
		}
		Hash2018 hash2018 = new Hash2018();
		try {
			hash2018.readFile(args[1]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		try {
			hash2018.writeToFile(args[2], "Hello");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} 
	}

}

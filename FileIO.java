import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
public class FileIO {
	public static void main(String[] args) {
		
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
			writer.write("Writing to a file");
			writer.write("\nHeres another line");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	try {
		BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
		System.out.print(reader.readLine());
		reader.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

}

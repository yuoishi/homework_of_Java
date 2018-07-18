package bo;

import java.io.FileWriter;
import java.io.IOException;

public class CSVFileWriter {
	private static final String FILENAME = "exmana.csv";

	public static void output(){
		try{
			FileWriter fw = new FileWriter(FILENAME);
			fw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

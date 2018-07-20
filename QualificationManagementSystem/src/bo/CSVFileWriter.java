package bo;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import dto.ExMana;

public class CSVFileWriter {
	private static final String USERNAME = ""; //あなたのPCのユーザ名を設定して下さい。
	private static final String FILENAME = "\\Users\\" + USERNAME + "\\Desktop\\exmana.csv";

	public static void output(ArrayList<ExMana> list){
		try{
			FileWriter fw = new FileWriter(FILENAME);
			for(ExMana em : list){
				fw.write(em.getDate() + ",");
				fw.write(em.getSno() + ",");
				fw.write(em.getSname() + ",");
				fw.write(em.getQname() + ",");
				fw.write(em.getSorf() + "\n");
			}
			fw.flush();
			fw.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

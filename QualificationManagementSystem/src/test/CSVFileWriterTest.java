package test;

import static bo.CSVFileWriter.*;

import dao.ExManaDAO;

public class CSVFileWriterTest {

	public static void main(String[] args) {
		output(ExManaDAO.show());
	}
}

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class HousingApp {
	
	private static CSVFile housingCsv;
	private static CSVFile studentCsv;
	private static CSVFile outputCsv;

	public static void main(String[] args)
	{
		try {
			housingCsv = CSVFile.load("housing.csv");
			studentCsv = CSVFile.load("student.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Resolver r = new Lottery();
		
		outputCsv = r.resolve(housingCsv, studentCsv);
		try {
			CSVFile.save("output.csv", outputCsv);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for (int i = 0; i < outputCsv.getLength(); i++) {
			System.out.println(outputCsv.getRow(i));
		}
		
	}

	
}

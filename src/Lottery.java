import java.util.HashMap;

public class Lottery implements Resolver {

	@Override
	public CSVFile resolve(CSVFile housingData, CSVFile studentChoices) {
		
		HashMap<String, Integer> seats = new HashMap<>();
		for (int i = 0; i < housingData.getLength(); i++) {
		  // For each row
		  HashMap<String, String> csvRow = housingData.getRow(i);
		  seats.put(csvRow.get("Dorm"), Integer.parseInt(csvRow.get("Spaces")));
		}
		CSVFile Output = CSVFile.empty(new String[] {"Student", "Dorm"});
		
		for (int i = 0; i < studentChoices.getLength(); i++) {
			HashMap<String, String> row = studentChoices.getRow(i);
			HashMap<String, String> studentEntry = new HashMap<String, String>();
			//HashMap<String, String> finalResult = new HashMap<String, String>();
			String firstChoice = row.get("First");
			String secondChoice = row.get("Second");
			int numSeats = seats.get(firstChoice);
			int numSSeats = seats.get(secondChoice);
			
			studentEntry.put("Student", row.get("Student"));
			
			
			if(numSeats > 0)
			{
				seats.put(firstChoice, numSeats - 1);
				studentEntry.put("Dorm", firstChoice);
				//Output.addRow();
			}
			else if(numSSeats > 0)
			{
				seats.put(secondChoice, numSSeats - 1);
				studentEntry.put("Dorm", secondChoice);
				
			}
			else
			{
				for (int j = 0; j < housingData.getLength(); j++) 
				{
					String getDorm = housingData.getRow(j).get("Dorm");
					
					int remainSeat = seats.get(getDorm);
					if(remainSeat > 0)
					{
						seats.put("Dorm", remainSeat - 1);
						studentEntry.put("Dorm", getDorm);
					}
					else
					{
						return null;
					}
				}
			}
			
			Output.addRow(studentEntry);
			
			
		}
		
		
		return Output;
	}

}

// Implementations of Resolver implement a strategy for allocating rooms to students fairly.
public interface Resolver {
    // Allocate rooms given student requests and available room data.
    public void roomAllocation();
    public void studentRequests();
    public void availableRooms();
    // See sample .csv files.
    CSVFile resolve(CSVFile housingData, CSVFile studentChoices);
}

class Solve implements Resolver
{

    public void roomAllocation()
    {
        
    }
}

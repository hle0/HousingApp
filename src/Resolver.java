// Implementations of Resolver implement a strategy for allocating rooms to students fairly.
public interface Resolver {
    // Allocate rooms given student requests and available room data.
    // See sample .csv files.
    CSVFile resolve(CSVFile housingData, CSVFile studentChoices);
}

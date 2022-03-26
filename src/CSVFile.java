import java.io.IOException;
import java.util.Arrays;

// A .csv file loaded into memory as a table, with header and body.
public class CSVFile {
    // The first line of the CSV file is the header.
    // It's in the same format as all the other rows, but it has the column names instead of actual values.
    private String[] header;
    // The stuff past the header.
    private String[][] body;

    public CSVFile(String[][] data) {
        // Copy the header
        this.header = data[0];
        // Copy the rest of the data
        this.body = Arrays.copyOfRange(data, 1, data.length);
    }

    // Return the entry at the row-th row of body and the column given by column.
    public String getEntry(String column, int row) {
        // TODO: implement.
        return "";
    }

    // Add a row to the CSVFile.
    public void advanceRow() {
        // TODO: implement.
    }

    // Set an entry in the last row. Meant to be used with advanceRow().
    public String setEntry(String column, String entry) {
        // TODO: implement.
        return "";
    }

    // Load a CSVFile from the given filename.
    public static CSVFile load(String filename) throws IOException {
        // TODO: implement.
        return null;
    }

    // Save a CSVFile to the given filename.
    public static void save(String filename, CSVFile csv) throws IOException {
        // TODO: implement.
    }

    // Create an empty CSVFile with the given header.
    public static CSVFile empty(String[] header) {
        // TODO: implement.
        return null;
    }
}

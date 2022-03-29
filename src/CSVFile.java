import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

// A .csv file loaded into memory as a table, with header and body.
public class CSVFile {
    // The first line of the CSV file is the header.
    // It's in the same format as all the other rows, but it has the column names instead of actual values.
    private String[] fields;
    // The stuff past the header.
    private ArrayList<HashMap<String, String>> body;

    public CSVFile(String[][] data) {
        // Copy the header
        this.fields = data[0];

        // Copy the rest of the data
        this.body = new ArrayList<>();
        // don't include the first line (int i = 1; ...)
        for (int i = 1; i < data.length; i++) {
            HashMap<String, String> row = new HashMap<>();

            for (int j = 0; j < this.fields.length; j++) {
                // key is the column name, value is the actual value
                row.put(this.fields[j], data[i][j]);
            }

            this.body.add(row);
        }
    }

    // Return the nth row of the CSV as a HashMap (this can be used to edit entries!)
    public HashMap<String, String> getRow(int row) {
        // TODO: implement
        return null;
    }

    // Add a new row to the CSV
    public void addRow(HashMap<String, String> row) {
        // TODO: implement
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

    // Create an empty CSVFile with the given headers.
    public static CSVFile empty(String[] header) {
        // TODO: implement.
        return null;
    }
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

    // Return the number of rows in the CSV file
    public int getLength()
    {
        return this.body.size();
    }

    // Return the nth row of the CSV as a HashMap (this can be used to edit entries!)
    public HashMap<String, String> getRow(int row) {
        return this.body.get(row);
    }

    // Add a new row to the CSV
    public void addRow(HashMap<String, String> row) {
        this.body.add(row);
    }

    // Load a CSVFile from the given filename.
    public static CSVFile load(String filename) throws IOException {
        String[][] data = (String[][])
            // read all the lines in the file into a String[]
            Files.readAllLines(new File(filename).toPath())
            // iterate over them
            .stream()
            // remove extra spaces on the ends of each line
            .map(s -> s.trim())
            // if the line is empty, don't count it
            .filter(s -> !s.isEmpty())
            // split the line on ",". From now on, we're iterating on a list of String[]'s
            .map(s -> s.split(","))
            // for each row, replace the row with:
            .map(ss ->
                Arrays
                    // for each column in the row:
                    .stream(ss)
                    // remove the extra spaces on each end (e.g. for parsing numbers)
                    .map(s -> s.trim())
                    // make the line String[] again
                    .toArray()
            )
            // make the data String[][] again
            .toArray();

        // call the contructor with our data:
        return new CSVFile(data);
    }

    // Save a CSVFile to the given filename.
    public static void save(String filename, CSVFile csv) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
                // print the header
                printWriter.println(String.join(",", csv.fields));

                for (HashMap<String, String> row : csv.body) {
                    for (int i = 0; i < csv.fields.length; i++) {
                        printWriter.print(row.get(csv.fields[i]));

                        if (i != csv.fields.length - 1) {
                            // Skip only the last comma
                            printWriter.print(",");
                        }
                    }

                    printWriter.println();
                }
            }
        }
    }

    // Create an empty CSVFile with the given headers.
    public static CSVFile empty(String[] header) {
        // Make a CSV with only a header
        return new CSVFile(new String[][]{header});
    }
}

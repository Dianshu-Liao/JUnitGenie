package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import java.io.IOException;
import java.io.StringWriter;
import static org.junit.Assert.assertEquals;

public class CSVFormat_printRecord_Appendable_Object_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPrintRecord() {
        CSVFormat csvFormat = CSVFormat.DEFAULT; // Using a default CSVFormat instance
        StringWriter stringWriter = new StringWriter();
        Object[] values = {"value1", "value2", "value3"};

        try {
            csvFormat.printRecord(stringWriter, values);
            String expectedOutput = "value1,value2,value3\n"; // Assuming default CSVFormat behavior
            assertEquals(expectedOutput, stringWriter.toString());
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}
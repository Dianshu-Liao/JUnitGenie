package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import java.io.IOException;
import java.io.StringWriter;
import static org.junit.Assert.assertEquals;

public class CSVFormat_println_Appendable_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPrintlnWithTrailingDelimiterAndRecordSeparator() {
        // Arrange
        CSVFormat csvFormat = CSVFormat.DEFAULT.withTrailingDelimiter(true).withRecordSeparator("\n");

        StringWriter writer = new StringWriter();
        String expectedOutput = csvFormat.getDelimiterString() + csvFormat.getRecordSeparator(); // Assuming recordSeparator is set

        // Act
        try {
            csvFormat.print(writer);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Assert
        assertEquals(expectedOutput, writer.toString());
    }

    @Test(timeout = 4000)
    public void testPrintlnWithNoRecordSeparator() {
        // Arrange
        CSVFormat csvFormat = CSVFormat.DEFAULT.withTrailingDelimiter(true).withRecordSeparator(null); // Simulating no record separator

        StringWriter writer = new StringWriter();
        String expectedOutput = csvFormat.getDelimiterString(); // Only the delimiter should be output

        // Act
        try {
            csvFormat.print(writer);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Assert
        assertEquals(expectedOutput, writer.toString());
    }


}
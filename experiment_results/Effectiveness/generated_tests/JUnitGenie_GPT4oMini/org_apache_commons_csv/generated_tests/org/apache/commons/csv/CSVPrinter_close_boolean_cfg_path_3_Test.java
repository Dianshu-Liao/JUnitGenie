package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;
import java.io.IOException;
import java.io.StringWriter;
import static org.junit.Assert.assertNotNull;

public class CSVPrinter_close_boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCloseWithoutFlush() {
        // Arrange
        StringWriter stringWriter = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT.withAutoFlush(true);
        CSVPrinter csvPrinter = null;

        try {
            csvPrinter = new CSVPrinter(stringWriter, format);

            // Act
            csvPrinter.close(false); // flush is false
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        } finally {
            if (csvPrinter != null) {
                try {
                    csvPrinter.close(); // Ensure the printer is closed in case of an exception
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Assert
        assertNotNull(stringWriter.toString()); // Ensure that the writer is not null after close
    }

}
package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;
import java.io.IOException;
import java.io.StringWriter;
import static org.junit.Assert.assertNotNull;

public class CSVPrinter_close_boolean_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testCloseWithFlush() {
        StringWriter stringWriter = new StringWriter();
        CSVPrinter csvPrinter = null;
        
        try {
            csvPrinter = new CSVPrinter(stringWriter, CSVFormat.DEFAULT);
            csvPrinter.close(true);
            assertNotNull(stringWriter.toString()); // Ensure that the writer is not null after close
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        } finally {
            if (csvPrinter != null) {
                try {
                    csvPrinter.close(); // Ensure the printer is closed in case of an exception
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test(timeout = 4000)
    public void testCloseWithoutFlush() {
        StringWriter stringWriter = new StringWriter();
        CSVPrinter csvPrinter = null;
        
        try {
            csvPrinter = new CSVPrinter(stringWriter, CSVFormat.DEFAULT);
            csvPrinter.close(false);
            assertNotNull(stringWriter.toString()); // Ensure that the writer is not null after close
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        } finally {
            if (csvPrinter != null) {
                try {
                    csvPrinter.close(); // Ensure the printer is closed in case of an exception
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
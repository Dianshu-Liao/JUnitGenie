package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;
import java.io.StringWriter;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;

public class CSVPrinter__init__Appendable_CSVFormat_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCSVPrinterInitializationWithValidInputs() {
        StringWriter writer = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT.withHeader("Header1", "Header2").withSkipHeaderRecord(false);

        try {
            CSVPrinter printer = new CSVPrinter(writer, format);
            // Ensuring that since the constructor runs without exceptions, the printer is not null.
            assertNotNull(printer);
        } catch (IOException e) {
            // Handle the exception here
            e.printStackTrace();
        }
    }

    @Test(expected = NullPointerException.class)
    public void testCSVPrinterInitializationWithNullAppendable() throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.withHeader("Header1", "Header2");

        try {
            new CSVPrinter(null, format);
        } catch (NullPointerException e) {
            // Test passed, rethrow the exception for JUnit.
            throw e;
        }
    }

    @Test(expected = NullPointerException.class)
    public void testCSVPrinterInitializationWithNullFormat() throws IOException {
        StringWriter writer = new StringWriter();

        try {
            new CSVPrinter(writer, null);
        } catch (NullPointerException e) {
            // Test passed, rethrow the exception for JUnit.
            throw e;
        }
    }

}
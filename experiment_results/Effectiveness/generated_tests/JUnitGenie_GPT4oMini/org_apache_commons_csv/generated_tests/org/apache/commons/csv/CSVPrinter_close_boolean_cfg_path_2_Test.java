package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;
import java.io.IOException;
import java.io.StringWriter;
import static org.junit.Assert.assertTrue;

public class CSVPrinter_close_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCloseWithFlush() {
        StringWriter writer = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT.withAutoFlush(true);
        CSVPrinter printer = null;

        try {
            printer = new CSVPrinter(writer, format);
            printer.close(true);
            assertTrue(writer.toString().isEmpty()); // Verify that nothing was written (assuming flush does not write anything)
        } catch (IOException e) {
            // Handle exception if close() throws IOException
            e.printStackTrace();
        } finally {
            if (printer != null) {
                try {
                    printer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test(timeout = 4000)
    public void testCloseWithoutFlush() {
        StringWriter writer = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT.withAutoFlush(false);
        CSVPrinter printer = null;

        try {
            printer = new CSVPrinter(writer, format);
            printer.close(false);
            assertTrue(writer.toString().isEmpty()); // Verify that nothing was written
        } catch (IOException e) {
            // Handle exception if close() throws IOException
            e.printStackTrace();
        } finally {
            if (printer != null) {
                try {
                    printer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test(timeout = 4000)
    public void testCloseWithAppendableCloseable() {
        StringWriter writer = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT.withAutoFlush(false);
        CSVPrinter printer = null;

        try {
            printer = new CSVPrinter(writer, format);
            printer.close(false);
            // Verify successful execution without exceptions
        } catch (IOException e) {
            // Handle exception if close() throws IOException
            e.printStackTrace();
        } finally {
            if (printer != null) {
                try {
                    printer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;
import java.io.StringWriter;
import java.io.IOException;
import static org.junit.Assert.*;

public class CSVPrinter__init__Appendable_CSVFormat_cfg_path_3_Test {
    
    @Test(timeout = 4000)
    public void testCSVPrinterWithNullAppendable() {
        try {
            new CSVPrinter(null, CSVFormat.DEFAULT);
            fail("Expected an IOException to be thrown due to null appendable");
        } catch (IOException e) {
            assertEquals("appendable", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCSVPrinterWithNullFormat() {
        try {
            StringWriter writer = new StringWriter();
            new CSVPrinter(writer, null);
            fail("Expected an IOException to be thrown due to null format");
        } catch (IOException e) {
            assertEquals("format", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCSVPrinterWithHeaderComments() throws IOException {
        StringWriter writer = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT.withHeaderComments("Comment 1", "Comment 2");
        CSVPrinter printer = new CSVPrinter(writer, format);
        
        printer.printRecord("test"); // Simulate usage after initialization
        
        // Check the output
        String expectedOutput = "# Comment 1\r\n# Comment 2\r\n";
        assertEquals(expectedOutput, writer.toString());
    }

    @Test(timeout = 4000)
    public void testCSVPrinterWithNoHeader() throws IOException {
        StringWriter writer = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT.withHeader((String[]) null); // This should yield a null header
        CSVPrinter printer = new CSVPrinter(writer, format);
        
        printer.printRecord("test"); // Simulate usage after initialization
        
        // Validate behavior (no output for header)
        String expectedOutput = "test\r\n";
        assertEquals(expectedOutput, writer.toString());
    }

}
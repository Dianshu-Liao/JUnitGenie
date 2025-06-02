package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;
import java.io.StringWriter;
import java.io.IOException;
import static org.junit.Assert.*;

public class CSVPrinter__init__Appendable_CSVFormat_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testCSVPrinter_withValidParameters() {
        StringWriter stringWriter = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT.withHeader("header1", "header2").withSkipHeaderRecord(false).withHeaderComments("Comment line 1", "Comment line 2");

        try {
            CSVPrinter printer = new CSVPrinter(stringWriter, format);
            // Validate the output of stringWriter or any other state of the printer if needed
        } catch (IOException e) {
            fail("IOException should not have occurred");
        }
    }

    @Test(timeout = 4000)
    public void testCSVPrinter_withNullAppendable() {
        CSVFormat format = CSVFormat.DEFAULT;

        try {
            new CSVPrinter(null, format);
            fail("Should have thrown NullPointerException for null appendable");
        } catch (NullPointerException expected) {
            // Expected exception
        } catch (IOException e) {
            fail("IOException should not have occurred");
        }
    }

    @Test(timeout = 4000)
    public void testCSVPrinter_withNullFormat() {
        StringWriter stringWriter = new StringWriter();

        try {
            new CSVPrinter(stringWriter, null);
            fail("Should have thrown NullPointerException for null format");
        } catch (NullPointerException expected) {
            // Expected exception
        } catch (IOException e) {
            fail("IOException should not have occurred");
        }
    }

}
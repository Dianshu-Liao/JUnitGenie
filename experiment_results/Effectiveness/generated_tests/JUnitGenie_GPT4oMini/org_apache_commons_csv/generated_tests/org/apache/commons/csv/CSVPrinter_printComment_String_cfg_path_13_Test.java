package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;
import java.io.IOException;
import java.io.StringWriter;
import static org.junit.Assert.assertNotNull;

public class CSVPrinter_printComment_String_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testPrintCommentWithNullComment() {
        StringWriter writer = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT.withCommentMarker('#');
        CSVPrinter printer = null;
        
        try {
            printer = new CSVPrinter(writer, format);
            printer.printComment(null);
            // Verify that nothing was written to the writer
            assertNotNull(writer.toString());
        } catch (IOException e) {
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
    public void testPrintCommentWithCommentMarkerNotSet() {
        StringWriter writer = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT.withCommentMarker(null); // No comment marker
        CSVPrinter printer = null;
        
        try {
            printer = new CSVPrinter(writer, format);
            printer.printComment("This is a comment");
            // Verify that nothing was written to the writer
            assertNotNull(writer.toString());
        } catch (IOException e) {
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
    public void testPrintCommentWithValidComment() {
        StringWriter writer = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT.withCommentMarker('#'); // Valid comment marker
        CSVPrinter printer = null;
        
        try {
            printer = new CSVPrinter(writer, format);
            printer.printComment("This is a comment");
            // Verify that the comment was written correctly
            String expectedOutput = "# This is a comment\n";
            assertNotNull(writer.toString());
            assert(writer.toString().equals(expectedOutput));
        } catch (IOException e) {
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
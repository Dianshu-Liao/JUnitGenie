package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;
import java.io.IOException;
import java.io.StringWriter;
import static org.junit.Assert.assertEquals;

public class CSVPrinter_printComment_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPrintComment() {
        StringWriter writer = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT.withCommentMarker(null); // setting commentMarker as null
        CSVPrinter printer = null;

        try {
            printer = new CSVPrinter(writer, format);
            printer.printComment("This is a test comment.");
            // Checking the output after processing a comment with a null comment marker
            assertEquals("", writer.toString()); // Expecting empty output, because commentMarker is null
        } catch (IOException e) {
            e.printStackTrace(); // Exception handling per rule 1
        } finally {
            if (printer != null) {
                try {
                    printer.close(); // Ensure the printer is closed
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Test when the comment marker is not null
        StringWriter writerTwo = new StringWriter();
        CSVFormat formatTwo = CSVFormat.DEFAULT.withCommentMarker('#'); // setting commentMarker
        CSVPrinter printerTwo = null;

        try {
            printerTwo = new CSVPrinter(writerTwo, formatTwo);
            printerTwo.printComment("This is a test comment with newline\nAnd more text.");
            // Asserting the formatted output
            assertEquals("# This is a test comment with newline\n# And more text.\n", writerTwo.toString());
        } catch (IOException e) {
            e.printStackTrace(); // Exception handling per rule 1
        } finally {
            if (printerTwo != null) {
                try {
                    printerTwo.close(); // Ensure the printer is closed
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
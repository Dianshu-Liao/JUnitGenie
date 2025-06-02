package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;
import java.io.IOException;
import java.io.StringWriter;
import static org.junit.Assert.assertEquals;

public class CSVPrinter_printComment_String_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testPrintComment() {
        StringWriter stringWriter = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT.withCommentMarker('#'); // Ensure comment marker is set
        CSVPrinter printer = null;

        try {
            printer = new CSVPrinter(stringWriter, format);
            
            // Call the method with a valid comment
            String comment = "This is a comment\nAnother line";
            printer.printComment(comment);
            
            // Expected output
            String expectedOutput = "# This is a comment\n# Another line\n";
            assertEquals(expectedOutput, stringWriter.toString());
        } catch (IOException e) {
            // Handle the exception as per rule 1
            e.printStackTrace();
        } finally {
            if (printer != null) {
                try {
                    printer.close(); // Ensure the printer is closed after use
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;
import java.io.IOException;
import java.io.StringWriter;
import static org.junit.Assert.assertEquals;

public class CSVPrinter_printComment_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPrintComment() {
        StringWriter writer = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT.withCommentMarker('#'); // Ensure comment marker is set
        CSVPrinter printer = null;

        try {
            printer = new CSVPrinter(writer, format);
            String comment = "This is a comment\nAnother line";
            printer.printComment(comment);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        } finally {
            if (printer != null) {
                try {
                    printer.close(); // Ensure the printer is closed
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        String expectedOutput = "# This is a comment\n# Another line\n";
        assertEquals(expectedOutput, writer.toString());
    }

}
package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;
import java.io.StringWriter;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class CSVPrinter_printComment_String_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testPrintComment() {
        StringWriter stringWriter = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT.withCommentMarker('#');
        CSVPrinter printer = null;

        try {
            printer = new CSVPrinter(stringWriter, format);
            printer.printComment("This is a comment\nNew line with CR\r\nAnother line.");
            String expectedOutput = "# This is a comment\n# New line with CR\n# Another line.\n";
            assertEquals(expectedOutput, stringWriter.toString());
        } catch (IOException e) {
            // Handle exception if any occur during the test
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
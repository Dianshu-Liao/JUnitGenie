package org.apache.commons.csv;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.StringWriter;
import java.io.IOException;

public class CSVPrinter_printComment_String_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testPrintComment_NullComment() {
        StringWriter writer = new StringWriter();
        CSVPrinter printer = null;
        
        try {
            printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
            printer.printComment(null);
        } catch (IOException e) {
            // Handle the exception if it occurs
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
        
        // Since the comment is null, we expect no output
        String output = writer.toString();
        assertEquals("", output);
    }

}
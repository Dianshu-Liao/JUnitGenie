package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testReadLineBreaks() {
        // Setup
        String testInput = "First Line\nSecond Line\r\nThird Line";
        StringReader stringReader = new StringReader(testInput);
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader, Charset.forName("UTF-8"), true);

        try {
            // Execution
            int firstChar = reader.read();
            int secondChar = reader.read();
            // Checking line number increment on LF
            assertEquals('F', (char) firstChar);
            assertEquals('i', (char) secondChar);
            // The line number should reflect the first read wasn't a line break
            assertEquals(0, reader.getLineNumber());

            // Read until the first line break
            while (firstChar != -1) {
                firstChar = reader.read();
            }

            // Now line number should be incremented
            assertEquals(2, reader.getLineNumber()); // Expecting 2 after reading through "First Line" and "Second Line"

        } catch (IOException e) {
            e.printStackTrace();
            // Handle IOException
        }
    }


}
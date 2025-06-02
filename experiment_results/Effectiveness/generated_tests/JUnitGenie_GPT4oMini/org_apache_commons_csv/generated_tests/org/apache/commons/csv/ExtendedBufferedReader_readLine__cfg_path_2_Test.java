package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_readLine__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testReadLine() {
        String input = "Hello\nWorld";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String line1 = reader.readLine();
            assertEquals("Hello", line1);

            String line2 = reader.readLine();
            assertEquals("World", line2);

            String line3 = reader.readLine();
            assertEquals(null, line3); // End of input should return null
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        }
    }

}
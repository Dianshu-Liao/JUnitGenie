package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_readLine__cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testReadLine() {
        String input = "Hello World\nThis is a test.";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String line1 = reader.readLine();
            assertEquals("Hello World", line1);

            String line2 = reader.readLine();
            assertEquals("This is a test.", line2);

            String line3 = reader.readLine();
            assertEquals(null, line3); // End of input should return null
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
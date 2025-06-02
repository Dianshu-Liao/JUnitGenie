package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.IOException;
import java.io.StringReader;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_readLine__cfg_path_26_Test {

    @Test(timeout = 4000)
    public void testReadLine_withValidInput() {
        String input = "Hello, World!";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String result = reader.readLine();
            assertEquals("Hello, World!", result);
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testReadLine_endOfFile() {
        String input = "";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String result = reader.readLine();
            assertEquals(null, result); // Expecting null at EOF
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testReadLine_withLineFeed() {
        String input = "Line 1\nLine 2";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String result = reader.readLine();
            assertEquals("Line 1", result);
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testReadLine_withCarriageReturn() {
        String input = "Line 1\rLine 2";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));

        try {
            String result = reader.readLine();
            assertEquals("Line 1", result);
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception
        }
    }

}
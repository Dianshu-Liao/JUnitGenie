package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_readLine__cfg_path_22_Test {

    @Test(timeout = 4000)
    public void testReadLine_NotCRorLF() {
        // Setup: Create a Reader that does not produce CR or LF
        String testInput = "Hello, World!";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(testInput));

        try {
            // Execution: Call the readLine method
            String result = reader.readLine();

            // Assertion: Verify the output of readLine
            assertEquals("Hello, World!", result);
        } catch (IOException e) {
            e.printStackTrace(); // Handling exception as rule1 applies
        }
    }

    @Test(timeout = 4000)
    public void testReadLine_WithCR() {
        // Setup: Create a Reader with CR character
        String testInput = "Hello, World!\rThis is a test.";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(testInput));

        try {
            // Execution: Call the readLine method
            String result = reader.readLine();

            // Assertion: Verify the output of readLine
            assertEquals("Hello, World!", result);
        } catch (IOException e) {
            e.printStackTrace(); // Handling exception as rule1 applies
        }
    }

    @Test(timeout = 4000)
    public void testReadLine_WithLF() {
        // Setup: Create a Reader with LF character
        String testInput = "Hello, World!\nThis is a test.";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(testInput));

        try {
            // Execution: Call the readLine method
            String result = reader.readLine();

            // Assertion: Verify the output of readLine
            assertEquals("Hello, World!", result);
        } catch (IOException e) {
            e.printStackTrace(); // Handling exception as rule1 applies
        }
    }

    @Test(timeout = 4000)
    public void testReadLine_EmptyInput() {
        // Setup: Create a Reader with empty input
        String testInput = "";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(testInput));

        try {
            // Execution: Call readLine method
            String result = reader.readLine();

            // Assertion: Verify that the result is null for empty input
            assertEquals(null, result);
        } catch (IOException e) {
            e.printStackTrace(); // Handling exception as rule1 applies
        }
    }

}
package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ri_parser_SimpleCharStream_readChar__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReadChar() {
        // Setup: Create a SimpleCharStream instance with a buffer
        String input = "Hello";
        SimpleCharStream charStream = new SimpleCharStream(new StringReader(input), 1, 1);

        // Set the internal state to simulate the conditions for the CFG path
        charStream.bufpos = 0; // Start at the beginning of the buffer
        charStream.inBuf = 1; // Simulate that there is one character in the buffer
        charStream.buffer = input.toCharArray(); // Fill the buffer with input characters
        charStream.maxNextCharInd = input.length(); // Set maxNextCharInd to the length of input

        try {
            // Execute: Call the readChar method
            char result = charStream.readChar();

            // Verify: Check that the result is as expected
            assertEquals('H', result); // The first character should be 'H'
        } catch (IOException e) {
            // Handle the exception as per rule 1
            e.printStackTrace();
        }
    }

}
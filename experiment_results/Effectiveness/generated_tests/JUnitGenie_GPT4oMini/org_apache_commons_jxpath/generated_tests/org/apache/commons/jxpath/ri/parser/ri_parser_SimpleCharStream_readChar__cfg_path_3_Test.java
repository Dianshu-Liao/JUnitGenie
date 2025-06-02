package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ri_parser_SimpleCharStream_readChar__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testReadChar() {
        // Setup
        String input = "Hello";
        SimpleCharStream charStream = new SimpleCharStream(new StringReader(input), 1, 1, 1);
        
        // Initialize the internal state to simulate the conditions for the CFG path
        charStream.inBuf = 1; // Set inBuf to a value greater than 0
        charStream.bufpos = -1; // Start at the beginning of the buffer
        charStream.buffer = input.toCharArray(); // Fill the buffer with input
        charStream.bufsize = input.length(); // Set the buffer size

        try {
            // Execute the method under test
            char result = charStream.readChar();
            
            // Verify the result
            assertEquals('H', result); // Expecting the first character 'H'
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}
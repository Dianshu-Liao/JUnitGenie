package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ri_parser_SimpleCharStream_readChar__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testReadChar() {
        // Setup: Create a SimpleCharStream instance with a StringReader
        String input = "Hello";
        SimpleCharStream charStream = new SimpleCharStream(new StringReader(input), 1, 1);

        // Initialize the internal state to simulate the conditions for the test
        charStream.inBuf = 1; // Set inBuf to a value greater than 0
        charStream.bufpos = -1; // Start at the beginning of the buffer
        charStream.buffer = new char[] {'H', 'e', 'l', 'l', 'o'};
        charStream.bufsize = charStream.buffer.length;

        try {
            // Execute: Call the readChar method
            char result = charStream.readChar();

            // Verify: Check that the result is as expected
            assertEquals('H', result);
        } catch (IOException e) {
            // Handle the exception as per rule 1
            e.printStackTrace();
        }
    }

}
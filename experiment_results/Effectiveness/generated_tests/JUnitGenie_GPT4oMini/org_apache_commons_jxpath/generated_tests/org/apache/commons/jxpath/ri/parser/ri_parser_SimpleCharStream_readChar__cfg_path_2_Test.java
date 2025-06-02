package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class ri_parser_SimpleCharStream_readChar__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testReadChar() {
        // Setup the input stream and the SimpleCharStream instance
        String input = "Hello, World!";
        SimpleCharStream charStream = new SimpleCharStream(new StringReader(input), 1, 1);

        // Set the necessary fields to meet the constraints
        charStream.maxNextCharInd = input.length(); // Ensure maxNextCharInd is set correctly
        charStream.buffer = input.toCharArray(); // Populate the buffer
        charStream.inBuf = input.length(); // Set inBuf to the length of the input

        try {
            // Read characters and validate the output
            for (int i = 0; i < input.length(); i++) {
                char expected = input.charAt(i);
                char actual = charStream.readChar();
                assertEquals(expected, actual);
            }
        } catch (IOException e) {
            // Handle the exception as per rule 1
            e.printStackTrace();
        }
    }

}
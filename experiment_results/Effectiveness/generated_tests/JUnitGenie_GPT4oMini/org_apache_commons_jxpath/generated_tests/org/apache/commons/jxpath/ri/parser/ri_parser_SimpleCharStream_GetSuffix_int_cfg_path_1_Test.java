package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ri_parser_SimpleCharStream_GetSuffix_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetSuffix() {
        // Setup
        char[] buffer = {'a', 'b', 'c', 'd', 'e'};
        SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("abcde"), 0, 0, 0);
        stream.bufpos = 4; // Set bufpos to the last index of the buffer
        stream.buffer = buffer; // Initialize the buffer
        stream.bufsize = buffer.length; // Set bufsize to the length of the buffer

        // Execute
        char[] result = stream.GetSuffix(3);

        // Verify
        char[] expected = {'c', 'd', 'e'};
        assertArrayEquals(expected, result);
    }

}
package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_parser_SimpleCharStream_adjustBeginLineColumn_int_int_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testAdjustBeginLineColumn() {
        // Setup
        int newLine = 2;
        int newCol = 3;
        SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("test"), 1, 1, 1);
        
        // Initialize the internal state to cover the CFG path
        stream.bufsize = 10; // Set buffer size
        stream.bufline = new int[stream.bufsize]; // Initialize bufline
        stream.bufcolumn = new int[stream.bufsize]; // Initialize bufcolumn
        stream.tokenBegin = 0; // Set tokenBegin
        stream.bufpos = 5; // Set bufpos to a value greater than tokenBegin
        stream.inBuf = 0; // Set inBuf to 0

        // Execute the method under test
        try {
            stream.adjustBeginLineColumn(newLine, newCol);
        } catch (Exception e) {
            fail("Method threw an exception: " + e.getMessage());
        }

        // Verify the results
        assertEquals(newLine, stream.bufline[stream.bufpos]);
        assertEquals(newCol, stream.bufcolumn[stream.bufpos]);
        assertEquals(newLine, stream.line);
        assertEquals(newCol, stream.column);
    }

}
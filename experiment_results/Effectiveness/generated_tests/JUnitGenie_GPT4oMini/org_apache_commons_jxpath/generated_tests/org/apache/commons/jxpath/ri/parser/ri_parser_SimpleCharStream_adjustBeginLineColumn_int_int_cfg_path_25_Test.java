package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_parser_SimpleCharStream_adjustBeginLineColumn_int_int_cfg_path_25_Test {

    @Test(timeout = 4000)
    public void testAdjustBeginLineColumn() {
        // Setup
        int newLine = 2;
        int newCol = 3;
        SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("test"), 1, 1, 1);
        
        // Initialize the internal state to cover the CFG path
        stream.bufpos = 0; // Set bufpos to a valid position
        stream.tokenBegin = 0; // Set tokenBegin to 0
        stream.bufsize = 10; // Set bufsize to a reasonable value
        stream.bufline = new int[10]; // Initialize bufline array
        stream.bufcolumn = new int[10]; // Initialize bufcolumn array
        stream.bufline[0] = 1; // Set initial line
        stream.bufcolumn[0] = 0; // Set initial column

        // Execute the method under test
        try {
            stream.adjustBeginLineColumn(newLine, newCol);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Verify the results
        assertEquals(newLine, stream.bufline[0]);
        assertEquals(newCol, stream.bufcolumn[0]);
    }

}
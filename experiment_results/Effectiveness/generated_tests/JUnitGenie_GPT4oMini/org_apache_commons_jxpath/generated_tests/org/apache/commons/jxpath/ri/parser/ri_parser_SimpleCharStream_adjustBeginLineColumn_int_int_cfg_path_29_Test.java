package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_parser_SimpleCharStream_adjustBeginLineColumn_int_int_cfg_path_29_Test {

    @Test(timeout = 4000)
    public void testAdjustBeginLineColumn() {
        // Setup
        SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("test"), 1, 1);
        stream.bufline = new int[10]; // Initialize bufline with a size
        stream.bufcolumn = new int[10]; // Initialize bufcolumn with a size
        stream.tokenBegin = 0;
        stream.bufpos = 5; // Set bufpos to a value greater than tokenBegin
        stream.inBuf = 0;

        // Pre-fill bufline and bufcolumn for testing
        for (int i = 0; i < 10; i++) {
            stream.bufline[i] = 1; // All lines initialized to 1
            stream.bufcolumn[i] = i; // Columns initialized to their index
        }

        // Execute
        int newLine = 2;
        int newCol = 3;
        try {
            stream.adjustBeginLineColumn(newLine, newCol);
        } catch (Exception e) {
            fail("Exception thrown during adjustBeginLineColumn: " + e.getMessage());
        }

        // Verify
        assertEquals(newLine, stream.bufline[stream.tokenBegin]);
        assertEquals(newCol, stream.bufcolumn[stream.tokenBegin]);
        // Additional assertions can be added to verify the state of bufline and bufcolumn
    }

}
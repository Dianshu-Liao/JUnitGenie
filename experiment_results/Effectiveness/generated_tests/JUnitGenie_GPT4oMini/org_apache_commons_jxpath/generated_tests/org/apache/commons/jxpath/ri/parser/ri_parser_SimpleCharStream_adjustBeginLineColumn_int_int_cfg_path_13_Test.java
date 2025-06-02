package org.apache.commons.jxpath.ri.parser;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import java.io.StringReader;

public class ri_parser_SimpleCharStream_adjustBeginLineColumn_int_int_cfg_path_13_Test {
    private SimpleCharStream stream;

    @Before
    public void setUp() {
        stream = new SimpleCharStream(new StringReader("Test input"), 1, 0, 1);
        // Initialize bufline and bufcolumn for testing
        stream.bufsize = 10; // Set buffer size
        stream.bufline = new int[stream.bufsize];
        stream.bufcolumn = new int[stream.bufsize];
        stream.bufpos = 0; // Start at position 0
        stream.tokenBegin = 0; // Start token
        stream.inBuf = 0; // No inBuf initially
        for (int i = 0; i < stream.bufsize; i++) {
            stream.bufline[i] = 0; // Initialize bufline
            stream.bufcolumn[i] = 0; // Initialize bufcolumn
        }
    }

    @Test(timeout = 4000)
    public void testAdjustBeginLineColumn() {
        try {
            stream.adjustBeginLineColumn(2, 5);
            assertEquals(2, stream.line);
            assertEquals(5, stream.column);
            assertArrayEquals(new int[] {2, 2, 2, 0, 0, 0, 0, 0, 0, 0}, stream.bufline);
            assertArrayEquals(new int[] {5, 6, 7, 0, 0, 0, 0, 0, 0, 0}, stream.bufcolumn);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}
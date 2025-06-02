package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_parser_SimpleCharStream_adjustBeginLineColumn_int_int_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testAdjustBeginLineColumn() {
        // Arrange
        SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("test"), 1, 0);
        stream.bufsize = 10; // Setting buffer size
        stream.bufline = new int[stream.bufsize]; // Initialize bufline array
        stream.bufcolumn = new int[stream.bufsize]; // Initialize bufcolumn array
        stream.bufpos = 0; // Setting initial buffer position
        stream.tokenBegin = 0; // Setting initial token begin
        stream.inBuf = 0; // Initialize inBuf
        // Fill bufline with some values for testing
        for (int i = 0; i < stream.bufsize; i++) {
            stream.bufline[i] = 1; // Initial line values
            stream.bufcolumn[i] = 0; // Initial column values
        }

        int newLine = 2; // New line number to be set
        int newCol = 3; // New column number to be set

        // Act
        try {
            stream.adjustBeginLineColumn(newLine, newCol);
        } catch (Exception e) {
            fail("Adjustment failed: " + e.getMessage());
        }

        // Assert
        assertEquals(newLine, stream.bufline[stream.bufpos]);
        assertEquals(newCol, stream.bufcolumn[stream.bufpos]);
    }

}
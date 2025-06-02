package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_parser_SimpleCharStream_adjustBeginLineColumn_int_int_cfg_path_31_Test {

    @Test(timeout = 4000)
    public void testAdjustBeginLineColumn() {
        // Arrange
        int newLine = 2;
        int newCol = 3;
        SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("test"), 1, 1, 1);
        
        // Initialize the protected fields for testing
        stream.bufsize = 10; // Set buffer size
        stream.bufline = new int[stream.bufsize]; // Initialize bufline
        stream.bufcolumn = new int[stream.bufsize]; // Initialize bufcolumn
        stream.tokenBegin = 0; // Set tokenBegin
        stream.bufpos = 5; // Set bufpos
        stream.inBuf = 0; // Set inBuf

        // Fill bufline and bufcolumn with test data
        for (int i = 0; i < stream.bufsize; i++) {
            stream.bufline[i] = 1; // Initial line number
            stream.bufcolumn[i] = i; // Column numbers
        }

        // Act
        try {
            stream.adjustBeginLineColumn(newLine, newCol);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert
        assertEquals(newLine, stream.bufline[stream.bufpos % stream.bufsize]);
        assertEquals(newCol, stream.bufcolumn[stream.bufpos % stream.bufsize]);
    }

}
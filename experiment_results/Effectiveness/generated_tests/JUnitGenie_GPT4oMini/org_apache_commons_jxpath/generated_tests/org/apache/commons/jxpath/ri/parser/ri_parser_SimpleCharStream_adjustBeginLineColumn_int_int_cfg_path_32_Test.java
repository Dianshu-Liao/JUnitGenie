package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_parser_SimpleCharStream_adjustBeginLineColumn_int_int_cfg_path_32_Test {

    @Test(timeout = 4000)
    public void testAdjustBeginLineColumn() {
        // Arrange
        SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("sample input"), 1, 1);
        stream.bufsize = 1024; // Setting an arbitrary buffer size
        stream.bufline = new int[stream.bufsize];
        stream.bufcolumn = new int[stream.bufsize];
        stream.bufpos = 10; // Set buffer position
        stream.tokenBegin = 5; // Setting token begin

        // Pre-fill bufline and bufcolumn
        for (int i = 0; i < 20; i++) {
            stream.bufline[i] = 1; // Initializing all lines to 1 for simplicity
            stream.bufcolumn[i] = i; // Columns set to their index
        }

        // Act
        int newLine = 2; // New line to set
        int newCol = 5;  // New column to set
        try {
            stream.adjustBeginLineColumn(newLine, newCol);
        } catch (Exception e) {
            fail("Exception thrown during adjustBeginLineColumn: " + e.getMessage());
        }

        // Assert
        assertEquals(newLine, stream.bufline[stream.tokenBegin]);
        assertEquals(newCol, stream.bufcolumn[stream.tokenBegin]);
    }

}
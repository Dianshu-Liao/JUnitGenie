package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_parser_SimpleCharStream_adjustBeginLineColumn_int_int_cfg_path_23_Test {

    @Test(timeout = 4000)
    public void testAdjustBeginLineColumn() {
        // Setup
        int bufferSize = 10;
        int[] bufline = new int[bufferSize];
        int[] bufcolumn = new int[bufferSize];
        SimpleCharStream simpleCharStream = new SimpleCharStream(new java.io.StringReader("Test"), bufferSize, 0, 0);
        
        // Initialize fields before calling adjustBeginLineColumn
        simpleCharStream.bufline = bufline;
        simpleCharStream.bufcolumn = bufcolumn;
        simpleCharStream.bufsize = bufferSize;
        simpleCharStream.bufpos = 5; // Example position
        simpleCharStream.tokenBegin = 0; // Example token begin
        simpleCharStream.inBuf = 0;

        // Set initial state of bufline and bufcolumn
        for (int i = 0; i < bufferSize; i++) {
            simpleCharStream.bufline[i] = 1; // initial line number 1
            simpleCharStream.bufcolumn[i] = i; // column numbers from 0 to buffer size
        }

        // Expected values
        int newLine = 2; // new line to be set
        int newCol = 3; // new column to be set

        // Act
        try {
            simpleCharStream.adjustBeginLineColumn(newLine, newCol);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }

        // Assert the state after adjustment
        assertEquals(newLine, simpleCharStream.bufline[simpleCharStream.bufpos % bufferSize]);
        assertEquals(newCol + 0, simpleCharStream.bufcolumn[simpleCharStream.bufpos % bufferSize]); // initial columnDiff is 0
        // Additional assertions can be added to verify other parts of the buffer state if necessary
    }

}
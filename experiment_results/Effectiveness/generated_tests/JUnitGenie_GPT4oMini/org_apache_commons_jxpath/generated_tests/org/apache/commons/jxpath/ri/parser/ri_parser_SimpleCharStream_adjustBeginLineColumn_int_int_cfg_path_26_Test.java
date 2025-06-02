package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.StringReader;

public class ri_parser_SimpleCharStream_adjustBeginLineColumn_int_int_cfg_path_26_Test {

    @Test(timeout = 4000)
    public void testAdjustBeginLineColumn() {
        // Create a StringReader to test our method
        StringReader sr = new StringReader("Some initial text");
        SimpleCharStream charStream = new SimpleCharStream(sr, 1, 0, 1);

        // Initialize the state of the necessary fields
        charStream.bufsize = 10; // Set bufsize
        charStream.bufline = new int[10]; // Initialize bufline
        charStream.bufcolumn = new int[10]; // Initialize bufcolumn
        charStream.inBuf = 0; // inBuf default value
        charStream.bufpos = 5; // Make bufpos greater than tokenBegin
        charStream.tokenBegin = 0; // Set tokenBegin

        // Set bufline and bufcolumn for testing
        charStream.bufline[0] = 1;
        charStream.bufline[1] = 1;
        charStream.bufline[2] = 1;
        charStream.bufline[3] = 1;
        charStream.bufline[4] = 1;
        charStream.bufline[5] = 1;

        charStream.bufcolumn[0] = 0;
        charStream.bufcolumn[1] = 1;
        charStream.bufcolumn[2] = 2;
        charStream.bufcolumn[3] = 3;
        charStream.bufcolumn[4] = 4;
        charStream.bufcolumn[5] = 5;

        // Execute the method with the parameters to cover the CFG path
        charStream.adjustBeginLineColumn(2, 1);

        // Assert the final state after method execution
        assertEquals(1, charStream.bufline[5]); // Confirm line number hasn't changed
        assertEquals(6, charStream.bufcolumn[5]); // Confirm column number after adjustment
        assertEquals(1, charStream.line); // Check updated line
        assertEquals(6, charStream.column); // Check updated column
    }


}
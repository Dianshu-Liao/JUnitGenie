package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_parser_SimpleCharStream_adjustBeginLineColumn_int_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testAdjustBeginLineColumn() {
        // Arrange
        java.io.StringReader reader = new java.io.StringReader("sample text");
        SimpleCharStream stream = new SimpleCharStream(reader, 1, 1, 1);
        stream.bufline = new int[10]; // Initialize bufline for testing
        stream.bufcolumn = new int[10]; // Initialize bufcolumn for testing
        stream.bufsize = 10; // Set buffer size
        stream.bufpos = 0; // Set buffer position
        stream.tokenBegin = 0; // Set token begin

        // Pre-fill to simulate existing values in the buffer
        for (int i = 0; i < 10; i++) {
            stream.bufline[i] = i; // Setting line numbers for testing
            stream.bufcolumn[i] = i * 2; // Setting column numbers for testing
        }

        int newLine = 5; // New line to set
        int newCol = 2; // New column to set

        // Act
        stream.adjustBeginLineColumn(newLine, newCol);

        // Assert
        int expectedLine = stream.bufline[stream.bufpos]; // Get the expected line after adjustment
        int expectedColumn = stream.bufcolumn[stream.bufpos]; // Get the expected column after adjustment

        assertEquals("Line should be adjusted correctly.", expectedLine, (newLine + 1));
        assertEquals("Column should be adjusted correctly.", expectedColumn, (newCol + (0 * 2))); // Adjust according to starting column logic
    }

}
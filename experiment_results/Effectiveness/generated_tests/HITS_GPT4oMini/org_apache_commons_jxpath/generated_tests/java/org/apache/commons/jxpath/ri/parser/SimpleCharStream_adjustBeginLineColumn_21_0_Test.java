package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class SimpleCharStream_adjustBeginLineColumn_21_0_Test {

    private SimpleCharStream simpleCharStream;

    private int bufferSize = 10;

    @BeforeEach
    public void setUp() {
        StringReader stringReader = new StringReader("Sample input text");
        simpleCharStream = new SimpleCharStream(stringReader, 1, 1, bufferSize);
        simpleCharStream.bufline = new int[bufferSize];
        simpleCharStream.bufcolumn = new int[bufferSize];
        simpleCharStream.tokenBegin = 0;
        simpleCharStream.bufpos = 0;
        // Initial line
        simpleCharStream.bufline[0] = 1;
        // Initial column
        simpleCharStream.bufcolumn[0] = 1;
        // No characters in buffer
        simpleCharStream.inBuf = 0;
    }

    @Test
    public void testAdjustBeginLineColumn_SingleLine() {
        // Position in the buffer
        simpleCharStream.bufpos = 5;
        // All characters on the same line
        simpleCharStream.bufline[5] = 1;
        // Column position
        simpleCharStream.bufcolumn[5] = 6;
        simpleCharStream.adjustBeginLineColumn(2, 3);
        assertEquals(2, simpleCharStream.line);
        assertEquals(3, simpleCharStream.column);
        // Check first position
        assertEquals(2, simpleCharStream.bufline[0]);
        // Check first position
        assertEquals(3, simpleCharStream.bufcolumn[0]);
    }

    @Test
    public void testAdjustBeginLineColumn_MultiLine() {
        // Position in the buffer
        simpleCharStream.bufpos = 10;
        // Initial line
        simpleCharStream.bufline[0] = 1;
        simpleCharStream.bufline[1] = 1;
        // Second line
        simpleCharStream.bufline[2] = 2;
        // Third line
        simpleCharStream.bufline[3] = 2;
        // Initial column
        simpleCharStream.bufcolumn[0] = 1;
        simpleCharStream.bufcolumn[1] = 2;
        // Second line starts
        simpleCharStream.bufcolumn[2] = 1;
        simpleCharStream.bufcolumn[3] = 2;
        simpleCharStream.adjustBeginLineColumn(3, 1);
        assertEquals(3, simpleCharStream.line);
        assertEquals(1, simpleCharStream.column);
        // Check second line
        assertEquals(3, simpleCharStream.bufline[2]);
        // Check second line
        assertEquals(1, simpleCharStream.bufcolumn[2]);
    }

    @Test
    public void testAdjustBeginLineColumn_EmptyBuffer() {
        // No characters in buffer
        simpleCharStream.bufpos = -1;
        simpleCharStream.adjustBeginLineColumn(1, 1);
        assertEquals(1, simpleCharStream.line);
        assertEquals(1, simpleCharStream.column);
    }

    @Test
    public void testAdjustBeginLineColumn_BufferWrap() {
        // Wrap around in buffer
        simpleCharStream.bufpos = 8;
        // Wrap around line
        simpleCharStream.bufline[8] = 1;
        // Wrap around column
        simpleCharStream.bufcolumn[8] = 9;
        simpleCharStream.adjustBeginLineColumn(4, 5);
        assertEquals(4, simpleCharStream.line);
        assertEquals(5, simpleCharStream.column);
        // Check wrap around line
        assertEquals(4, simpleCharStream.bufline[8]);
        // Check wrap around column
        assertEquals(5, simpleCharStream.bufcolumn[8]);
    }
}

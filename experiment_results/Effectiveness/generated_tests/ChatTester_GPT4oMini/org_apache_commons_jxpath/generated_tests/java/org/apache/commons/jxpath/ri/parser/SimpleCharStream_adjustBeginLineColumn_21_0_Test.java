package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class SimpleCharStream_adjustBeginLineColumn_21_0_Test {

    private SimpleCharStream simpleCharStream;

    @BeforeEach
    public void setUp() {
        // Initialize with a dummy Reader and buffer size
        simpleCharStream = new SimpleCharStream(new StringReader(""), 1, 1, 10);
        // Assuming a buffer size of 10 for testing
        simpleCharStream.bufline = new int[10];
        simpleCharStream.bufcolumn = new int[10];
        simpleCharStream.tokenBegin = 0;
        // Set to a position for testing
        simpleCharStream.bufpos = 5;
        simpleCharStream.inBuf = 0;
        simpleCharStream.bufsize = 10;
    }

    @Test
    public void testAdjustBeginLineColumn() throws Exception {
        // Setup initial state
        simpleCharStream.bufline[0] = 1;
        simpleCharStream.bufline[1] = 1;
        simpleCharStream.bufline[2] = 1;
        simpleCharStream.bufline[3] = 2;
        simpleCharStream.bufline[4] = 2;
        simpleCharStream.bufline[5] = 2;
        simpleCharStream.bufline[6] = 3;
        simpleCharStream.bufcolumn[0] = 0;
        simpleCharStream.bufcolumn[1] = 1;
        simpleCharStream.bufcolumn[2] = 2;
        simpleCharStream.bufcolumn[3] = 0;
        simpleCharStream.bufcolumn[4] = 1;
        simpleCharStream.bufcolumn[5] = 2;
        simpleCharStream.bufcolumn[6] = 0;
        // Invoke the focal method using reflection
        Method method = SimpleCharStream.class.getDeclaredMethod("adjustBeginLineColumn", int.class, int.class);
        method.setAccessible(true);
        // Call the method with new line and column
        method.invoke(simpleCharStream, 4, 5);
        // Verify the results
        assertEquals(4, simpleCharStream.bufline[0]);
        assertEquals(5, simpleCharStream.bufcolumn[0]);
        assertEquals(4, simpleCharStream.bufline[1]);
        assertEquals(6, simpleCharStream.bufcolumn[1]);
        assertEquals(4, simpleCharStream.bufline[2]);
        assertEquals(7, simpleCharStream.bufcolumn[2]);
        assertEquals(5, simpleCharStream.bufline[3]);
        assertEquals(5, simpleCharStream.bufcolumn[3]);
        assertEquals(5, simpleCharStream.bufline[4]);
        assertEquals(6, simpleCharStream.bufcolumn[4]);
        assertEquals(5, simpleCharStream.bufline[5]);
        assertEquals(7, simpleCharStream.bufcolumn[5]);
        assertEquals(6, simpleCharStream.bufline[6]);
        assertEquals(5, simpleCharStream.bufcolumn[6]);
    }

    @Test
    public void testAdjustBeginLineColumnWithDifferentTokenBegin() throws Exception {
        // Setup initial state with different tokenBegin
        simpleCharStream.tokenBegin = 3;
        // Set to a position for testing
        simpleCharStream.bufpos = 7;
        simpleCharStream.bufline[3] = 1;
        simpleCharStream.bufline[4] = 1;
        simpleCharStream.bufline[5] = 2;
        simpleCharStream.bufline[6] = 2;
        simpleCharStream.bufcolumn[3] = 0;
        simpleCharStream.bufcolumn[4] = 1;
        simpleCharStream.bufcolumn[5] = 0;
        simpleCharStream.bufcolumn[6] = 1;
        // Invoke the focal method using reflection
        Method method = SimpleCharStream.class.getDeclaredMethod("adjustBeginLineColumn", int.class, int.class);
        method.setAccessible(true);
        // Call the method with new line and column
        method.invoke(simpleCharStream, 3, 2);
        // Verify the results for new line and column adjustments
        assertEquals(3, simpleCharStream.bufline[3]);
        assertEquals(2, simpleCharStream.bufcolumn[3]);
        assertEquals(3, simpleCharStream.bufline[4]);
        assertEquals(3, simpleCharStream.bufcolumn[4]);
        assertEquals(4, simpleCharStream.bufline[5]);
        assertEquals(2, simpleCharStream.bufcolumn[5]);
        assertEquals(4, simpleCharStream.bufline[6]);
        assertEquals(3, simpleCharStream.bufcolumn[6]);
    }
}

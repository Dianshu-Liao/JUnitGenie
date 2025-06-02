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
        StringReader reader = new StringReader("Sample input text");
        simpleCharStream = new SimpleCharStream(reader, 1, 1, 4096);
    }

    @Test
    public void testAdjustBeginLineColumn() throws Exception {
        // Prepare the internal state
        simpleCharStream.bufline = new int[10];
        simpleCharStream.bufcolumn = new int[10];
        simpleCharStream.tokenBegin = 0;
        // Simulate position in buffer
        simpleCharStream.bufpos = 4;
        simpleCharStream.bufline[0] = 1;
        simpleCharStream.bufline[1] = 1;
        simpleCharStream.bufline[2] = 1;
        simpleCharStream.bufline[3] = 1;
        simpleCharStream.bufline[4] = 1;
        simpleCharStream.bufcolumn[0] = 1;
        simpleCharStream.bufcolumn[1] = 2;
        simpleCharStream.bufcolumn[2] = 3;
        simpleCharStream.bufcolumn[3] = 4;
        simpleCharStream.bufcolumn[4] = 5;
        // Invoke the method using reflection
        Method method = SimpleCharStream.class.getDeclaredMethod("adjustBeginLineColumn", int.class, int.class);
        method.setAccessible(true);
        // Test case 1: Adjust to new line and column
        method.invoke(simpleCharStream, 2, 5);
        assertEquals(2, simpleCharStream.bufline[0]);
        assertEquals(5, simpleCharStream.bufcolumn[0]);
        // Test case 2: Adjust with different values
        method.invoke(simpleCharStream, 3, 6);
        assertEquals(3, simpleCharStream.bufline[1]);
        assertEquals(6, simpleCharStream.bufcolumn[1]);
        // Test case 3: Check state after adjustment
        assertEquals(1, simpleCharStream.line);
        assertEquals(5, simpleCharStream.column);
    }

    @Test
    public void testAdjustBeginLineColumnWithWrapAround() throws Exception {
        // Prepare the internal state for wrap around case
        simpleCharStream.bufline = new int[10];
        simpleCharStream.bufcolumn = new int[10];
        // Simulate token begin in the buffer
        simpleCharStream.tokenBegin = 7;
        // Simulate position in buffer
        simpleCharStream.bufpos = 3;
        simpleCharStream.bufline[7] = 1;
        simpleCharStream.bufcolumn[7] = 1;
        // Invoke the method using reflection
        Method method = SimpleCharStream.class.getDeclaredMethod("adjustBeginLineColumn", int.class, int.class);
        method.setAccessible(true);
        // Adjust to new line and column
        method.invoke(simpleCharStream, 4, 8);
        // Validate the wrap around adjustment
        assertEquals(4, simpleCharStream.bufline[7]);
        assertEquals(8, simpleCharStream.bufcolumn[7]);
    }
}

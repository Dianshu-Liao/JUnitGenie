package org.apache.commons.jxpath.ri.parser;

import java.io.StringReader;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class SimpleCharStream_ExpandBuff_0_0_Test {

    private SimpleCharStream simpleCharStream;

    @BeforeEach
    void setUp() {
        simpleCharStream = new SimpleCharStream(new StringReader("test input"), 1, 1, 1024);
        // Setup necessary fields for testing ExpandBuff
        simpleCharStream.bufsize = 1024;
        simpleCharStream.tokenBegin = 0;
        simpleCharStream.bufpos = 0;
        simpleCharStream.buffer = new char[1024];
        simpleCharStream.bufline = new int[1024];
        simpleCharStream.bufcolumn = new int[1024];
        simpleCharStream.available = 1024;
    }

    @Test
    void testExpandBuffWithWrapAround() throws Exception {
        // Fill buffer with test data
        for (int i = 0; i < simpleCharStream.bufsize; i++) {
            simpleCharStream.buffer[i] = (char) ('a' + i);
            simpleCharStream.bufline[i] = i + 1;
            simpleCharStream.bufcolumn[i] = i + 1;
        }
        // Set bufpos to the last index
        simpleCharStream.bufpos = simpleCharStream.bufsize - 1;
        // Invoke the private method ExpandBuff with wrapAround = true
        Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
        method.setAccessible(true);
        method.invoke(simpleCharStream, true);
        // Assertions to verify the state after expansion
        assertNotNull(simpleCharStream.buffer);
        assertEquals(1024 + 2048, simpleCharStream.bufsize);
        assertEquals(1024, simpleCharStream.available);
        assertEquals(1024, simpleCharStream.maxNextCharInd);
        assertEquals(0, simpleCharStream.tokenBegin);
        assertEquals('a', simpleCharStream.buffer[0]);
        // Check that data is copied correctly
        assertEquals('z', simpleCharStream.buffer[25]);
    }

    @Test
    void testExpandBuffWithoutWrapAround() throws Exception {
        // Fill buffer with test data
        for (int i = 0; i < simpleCharStream.bufsize; i++) {
            simpleCharStream.buffer[i] = (char) ('a' + i);
            simpleCharStream.bufline[i] = i + 1;
            simpleCharStream.bufcolumn[i] = i + 1;
        }
        // Set bufpos to the last index
        simpleCharStream.bufpos = simpleCharStream.bufsize - 1;
        // Invoke the private method ExpandBuff with wrapAround = false
        Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
        method.setAccessible(true);
        method.invoke(simpleCharStream, false);
        // Assertions to verify the state after expansion
        assertNotNull(simpleCharStream.buffer);
        assertEquals(1024 + 2048, simpleCharStream.bufsize);
        assertEquals(1024, simpleCharStream.available);
        assertEquals(1024, simpleCharStream.maxNextCharInd);
        assertEquals(0, simpleCharStream.tokenBegin);
        assertEquals('a', simpleCharStream.buffer[0]);
        // Check that data is copied correctly
        assertEquals('z', simpleCharStream.buffer[25]);
    }
}

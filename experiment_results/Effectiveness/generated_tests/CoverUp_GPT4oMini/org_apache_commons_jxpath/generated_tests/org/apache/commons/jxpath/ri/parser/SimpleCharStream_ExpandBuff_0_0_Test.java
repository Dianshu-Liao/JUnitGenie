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
        simpleCharStream = new SimpleCharStream(new StringReader("Test input"), 1, 1, 1024);
        // Initialize the buffer and other fields as needed for testing
        simpleCharStream.bufsize = 1024;
        simpleCharStream.buffer = new char[1024];
        simpleCharStream.bufline = new int[1024];
        simpleCharStream.bufcolumn = new int[1024];
        simpleCharStream.tokenBegin = 0;
        simpleCharStream.available = 1024;
        simpleCharStream.bufpos = 0;
    }

    @Test
    void testExpandBuffWithWrapAround() throws Exception {
        // Set up the initial state
        // Simulate the token begin position
        simpleCharStream.tokenBegin = 100;
        // Simulate the buffer position
        simpleCharStream.bufpos = 200;
        // Invoke the private method ExpandBuff with wrapAround = true
        invokeExpandBuff(true);
        // Assertions to verify the state after expansion
        assertEquals(1024 + 2048, simpleCharStream.bufsize);
        assertEquals(1024 + 2048, simpleCharStream.available);
        assertEquals(0, simpleCharStream.tokenBegin);
        // Adjusted position
        assertEquals(200 + (1024 - 100), simpleCharStream.bufpos);
    }

    @Test
    void testExpandBuffWithoutWrapAround() throws Exception {
        // Set up the initial state
        // Simulate the token begin position
        simpleCharStream.tokenBegin = 100;
        // Simulate the buffer position
        simpleCharStream.bufpos = 200;
        // Invoke the private method ExpandBuff with wrapAround = false
        invokeExpandBuff(false);
        // Assertions to verify the state after expansion
        assertEquals(1024 + 2048, simpleCharStream.bufsize);
        assertEquals(1024 + 2048, simpleCharStream.available);
        assertEquals(0, simpleCharStream.tokenBegin);
        // Adjusted position
        assertEquals(200 - 100, simpleCharStream.bufpos);
    }

    private void invokeExpandBuff(boolean wrapAround) throws Exception {
        Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
        method.setAccessible(true);
        method.invoke(simpleCharStream, wrapAround);
    }
}

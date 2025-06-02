package org.apache.commons.jxpath.ri.parser;

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
        // Create a Reader (can be a StringReader for testing purposes)
        simpleCharStream = new SimpleCharStream(new java.io.StringReader(""), 2048, 1, 1);
        // Initial buffer size
        simpleCharStream.bufsize = 2048;
        simpleCharStream.buffer = new char[simpleCharStream.bufsize];
        simpleCharStream.bufline = new int[simpleCharStream.bufsize];
        simpleCharStream.bufcolumn = new int[simpleCharStream.bufsize];
        simpleCharStream.tokenBegin = 0;
        simpleCharStream.bufpos = -1;
        simpleCharStream.available = simpleCharStream.bufsize;
    }

    @Test
    void testExpandBuffWithoutWrapAround() {
        // Simulate filled buffer
        simpleCharStream.bufpos = 1000;
        simpleCharStream.ExpandBuff(false);
        assertEquals(2048 + 2048, simpleCharStream.bufsize);
        assertEquals(2048 + 2048, simpleCharStream.available);
        assertEquals(0, simpleCharStream.tokenBegin);
        assertEquals(1000 - simpleCharStream.tokenBegin, simpleCharStream.bufpos);
    }

    @Test
    void testExpandBuffWithWrapAround() {
        // Simulate filled buffer
        simpleCharStream.bufpos = 1000;
        // Set tokenBegin to a value
        simpleCharStream.tokenBegin = 500;
        simpleCharStream.ExpandBuff(true);
        assertEquals(2048 + 2048, simpleCharStream.bufsize);
        assertEquals(2048 + 2048, simpleCharStream.available);
        assertEquals(0, simpleCharStream.tokenBegin);
        assertEquals(1000 + (simpleCharStream.bufsize - simpleCharStream.tokenBegin), simpleCharStream.bufpos);
    }

    @Test
    void testExpandBuffHandlesThrowable() {
        // This test will simulate a situation where an exception is thrown
        // Set buffer to null to trigger an error
        simpleCharStream.buffer = null;
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            simpleCharStream.ExpandBuff(false);
        });
        assertNotNull(exception.getMessage());
    }
}

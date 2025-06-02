package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import java.util.*;

class ByteArrayBuilder_append_4_0_Test {

    private ByteArrayBuilder byteArrayBuilder;

    @BeforeEach
    void setUp() {
        byteArrayBuilder = new ByteArrayBuilder();
    }

    @Test
    void testAppendWhenCurrentBlockIsNotFull() {
        byteArrayBuilder.append(1);
        assertEquals(1, byteArrayBuilder.getCurrentSegment()[0]);
        assertEquals(1, byteArrayBuilder.getCurrentSegmentLength());
    }

    @Test
    void testAppendWhenCurrentBlockIsFull() throws Exception {
        // Fill current block to the edge
        for (int i = 0; i < ByteArrayBuilder.DEFAULT_BLOCK_ARRAY_SIZE; i++) {
            byteArrayBuilder.append(i);
        }
        // Now append one more to trigger allocation of a new block
        byteArrayBuilder.append(256);
        // Verify that the new block is allocated
        assertEquals(256, byteArrayBuilder.getCurrentSegment()[0]);
        assertEquals(1, byteArrayBuilder.getCurrentSegmentLength());
        // Verify that the previous block is in the past blocks
        Method getPastBlocksMethod = ByteArrayBuilder.class.getDeclaredMethod("getPastBlocks");
        getPastBlocksMethod.setAccessible(true);
        LinkedList<byte[]> pastBlocks = (LinkedList<byte[]>) getPastBlocksMethod.invoke(byteArrayBuilder);
        assertEquals(1, pastBlocks.size());
    }

    @Test
    void testAppendHandlesLargeValues() {
        // Append a large value
        byteArrayBuilder.append(255);
        assertEquals(255, byteArrayBuilder.getCurrentSegment()[0]);
    }

    @Test
    void testAppendHandlesNegativeValues() {
        // Append a negative value
        byteArrayBuilder.append(-1);
        assertEquals(-1, byteArrayBuilder.getCurrentSegment()[0]);
    }

    @Test
    void testAllocMore() throws Exception {
        // Access the private method _allocMore
        Method allocMoreMethod = ByteArrayBuilder.class.getDeclaredMethod("_allocMore");
        allocMoreMethod.setAccessible(true);
        // Fill the initial block to trigger _allocMore
        for (int i = 0; i < ByteArrayBuilder.DEFAULT_BLOCK_ARRAY_SIZE; i++) {
            byteArrayBuilder.append(i);
        }
        // Invoke _allocMore
        allocMoreMethod.invoke(byteArrayBuilder);
        // Verify that the current block is now allocated and has the correct length
        assertNotNull(byteArrayBuilder.getCurrentSegment());
        assertEquals(0, byteArrayBuilder.getCurrentSegmentLength());
    }
}

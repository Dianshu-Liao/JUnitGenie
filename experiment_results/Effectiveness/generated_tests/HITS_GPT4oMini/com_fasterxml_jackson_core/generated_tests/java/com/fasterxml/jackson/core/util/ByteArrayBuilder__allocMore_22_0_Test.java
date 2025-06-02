package com.fasterxml.jackson.core.util;

import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import java.util.*;

class ByteArrayBuilder__allocMore_22_0_Test {

    private ByteArrayBuilder byteArrayBuilder;

    @BeforeEach
    void setUp() {
        byteArrayBuilder = new ByteArrayBuilder();
    }

    @Test
    void testAllocMore() throws Exception {
        // Initial state
        LinkedList<byte[]> pastBlocks = getPastBlocks(byteArrayBuilder);
        assertEquals(0, pastBlocks.size());
        // Simulating a condition that would lead to allocation
        byte[] buffer = new byte[getInitialBlockSize()];
        setCurrBlock(byteArrayBuilder, buffer);
        setCurrBlockPtr(byteArrayBuilder, getInitialBlockSize());
        // Trigger allocation
        invokeAllocMore(byteArrayBuilder);
        // Check the state after allocation
        pastBlocks = getPastBlocks(byteArrayBuilder);
        assertEquals(1, pastBlocks.size());
        // Check the size of the first block
        assertEquals(getInitialBlockSize(), pastBlocks.get(0).length);
    }

    @Test
    void testAllocMoreMultipleAllocations() throws Exception {
        // Perform multiple allocations by simulating conditions
        for (int i = 0; i < 10; i++) {
            byte[] buffer = new byte[getInitialBlockSize()];
            setCurrBlock(byteArrayBuilder, buffer);
            setCurrBlockPtr(byteArrayBuilder, getInitialBlockSize());
            invokeAllocMore(byteArrayBuilder);
        }
        // Access past blocks
        LinkedList<byte[]> pastBlocks = getPastBlocks(byteArrayBuilder);
        // Assert the number of blocks allocated
        assertEquals(10, pastBlocks.size());
    }

    private void setCurrBlock(ByteArrayBuilder byteArrayBuilder, byte[] block) throws Exception {
        Field currBlockField = ByteArrayBuilder.class.getDeclaredField("_currBlock");
        currBlockField.setAccessible(true);
        currBlockField.set(byteArrayBuilder, block);
    }

    private void setCurrBlockPtr(ByteArrayBuilder byteArrayBuilder, int ptr) throws Exception {
        Field currBlockPtrField = ByteArrayBuilder.class.getDeclaredField("_currBlockPtr");
        currBlockPtrField.setAccessible(true);
        currBlockPtrField.set(byteArrayBuilder, ptr);
    }

    private void invokeAllocMore(ByteArrayBuilder byteArrayBuilder) throws Exception {
        Field allocMoreField = ByteArrayBuilder.class.getDeclaredField("_allocMore");
        allocMoreField.setAccessible(true);
        allocMoreField.set(byteArrayBuilder, null);
    }

    private LinkedList<byte[]> getPastBlocks(ByteArrayBuilder byteArrayBuilder) throws Exception {
        Field pastBlocksField = ByteArrayBuilder.class.getDeclaredField("_pastBlocks");
        pastBlocksField.setAccessible(true);
        return (LinkedList<byte[]>) pastBlocksField.get(byteArrayBuilder);
    }

    private int getInitialBlockSize() throws Exception {
        Field initialBlockSizeField = ByteArrayBuilder.class.getDeclaredField("INITIAL_BLOCK_SIZE");
        initialBlockSizeField.setAccessible(true);
        return (int) initialBlockSizeField.get(null);
    }
}

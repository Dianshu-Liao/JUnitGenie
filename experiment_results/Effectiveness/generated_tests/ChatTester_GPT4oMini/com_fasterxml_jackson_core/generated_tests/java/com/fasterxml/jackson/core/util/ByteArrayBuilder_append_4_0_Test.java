package com.fasterxml.jackson.core.util;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import java.util.*;

public class ByteArrayBuilder_append_4_0_Test {

    private ByteArrayBuilder byteArrayBuilder;

    @BeforeEach
    public void setUp() {
        byteArrayBuilder = new ByteArrayBuilder();
        // Initialize _currBlock with a size of INITIAL_BLOCK_SIZE
        invokePrivateConstructor(byteArrayBuilder, 500);
    }

    @Test
    public void testAppendWithinBlockSize() {
        byteArrayBuilder.append(1);
        byteArrayBuilder.append(2);
        byteArrayBuilder.append(3);
        // Verify that the first three bytes are correctly appended
        assertArrayEquals(new byte[] { 1, 2, 3 }, getCurrentBlock(byteArrayBuilder));
    }

    @Test
    public void testAppendExceedingBlockSize() {
        // Fill the current block to its limit
        for (int i = 0; i < 500; i++) {
            byteArrayBuilder.append(i);
        }
        // Now append one more byte to trigger the allocation of a new block
        byteArrayBuilder.append(500);
        // Verify that the first block is filled and a new block is allocated
        assertArrayEquals(new byte[500], getCurrentBlock(byteArrayBuilder));
        assertEquals(1, getPastBlocksCount(byteArrayBuilder));
    }

    @Test
    public void testAppendNegativeValue() {
        byteArrayBuilder.append(-1);
        assertArrayEquals(new byte[] { -1 }, getCurrentBlock(byteArrayBuilder));
    }

    @Test
    public void testAppendLargeValue() {
        // 256 should be cast to byte, resulting in 0
        byteArrayBuilder.append(256);
        assertArrayEquals(new byte[] { 0 }, getCurrentBlock(byteArrayBuilder));
    }

    @Test
    public void testAppendEdgeCase() {
        // Append the maximum byte value
        byteArrayBuilder.append(127);
        assertArrayEquals(new byte[] { 127 }, getCurrentBlock(byteArrayBuilder));
        // Append the minimum byte value
        byteArrayBuilder.append(-128);
        assertArrayEquals(new byte[] { 127, -128 }, getCurrentBlock(byteArrayBuilder));
    }

    // Helper methods using reflection
    private void invokePrivateConstructor(ByteArrayBuilder builder, int size) {
        try {
            Method method = ByteArrayBuilder.class.getDeclaredMethod("append", int.class);
            method.setAccessible(true);
            method.invoke(builder, size);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] getCurrentBlock(ByteArrayBuilder builder) {
        try {
            Method method = ByteArrayBuilder.class.getDeclaredMethod("getCurrentSegment");
            method.setAccessible(true);
            return (byte[]) method.invoke(builder);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private int getPastBlocksCount(ByteArrayBuilder builder) {
        try {
            Method method = ByteArrayBuilder.class.getDeclaredMethod("_pastBlocks");
            method.setAccessible(true);
            LinkedList<byte[]> pastBlocks = (LinkedList<byte[]>) method.invoke(builder);
            return pastBlocks.size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}

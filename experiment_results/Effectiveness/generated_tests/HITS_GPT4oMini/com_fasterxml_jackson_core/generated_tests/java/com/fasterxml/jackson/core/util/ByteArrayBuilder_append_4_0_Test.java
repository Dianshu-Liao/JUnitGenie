package com.fasterxml.jackson.core.util;

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
    }

    @Test
    public void testAppendSingleByte() {
        // ASCII for 'A'
        byteArrayBuilder.append(65);
        assertArrayEquals(new byte[] { 65 }, byteArrayBuilder.getCurrentSegment());
    }

    @Test
    public void testAppendMultipleBytes() {
        // 'A'
        byteArrayBuilder.append(65);
        // 'B'
        byteArrayBuilder.append(66);
        // 'C'
        byteArrayBuilder.append(67);
        assertArrayEquals(new byte[] { 65, 66, 67 }, byteArrayBuilder.getCurrentSegment());
    }

    @Test
    public void testAppendExceedCurrentBlock() {
        // Initialize with a small block size for testing
        byteArrayBuilder = new ByteArrayBuilder(2);
        // 'A'
        byteArrayBuilder.append(65);
        // 'B'
        byteArrayBuilder.append(66);
        // 'C' - should trigger allocation of new block
        byteArrayBuilder.append(67);
        assertArrayEquals(new byte[] { 65, 66 }, byteArrayBuilder.getCurrentSegment());
        // This should be the second block
        byte[] pastBlock = byteArrayBuilder.getCurrentSegment();
        assertArrayEquals(new byte[] { 67 }, pastBlock);
    }

    @Test
    public void testAppendBytesUntilMaxBlockSize() {
        // Small initial size
        byteArrayBuilder = new ByteArrayBuilder(5);
        for (int i = 0; i < 5; i++) {
            byteArrayBuilder.append(i);
        }
        assertArrayEquals(new byte[] { 0, 1, 2, 3, 4 }, byteArrayBuilder.getCurrentSegment());
        // Append more bytes to trigger allocation of a new block
        byteArrayBuilder.append(5);
        byte[] currentSegment = byteArrayBuilder.getCurrentSegment();
        assertArrayEquals(new byte[] { 0, 1, 2, 3, 4 }, currentSegment);
    }

    @Test
    public void testAppendNegativeByte() {
        // This should be treated as 255
        byteArrayBuilder.append(-1);
        assertArrayEquals(new byte[] { -1 }, byteArrayBuilder.getCurrentSegment());
    }

    @Test
    public void testAppendLargeValues() {
        // This should be treated as 0
        byteArrayBuilder.append(256);
        assertArrayEquals(new byte[] { 0 }, byteArrayBuilder.getCurrentSegment());
    }

    @Test
    public void testAppendMultipleTimesExceedingCapacity() {
        // Start with a very small size
        byteArrayBuilder = new ByteArrayBuilder(1);
        for (int i = 0; i < 1000; i++) {
            byteArrayBuilder.append(i);
        }
        assertArrayEquals(new byte[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, byteArrayBuilder.getCurrentSegment());
    }
}

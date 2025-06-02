package org.apache.commons.compress.utils;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteUtils_fromLittleEndian_1_0_Test {

    @Test
    public void testFromLittleEndian_EmptyArray() {
        byte[] input = ByteUtils.EMPTY_BYTE_ARRAY;
        long result = ByteUtils.fromLittleEndian(input);
        assertEquals(0, result, "Expected result for an empty array should be 0.");
    }

    @Test
    public void testFromLittleEndian_SingleByte() {
        byte[] input = { 1 };
        long result = ByteUtils.fromLittleEndian(input);
        assertEquals(1, result, "Expected result for single byte [1] should be 1.");
    }

    @Test
    public void testFromLittleEndian_TwoBytes() {
        byte[] input = { 1, 2 };
        long result = ByteUtils.fromLittleEndian(input);
        assertEquals(513, result, "Expected result for bytes [1, 2] should be 513.");
    }

    @Test
    public void testFromLittleEndian_MultipleBytes() {
        byte[] input = { 1, 2, 3, 4 };
        long result = ByteUtils.fromLittleEndian(input);
        assertEquals(67305985, result, "Expected result for bytes [1, 2, 3, 4] should be 67305985.");
    }

    @Test
    public void testFromLittleEndian_NegativeByteValues() {
        byte[] input = { -1, -2, -3, -4 };
        long result = ByteUtils.fromLittleEndian(input);
        assertEquals(4294967291L, result, "Expected result for bytes [-1, -2, -3, -4] should be 4294967291.");
    }

    @Test
    public void testFromLittleEndian_LargeArray() {
        byte[] input = { 10, 20, 30, 40, 50, 60, 70, 80 };
        long result = ByteUtils.fromLittleEndian(input);
        assertEquals(1000000000, result, "Expected result for large array should be 1000000000.");
    }

    @Test
    public void testFromLittleEndian_WithOffset() {
        byte[] input = { 0, 1, 2, 3, 4 };
        // Should consider bytes [1, 2, 3]
        long result = ByteUtils.fromLittleEndian(input, 1, 3);
        assertEquals(66051, result, "Expected result for bytes [1, 2, 3] should be 66051.");
    }

    @Test
    public void testFromLittleEndian_InvalidLength() {
        byte[] input = { 1, 2, 3 };
        // This test assumes that checkReadLength will throw an exception for invalid length
        // Here we assume a length greater than input size
        Exception exception = null;
        try {
            ByteUtils.fromLittleEndian(input, 0, 5);
        } catch (Exception e) {
            exception = e;
        }
        assertEquals("Index 3 out of bounds for length 3", exception.getMessage());
    }
}

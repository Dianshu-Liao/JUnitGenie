package org.apache.commons.compress.utils;

import java.io.DataInput;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataOutput;
import java.io.InputStream;
import java.io.OutputStream;

class ByteUtils_fromLittleEndian_4_0_Test {

    private DataInput dataInput;

    @BeforeEach
    void setUp() {
        // Setting up a DataInput stream for testing
    }

    @Test
    void testFromLittleEndian_ValidInput() throws IOException {
        // represents 0x04030201 in little-endian
        byte[] inputBytes = { 0x01, 0x02, 0x03, 0x04 };
        dataInput = new DataInputStream(new ByteArrayInputStream(inputBytes));
        long result = ByteUtils.fromLittleEndian(dataInput, 4);
        assertEquals(0x04030201, result);
    }

    @Test
    void testFromLittleEndian_EmptyInput() throws IOException {
        // empty input
        byte[] inputBytes = {};
        dataInput = new DataInputStream(new ByteArrayInputStream(inputBytes));
        // should return 0 for length 0
        long result = ByteUtils.fromLittleEndian(dataInput, 0);
        assertEquals(0, result);
    }

    @Test
    void testFromLittleEndian_SingleByteInput() throws IOException {
        // represents 0x05
        byte[] inputBytes = { 0x05 };
        dataInput = new DataInputStream(new ByteArrayInputStream(inputBytes));
        long result = ByteUtils.fromLittleEndian(dataInput, 1);
        assertEquals(0x05, result);
    }

    @Test
    void testFromLittleEndian_MultipleBytesInput() throws IOException {
        // represents 0x05040302 in little-endian
        byte[] inputBytes = { 0x01, 0x02, 0x03, 0x04, 0x05 };
        dataInput = new DataInputStream(new ByteArrayInputStream(inputBytes));
        long result = ByteUtils.fromLittleEndian(dataInput, 4);
        assertEquals(0x05040302, result);
    }

    @Test
    void testFromLittleEndian_InvalidLength() {
        // only 2 bytes available
        byte[] inputBytes = { 0x01, 0x02 };
        dataInput = new DataInputStream(new ByteArrayInputStream(inputBytes));
        // Assuming checkReadLength throws an IOException for invalid length
        assertThrows(IOException.class, () -> ByteUtils.fromLittleEndian(dataInput, 4));
    }

    @Test
    void testFromLittleEndian_NegativeLength() {
        // only 2 bytes available
        byte[] inputBytes = { 0x01, 0x02 };
        dataInput = new DataInputStream(new ByteArrayInputStream(inputBytes));
        // Assuming checkReadLength throws an IOException for negative length
        assertThrows(IOException.class, () -> ByteUtils.fromLittleEndian(dataInput, -1));
    }
}

package org.apache.commons.compress.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InputStream;
import java.io.OutputStream;

class ByteUtils_fromLittleEndian_5_1_Test {

    @Test
    void testFromLittleEndian_ValidInput() throws IOException {
        byte[] input = { 0x01, 0x02, 0x03, 0x04 };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        long result = ByteUtils.fromLittleEndian(inputStream, 4);
        assertEquals(0x04030201, result);
    }

    @Test
    void testFromLittleEndian_PrematureEndOfData() {
        byte[] input = { 0x01, 0x02 };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        assertThrows(IOException.class, () -> {
            ByteUtils.fromLittleEndian(inputStream, 4);
        });
    }

    @Test
    void testFromLittleEndian_TooManyBytes() {
        byte[] input = { 0x01, 0x02, 0x03, 0x04 };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        assertThrows(IllegalArgumentException.class, () -> {
            // More than 8 bytes
            ByteUtils.fromLittleEndian(inputStream, 9);
        });
    }

    @Test
    void testFromLittleEndian_ZeroLength() throws IOException {
        byte[] input = {};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        long result = ByteUtils.fromLittleEndian(inputStream, 0);
        assertEquals(0, result);
    }

    @Test
    void testFromLittleEndian_OneByte() throws IOException {
        byte[] input = { 0x01 };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        long result = ByteUtils.fromLittleEndian(inputStream, 1);
        assertEquals(0x01, result);
    }
}

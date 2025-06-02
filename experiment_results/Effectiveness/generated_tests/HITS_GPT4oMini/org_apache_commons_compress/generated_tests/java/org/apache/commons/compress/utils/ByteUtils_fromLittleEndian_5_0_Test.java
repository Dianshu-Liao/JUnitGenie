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

public class ByteUtils_fromLittleEndian_5_0_Test {

    @Test
    public void testFromLittleEndian_OneByte() throws IOException {
        byte[] input = { 0x01 };
        ByteArrayInputStream in = new ByteArrayInputStream(input);
        long result = ByteUtils.fromLittleEndian(in, 1);
        assertEquals(1L, result);
    }

    @Test
    public void testFromLittleEndian_TwoBytes() throws IOException {
        byte[] input = { 0x01, 0x02 };
        ByteArrayInputStream in = new ByteArrayInputStream(input);
        long result = ByteUtils.fromLittleEndian(in, 2);
        // 0x0201 is 0x01 in the first byte and 0x02 in the second byte
        assertEquals(0x0201L, result);
    }

    @Test
    public void testFromLittleEndian_ThreeBytes() throws IOException {
        byte[] input = { 0x01, 0x02, 0x03 };
        ByteArrayInputStream in = new ByteArrayInputStream(input);
        long result = ByteUtils.fromLittleEndian(in, 3);
        // 0x030201 is 0x01, 0x02, 0x03 in little-endian
        assertEquals(0x030201L, result);
    }

    @Test
    public void testFromLittleEndian_FourBytes() throws IOException {
        byte[] input = { 0x01, 0x02, 0x03, 0x04 };
        ByteArrayInputStream in = new ByteArrayInputStream(input);
        long result = ByteUtils.fromLittleEndian(in, 4);
        // 0x04030201 is 0x01, 0x02, 0x03, 0x04 in little-endian
        assertEquals(0x04030201L, result);
    }

    @Test
    public void testFromLittleEndian_FiveBytes() throws IOException {
        byte[] input = { 0x01, 0x02, 0x03, 0x04, 0x05 };
        ByteArrayInputStream in = new ByteArrayInputStream(input);
        long result = ByteUtils.fromLittleEndian(in, 5);
        // 0x0504030201 is 0x01, 0x02, 0x03, 0x04, 0x05 in little-endian
        assertEquals(0x0504030201L, result);
    }

    @Test
    public void testFromLittleEndian_SixBytes() throws IOException {
        byte[] input = { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06 };
        ByteArrayInputStream in = new ByteArrayInputStream(input);
        long result = ByteUtils.fromLittleEndian(in, 6);
        // 0x060504030201 is 0x01, 0x02, 0x03, 0x04, 0x05, 0x06 in little-endian
        assertEquals(0x060504030201L, result);
    }

    @Test
    public void testFromLittleEndian_SevenBytes() throws IOException {
        byte[] input = { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07 };
        ByteArrayInputStream in = new ByteArrayInputStream(input);
        long result = ByteUtils.fromLittleEndian(in, 7);
        // 0x07060504030201 is 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07 in little-endian
        assertEquals(0x07060504030201L, result);
    }
}

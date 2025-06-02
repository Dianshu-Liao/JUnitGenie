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
        assertEquals(0L, result);
    }

    @Test
    public void testFromLittleEndian_SingleByte() {
        byte[] input = new byte[] { 0x01 };
        long result = ByteUtils.fromLittleEndian(input);
        assertEquals(1L, result);
    }

    @Test
    public void testFromLittleEndian_TwoBytes() {
        // 0x0102 in little-endian
        byte[] input = new byte[] { 0x02, 0x01 };
        long result = ByteUtils.fromLittleEndian(input);
        assertEquals(258L, result);
    }

    @Test
    public void testFromLittleEndian_FourBytes() {
        // 0x01020304 in little-endian
        byte[] input = new byte[] { 0x04, 0x03, 0x02, 0x01 };
        long result = ByteUtils.fromLittleEndian(input);
        assertEquals(16909060L, result);
    }

    @Test
    public void testFromLittleEndian_EightBytes() {
        // 0x0102030405060708 in little-endian
        byte[] input = new byte[] { 0x08, 0x07, 0x06, 0x05, 0x04, 0x03, 0x02, 0x01 };
        long result = ByteUtils.fromLittleEndian(input);
        assertEquals(72623859790382856L, result);
    }

    @Test
    public void testFromLittleEndian_NegativeValue() {
        // -1 in little-endian
        byte[] input = new byte[] { (byte) 0xFF, (byte) 0xFF };
        long result = ByteUtils.fromLittleEndian(input);
        assertEquals(-1L, result);
    }

    @Test
    public void testFromLittleEndian_LargeValue() {
        // 0x0100000000000000 in little-endian
        byte[] input = new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01 };
        long result = ByteUtils.fromLittleEndian(input);
        assertEquals(72057594037927936L, result);
    }
}

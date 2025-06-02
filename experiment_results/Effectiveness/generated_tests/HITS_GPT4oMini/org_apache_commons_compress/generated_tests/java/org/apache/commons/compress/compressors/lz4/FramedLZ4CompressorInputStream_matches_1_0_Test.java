package org.apache.commons.compress.compressors.lz4;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.CheckedInputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;

public class FramedLZ4CompressorInputStream_matches_1_0_Test {

    @Test
    public void testMatches_WithValidSignatureAndExactLength() {
        byte[] validSignature = { 4, 0x22, 0x4d, 0x18 };
        int length = validSignature.length;
        assertTrue(FramedLZ4CompressorInputStream.matches(validSignature, length));
    }

    @Test
    public void testMatches_WithValidSignatureAndLongerArray() {
        byte[] validSignature = { 4, 0x22, 0x4d, 0x18, 0x00, 0x01 };
        int length = validSignature.length;
        assertTrue(FramedLZ4CompressorInputStream.matches(validSignature, length));
    }

    @Test
    public void testMatches_WithValidSignatureAndShorterArray() {
        byte[] validSignature = { 4, 0x22, 0x4d };
        int length = validSignature.length;
        assertFalse(FramedLZ4CompressorInputStream.matches(validSignature, length));
    }

    @Test
    public void testMatches_WithInvalidSignature() {
        byte[] invalidSignature = { 0x00, 0x00, 0x00, 0x00 };
        int length = invalidSignature.length;
        assertFalse(FramedLZ4CompressorInputStream.matches(invalidSignature, length));
    }

    @Test
    public void testMatches_WithEmptyArray() {
        byte[] emptySignature = {};
        int length = emptySignature.length;
        assertFalse(FramedLZ4CompressorInputStream.matches(emptySignature, length));
    }

    @Test
    public void testMatches_WithLengthLessThanSignature() {
        byte[] shortSignature = { 4, 0x22 };
        int length = shortSignature.length;
        assertFalse(FramedLZ4CompressorInputStream.matches(shortSignature, length));
    }
}

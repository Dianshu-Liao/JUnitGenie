package org.apache.commons.compress.compressors.lz4;

import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream;
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

class FramedLZ4CompressorInputStream_matches_1_0_Test {

    @Test
    void testMatches_withValidSignature() {
        byte[] validSignature = { 4, 0x22, 0x4d, 0x18 };
        assertTrue(FramedLZ4CompressorInputStream.matches(validSignature, validSignature.length));
    }

    @Test
    void testMatches_withShorterSignature() {
        byte[] shorterSignature = { 4, 0x22 };
        assertFalse(FramedLZ4CompressorInputStream.matches(shorterSignature, shorterSignature.length));
    }

    @Test
    void testMatches_withInvalidSignature() {
        byte[] invalidSignature = { 1, 2, 3, 4 };
        assertFalse(FramedLZ4CompressorInputStream.matches(invalidSignature, invalidSignature.length));
    }

    @Test
    void testMatches_withExactLength() {
        // Extra byte
        byte[] exactLengthSignature = { 4, 0x22, 0x4d, 0x18, 0x00 };
        assertTrue(FramedLZ4CompressorInputStream.matches(exactLengthSignature, 4));
    }

    @Test
    void testMatches_withNullSignature() {
        assertFalse(FramedLZ4CompressorInputStream.matches(null, 0));
    }

    @Test
    void testMatches_withLengthLessThanSignature() {
        byte[] signature = { 4, 0x22, 0x4d };
        assertFalse(FramedLZ4CompressorInputStream.matches(signature, 3));
    }
}

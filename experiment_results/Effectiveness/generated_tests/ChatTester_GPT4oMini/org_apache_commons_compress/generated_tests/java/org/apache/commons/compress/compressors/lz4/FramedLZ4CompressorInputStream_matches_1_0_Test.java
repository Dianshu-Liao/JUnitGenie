package org.apache.commons.compress.compressors.lz4;

import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CheckedInputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;

public class FramedLZ4CompressorInputStream_matches_1_0_Test {

    @Test
    public void testMatches_WithShortSignature_ReturnsFalse() {
        // Shorter than LZ4_SIGNATURE
        byte[] shortSignature = { 4, 0x22 };
        int length = shortSignature.length;
        assertFalse(FramedLZ4CompressorInputStream.matches(shortSignature, length));
    }

    @Test
    public void testMatches_WithExactSignature_ReturnsTrue() {
        // Exact match
        byte[] exactSignature = { 4, 0x22, 0x4d, 0x18 };
        int length = exactSignature.length;
        assertTrue(FramedLZ4CompressorInputStream.matches(exactSignature, length));
    }

    @Test
    public void testMatches_WithLongSignature_ReturnsTrue() {
        // Longer than LZ4_SIGNATURE
        byte[] longSignature = { 4, 0x22, 0x4d, 0x18, 0x01, 0x02 };
        int length = longSignature.length;
        assertTrue(FramedLZ4CompressorInputStream.matches(longSignature, length));
    }

    @Test
    public void testMatches_WithDifferentSignature_ReturnsFalse() {
        // Different from LZ4_SIGNATURE
        byte[] differentSignature = { 0x01, 0x02, 0x03, 0x04 };
        int length = differentSignature.length;
        assertFalse(FramedLZ4CompressorInputStream.matches(differentSignature, length));
    }

    @Test
    public void testMatches_WithEmptySignature_ReturnsFalse() {
        // Empty signature
        byte[] emptySignature = {};
        int length = emptySignature.length;
        assertFalse(FramedLZ4CompressorInputStream.matches(emptySignature, length));
    }

    @Test
    public void testMatches_WithSignatureExactlyEqualToLength_ReturnsTrue() {
        // Exact match of length
        byte[] exactMatch = { 4, 0x22, 0x4d, 0x18 };
        int length = exactMatch.length;
        assertTrue(FramedLZ4CompressorInputStream.matches(exactMatch, length));
    }

    @Test
    public void testMatches_WithSignatureLongerThanExpected_ReturnsTrue() {
        // Longer than expected but matches
        byte[] longMatch = { 4, 0x22, 0x4d, 0x18, 0x00, 0x00 };
        int length = longMatch.length;
        assertTrue(FramedLZ4CompressorInputStream.matches(longMatch, length));
    }

    @Test
    public void testMatches_WithSignatureShorterThanExpected_ReturnsFalse() {
        // Shorter than expected
        byte[] shortMatch = { 4, 0x22, 0x4d };
        int length = shortMatch.length;
        assertFalse(FramedLZ4CompressorInputStream.matches(shortMatch, length));
    }
}

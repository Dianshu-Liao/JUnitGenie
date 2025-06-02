package org.apache.commons.compress.compressors.lzma;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.compress.utils.OsgiUtils;

class LZMAUtils_matches_9_0_Test {

    @Test
    void testMatches_WithShortSignature_ReturnsFalse() {
        // Shorter than HEADER_MAGIC
        byte[] shortSignature = { (byte) 0x5D };
        assertFalse(LZMAUtils.matches(shortSignature, shortSignature.length));
    }

    @Test
    void testMatches_WithNonMatchingSignature_ReturnsFalse() {
        // Last byte differs
        byte[] nonMatchingSignature = { (byte) 0x5D, 0, 1 };
        assertFalse(LZMAUtils.matches(nonMatchingSignature, nonMatchingSignature.length));
    }

    @Test
    void testMatches_WithMatchingSignature_ReturnsTrue() {
        // Matches HEADER_MAGIC
        byte[] matchingSignature = { (byte) 0x5D, 0, 0 };
        assertTrue(LZMAUtils.matches(matchingSignature, matchingSignature.length));
    }

    @Test
    void testMatches_WithExactLengthSignature_ReturnsTrue() {
        // Matches exactly
        byte[] exactLengthSignature = { (byte) 0x5D, 0, 0 };
        assertTrue(LZMAUtils.matches(exactLengthSignature, exactLengthSignature.length));
    }

    @Test
    void testMatches_WithLongerSignature_ReturnsTrue() {
        // Longer but matches
        byte[] longerSignature = { (byte) 0x5D, 0, 0, 1, 2, 3 };
        assertTrue(LZMAUtils.matches(longerSignature, longerSignature.length));
    }

    @Test
    void testMatches_WithDifferentLength_ReturnsFalse() {
        // Extra byte
        byte[] differentLengthSignature = { (byte) 0x5D, 0, 0, 0 };
        assertFalse(LZMAUtils.matches(differentLengthSignature, differentLengthSignature.length));
    }
}

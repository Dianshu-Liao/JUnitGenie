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

public class LZMAUtils_matches_9_0_Test {

    @Test
    public void testMatches_WithValidSignature_ReturnsTrue() {
        byte[] validSignature = { (byte) 0x5D, 0, 0 };
        int length = validSignature.length;
        assertTrue(LZMAUtils.matches(validSignature, length), "Expected true for valid LZMA signature.");
    }

    @Test
    public void testMatches_WithInvalidSignature_ReturnsFalse() {
        byte[] invalidSignature = { 0, 0, 0 };
        int length = invalidSignature.length;
        assertFalse(LZMAUtils.matches(invalidSignature, length), "Expected false for invalid LZMA signature.");
    }

    @Test
    public void testMatches_WithSignatureShorterThanHeader_ReturnsFalse() {
        byte[] shortSignature = { (byte) 0x5D };
        int length = shortSignature.length;
        assertFalse(LZMAUtils.matches(shortSignature, length), "Expected false for signature shorter than header magic.");
    }

    @Test
    public void testMatches_WithSignatureExactlyHeaderLength_ReturnsTrue() {
        byte[] exactLengthSignature = { (byte) 0x5D, 0, 0 };
        int length = exactLengthSignature.length;
        assertTrue(LZMAUtils.matches(exactLengthSignature, length), "Expected true for signature exactly matching header length.");
    }

    @Test
    public void testMatches_WithSignatureLongerThanHeader_ReturnsTrue() {
        byte[] longSignature = { (byte) 0x5D, 0, 0, 1, 2, 3 };
        int length = longSignature.length;
        assertTrue(LZMAUtils.matches(longSignature, length), "Expected true for signature longer than header magic.");
    }

    @Test
    public void testMatches_WithNullSignature_ReturnsFalse() {
        byte[] nullSignature = null;
        int length = 0;
        assertFalse(LZMAUtils.matches(nullSignature, length), "Expected false for null signature.");
    }

    @Test
    public void testMatches_WithNegativeLength_ReturnsFalse() {
        byte[] validSignature = { (byte) 0x5D, 0, 0 };
        int length = -1;
        assertFalse(LZMAUtils.matches(validSignature, length), "Expected false for negative length.");
    }
}

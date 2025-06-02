package org.apache.commons.compress.compressors.lz4;
import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class compressors_lz4_FramedLZ4CompressorInputStream_matches_byte_____int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMatchesWithValidSignature() {
        byte[] validSignature = { 4, 0x22, 0x4d, 0x18 };
        int length = validSignature.length;
        boolean result = FramedLZ4CompressorInputStream.matches(validSignature, length);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testMatchesWithInvalidSignature() {
        byte[] invalidSignature = { 1, 0x22, 0x4d, 0x18 };
        int length = invalidSignature.length;
        boolean result = FramedLZ4CompressorInputStream.matches(invalidSignature, length);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testMatchesWithShorterLength() {
        byte[] shortSignature = { 4, 0x22 };
        int length = shortSignature.length;
        boolean result = FramedLZ4CompressorInputStream.matches(shortSignature, length);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testMatchesWithLongerSignature() {
        byte[] longSignature = { 4, 0x22, 0x4d, 0x18, 0x00, 0x00 };
        int length = longSignature.length;
        boolean result = FramedLZ4CompressorInputStream.matches(longSignature, length);
        assertTrue(result);
    }

}
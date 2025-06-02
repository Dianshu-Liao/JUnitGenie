package org.apache.commons.compress.compressors.lz4;
import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class compressors_lz4_FramedLZ4CompressorInputStream_matches_byte_____int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testMatchesWithValidSignature() {
        byte[] validSignature = { 4, 0x22, 0x4d, 0x18 }; // This matches LZ4_SIGNATURE
        int length = validSignature.length;
        boolean result = FramedLZ4CompressorInputStream.matches(validSignature, length);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testMatchesWithShorterSignature() {
        byte[] shortSignature = { 4, 0x22 }; // This is shorter than LZ4_SIGNATURE
        int length = shortSignature.length;
        boolean result = FramedLZ4CompressorInputStream.matches(shortSignature, length);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testMatchesWithLongerSignature() {
        byte[] longSignature = { 4, 0x22, 0x4d, 0x18, 0x00 }; // This is longer than LZ4_SIGNATURE
        int length = longSignature.length;
        boolean result = FramedLZ4CompressorInputStream.matches(longSignature, length);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testMatchesWithDifferentSignature() {
        byte[] differentSignature = { 1, 2, 3, 4 }; // This does not match LZ4_SIGNATURE
        int length = differentSignature.length;
        boolean result = FramedLZ4CompressorInputStream.matches(differentSignature, length);
        assertFalse(result);
    }

}
package org.apache.commons.compress.compressors.lzma;
import org.apache.commons.compress.compressors.lzma.LZMAUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class compressors_lzma_LZMAUtils_matches_byte_____int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMatchesWithValidSignature() {
        byte[] validSignature = { (byte) 0x5D, 0, 0 };
        int length = validSignature.length;
        boolean result = LZMAUtils.matches(validSignature, length);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testMatchesWithInvalidSignature() {
        byte[] invalidSignature = { (byte) 0x5D, 0, 1 }; // Change last byte to make it invalid
        int length = invalidSignature.length;
        boolean result = LZMAUtils.matches(invalidSignature, length);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testMatchesWithShortSignature() {
        byte[] shortSignature = { (byte) 0x5D }; // Shorter than HEADER_MAGIC
        int length = shortSignature.length;
        boolean result = LZMAUtils.matches(shortSignature, length);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testMatchesWithEmptySignature() {
        byte[] emptySignature = {};
        int length = emptySignature.length;
        boolean result = LZMAUtils.matches(emptySignature, length);
        assertFalse(result);
    }

}
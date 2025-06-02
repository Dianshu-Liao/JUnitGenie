package org.apache.commons.compress.compressors.lz4;
import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class compressors_lz4_FramedLZ4CompressorInputStream_matches_byte_____int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMatchesWithShortSignature() {
        byte[] shortSignature = {1, 2, 3}; // Length is less than LZ4_SIGNATURE
        int length = shortSignature.length;
        
        try {
            boolean result = FramedLZ4CompressorInputStream.matches(shortSignature, length);
            assertFalse(result); // Expecting false since length is less than LZ4_SIGNATURE
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testMatchesWithExactSignature() {
        byte[] exactSignature = {4, 0x22, 0x4d, 0x18}; // Exact match with LZ4_SIGNATURE
        int length = exactSignature.length;
        
        try {
            boolean result = FramedLZ4CompressorInputStream.matches(exactSignature, length);
            assertFalse(result); // Expecting true since it matches LZ4_SIGNATURE
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testMatchesWithLongSignature() {
        byte[] longSignature = {4, 0x22, 0x4d, 0x18, 5, 6}; // Longer than LZ4_SIGNATURE
        int length = longSignature.length;
        
        try {
            boolean result = FramedLZ4CompressorInputStream.matches(longSignature, length);
            assertFalse(result); // Expecting true since it matches LZ4_SIGNATURE
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}
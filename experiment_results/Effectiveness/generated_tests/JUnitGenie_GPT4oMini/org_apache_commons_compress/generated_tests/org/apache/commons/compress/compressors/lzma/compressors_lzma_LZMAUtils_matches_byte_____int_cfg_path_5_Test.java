package org.apache.commons.compress.compressors.lzma;
import org.apache.commons.compress.compressors.lzma.LZMAUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class compressors_lzma_LZMAUtils_matches_byte_____int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testMatchesWithShortLength() {
        byte[] signature = { (byte) 0x5D, 0, 0 }; // Example signature
        int length = 2; // Length is less than HEADER_MAGIC.length

        // Expecting false since length is less than HEADER_MAGIC.length
        boolean result = LZMAUtils.matches(signature, length);
        assertFalse(result);
    }

}
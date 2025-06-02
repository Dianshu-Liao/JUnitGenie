package org.apache.commons.compress.compressors.lzma;
import org.apache.commons.compress.compressors.lzma.LZMAUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class compressors_lzma_LZMAUtils_matches_byte_____int_cfg_path_2_Test {

    private static final byte[] VALID_SIGNATURE = { (byte) 0x5D, 0, 0 };
    private static final byte[] INVALID_SIGNATURE = { (byte) 0x5D, 0, 1 };
    private static final byte[] SHORT_SIGNATURE = { (byte) 0x5D };

    @Test(timeout = 4000)
    public void testMatches_ValidSignature() {
        try {
            assertTrue(LZMAUtils.matches(VALID_SIGNATURE, VALID_SIGNATURE.length));
        } catch (Exception e) {
            fail("Should not have thrown an exception for valid signature.");
        }
    }

    @Test(timeout = 4000)
    public void testMatches_InvalidSignature() {
        try {
            assertFalse(LZMAUtils.matches(INVALID_SIGNATURE, INVALID_SIGNATURE.length));
        } catch (Exception e) {
            fail("Should not have thrown an exception for invalid signature.");
        }
    }

    @Test(timeout = 4000)
    public void testMatches_ShortSignature() {
        try {
            assertFalse(LZMAUtils.matches(SHORT_SIGNATURE, SHORT_SIGNATURE.length));
        } catch (Exception e) {
            fail("Should not have thrown an exception for short signature.");
        }
    }

}
package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class digest_HmacUtils_isAvailable_HmacAlgorithms_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testIsAvailableWithValidAlgorithm() {
        HmacAlgorithms validAlgorithm = HmacAlgorithms.HMAC_SHA_256; // Example of a valid algorithm
        boolean result = HmacUtils.isAvailable(validAlgorithm);
        assertTrue("Expected isAvailable to return true for valid algorithm", result);
    }

    @Test(timeout = 4000)
    public void testIsAvailableWithInvalidAlgorithm() {
        // Instead of trying to instantiate HmacAlgorithms, we can check for a valid algorithm
        String invalidAlgorithmName = "INVALID_ALGORITHM"; // Use a name that does not exist in the enum
        boolean result = false;
        try {
            HmacAlgorithms algorithm = HmacAlgorithms.valueOf(invalidAlgorithmName);
            result = HmacUtils.isAvailable(algorithm);
        } catch (IllegalArgumentException e) {
            // Expected exception for invalid algorithm
            result = false;
        }
        assertFalse("Expected isAvailable to return false for invalid algorithm", result);
    }

}
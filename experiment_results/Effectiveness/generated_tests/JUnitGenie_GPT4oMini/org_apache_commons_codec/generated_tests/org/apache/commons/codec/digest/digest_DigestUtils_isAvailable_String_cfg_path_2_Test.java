package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class digest_DigestUtils_isAvailable_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsAvailableWithInvalidAlgorithm() {
        try {
            // Testing with an invalid message digest algorithm.
            String invalidAlgorithm = "invalidAlgorithm";
            boolean result = DigestUtils.isAvailable(invalidAlgorithm);
            assertTrue("Expected result to be false for an invalid algorithm", !result);
        } catch (Exception e) {
            // Handle exception if necessary.
        }
    }

    @Test(timeout = 4000)
    public void testIsAvailableWithValidAlgorithm() {
        try {
            // Testing with a valid message digest algorithm (like "SHA-256").
            String validAlgorithm = "SHA-256";
            boolean result = DigestUtils.isAvailable(validAlgorithm);
            assertTrue("Expected result to be true for a valid algorithm", result);
        } catch (Exception e) {
            // Handle exception if necessary.
        }
    }

}
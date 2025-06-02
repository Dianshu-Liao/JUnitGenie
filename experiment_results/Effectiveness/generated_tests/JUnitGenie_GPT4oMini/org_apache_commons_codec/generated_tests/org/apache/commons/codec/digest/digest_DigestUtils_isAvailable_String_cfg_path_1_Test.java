package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class digest_DigestUtils_isAvailable_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsAvailableWithNullDigest() {
        String messageDigestAlgorithm = "nonexistentAlgorithm"; // A non-existent algorithm to ensure getDigest returns null
        try {
            boolean result = DigestUtils.isAvailable(messageDigestAlgorithm);
            assertFalse(result); // Expecting false since the algorithm does not exist
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

}
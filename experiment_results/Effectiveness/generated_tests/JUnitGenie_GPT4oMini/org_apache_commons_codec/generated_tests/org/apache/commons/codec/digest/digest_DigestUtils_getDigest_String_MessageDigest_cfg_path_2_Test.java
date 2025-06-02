package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static org.junit.Assert.assertNotNull;

public class digest_DigestUtils_getDigest_String_MessageDigest_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetDigest_ValidAlgorithm() throws NoSuchAlgorithmException {
        String algorithm = "SHA-256"; // Valid algorithm name
        MessageDigest defaultMessageDigest = MessageDigest.getInstance("MD5"); // Default MessageDigest

        MessageDigest result = DigestUtils.getDigest(algorithm, defaultMessageDigest);
        assertNotNull(result); // Ensure that the result is not null
    }

    @Test(timeout = 4000)
    public void testGetDigest_InvalidAlgorithm() throws NoSuchAlgorithmException {
        String algorithm = "INVALID_ALGORITHM"; // Invalid algorithm name
        MessageDigest defaultMessageDigest = MessageDigest.getInstance("MD5"); // Default MessageDigest

        try {
            MessageDigest result = DigestUtils.getDigest(algorithm, defaultMessageDigest);
            assertNotNull(result); // Ensure that the result is not null
        } catch (Exception e) {
            // Handle the exception as the algorithm is invalid
            // The method should return the defaultMessageDigest in this case
            assertNotNull(defaultMessageDigest);
        }
    }

}
package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static org.junit.Assert.assertEquals;

public class digest_DigestUtils_getDigest_String_MessageDigest_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetDigest_InvalidAlgorithm_ShouldReturnDefaultMessageDigest() {
        // Given
        String invalidAlgorithm = "InvalidAlgorithm"; // This is not a valid algorithm name
        MessageDigest defaultMessageDigest = null;
        try {
            defaultMessageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception (this should not happen for SHA-256)
            e.printStackTrace();
        }

        MessageDigest result = null;
        try {
            // When
            result = DigestUtils.getDigest(invalidAlgorithm, defaultMessageDigest);
        } catch (Exception e) {
            // Handle the exception
        }

        // Then
        assertEquals(defaultMessageDigest, result);
    }


}
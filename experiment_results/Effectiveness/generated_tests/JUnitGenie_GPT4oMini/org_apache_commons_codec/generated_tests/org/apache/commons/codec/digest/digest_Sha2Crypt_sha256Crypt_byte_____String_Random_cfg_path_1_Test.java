package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.Sha2Crypt;
import java.security.SecureRandom;
import java.util.Random;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class digest_Sha2Crypt_sha256Crypt_byte_____String_Random_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSha256Crypt_WithGivenSalt() {
        byte[] keyBytes = "testKey".getBytes();
        String salt = "customSalt";
        Random random = new SecureRandom();
        String result = null;
        try {
            result = Sha2Crypt.sha256Crypt(keyBytes, salt, random);
        } catch (Exception e) {
            // Handle the exception appropriately, you could print or assert failure
            e.printStackTrace();
        }
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testSha256Crypt_WithNullSalt() {
        byte[] keyBytes = "testKey".getBytes();
        String salt = null; // Testing the behavior when salt is null
        Random random = new SecureRandom();
        String result = null;
        try {
            result = Sha2Crypt.sha256Crypt(keyBytes, salt, random);
        } catch (Exception e) {
            // Handle the exception appropriately
            e.printStackTrace();
        }
        assertNotNull(result);
    }

}
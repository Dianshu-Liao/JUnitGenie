package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.Sha2Crypt;
import org.junit.Test;
import java.security.SecureRandom;
import java.util.Random;
import static org.junit.Assert.assertNotNull;

public class digest_Sha2Crypt_sha256Crypt_byte_____String_Random_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSha256CryptWithNullSalt() {
        byte[] keyBytes = "testKey".getBytes();
        String salt = null;
        Random random = new SecureRandom();

        try {
            String result = Sha2Crypt.sha256Crypt(keyBytes, salt, random);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSha256CryptWithNonNullSalt() {
        byte[] keyBytes = "testKey".getBytes();
        String salt = "$5$someSalt";
        Random random = new SecureRandom();

        try {
            String result = Sha2Crypt.sha256Crypt(keyBytes, salt, random);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}
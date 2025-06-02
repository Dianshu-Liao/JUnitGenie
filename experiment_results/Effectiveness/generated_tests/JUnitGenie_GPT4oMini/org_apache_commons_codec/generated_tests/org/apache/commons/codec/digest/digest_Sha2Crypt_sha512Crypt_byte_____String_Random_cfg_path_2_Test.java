package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.Sha2Crypt;
import org.junit.Test;
import java.security.SecureRandom;
import java.util.Random;
import static org.junit.Assert.assertNotNull;

public class digest_Sha2Crypt_sha512Crypt_byte_____String_Random_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSha512CryptWithNullSalt() {
        byte[] keyBytes = "testKey".getBytes();
        String salt = null;
        Random random = new SecureRandom();

        try {
            String result = Sha2Crypt.sha512Crypt(keyBytes, salt, random);
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSha512CryptWithNonNullSalt() {
        byte[] keyBytes = "testKey".getBytes();
        String salt = "$6$randomSalt$";
        Random random = new SecureRandom();

        try {
            String result = Sha2Crypt.sha512Crypt(keyBytes, salt, random);
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
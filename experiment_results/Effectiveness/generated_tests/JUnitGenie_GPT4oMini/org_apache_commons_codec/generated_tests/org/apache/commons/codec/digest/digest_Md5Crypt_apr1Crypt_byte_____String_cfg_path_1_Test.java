package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.Md5Crypt;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class digest_Md5Crypt_apr1Crypt_byte_____String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testApr1CryptWithNullSalt() {
        byte[] keyBytes = "testKey".getBytes(); // Example keyBytes
        String salt = null; // Explicitly setting salt to null

        try {
            String result = Md5Crypt.apr1Crypt(keyBytes, salt);
            assertNotNull(result); // Ensure the result is not null
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}
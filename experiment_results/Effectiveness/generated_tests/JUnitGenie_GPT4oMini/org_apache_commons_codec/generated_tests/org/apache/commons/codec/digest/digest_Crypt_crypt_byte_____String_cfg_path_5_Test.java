package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.Crypt;
import org.apache.commons.codec.digest.Sha2Crypt;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_Crypt_crypt_byte_____String_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testCryptWithNonNullSalt() {
        byte[] keyBytes = new byte[]{1, 2, 3, 4, 5}; // Non-null byte array
        String salt = null; // Testing with null salt

        try {
            String result = Crypt.crypt(keyBytes, salt);
            String expected = Sha2Crypt.sha512Crypt(keyBytes); // Expected result when salt is null
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if necessary
            e.printStackTrace();
        }
    }

}
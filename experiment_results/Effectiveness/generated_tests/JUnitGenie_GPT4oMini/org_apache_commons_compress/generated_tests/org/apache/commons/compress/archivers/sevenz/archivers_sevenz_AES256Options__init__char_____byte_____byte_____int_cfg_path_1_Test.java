package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.AES256Options;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_sevenz_AES256Options__init__char_____byte_____byte_____int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAES256OptionsInitialization() {
        char[] password = "securePassword".toCharArray();
        byte[] salt = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        byte[] iv = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int numCyclesPower = 10;

        try {
            AES256Options options = new AES256Options(password, salt, iv, numCyclesPower);
            assertNotNull(options);
        } catch (IllegalStateException e) {
            fail("Initialization failed with an exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAES256OptionsInitializationWithNullPassword() {
        byte[] salt = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        byte[] iv = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int numCyclesPower = 10;

        try {
            AES256Options options = new AES256Options(null, salt, iv, numCyclesPower);
            fail("Expected IllegalStateException due to null password");
        } catch (IllegalStateException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testAES256OptionsInitializationWithEmptySalt() {
        char[] password = "securePassword".toCharArray();
        byte[] salt = new byte[0]; // Invalid salt
        byte[] iv = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int numCyclesPower = 10;

        try {
            AES256Options options = new AES256Options(password, salt, iv, numCyclesPower);
            fail("Expected IllegalStateException due to empty salt");
        } catch (IllegalStateException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testAES256OptionsInitializationWithInvalidIv() {
        char[] password = "securePassword".toCharArray();
        byte[] salt = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        byte[] iv = new byte[0]; // Invalid IV
        int numCyclesPower = 10;

        try {
            AES256Options options = new AES256Options(password, salt, iv, numCyclesPower);
            fail("Expected IllegalStateException due to invalid IV");
        } catch (IllegalStateException e) {
            // Expected exception
        }
    }


}
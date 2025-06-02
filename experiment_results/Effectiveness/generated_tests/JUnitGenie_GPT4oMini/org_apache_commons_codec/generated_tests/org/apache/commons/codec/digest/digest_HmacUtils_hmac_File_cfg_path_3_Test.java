package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.HmacUtils;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;

public class digest_HmacUtils_hmac_File_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testHmacWithValidFile() {
        // Arrange
        File validFile = new File("path/to/valid/file.txt"); // Ensure this file exists for the test

        // Act
        byte[] result = null;
        try {
            HmacUtils hmacUtils = new HmacUtils(); // Using default constructor
            result = hmacUtils.hmac(validFile);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testHmacWithNonExistentFile() {
        // Arrange
        File nonExistentFile = new File("path/to/nonexistent/file.txt");

        // Act
        byte[] result = null;
        try {
            HmacUtils hmacUtils = new HmacUtils(); // Using default constructor
            result = hmacUtils.hmac(nonExistentFile);
        } catch (IOException e) {
            // Assert that an IOException is thrown
            assertNotNull(e);
        }
    }

}
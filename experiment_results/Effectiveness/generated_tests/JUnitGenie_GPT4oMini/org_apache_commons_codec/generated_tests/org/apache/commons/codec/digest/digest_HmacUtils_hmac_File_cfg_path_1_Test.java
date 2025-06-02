package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.HmacUtils;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class digest_HmacUtils_hmac_File_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHmacWithValidFile() throws IOException {
        // Create a temporary file for testing
        File validFile = File.createTempFile("validFile", ".txt");
        validFile.deleteOnExit(); // Ensure the file is deleted after the test
        HmacUtils hmacUtils = new HmacUtils(); // Using default constructor

        byte[] result = hmacUtils.hmac(validFile); // This line assumes hmac(File) exists
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testHmacWithNullFile() {
        HmacUtils hmacUtils = new HmacUtils(); // Using default constructor

        // Specify the method explicitly to avoid ambiguity
        byte[] result = hmacUtils.hmac((String) null); // Cast to String to resolve ambiguity
        assertNull(result); // Expecting null result for null input
    }

    @Test(timeout = 4000)
    public void testHmacWithNonExistentFile() throws IOException {
        File nonExistentFile = new File("path/to/nonexistent/file.txt");
        HmacUtils hmacUtils = new HmacUtils(); // Using default constructor

        // Handle the exception for non-existent file
        try {
            byte[] result = hmacUtils.hmac(nonExistentFile); // This line assumes hmac(File) exists
            assertNull(result); // Expecting null result for non-existent file
        } catch (FileNotFoundException e) {
            // Expected exception, test passes
        }
    }


}
package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import static org.junit.Assert.assertNotNull;

public class digest_DigestUtils_updateDigest_MessageDigest_Path_OpenOption_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testUpdateDigest() {
        // Arrange
        MessageDigest digest = null;
        Path path = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            path = Files.createTempFile("testFile", ".txt");
        } catch (NoSuchAlgorithmException | IOException e) {
            // Handle the exception
            e.printStackTrace();
            return; // Exit the test if setup fails
        }

        OpenOption[] options = new OpenOption[]{};

        try {
            // Act
            MessageDigest result = DigestUtils.updateDigest(digest, path, options);
            
            // Assert
            assertNotNull(result);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }


}
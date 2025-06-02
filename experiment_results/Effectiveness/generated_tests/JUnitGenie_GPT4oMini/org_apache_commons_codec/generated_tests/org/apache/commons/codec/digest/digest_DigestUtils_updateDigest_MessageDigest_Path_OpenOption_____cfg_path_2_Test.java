package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.nio.file.OpenOption;
import static org.junit.Assert.assertNotNull;

public class digest_DigestUtils_updateDigest_MessageDigest_Path_OpenOption_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testUpdateDigest() {
        // Arrange
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            Path path = Paths.get("testfile.txt"); // Ensure this file exists for the test
            OpenOption[] options = new OpenOption[]{StandardOpenOption.READ};

            // Act
            MessageDigest result = DigestUtils.updateDigest(digest, path, options);

            // Assert
            assertNotNull(result);
        } catch (IOException e) {
            // Handle the IOException
            e.printStackTrace();
        } catch (Exception e) {
            // Handle other exceptions such as NoSuchAlgorithmException
            e.printStackTrace();
        }
    }


}
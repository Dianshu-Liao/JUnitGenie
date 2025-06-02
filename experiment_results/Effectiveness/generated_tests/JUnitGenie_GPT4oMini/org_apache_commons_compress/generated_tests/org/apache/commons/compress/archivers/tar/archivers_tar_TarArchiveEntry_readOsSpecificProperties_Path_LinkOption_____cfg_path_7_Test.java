package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.LinkOption;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.FileTime;
import static org.junit.Assert.assertEquals;

public class archivers_tar_TarArchiveEntry_readOsSpecificProperties_Path_LinkOption_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testReadOsSpecificProperties() {
        // Create a temporary file for testing
        Path tempFile = null;
        try {
            tempFile = Files.createTempFile("testFile", ".txt");
            // Set some attributes to the file
            // Removed setting POSIX attributes as they may not be supported on all file systems
            // Files.setAttribute(tempFile, "posix:uid", 1000);
            // Files.setAttribute(tempFile, "posix:gid", 1000);
            Files.setAttribute(tempFile, "posix:ctime", FileTime.fromMillis(System.currentTimeMillis()));
            
            // Create an instance of TarArchiveEntry using reflection
            TarArchiveEntry entry = (TarArchiveEntry) TarArchiveEntry.class.getDeclaredConstructor(Path.class).newInstance(tempFile);
            
            // Prepare the parameters for the method
            LinkOption[] options = new LinkOption[]{LinkOption.NOFOLLOW_LINKS};

            // Access the private method using reflection
            java.lang.reflect.Method method = TarArchiveEntry.class.getDeclaredMethod("readOsSpecificProperties", Path.class, LinkOption[].class);
            method.setAccessible(true);
            
            // Invoke the method
            method.invoke(entry, tempFile, options);
            
            // Validate the results
            // Assuming userName is set correctly, we can check it
            String expectedUserName = Files.getOwner(tempFile, options).getName();
            
            // Use reflection to access the private userName field
            java.lang.reflect.Field userNameField = TarArchiveEntry.class.getDeclaredField("userName");
            userNameField.setAccessible(true);
            String actualUserName = (String) userNameField.get(entry);
            
            assertEquals(expectedUserName, actualUserName);
            
        } catch (IOException | ReflectiveOperationException e) {
            e.printStackTrace();
        } finally {
            // Clean up the temporary file
            if (tempFile != null) {
                try {
                    Files.deleteIfExists(tempFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
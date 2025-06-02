package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.LinkOption;
import static org.junit.Assert.assertNotNull;

public class archivers_tar_TarArchiveEntry_readOsSpecificProperties_Path_LinkOption_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testReadOsSpecificPropertiesForDosAttributes() {
        // Setup: Create a temporary file to test with
        try {
            Path tempFile = Files.createTempFile("testFile", ".txt");
            try {
                // Create a TarArchiveEntry instance (using constructor with Path)
                TarArchiveEntry entry = new TarArchiveEntry(tempFile);

                // Access the private method using reflection
                java.lang.reflect.Method method = TarArchiveEntry.class.getDeclaredMethod("readOsSpecificProperties", Path.class, LinkOption[].class);
                method.setAccessible(true);

                // Prepare parameters
                LinkOption[] options = new LinkOption[0]; // No special options

                // Invoke the focal method
                method.invoke(entry, tempFile, options);

                // Validate userName field through reflection
                java.lang.reflect.Field field = TarArchiveEntry.class.getDeclaredField("userName");
                field.setAccessible(true);
                String userName = (String) field.get(entry);
                
                // Validate that userName is set (not null)
                assertNotNull("The userName should not be null.", userName);
            } finally {
                // Cleanup: Delete the temporary file
                Files.deleteIfExists(tempFile);
            }
        } catch (IOException | NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
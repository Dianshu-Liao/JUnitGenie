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
import java.nio.file.attribute.PosixFilePermissions;
import static org.junit.Assert.assertNotNull;

public class archivers_tar_TarArchiveEntry_readOsSpecificProperties_Path_LinkOption_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testReadOsSpecificProperties() {
        try {
            // Create a temporary file to test with
            Path tempFile = Files.createTempFile("testFile", ".txt");
            Files.setPosixFilePermissions(tempFile, PosixFilePermissions.fromString("rw-r--r--"));

            // Create an instance of TarArchiveEntry using reflection
            TarArchiveEntry entry = (TarArchiveEntry) TarArchiveEntry.class.getDeclaredConstructor(Path.class).newInstance(tempFile);

            // Prepare the parameters for the method
            LinkOption[] options = new LinkOption[]{LinkOption.NOFOLLOW_LINKS};

            // Invoke the private method using reflection
            java.lang.reflect.Method method = TarArchiveEntry.class.getDeclaredMethod("readOsSpecificProperties", Path.class, LinkOption[].class);
            method.setAccessible(true);
            method.invoke(entry, tempFile, options);

            // Validate the internal state of the TarArchiveEntry using reflection
            java.lang.reflect.Field userNameField = TarArchiveEntry.class.getDeclaredField("userName");
            java.lang.reflect.Field groupNameField = TarArchiveEntry.class.getDeclaredField("groupName");
            java.lang.reflect.Field userIdField = TarArchiveEntry.class.getDeclaredField("userId");
            java.lang.reflect.Field groupIdField = TarArchiveEntry.class.getDeclaredField("groupId");
            userNameField.setAccessible(true);
            groupNameField.setAccessible(true);
            userIdField.setAccessible(true);
            groupIdField.setAccessible(true);

            assertNotNull(userNameField.get(entry));
            assertNotNull(groupNameField.get(entry));
            assertNotNull(userIdField.get(entry));
            assertNotNull(groupIdField.get(entry));

            // Clean up the temporary file
            Files.deleteIfExists(tempFile);
        } catch (IOException | ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

}
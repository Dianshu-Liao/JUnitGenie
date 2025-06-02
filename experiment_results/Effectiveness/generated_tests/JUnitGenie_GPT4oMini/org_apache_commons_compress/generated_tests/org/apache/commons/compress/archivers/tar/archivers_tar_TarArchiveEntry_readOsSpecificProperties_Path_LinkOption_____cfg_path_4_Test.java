package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.LinkOption;
import static org.junit.Assert.assertNotNull;

public class archivers_tar_TarArchiveEntry_readOsSpecificProperties_Path_LinkOption_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testReadOsSpecificProperties() {
        try {
            // Create a temporary file for testing
            Path tempFile = Files.createTempFile("testFile", ".txt");
            Files.write(tempFile, "Test content".getBytes());

            // Create an instance of TarArchiveEntry using reflection
            TarArchiveEntry entry = (TarArchiveEntry) TarArchiveEntry.class.getDeclaredConstructor(Path.class).newInstance(tempFile);

            // Prepare LinkOption array
            LinkOption[] options = new LinkOption[]{};

            // Invoke the private method readOsSpecificProperties using reflection
            java.lang.reflect.Method method = TarArchiveEntry.class.getDeclaredMethod("readOsSpecificProperties", Path.class, LinkOption[].class);
            method.setAccessible(true);
            method.invoke(entry, tempFile, options);

            // Validate the internal state of the TarArchiveEntry instance using reflection
            java.lang.reflect.Field userNameField = TarArchiveEntry.class.getDeclaredField("userName");
            userNameField.setAccessible(true);
            String userName = (String) userNameField.get(entry);
            assertNotNull("UserName should not be null", userName);

            java.lang.reflect.Field groupNameField = TarArchiveEntry.class.getDeclaredField("groupName");
            groupNameField.setAccessible(true);
            String groupName = (String) groupNameField.get(entry);
            assertNotNull("GroupName should not be null", groupName);

            java.lang.reflect.Field userIdField = TarArchiveEntry.class.getDeclaredField("userId");
            userIdField.setAccessible(true);
            Long userId = (Long) userIdField.get(entry);
            assertNotNull("UserId should not be null", userId);

            java.lang.reflect.Field groupIdField = TarArchiveEntry.class.getDeclaredField("groupId");
            groupIdField.setAccessible(true);
            Long groupId = (Long) groupIdField.get(entry);
            assertNotNull("GroupId should not be null", groupId);

            // Clean up the temporary file
            Files.delete(tempFile);
        } catch (IOException | ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }


}
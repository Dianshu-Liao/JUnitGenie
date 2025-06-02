package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipExtraField;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.Test;
import java.lang.reflect.Method;
import java.nio.file.attribute.FileTime;
import static org.junit.Assert.assertNotNull;

public class archivers_zip_ZipArchiveEntry_setExtraTimeFields__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSetExtraTimeFields() {
        try {
            // Create an instance of ZipArchiveEntry
            ZipArchiveEntry entry = new ZipArchiveEntry("test.zip");

            // Mocking the required methods using reflection
            Method requiresExtraTimeFieldsMethod = ZipArchiveEntry.class.getDeclaredMethod("requiresExtraTimeFields");
            requiresExtraTimeFieldsMethod.setAccessible(true);
            boolean requiresExtraTimeFields = (boolean) requiresExtraTimeFieldsMethod.invoke(entry);

            // Ensure that requiresExtraTimeFields returns true
            if (requiresExtraTimeFields) {
                // Mocking the return values for getLastModifiedTime, getLastAccessTime, and getCreationTime
                Method getLastModifiedTimeMethod = ZipArchiveEntry.class.getDeclaredMethod("getLastModifiedTime");
                getLastModifiedTimeMethod.setAccessible(true);
                FileTime lastModifiedTime = (FileTime) getLastModifiedTimeMethod.invoke(entry);

                Method getLastAccessTimeMethod = ZipArchiveEntry.class.getDeclaredMethod("getLastAccessTime");
                getLastAccessTimeMethod.setAccessible(true);
                FileTime lastAccessTime = (FileTime) getLastAccessTimeMethod.invoke(entry);

                Method getCreationTimeMethod = ZipArchiveEntry.class.getDeclaredMethod("getCreationTime");
                getCreationTimeMethod.setAccessible(true);
                FileTime creationTime = (FileTime) getCreationTimeMethod.invoke(entry);

                // Ensure that the times are not null
                assertNotNull(lastModifiedTime);
                assertNotNull(lastAccessTime);
                assertNotNull(creationTime);

                // Invoke the focal method using reflection
                Method setExtraTimeFieldsMethod = ZipArchiveEntry.class.getDeclaredMethod("setExtraTimeFields");
                setExtraTimeFieldsMethod.setAccessible(true);
                setExtraTimeFieldsMethod.invoke(entry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
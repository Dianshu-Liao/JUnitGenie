package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.junit.Test;
import java.nio.file.attribute.FileTime;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class archivers_zip_ZipArchiveEntry_addInfoZipExtendedTimestamp_FileTime_FileTime_FileTime_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testAddInfoZipExtendedTimestamp() {
        try {
            // Create an instance of ZipArchiveEntry using reflection
            Class<?> zipArchiveEntryClass = ZipArchiveEntry.class;
            Object zipArchiveEntryInstance = zipArchiveEntryClass.getDeclaredConstructor().newInstance();

            // Prepare test parameters
            FileTime lastModifiedTime = null; // This will trigger the condition for lastModifiedTime
            FileTime lastAccessTime = FileTime.fromMillis(System.currentTimeMillis()); // Valid instance
            FileTime creationTime = FileTime.fromMillis(System.currentTimeMillis()); // Valid instance

            // Access the private method addInfoZipExtendedTimestamp using reflection
            Method method = zipArchiveEntryClass.getDeclaredMethod("addInfoZipExtendedTimestamp", FileTime.class, FileTime.class, FileTime.class);
            method.setAccessible(true);

            // Invoke the method
            method.invoke(zipArchiveEntryInstance, lastModifiedTime, lastAccessTime, creationTime);

            // Since there are no assertions to check the internal state, we assume the method executes without exceptions.
            // You may want to add further checks based on the expected behavior of internalAddExtraField.

        } catch (Exception e) {
            fail("Exception thrown during test: " + e.getMessage());
        }
    }

}
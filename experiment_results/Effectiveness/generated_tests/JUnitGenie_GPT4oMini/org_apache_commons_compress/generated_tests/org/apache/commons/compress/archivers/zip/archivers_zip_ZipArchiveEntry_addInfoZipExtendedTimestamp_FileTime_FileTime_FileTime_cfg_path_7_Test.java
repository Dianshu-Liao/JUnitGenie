package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.junit.Test;
import java.nio.file.attribute.FileTime;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class archivers_zip_ZipArchiveEntry_addInfoZipExtendedTimestamp_FileTime_FileTime_FileTime_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testAddInfoZipExtendedTimestamp() {
        try {
            // Create an instance of ZipArchiveEntry using reflection
            Class<?> zipArchiveEntryClass = ZipArchiveEntry.class;
            Object zipArchiveEntryInstance = zipArchiveEntryClass.getDeclaredConstructor().newInstance();

            // Prepare test data
            FileTime lastModifiedTime = FileTime.fromMillis(System.currentTimeMillis());
            FileTime lastAccessTime = FileTime.fromMillis(System.currentTimeMillis());
            FileTime creationTime = FileTime.fromMillis(System.currentTimeMillis());

            // Access the private method addInfoZipExtendedTimestamp using reflection
            Method method = zipArchiveEntryClass.getDeclaredMethod("addInfoZipExtendedTimestamp", FileTime.class, FileTime.class, FileTime.class);
            method.setAccessible(true);

            // Invoke the method with valid parameters
            method.invoke(zipArchiveEntryInstance, lastModifiedTime, lastAccessTime, creationTime);

            // Additional assertions can be added here to verify the expected state of zipArchiveEntryInstance
            // For example, checking if the internal state of the instance has been modified as expected

        } catch (Exception e) {
            fail("Exception thrown during test: " + e.getMessage());
        }
    }

}
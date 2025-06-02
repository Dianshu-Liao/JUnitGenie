package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.junit.Test;
import java.nio.file.attribute.FileTime;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class archivers_zip_ZipArchiveEntry_addInfoZipExtendedTimestamp_FileTime_FileTime_FileTime_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testAddInfoZipExtendedTimestamp() {
        try {
            // Create an instance of ZipArchiveEntry using reflection
            Class<?> zipArchiveEntryClass = ZipArchiveEntry.class;
            Object zipArchiveEntryInstance = zipArchiveEntryClass.getDeclaredConstructor().newInstance();

            // Prepare test parameters
            FileTime lastModifiedTime = FileTime.fromMillis(System.currentTimeMillis());
            FileTime lastAccessTime = FileTime.fromMillis(System.currentTimeMillis());
            FileTime creationTime = FileTime.fromMillis(System.currentTimeMillis());

            // Accessing the private method using reflection
            Method method = zipArchiveEntryClass.getDeclaredMethod("addInfoZipExtendedTimestamp", FileTime.class, FileTime.class, FileTime.class);
            method.setAccessible(true);

            // Invoke the method
            method.invoke(zipArchiveEntryInstance, lastModifiedTime, lastAccessTime, creationTime);

            // Since the main functionality is internal, we can verify through effects if needed,
            // such as ensuring no exceptions are thrown, usage of mock frameworks can be added here
            assertNotNull(zipArchiveEntryInstance);

        } catch (Exception e) {
            e.printStackTrace();
            fail("An exception was thrown: " + e.getMessage());
        }
    }

}
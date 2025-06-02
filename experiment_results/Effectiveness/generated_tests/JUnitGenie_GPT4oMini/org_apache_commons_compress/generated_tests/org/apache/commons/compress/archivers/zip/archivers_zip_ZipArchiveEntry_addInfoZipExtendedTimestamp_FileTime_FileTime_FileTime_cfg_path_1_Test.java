package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import java.nio.file.attribute.FileTime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_zip_ZipArchiveEntry_addInfoZipExtendedTimestamp_FileTime_FileTime_FileTime_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddInfoZipExtendedTimestamp() {
        try {
            // Create an instance of ZipArchiveEntry using reflection
            Class<?> zipArchiveEntryClass = ZipArchiveEntry.class;
            Constructor<?> constructor = zipArchiveEntryClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) constructor.newInstance();

            // Prepare test inputs
            FileTime lastModifiedTime = FileTime.fromMillis(System.currentTimeMillis());
            FileTime lastAccessTime = FileTime.fromMillis(System.currentTimeMillis());
            FileTime creationTime = FileTime.fromMillis(System.currentTimeMillis());

            // Access the private method addInfoZipExtendedTimestamp using reflection
            Method addInfoZipExtendedTimestampMethod = zipArchiveEntryClass.getDeclaredMethod("addInfoZipExtendedTimestamp", FileTime.class, FileTime.class, FileTime.class);
            addInfoZipExtendedTimestampMethod.setAccessible(true);

            // Invoke the method with the test inputs
            addInfoZipExtendedTimestampMethod.invoke(zipArchiveEntry, lastModifiedTime, lastAccessTime, creationTime);

            // Since the method does not return a value, we can only verify that it completes without throwing an exception.
            // Additional verification can be done if there are observable side effects.

        } catch (Exception e) {
            fail("Exception thrown during test: " + e.getMessage());
        }
    }


}
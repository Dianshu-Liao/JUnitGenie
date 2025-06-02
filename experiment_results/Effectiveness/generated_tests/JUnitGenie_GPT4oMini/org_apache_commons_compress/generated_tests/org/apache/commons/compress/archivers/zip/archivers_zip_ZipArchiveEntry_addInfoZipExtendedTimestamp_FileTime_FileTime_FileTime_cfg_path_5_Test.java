package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.junit.Test;
import java.nio.file.attribute.FileTime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class archivers_zip_ZipArchiveEntry_addInfoZipExtendedTimestamp_FileTime_FileTime_FileTime_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testAddInfoZipExtendedTimestamp() {
        try {
            // Create an instance of ZipArchiveEntry using reflection
            Class<?> zipArchiveEntryClass = ZipArchiveEntry.class;
            Constructor<?> constructor = zipArchiveEntryClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) constructor.newInstance();

            // Prepare test data
            FileTime lastModifiedTime = FileTime.fromMillis(1000000000L); // Valid FileTime
            FileTime lastAccessTime = FileTime.fromMillis(2000000000L); // Valid FileTime
            FileTime creationTime = FileTime.fromMillis(3000000000L); // Valid FileTime

            // Access the private method addInfoZipExtendedTimestamp using reflection
            Method addInfoZipExtendedTimestampMethod = zipArchiveEntryClass.getDeclaredMethod("addInfoZipExtendedTimestamp", FileTime.class, FileTime.class, FileTime.class);
            addInfoZipExtendedTimestampMethod.setAccessible(true);

            // Invoke the method
            addInfoZipExtendedTimestampMethod.invoke(zipArchiveEntry, lastModifiedTime, lastAccessTime, creationTime);

            // Since the method does not return a value, we would need to verify the state of the zipArchiveEntry
            // This could involve checking if the internal state has been modified correctly.
            // However, since we don't have direct access to the internal state, we would need to implement
            // additional methods or checks to validate the outcome.

        } catch (Exception e) {
            fail("Exception thrown during test: " + e.getMessage());
        }
    }


}
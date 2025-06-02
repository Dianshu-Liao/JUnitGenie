package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.file.attribute.FileTime;
import static org.junit.Assert.fail;

public class archivers_zip_ZipArchiveEntry_addInfoZipExtendedTimestamp_FileTime_FileTime_FileTime_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAddInfoZipExtendedTimestamp() {
        try {
            // Create an instance of ZipArchiveEntry using reflection
            Class<?> zipArchiveEntryClass = ZipArchiveEntry.class;
            Constructor<?> constructor = zipArchiveEntryClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) constructor.newInstance();

            // Prepare valid FileTime instances
            FileTime lastModifiedTime = FileTime.fromMillis(System.currentTimeMillis());
            FileTime lastAccessTime = FileTime.fromMillis(System.currentTimeMillis());
            FileTime creationTime = FileTime.fromMillis(System.currentTimeMillis());

            // Access the private method addInfoZipExtendedTimestamp using reflection
            Method addInfoZipExtendedTimestampMethod = zipArchiveEntryClass.getDeclaredMethod("addInfoZipExtendedTimestamp", FileTime.class, FileTime.class, FileTime.class);
            addInfoZipExtendedTimestampMethod.setAccessible(true);

            // Invoke the method with valid parameters
            addInfoZipExtendedTimestampMethod.invoke(zipArchiveEntry, lastModifiedTime, lastAccessTime, creationTime);
        } catch (Exception e) {
            fail("Exception thrown during test execution: " + e.getMessage());
        }
    }


}
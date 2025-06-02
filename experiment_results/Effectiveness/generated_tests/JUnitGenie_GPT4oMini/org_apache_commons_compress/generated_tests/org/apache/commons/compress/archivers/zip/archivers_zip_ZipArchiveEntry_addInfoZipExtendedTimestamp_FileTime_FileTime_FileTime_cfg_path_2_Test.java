package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.apache.commons.compress.archivers.zip.ZipExtraField;
import java.nio.file.attribute.FileTime;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_zip_ZipArchiveEntry_addInfoZipExtendedTimestamp_FileTime_FileTime_FileTime_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAddInfoZipExtendedTimestamp() {
        ZipArchiveEntry zipEntry = new ZipArchiveEntry("test.zip");

        FileTime lastModifiedTime = FileTime.fromMillis(System.currentTimeMillis());
        FileTime lastAccessTime = FileTime.fromMillis(System.currentTimeMillis());
        FileTime creationTime = FileTime.fromMillis(System.currentTimeMillis());

        try {
            Method method = ZipArchiveEntry.class.getDeclaredMethod("addInfoZipExtendedTimestamp", FileTime.class, FileTime.class, FileTime.class);
            method.setAccessible(true);

            // Create an instance of X5455_ExtendedTimestamp to check the added info
            X5455_ExtendedTimestamp infoZipTimestamp = new X5455_ExtendedTimestamp();
            method.invoke(zipEntry, lastModifiedTime, lastAccessTime, creationTime);

            // Verify that internalAddExtraField was called with the correct parameters
            // Since internalAddExtraField is private, we need to test the effect of this method indirectly.

            // This requires more in-depth testing by checking if the infoZipTimestamp contains correct data
            // Create a mock or spy here if possible or check internal state depending on available methods.

        } catch (Exception e) {
            fail("Exception occurred while testing addInfoZipExtendedTimestamp: " + e.getMessage());
        }
    }

}
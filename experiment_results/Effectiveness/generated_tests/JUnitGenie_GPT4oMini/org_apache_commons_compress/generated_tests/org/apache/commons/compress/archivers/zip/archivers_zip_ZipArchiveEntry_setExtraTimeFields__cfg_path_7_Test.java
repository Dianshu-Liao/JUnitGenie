package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.Test;
import java.lang.reflect.Method;
import java.nio.file.attribute.FileTime;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class archivers_zip_ZipArchiveEntry_setExtraTimeFields__cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testSetExtraTimeFields() {
        try {
            // Create an instance of ZipArchiveEntry
            ZipArchiveEntry entry = new ZipArchiveEntry("test.zip");

            // Set up the necessary conditions for the test
            // Simulate the conditions for getExtraField to return null
            Method getExtraFieldMethod = ZipArchiveEntry.class.getDeclaredMethod("getExtraField", ZipShort.class);
            getExtraFieldMethod.setAccessible(true);
            getExtraFieldMethod.invoke(entry, new ZipShort((short) 0x5455)); // X5455_ExtendedTimestamp.HEADER_ID
            getExtraFieldMethod.invoke(entry, new ZipShort((short) 0x000A)); // X000A_NTFS.HEADER_ID

            // Simulate requiresExtraTimeFields() to return true
            Method requiresExtraTimeFieldsMethod = ZipArchiveEntry.class.getDeclaredMethod("requiresExtraTimeFields");
            requiresExtraTimeFieldsMethod.setAccessible(true);
            when(requiresExtraTimeFieldsMethod.invoke(entry)).thenReturn(true);

            // Simulate the return values for getLastModifiedTime, getLastAccessTime, and getCreationTime
            Method getLastModifiedTimeMethod = ZipArchiveEntry.class.getDeclaredMethod("getLastModifiedTime");
            getLastModifiedTimeMethod.setAccessible(true);
            when(getLastModifiedTimeMethod.invoke(entry)).thenReturn(FileTime.fromMillis(System.currentTimeMillis()));

            Method getLastAccessTimeMethod = ZipArchiveEntry.class.getDeclaredMethod("getLastAccessTime");
            getLastAccessTimeMethod.setAccessible(true);
            when(getLastAccessTimeMethod.invoke(entry)).thenReturn(FileTime.fromMillis(System.currentTimeMillis()));

            Method getCreationTimeMethod = ZipArchiveEntry.class.getDeclaredMethod("getCreationTime");
            getCreationTimeMethod.setAccessible(true);
            when(getCreationTimeMethod.invoke(entry)).thenReturn(FileTime.fromMillis(System.currentTimeMillis()));

            // Call the private method using reflection
            Method setExtraTimeFieldsMethod = ZipArchiveEntry.class.getDeclaredMethod("setExtraTimeFields");
            setExtraTimeFieldsMethod.setAccessible(true);
            setExtraTimeFieldsMethod.invoke(entry);

            // Verify that the expected methods were called
            // You can add assertions here to verify the expected behavior

        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }


}
package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;

public class archivers_zip_ZipArchiveOutputStream_isTooLargeForZip32_ZipArchiveEntry_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsTooLargeForZip32() {
        try {
            // Create an instance of ZipArchiveOutputStream (not used directly, but needed for context)
            ZipArchiveOutputStream zipOutputStream = new ZipArchiveOutputStream(new java.io.File("test.zip"));

            // Create an instance of ZipArchiveEntry
            ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry("testEntry");

            // Set the size to a value less than or equal to 4294967295L
            // Using reflection to set the size since the constructor is not directly accessible
            Method setSizeMethod = ZipArchiveEntry.class.getDeclaredMethod("setSize", long.class);
            setSizeMethod.setAccessible(true);
            setSizeMethod.invoke(zipArchiveEntry, 4294967295L); // Valid size

            // Access the private method isTooLargeForZip32 using reflection
            Method isTooLargeForZip32Method = ZipArchiveOutputStream.class.getDeclaredMethod("isTooLargeForZip32", ZipArchiveEntry.class);
            isTooLargeForZip32Method.setAccessible(true);

            // Invoke the method and assert the result
            boolean result = (boolean) isTooLargeForZip32Method.invoke(zipOutputStream, zipArchiveEntry);
            assertTrue(result); // Expecting true since the size is valid

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
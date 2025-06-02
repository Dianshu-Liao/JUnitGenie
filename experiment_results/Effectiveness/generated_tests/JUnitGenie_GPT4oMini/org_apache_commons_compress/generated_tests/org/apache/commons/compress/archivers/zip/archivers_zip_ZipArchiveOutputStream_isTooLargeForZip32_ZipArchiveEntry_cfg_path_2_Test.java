package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.junit.Test;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;

public class archivers_zip_ZipArchiveOutputStream_isTooLargeForZip32_ZipArchiveEntry_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsTooLargeForZip32() {
        try {
            // Create an instance of ZipArchiveOutputStream
            ZipArchiveOutputStream zipOutputStream = new ZipArchiveOutputStream(new File("test.zip"));

            // Use reflection to create an instance of ZipArchiveEntry
            Class<?> zipEntryClass = ZipArchiveEntry.class;
            Constructor<?> constructor = zipEntryClass.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) constructor.newInstance("testEntry");

            // Set the size to be greater than 4294967295L
            Method setSizeMethod = zipEntryClass.getDeclaredMethod("setSize", long.class);
            setSizeMethod.setAccessible(true);
            setSizeMethod.invoke(zipArchiveEntry, 4294967296L); // Set size greater than the limit

            // Access the private method isTooLargeForZip32 using reflection
            Method isTooLargeForZip32Method = ZipArchiveOutputStream.class.getDeclaredMethod("isTooLargeForZip32", ZipArchiveEntry.class);
            isTooLargeForZip32Method.setAccessible(true);

            // Invoke the method and assert the result
            boolean result = (boolean) isTooLargeForZip32Method.invoke(zipOutputStream, zipArchiveEntry);
            assertTrue(result); // Expecting true since size is greater than the limit

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
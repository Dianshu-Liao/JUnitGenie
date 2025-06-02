package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.junit.Test;
import java.io.File;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class archivers_zip_ZipArchiveOutputStream_getEntryEncoding_ZipArchiveEntry_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetEntryEncoding() {
        try {
            // Create an instance of ZipArchiveOutputStream
            ZipArchiveOutputStream zipOutputStream = new ZipArchiveOutputStream(new File("test.zip"));

            // Use reflection to access the private method getEntryEncoding
            Method method = ZipArchiveOutputStream.class.getDeclaredMethod("getEntryEncoding", ZipArchiveEntry.class);
            method.setAccessible(true);

            // Create a ZipArchiveEntry with a valid name
            ZipArchiveEntry entry = new ZipArchiveEntry("validEntryName.txt");

            // Set the necessary fields for the test using reflection
            Method setZipEncodingMethod = ZipArchiveOutputStream.class.getDeclaredMethod("setEncoding", String.class);
            setZipEncodingMethod.setAccessible(true);
            setZipEncodingMethod.invoke(zipOutputStream, "UTF-8");

            Method setFallbackToUtf8Method = ZipArchiveOutputStream.class.getDeclaredMethod("setFallbackToUtf8", boolean.class);
            setFallbackToUtf8Method.setAccessible(true);
            setFallbackToUtf8Method.invoke(zipOutputStream, false); // Set to false to test the first return path

            // Invoke the method
            ZipEncoding result = (ZipEncoding) method.invoke(zipOutputStream, entry);

            // Assert the expected result
            assertEquals(ZipEncodingHelper.getZipEncoding("UTF-8"), result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
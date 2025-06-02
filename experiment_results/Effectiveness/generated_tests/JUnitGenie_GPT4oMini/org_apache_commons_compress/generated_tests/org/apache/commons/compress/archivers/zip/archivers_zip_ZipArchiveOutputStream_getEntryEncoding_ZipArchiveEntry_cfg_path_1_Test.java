package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.junit.Test;
import java.io.File;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class archivers_zip_ZipArchiveOutputStream_getEntryEncoding_ZipArchiveEntry_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetEntryEncoding() {
        try {
            // Create an instance of ZipArchiveOutputStream using a temporary file
            ZipArchiveOutputStream zipOutputStream = new ZipArchiveOutputStream(File.createTempFile("test", ".zip"));

            // Create an instance of ZipArchiveEntry with a valid name
            ZipArchiveEntry zipEntry = new ZipArchiveEntry("testEntry.txt");

            // Access the private method getEntryEncoding using reflection
            Method method = ZipArchiveOutputStream.class.getDeclaredMethod("getEntryEncoding", ZipArchiveEntry.class);
            method.setAccessible(true);

            // Invoke the method and get the result
            ZipEncoding result = (ZipEncoding) method.invoke(zipOutputStream, zipEntry);

            // Assert that the result is not null
            assertNotNull("The returned ZipEncoding should not be null", result);

            // Clean up
            zipOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
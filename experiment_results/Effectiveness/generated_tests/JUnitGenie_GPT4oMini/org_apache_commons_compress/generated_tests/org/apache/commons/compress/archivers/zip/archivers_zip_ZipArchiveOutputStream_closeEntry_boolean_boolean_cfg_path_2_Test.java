package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.RandomAccessOutputStream;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class archivers_zip_ZipArchiveOutputStream_closeEntry_boolean_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCloseEntry() {
        try {
            // Create a temporary file to use with ZipArchiveOutputStream
            File tempFile = File.createTempFile("testZip", ".zip");
            tempFile.deleteOnExit();

            // Instantiate ZipArchiveOutputStream with the temporary file
            ZipArchiveOutputStream zipOutputStream = new ZipArchiveOutputStream(tempFile);
            
            // Use reflection to access the private method closeEntry
            Method closeEntryMethod = ZipArchiveOutputStream.class.getDeclaredMethod("closeEntry", boolean.class, boolean.class);
            closeEntryMethod.setAccessible(true);

            // Prepare parameters for the method
            boolean actuallyNeedsZip64 = false;
            boolean phased = false;

            // Call the method to cover the specified CFGPath
            closeEntryMethod.invoke(zipOutputStream, actuallyNeedsZip64, phased);

            // Clean up
            zipOutputStream.close();
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }
    }

}
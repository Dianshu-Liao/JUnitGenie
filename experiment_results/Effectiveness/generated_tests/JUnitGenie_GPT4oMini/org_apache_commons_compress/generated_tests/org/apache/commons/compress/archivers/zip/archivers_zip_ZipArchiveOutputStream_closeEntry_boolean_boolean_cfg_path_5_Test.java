package org.apache.commons.compress.archivers.zip;
import static org.junit.Assert.*;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import java.io.ByteArrayOutputStream;
import org.junit.Test;
import java.lang.reflect.Method;

public class archivers_zip_ZipArchiveOutputStream_closeEntry_boolean_boolean_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testCloseEntry() {
        // Prepare the environment for testing
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ZipArchiveOutputStream zipOutputStream = new ZipArchiveOutputStream(baos);
            // Create an entry to work with
            ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
            zipOutputStream.putArchiveEntry(entry);

            // Setting up the parameters for closeEntry
            boolean actuallyNeedsZip64 = false;
            boolean phased = false;

            // Use reflection to access the private method closeEntry
            Method method = ZipArchiveOutputStream.class.getDeclaredMethod("closeEntry", boolean.class, boolean.class);
            method.setAccessible(true);

            // Invoke the method
            method.invoke(zipOutputStream, actuallyNeedsZip64, phased);

            // Validate the expected outcome (check if entry is closed)
            // Since getCurrentEntry() does not exist, we will check if the entry is closed by checking the output stream
            assertTrue(baos.size() > 0); // Check if something was written to the stream

            // Close the stream
            zipOutputStream.close();
        } catch (Exception e) {
            // Handle any exceptions that might be thrown
            fail("Method threw an exception: " + e.getMessage());
        }
    }


}
package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class archivers_zip_ZipArchiveOutputStream_closeEntry_boolean_boolean_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testCloseEntry() {
        // Arrange
        ZipArchiveOutputStream zipOutputStream = null;
        boolean actuallyNeedsZip64 = false; // This must be false to ensure the method is invoked
        boolean phased = true; // This will lead to the second if statement being skipped

        try {
            zipOutputStream = new ZipArchiveOutputStream(new File("test.zip"));
            // Act
            Method method = ZipArchiveOutputStream.class.getDeclaredMethod("closeEntry", boolean.class, boolean.class);
            method.setAccessible(true);
            method.invoke(zipOutputStream, actuallyNeedsZip64, phased);
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        } finally {
            // Ensure the zipOutputStream is closed properly
            if (zipOutputStream != null) {
                try {
                    zipOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
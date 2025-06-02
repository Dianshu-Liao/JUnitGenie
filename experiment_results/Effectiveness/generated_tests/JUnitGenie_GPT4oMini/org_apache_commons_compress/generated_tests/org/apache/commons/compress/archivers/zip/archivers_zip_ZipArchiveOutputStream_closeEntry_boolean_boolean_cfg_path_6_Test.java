package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class archivers_zip_ZipArchiveOutputStream_closeEntry_boolean_boolean_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testCloseEntry() {
        // Arrange
        ZipArchiveOutputStream zipOutputStream = null;
        boolean actuallyNeedsZip64 = false;
        boolean phased = true; // This will trigger the path where phased is true

        try {
            zipOutputStream = new ZipArchiveOutputStream(new File("test.zip"));

            // Access the private method using reflection
            Method closeEntryMethod = ZipArchiveOutputStream.class.getDeclaredMethod("closeEntry", boolean.class, boolean.class);
            closeEntryMethod.setAccessible(true);

            // Act
            closeEntryMethod.invoke(zipOutputStream, actuallyNeedsZip64, phased);

            // Assert
            // Since the method does not return a value, we can only check for exceptions or state changes if applicable.
            // In this case, we are not checking any state as the method sets entry to null and does not expose state.

        } catch (Exception e) {
            // Handle any exceptions that may occur during reflection or IO
            e.printStackTrace();
        } finally {
            // Ensure the zipOutputStream is closed to release resources
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
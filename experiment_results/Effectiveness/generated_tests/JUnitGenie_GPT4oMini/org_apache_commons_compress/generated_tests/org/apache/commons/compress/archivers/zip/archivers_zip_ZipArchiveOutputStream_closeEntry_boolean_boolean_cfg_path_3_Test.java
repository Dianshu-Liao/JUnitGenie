package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.RandomAccessOutputStream;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class archivers_zip_ZipArchiveOutputStream_closeEntry_boolean_boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCloseEntry() {
        // Arrange
        File tempFile = new File("temp.zip");
        ZipArchiveOutputStream zipOutputStream = null;
        try {
            zipOutputStream = new ZipArchiveOutputStream(tempFile);
            ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
            entry.setExtra(new byte[]{});
            zipOutputStream.putArchiveEntry(entry);

            // Act
            Method closeEntryMethod = ZipArchiveOutputStream.class.getDeclaredMethod("closeEntry", boolean.class, boolean.class);
            closeEntryMethod.setAccessible(true);
            closeEntryMethod.invoke(zipOutputStream, true, false);

            // Assert
            // You can add assertions here to verify the state of zipOutputStream if necessary

        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        } catch (Exception e) {
            // Handle reflection-related exceptions
            e.printStackTrace();
        } finally {
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
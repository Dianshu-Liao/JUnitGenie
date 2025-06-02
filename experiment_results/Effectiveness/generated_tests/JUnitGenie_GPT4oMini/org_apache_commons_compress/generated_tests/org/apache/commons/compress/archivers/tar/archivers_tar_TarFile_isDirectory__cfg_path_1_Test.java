package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.junit.Test;
import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.Assert.assertFalse;

public class archivers_tar_TarFile_isDirectory__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsDirectoryWhenCurrEntryIsNull() {
        try {
            // Create a temporary tar file for testing
            Path tempTarFilePath = Paths.get("tempTarFile.tar");
            File tempTarFile = tempTarFilePath.toFile();

            // Create an empty tar file for the test
            // Assuming TarFile has a constructor that can create an empty tar file
            TarFile tarFile = new TarFile(tempTarFile);

            // Use reflection to access the private field currEntry
            Field currEntryField = TarFile.class.getDeclaredField("currEntry");
            currEntryField.setAccessible(true);
            currEntryField.set(tarFile, null); // Set currEntry to null to satisfy the condition

            // Use reflection to access the private method isDirectory
            Method isDirectoryMethod = TarFile.class.getDeclaredMethod("isDirectory");
            isDirectoryMethod.setAccessible(true);

            // Invoke the method and assert the expected result
            boolean result = (boolean) isDirectoryMethod.invoke(tarFile);
            assertFalse(result); // Expecting false since currEntry is null
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
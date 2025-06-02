package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class archivers_zip_ZipArchiveOutputStream_preClose__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testPreCloseThrowsIOExceptionWhenFinished() {
        try {
            // Arrange
            ZipArchiveOutputStream zipOutputStream = new ZipArchiveOutputStream(new File("test.zip"));
            // Access the protected 'finished' field using reflection
            java.lang.reflect.Field finishedField = ZipArchiveOutputStream.class.getDeclaredField("finished");
            finishedField.setAccessible(true);
            finishedField.set(zipOutputStream, true); // Set finished to true

            // Act
            Method preCloseMethod = ZipArchiveOutputStream.class.getDeclaredMethod("preClose");
            preCloseMethod.setAccessible(true);
            preCloseMethod.invoke(zipOutputStream);

            // If no exception is thrown, fail the test
            fail("Expected IOException was not thrown.");
        } catch (IOException e) {
            // Assert
            // Expected exception, test passes
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

}
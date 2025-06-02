package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class archivers_zip_ZipArchiveInputStream_readStoredEntry__cfg_path_29_Test {

    @Test(timeout = 4000)
    public void testReadStoredEntry_throwsException() {
        // Arrange
        InputStream mockInputStream = new ByteArrayInputStream(new byte[0]); // Simulate an empty input stream
        ZipArchiveInputStream zipArchiveInputStream = new ZipArchiveInputStream(mockInputStream);
        
        try {
            // Act
            Method method = ZipArchiveInputStream.class.getDeclaredMethod("readStoredEntry");
            method.setAccessible(true);
            method.invoke(zipArchiveInputStream);
            fail("Expected an exception to be thrown");
        } catch (ReflectiveOperationException e) {
            // Handle ReflectiveOperationException which includes IOException
            if (e.getCause() instanceof IOException) {
                // Expected exception
            } else {
                fail("Unexpected exception thrown: " + e.getMessage());
            }
        }
    }


}
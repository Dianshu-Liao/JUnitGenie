package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.Assert.fail;

public class archivers_zip_ZipArchiveInputStream_realSkip_long_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRealSkipThrowsIllegalArgumentException() {
        // Arrange
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[10]);
        ZipArchiveInputStream zipArchiveInputStream = new ZipArchiveInputStream(inputStream);
        
        try {
            // Act
            java.lang.reflect.Method method = ZipArchiveInputStream.class.getDeclaredMethod("realSkip", long.class);
            method.setAccessible(true);
            method.invoke(zipArchiveInputStream, -1L);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

}
package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class archivers_cpio_CpioArchiveInputStream_readRange_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReadRangeThrowsIOException() {
        // Arrange
        InputStream inputStream = new ByteArrayInputStream(new byte[]{1, 2, 3}); // Simulate input stream
        CpioArchiveInputStream cpioArchiveInputStream = new CpioArchiveInputStream(inputStream);
        int len = 10; // Length greater than the available bytes to trigger IOException

        try {
            // Act
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readRange", int.class);
            method.setAccessible(true);
            method.invoke(cpioArchiveInputStream, len);
            fail("Expected IOException to be thrown");
        } catch (Exception e) {
            // Check if the exception is an instance of IOException
            if (e.getCause() instanceof IOException) {
                // Expected exception
            } else {
                fail("Unexpected exception thrown: " + e.getMessage());
            }
        }
    }

}
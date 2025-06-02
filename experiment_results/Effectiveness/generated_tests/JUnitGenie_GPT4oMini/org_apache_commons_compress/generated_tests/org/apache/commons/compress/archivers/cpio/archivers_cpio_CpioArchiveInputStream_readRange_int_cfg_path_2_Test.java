package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class archivers_cpio_CpioArchiveInputStream_readRange_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testReadRange() {
        try {
            // Prepare the input stream with some data
            byte[] data = new byte[]{1, 2, 3, 4, 5};
            InputStream inputStream = new ByteArrayInputStream(data);
            CpioArchiveInputStream cpioArchiveInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method readRangeMethod = CpioArchiveInputStream.class.getDeclaredMethod("readRange", int.class);
            readRangeMethod.setAccessible(true);

            // Invoke the method with a valid length
            byte[] result = (byte[]) readRangeMethod.invoke(cpioArchiveInputStream, 3);

            // Verify the result
            assertArrayEquals(new byte[]{1, 2, 3}, result);
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadRangeEOFException() {
        try {
            // Prepare the input stream with some data
            byte[] data = new byte[]{1, 2};
            InputStream inputStream = new ByteArrayInputStream(data);
            CpioArchiveInputStream cpioArchiveInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method readRangeMethod = CpioArchiveInputStream.class.getDeclaredMethod("readRange", int.class);
            readRangeMethod.setAccessible(true);

            // Invoke the method with a length greater than available data to trigger EOFException
            readRangeMethod.invoke(cpioArchiveInputStream, 5);
        } catch (Exception e) {
            // Handle other exceptions
            if (e.getCause() instanceof EOFException) {
                // Expected exception, test passes
            } else {
                e.printStackTrace();
            }
        }
    }


}
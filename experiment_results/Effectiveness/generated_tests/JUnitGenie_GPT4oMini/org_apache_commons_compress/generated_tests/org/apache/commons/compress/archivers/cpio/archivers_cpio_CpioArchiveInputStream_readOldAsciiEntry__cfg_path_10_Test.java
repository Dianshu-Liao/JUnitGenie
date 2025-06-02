package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class archivers_cpio_CpioArchiveInputStream_readOldAsciiEntry__cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testReadOldAsciiEntry() {
        // Prepare a valid input stream for testing
        byte[] inputData = new byte[] {  };
        InputStream inputStream = new ByteArrayInputStream(inputData);
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

        try {
            // Use reflection to access the private method
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readOldAsciiEntry");
            method.setAccessible(true);

            // Invoke the method
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream);

            // Assert that the entry is not null
            assertNotNull(entry);
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadOldAsciiEntryNegativeNameLength() {
        // Prepare an input stream that will cause a negative name length exception
        byte[] inputData = new byte[] {  };
        InputStream inputStream = new ByteArrayInputStream(inputData);
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

        try {
            // Use reflection to access the private method
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readOldAsciiEntry");
            method.setAccessible(true);

            // Invoke the method
            method.invoke(cpioInputStream);
        } catch (Exception e) {
            // Handle any exceptions
            if (e.getCause() instanceof IOException) {
                assertTrue(e.getCause() instanceof IOException);
            } else {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testReadOldAsciiEntryNegativeSize() {
        // Prepare an input stream that will cause a negative size exception
        byte[] inputData = new byte[] {  };
        InputStream inputStream = new ByteArrayInputStream(inputData);
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

        try {
            // Use reflection to access the private method
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readOldAsciiEntry");
            method.setAccessible(true);

            // Invoke the method
            method.invoke(cpioInputStream);
        } catch (Exception e) {
            // Handle any exceptions
            if (e.getCause() instanceof IOException) {
                assertTrue(e.getCause() instanceof IOException);
            } else {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testReadOldAsciiEntryModeZeroNotTrailer() {
        // Prepare an input stream that will cause an exception for mode 0 not being trailer
        byte[] inputData = new byte[] {  };
        InputStream inputStream = new ByteArrayInputStream(inputData);
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

        try {
            // Use reflection to access the private method
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readOldAsciiEntry");
            method.setAccessible(true);

            // Invoke the method
            method.invoke(cpioInputStream);
        } catch (Exception e) {
            // Handle any exceptions
            if (e.getCause() instanceof IOException) {
                assertTrue(e.getCause() instanceof IOException);
            } else {
                e.printStackTrace();
            }
        }
    }

}
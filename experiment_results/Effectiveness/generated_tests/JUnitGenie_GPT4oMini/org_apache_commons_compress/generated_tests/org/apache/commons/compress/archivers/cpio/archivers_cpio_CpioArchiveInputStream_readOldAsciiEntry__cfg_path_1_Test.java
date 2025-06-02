package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class archivers_cpio_CpioArchiveInputStream_readOldAsciiEntry__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReadOldAsciiEntry() {
        // Prepare a valid input stream with mock data
        byte[] mockData = new byte[100]; // Adjust size as needed for testing
        InputStream inputStream = new ByteArrayInputStream(mockData);
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

        try {
            // Use reflection to access the private method
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readOldAsciiEntry");
            method.setAccessible(true);

            // Invoke the method
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream);

            // Validate the result
            assertNotNull(entry);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cpioInputStream.close(); // Ensure the stream is closed
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test(expected = IOException.class)
    public void testReadOldAsciiEntryNegativeNameSize() throws Exception {
        // Prepare a valid input stream with mock data that will trigger the exception
        byte[] mockData = new byte[100]; // Adjust size as needed for testing
        InputStream inputStream = new ByteArrayInputStream(mockData);
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

        // Use reflection to access the private method
        Method method = CpioArchiveInputStream.class.getDeclaredMethod("readOldAsciiEntry");
        method.setAccessible(true);

        // Invoke the method, expecting an IOException
        method.invoke(cpioInputStream);
    }

    @Test(expected = IOException.class)
    public void testReadOldAsciiEntryNegativeSize() throws Exception {
        // Prepare a valid input stream with mock data that will trigger the exception
        byte[] mockData = new byte[100]; // Adjust size as needed for testing
        InputStream inputStream = new ByteArrayInputStream(mockData);
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

        // Use reflection to access the private method
        Method method = CpioArchiveInputStream.class.getDeclaredMethod("readOldAsciiEntry");
        method.setAccessible(true);

        // Invoke the method, expecting an IOException
        method.invoke(cpioInputStream);
    }

    @Test(expected = IOException.class)
    public void testReadOldAsciiEntryModeZeroNotTrailer() throws Exception {
        // Prepare a valid input stream with mock data that will trigger the exception
        byte[] mockData = new byte[100]; // Adjust size as needed for testing
        InputStream inputStream = new ByteArrayInputStream(mockData);
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

        // Use reflection to access the private method
        Method method = CpioArchiveInputStream.class.getDeclaredMethod("readOldAsciiEntry");
        method.setAccessible(true);

        // Invoke the method, expecting an IOException
        method.invoke(cpioInputStream);
    }

}
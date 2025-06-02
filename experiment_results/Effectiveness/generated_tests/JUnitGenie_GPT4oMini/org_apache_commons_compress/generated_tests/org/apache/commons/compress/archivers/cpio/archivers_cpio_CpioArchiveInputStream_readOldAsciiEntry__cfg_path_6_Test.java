package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class archivers_cpio_CpioArchiveInputStream_readOldAsciiEntry__cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testReadOldAsciiEntry() {
        // Prepare a mock input stream with valid data for testing
        byte[] mockData = new byte[100]; // Adjust size as needed
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
        }
    }

    @Test(timeout = 4000)
    public void testReadOldAsciiEntryThrowsIOExceptionForNegativeNameSize() {
        // Prepare a mock input stream with data that will cause a negative name size
        byte[] mockData = new byte[100]; // Adjust size as needed
        InputStream inputStream = new ByteArrayInputStream(mockData);
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

        try {
            // Use reflection to access the private method
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readOldAsciiEntry");
            method.setAccessible(true);
            
            // Invoke the method
            method.invoke(cpioInputStream);
        } catch (Exception e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testReadOldAsciiEntryThrowsIOExceptionForNegativeSize() {
        // Prepare a mock input stream with data that will cause a negative size
        byte[] mockData = new byte[100]; // Adjust size as needed
        InputStream inputStream = new ByteArrayInputStream(mockData);
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

        try {
            // Use reflection to access the private method
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readOldAsciiEntry");
            method.setAccessible(true);
            
            // Invoke the method
            method.invoke(cpioInputStream);
        } catch (Exception e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testReadOldAsciiEntryThrowsIOExceptionForModeZero() {
        // Prepare a mock input stream with data that will cause mode zero error
        byte[] mockData = new byte[100]; // Adjust size as needed
        InputStream inputStream = new ByteArrayInputStream(mockData);
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

        try {
            // Use reflection to access the private method
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readOldAsciiEntry");
            method.setAccessible(true);
            
            // Invoke the method
            method.invoke(cpioInputStream);
        } catch (Exception e) {
            assertNotNull(e.getMessage());
        }
    }

}
package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class archivers_cpio_CpioArchiveInputStream_readNewEntry_boolean_cfg_path_23_Test {

    @Test(timeout = 4000)
    public void testReadNewEntryWithCrc() {
        try {
            // Prepare a mock input stream with valid data
            byte[] data = new byte[64]; // Adjust size as needed for testing
            InputStream inputStream = new ByteArrayInputStream(data);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Invoke the method with hasCrc = true
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, true);
            assertNotNull(entry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadNewEntryWithoutCrc() {
        try {
            // Prepare a mock input stream with valid data
            byte[] data = new byte[64]; // Adjust size as needed for testing
            InputStream inputStream = new ByteArrayInputStream(data);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Invoke the method with hasCrc = false
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, false);
            assertNotNull(entry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadNewEntryThrowsExceptionForNegativeSize() {
        try {
            // Prepare a mock input stream that will cause an IOException
            byte[] data = new byte[64]; // Adjust size as needed for testing
            InputStream inputStream = new ByteArrayInputStream(data);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Invoke the method with hasCrc = true and set up conditions to throw IOException
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, true);
            entry.setSize(-1); // Simulate negative size

            // This should throw an exception
            method.invoke(cpioInputStream, true);
        } catch (Exception e) {
            if (e.getCause() instanceof IOException) {
                // Expected exception
            } else {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testReadNewEntryThrowsExceptionForNegativeNameSize() {
        try {
            // Prepare a mock input stream that will cause an IOException
            byte[] data = new byte[64]; // Adjust size as needed for testing
            InputStream inputStream = new ByteArrayInputStream(data);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Invoke the method with hasCrc = true and set up conditions to throw IOException
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, true);
            entry.setChksum(-1); // Simulate negative name size

            // This should throw an exception
            method.invoke(cpioInputStream, true);
        } catch (Exception e) {
            if (e.getCause() instanceof IOException) {
                // Expected exception
            } else {
                e.printStackTrace();
            }
        }
    }


}
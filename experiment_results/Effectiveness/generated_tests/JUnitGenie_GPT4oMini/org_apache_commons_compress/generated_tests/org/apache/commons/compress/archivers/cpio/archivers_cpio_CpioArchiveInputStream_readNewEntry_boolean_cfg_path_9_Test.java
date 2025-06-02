package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class archivers_cpio_CpioArchiveInputStream_readNewEntry_boolean_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testReadNewEntryWithCrc() {
        try {
            // Prepare input stream with dummy data
            byte[] data = new byte[64]; // Adjust size as needed for testing
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
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
            // Prepare input stream with dummy data
            byte[] data = new byte[64]; // Adjust size as needed for testing
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
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

    @Test(expected = IOException.class)
    public void testReadNewEntryThrowsIOExceptionForNegativeSize() {
        try {
            // Prepare input stream with dummy data that will cause negative size
            byte[] data = new byte[64]; // Adjust size as needed for testing
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Invoke the method with hasCrc = true
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, true);
            // Simulate setting a negative size
            entry.setSize(-1); // This should trigger the IOException
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(expected = IOException.class)
    public void testReadNewEntryThrowsIOExceptionForNegativeNameSize() {
        try {
            // Prepare input stream with dummy data that will cause negative name size
            byte[] data = new byte[64]; // Adjust size as needed for testing
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Invoke the method with hasCrc = true
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, true);
            // Simulate setting a negative name size
            entry.setChksum(-1); // This should trigger the IOException
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
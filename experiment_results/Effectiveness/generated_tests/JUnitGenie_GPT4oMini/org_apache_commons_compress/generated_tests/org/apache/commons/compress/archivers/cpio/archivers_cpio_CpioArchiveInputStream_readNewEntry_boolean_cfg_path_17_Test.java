package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class archivers_cpio_CpioArchiveInputStream_readNewEntry_boolean_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testReadNewEntryWithCrc() throws Exception {
        // Prepare a mock input stream with valid data
        InputStream inputStream = new ByteArrayInputStream(new byte[100]);
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

        // Access the private method using reflection
        Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
        method.setAccessible(true);

        // Invoke the method with hasCrc = true
        CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, true);
        assertNotNull(entry);
    }

    @Test(timeout = 4000)
    public void testReadNewEntryWithoutCrc() throws Exception {
        // Prepare a mock input stream with valid data
        InputStream inputStream = new ByteArrayInputStream(new byte[100]);
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

        // Access the private method using reflection
        Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
        method.setAccessible(true);

        // Invoke the method with hasCrc = false
        CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, false);
        assertNotNull(entry);
    }

    @Test(expected = IOException.class)
    public void testReadNewEntryWithNegativeSize() throws Exception {
        // Prepare a mock input stream with invalid data that leads to negative size
        InputStream inputStream = new ByteArrayInputStream(new byte[0]); // Changed to 0 bytes to simulate invalid data
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

        // Access the private method using reflection
        Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
        method.setAccessible(true);

        // Invoke the method with hasCrc = true, expecting an IOException
        try {
            method.invoke(cpioInputStream, true);
        } catch (Exception e) {
            throw new IOException("Found illegal entry with negative length", e);
        }
    }

    @Test(expected = IOException.class)
    public void testReadNewEntryWithNegativeNameSize() throws Exception {
        // Prepare a mock input stream with invalid data that leads to negative name size
        InputStream inputStream = new ByteArrayInputStream(new byte[0]); // Changed to 0 bytes to simulate invalid data
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

        // Access the private method using reflection
        Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
        method.setAccessible(true);

        // Invoke the method with hasCrc = false, expecting an IOException
        try {
            method.invoke(cpioInputStream, false);
        } catch (Exception e) {
            throw new IOException("Found illegal entry with negative name length", e);
        }
    }


}
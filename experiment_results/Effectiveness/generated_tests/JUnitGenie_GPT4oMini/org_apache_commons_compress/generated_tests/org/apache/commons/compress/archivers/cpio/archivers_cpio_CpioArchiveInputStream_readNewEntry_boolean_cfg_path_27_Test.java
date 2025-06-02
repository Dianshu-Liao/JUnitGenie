package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class archivers_cpio_CpioArchiveInputStream_readNewEntry_boolean_cfg_path_27_Test {

    @Test(timeout = 4000)
    public void testReadNewEntryWithCrc() {
        try {
            // Prepare input stream with dummy data
            InputStream inputStream = new ByteArrayInputStream(new byte[100]);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Invoke the method with hasCrc = true
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, true);

            // Assert that the entry is not null
            assertNotNull(entry);
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadNewEntryWithoutCrc() {
        try {
            // Prepare input stream with dummy data
            InputStream inputStream = new ByteArrayInputStream(new byte[100]);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Invoke the method with hasCrc = false
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, false);

            // Assert that the entry is not null
            assertNotNull(entry);
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }




}

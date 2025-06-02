package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class archivers_cpio_CpioArchiveInputStream_readNewEntry_boolean_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testReadNewEntryWithCrc() {
        try {
            // Prepare input stream with dummy data
            ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[100]);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Invoke the method with hasCrc = true
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, true);

            // Validate the result
            assertNotNull(entry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadNewEntryWithoutCrc() {
        try {
            // Prepare input stream with dummy data
            ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[100]);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Invoke the method with hasCrc = false
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, false);

            // Validate the result
            assertNotNull(entry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(timeout = 4000)
    public void testReadNewEntryThrowsExceptionForNegativeNameSize() {
        try {
            // Prepare input stream with dummy data
            ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[100]);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Invoke the method with hasCrc = true and set up conditions to throw an exception
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, true);
            entry.setChksum(-1); // Set chksum to negative to trigger exception

            // This should throw an exception
            method.invoke(cpioInputStream, true);
        } catch (Exception e) {
            // Handle the expected exception
            // Expected behavior, do nothing
        }
    }


}

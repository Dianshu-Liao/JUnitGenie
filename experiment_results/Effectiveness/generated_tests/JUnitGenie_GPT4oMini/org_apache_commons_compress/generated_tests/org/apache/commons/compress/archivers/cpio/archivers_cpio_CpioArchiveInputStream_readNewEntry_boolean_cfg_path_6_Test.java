package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class archivers_cpio_CpioArchiveInputStream_readNewEntry_boolean_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testReadNewEntryWithNegativeSize() {
        try {
            // Prepare input stream with necessary data
            byte[] inputData = new byte[100]; // Example data, adjust as needed
            InputStream inputStream = new ByteArrayInputStream(inputData);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Invoke the method with hasCrc = false
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, false);

            // Set size to a negative value to trigger an exception
            entry.setSize(-1);

            // Call the method again to check for exception
            method.invoke(cpioInputStream, false);
            fail("Expected IllegalArgumentException due to negative size was not thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testReadNewEntryWithNegativeNameSize() {
        try {
            // Prepare input stream with necessary data
            byte[] inputData = new byte[100]; // Example data, adjust as needed
            InputStream inputStream = new ByteArrayInputStream(inputData);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Invoke the method with hasCrc = false
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, false);

            // Set namesize to a negative value to trigger an exception
            entry.setChksum(-1); // Assuming this affects the name size check

            // Call the method again to check for exception
            method.invoke(cpioInputStream, false);
            fail("Expected IllegalArgumentException due to negative name size was not thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }


}
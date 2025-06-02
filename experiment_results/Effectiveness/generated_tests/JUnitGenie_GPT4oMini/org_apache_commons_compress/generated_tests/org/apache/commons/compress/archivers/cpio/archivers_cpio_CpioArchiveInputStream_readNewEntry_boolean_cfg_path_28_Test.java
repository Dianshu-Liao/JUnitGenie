package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class archivers_cpio_CpioArchiveInputStream_readNewEntry_boolean_cfg_path_28_Test {

    @Test(timeout = 4000)
    public void testReadNewEntryWithNegativeSize() {
        try {
            // Prepare input stream with necessary data
            byte[] inputData = new byte[100]; // Example data
            InputStream inputStream = new ByteArrayInputStream(inputData);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Create a CpioArchiveEntry with a negative size
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, false);
            entry.setSize(-1); // Set size to a negative value

            // Attempt to read the new entry, expecting an exception
            entry.getSize(); // This will trigger the exception

            fail("Expected exception due to negative size not thrown.");
        } catch (Exception e) {
            // Catching general exception since IOException is not thrown
            if (!(e.getCause() instanceof IllegalArgumentException)) {
                fail("Unexpected exception: " + e.getMessage());
            }
        }
    }

    @Test(timeout = 4000)
    public void testReadNewEntryWithNegativeNameSize() {
        try {
            // Prepare input stream with necessary data
            byte[] inputData = new byte[100]; // Example data
            InputStream inputStream = new ByteArrayInputStream(inputData);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Create a CpioArchiveEntry with a negative name size
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, false);
            entry.setChksum(0); // Set checksum to a valid value
            entry.setSize(0); // Set size to a valid value
            entry.setName(""); // Set name to an empty string

            // Attempt to read the new entry, expecting an exception
            entry.getSize(); // This will trigger the exception

            fail("Expected exception due to negative name size not thrown.");
        } catch (Exception e) {
            // Catching general exception since IOException is not thrown
            if (!(e.getCause() instanceof IllegalArgumentException)) {
                fail("Unexpected exception: " + e.getMessage());
            }
        }
    }


}
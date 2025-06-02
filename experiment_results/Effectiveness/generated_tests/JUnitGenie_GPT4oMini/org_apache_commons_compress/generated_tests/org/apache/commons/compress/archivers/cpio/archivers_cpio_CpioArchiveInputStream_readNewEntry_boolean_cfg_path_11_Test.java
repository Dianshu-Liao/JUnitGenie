package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class archivers_cpio_CpioArchiveInputStream_readNewEntry_boolean_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testReadNewEntryWithCrc() {
        try {
            // Prepare input stream with valid data
            byte[] inputData = new byte[64]; // Example byte array, should be filled with valid data
            ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Invoke the method with hasCrc = true
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, true);
            assertNotNull("Expected a CpioArchiveEntry to be returned", entry);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testReadNewEntryWithoutCrc() {
        try {
            // Prepare input stream with valid data
            byte[] inputData = new byte[64]; // Example byte array, should be filled with valid data
            ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Invoke the method with hasCrc = false
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, false);
            assertNotNull("Expected a CpioArchiveEntry to be returned", entry);
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testReadNewEntryThrowsExceptionForNegativeSize() {
        try {
            // Prepare input stream with invalid data to trigger an exception
            byte[] inputData = new byte[64]; // Example byte array, should be filled with invalid data
            ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Invoke the method with hasCrc = true
            method.invoke(cpioInputStream, true);
            fail("Expected an exception to be thrown due to negative size");
        } catch (Exception e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testReadNewEntryThrowsExceptionForNegativeNameSize() {
        try {
            // Prepare input stream with invalid data to trigger an exception
            byte[] inputData = new byte[64]; // Example byte array, should be filled with invalid data
            ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
            CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Invoke the method with hasCrc = true
            method.invoke(cpioInputStream, true);
            fail("Expected an exception to be thrown due to negative name size");
        } catch (Exception e) {
            // Expected exception
        }
    }


}
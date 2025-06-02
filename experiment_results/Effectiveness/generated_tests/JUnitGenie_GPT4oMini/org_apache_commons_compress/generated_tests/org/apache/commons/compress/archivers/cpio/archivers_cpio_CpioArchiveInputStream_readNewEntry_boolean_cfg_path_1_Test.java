package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class archivers_cpio_CpioArchiveInputStream_readNewEntry_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReadNewEntryWithValidInputs() {
        // Prepare the input stream with valid data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[1024]); // Example byte array
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);
        
        try {
            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, true);

            // Assertions to ensure the method executed correctly
            assertNotNull(entry);
            // Additional asserts on entry can be added here if needed
            
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        } 
    }

    @Test(timeout = 4000)
    public void testReadNewEntryThrowsExceptionForNegativeSize() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[1024]); // Example byte array
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

        try {
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);
            
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, true);
            entry.setSize(-1); // Set illegal size to trigger the exception
            // Invoke the method again to trigger the exception
            method.invoke(cpioInputStream, true);
            fail("IOException expected for negative size");
        } catch (Exception e) {
            if (e.getCause() instanceof IOException) {
                assertEquals("Found illegal entry with negative length", e.getCause().getMessage());
            } else {
                fail("Unexpected exception: " + e.getMessage());
            }
        }
    }

    @Test(timeout = 4000)
    public void testReadNewEntryThrowsExceptionForNegativeNameLength() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[1024]); // Example byte array
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);

        try {
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);
            
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream, true);
            entry.setChksum(1); // Dummy value
            entry.setSize(0); // Ensure valid size
            // Set the headerPadCount directly to simulate a mismatch
            entry.setRemoteDeviceMaj(-1); // Invalid to trigger exception
            // Invoke the method again to trigger the exception
            method.invoke(cpioInputStream, true);
            fail("IOException expected for negative name length");
        } catch (Exception e) {
            if (e.getCause() instanceof IOException) {
                assertEquals("Header pad count mismatch.", e.getCause().getMessage());
            } else {
                fail("Unexpected exception: " + e.getMessage());
            }
        }
    }

}
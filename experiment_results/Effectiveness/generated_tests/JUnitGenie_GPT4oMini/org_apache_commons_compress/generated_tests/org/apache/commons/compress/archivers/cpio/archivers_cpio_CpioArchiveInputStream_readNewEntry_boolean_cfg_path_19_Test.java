package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class archivers_cpio_CpioArchiveInputStream_readNewEntry_boolean_cfg_path_19_Test {

    @Test(timeout = 4000)
    public void testReadNewEntryWithCrc() {
        try {
            // Arrange
            byte[] input = new byte[256]; // Example input, adjust as needed
            ByteArrayInputStream bis = new ByteArrayInputStream(input);
            CpioArchiveInputStream archiveInputStream = new CpioArchiveInputStream(bis);
            Class<?> clazz = CpioArchiveInputStream.class;

            // Access the private method using reflection
            Method method = clazz.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);
            
            // Act
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(archiveInputStream, true);

            // Assert - Check properties of the entry as needed
            assertNotNull(entry);
            // Further asserts can be added based on what the input is supposed to create.
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testReadNewEntryNegativeSize() {
        try {
            // Arrange - setup input that will cause negative size exception
            byte[] input = new byte[256]; // Adjust as needed
            ByteArrayInputStream bis = new ByteArrayInputStream(input);
            CpioArchiveInputStream archiveInputStream = new CpioArchiveInputStream(bis);
            Class<?> clazz = CpioArchiveInputStream.class;

            // Access the private method using reflection
            Method method = clazz.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);
            
            // Act
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(archiveInputStream, false);
        } catch (Exception e) {
            // Assert - Check that the expected exception is thrown
            assertEquals("Found illegal entry with negative length", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testReadNewEntryNegativeNameSize() {
        try {
            // Arrange - setup input that will cause negative name size exception
            byte[] input = new byte[256]; // Adjust as needed
            ByteArrayInputStream bis = new ByteArrayInputStream(input);
            CpioArchiveInputStream archiveInputStream = new CpioArchiveInputStream(bis);
            Class<?> clazz = CpioArchiveInputStream.class;

            // Access the private method using reflection
            Method method = clazz.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);
            
            // Act
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(archiveInputStream, true);
        } catch (Exception e) {
            // Assert - Check that the expected exception is thrown
            assertEquals("Found illegal entry with negative name length", e.getMessage());
        }
    }


}
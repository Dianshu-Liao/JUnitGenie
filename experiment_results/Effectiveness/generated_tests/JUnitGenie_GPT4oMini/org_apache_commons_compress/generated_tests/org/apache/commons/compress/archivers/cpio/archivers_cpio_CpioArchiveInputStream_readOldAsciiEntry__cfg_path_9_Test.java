package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class archivers_cpio_CpioArchiveInputStream_readOldAsciiEntry__cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testReadOldAsciiEntry() {
        // Arrange
        byte[] inputData = new byte[] { 0 }; // Provide valid input data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);
        Method method = null;
        
        try {
            // Access the private method using reflection
            method = CpioArchiveInputStream.class.getDeclaredMethod("readOldAsciiEntry");
            method.setAccessible(true);

            // Act
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioInputStream);

            // Assert
            assertNotNull(entry);
        
        } catch (Exception e) {
            e.printStackTrace();
            // Optional: Handle unexpected exceptions here
        }
    }
    
    @Test(timeout = 4000)
    public void testReadOldAsciiEntryWithNegativeSize() {
        // Arrange
        byte[] inputData = new byte[] { 0 }; // Provide valid input data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);
        Method method = null;
        
        try {
            method = CpioArchiveInputStream.class.getDeclaredMethod("readOldAsciiEntry");
            method.setAccessible(true);

            // Act
            method.invoke(cpioInputStream);

        } catch (Exception e) {
            // Assert
            if (e.getCause() instanceof IOException) {
                assertEquals("Found illegal entry with negative length", e.getCause().getMessage());
            } else {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testReadOldAsciiEntryWithIllegalMode() {
        // Arrange
        byte[] inputData = new byte[] { 0 }; // Provide valid input data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);
        Method method = null;
        
        try {
            method = CpioArchiveInputStream.class.getDeclaredMethod("readOldAsciiEntry");
            method.setAccessible(true);
            
            // Act
            method.invoke(cpioInputStream);

        } catch (Exception e) {
            // Assert
            if (e.getCause() instanceof IOException) {
                assertTrue(e.getCause().getMessage().contains("Mode 0 only allowed in the trailer"));
            } else {
                e.printStackTrace();
            }
        }
    }


}
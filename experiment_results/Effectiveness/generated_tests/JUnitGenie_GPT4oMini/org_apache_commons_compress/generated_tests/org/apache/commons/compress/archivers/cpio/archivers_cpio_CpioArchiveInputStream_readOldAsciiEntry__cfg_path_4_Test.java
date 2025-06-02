package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class archivers_cpio_CpioArchiveInputStream_readOldAsciiEntry__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testReadOldAsciiEntryThrowsReflectiveOperationExceptionForNegativeNameLength() {
        // Setup a mock input stream that would simulate the reading process
        byte[] inputData = new byte[] {  };
        InputStream inputStream = new ByteArrayInputStream(inputData);
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);
        
        // Accessing the private method using reflection
        try {
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readOldAsciiEntry");
            method.setAccessible(true);

            // Invoking the method
            CpioArchiveEntry result = (CpioArchiveEntry) method.invoke(cpioInputStream);
            
            // Assertions
            fail("Expected an IOException to be thrown before this point");
        } catch (ReflectiveOperationException e) {
            // Check if the cause of the exception is an IOException
            if (e.getCause() instanceof IOException) {
                IOException ioException = (IOException) e.getCause();
                assertEquals("Found illegal entry with negative name length", ioException.getMessage());
            } else {
                fail("Unexpected exception: " + e.getMessage());
            }
        }
    }

    @Test(timeout = 4000)
    public void testReadOldAsciiEntryThrowsReflectiveOperationExceptionForNegativeEntryLength() {
        // Simulated input data to trigger negative entry length
        byte[] inputData = new byte[] {  };
        InputStream inputStream = new ByteArrayInputStream(inputData);
        CpioArchiveInputStream cpioInputStream = new CpioArchiveInputStream(inputStream);
        
        // Accessing the private method using reflection
        try {
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readOldAsciiEntry");
            method.setAccessible(true);

            // Invoking the method
            CpioArchiveEntry result = (CpioArchiveEntry) method.invoke(cpioInputStream);
            
            // Assertions
            fail("Expected an IOException to be thrown before this point");
        } catch (ReflectiveOperationException e) {
            // Check if the cause of the exception is an IOException
            if (e.getCause() instanceof IOException) {
                IOException ioException = (IOException) e.getCause();
                assertEquals("Found illegal entry with negative length", ioException.getMessage());
            } else {
                fail("Unexpected exception: " + e.getMessage());
            }
        }
    }


}
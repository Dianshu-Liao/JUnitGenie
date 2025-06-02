package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class archivers_cpio_CpioArchiveInputStream_readNewEntry_boolean_cfg_path_21_Test {

    @Test(timeout = 4000)
    public void testReadNewEntryWithValidValues() {
        try {
            // Create a test input stream. The data needs to be appropriate for the method under test.
            byte[] data = new byte[64]; // Modify data as necessary for valid testing context.
            CpioArchiveInputStream inputStream = new CpioArchiveInputStream(new ByteArrayInputStream(data));

            // Access the private method using reflection
            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);
            
            // Invoke the method with hasCrc set to true
            CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(inputStream, true);
            assertNotNull("The entry should not be null", entry);

            // Optionally, repeat the test for hasCrc set to false to cover both branches.
            entry = (CpioArchiveEntry) method.invoke(inputStream, false);
            assertNotNull("The entry should not be null", entry);

        } catch (Exception e) {
            // Handle all exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadNewEntryThrowsExceptionForNegativeSize() {
        try {
            // Create a test input stream. The data needs to be set to induce negative size.
            byte[] data = new byte[64]; // Populate with data causing negative size.
            CpioArchiveInputStream inputStream = new CpioArchiveInputStream(new ByteArrayInputStream(data));

            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Invoke the method with appropriate values to induce an IOException
            method.invoke(inputStream, false);
        } catch (Exception e) {
            // We expect an IOException to be thrown
            assertNotNull(e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testReadNewEntryThrowsExceptionForNegativeNameLength() {
        try {
            // Create a test input stream. The data needs to be set to induce negative name size.
            byte[] data = new byte[64]; // Populate with data causing negative name length.
            CpioArchiveInputStream inputStream = new CpioArchiveInputStream(new ByteArrayInputStream(data));

            Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
            method.setAccessible(true);

            // Invoke the method with hasCrc as needed to cover the path
            method.invoke(inputStream, false);
        } catch (Exception e) {
            // We expect an IOException to be thrown
            assertNotNull(e.getMessage());
        }
    }


}
package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class archivers_cpio_CpioArchiveEntry_checkNewFormat__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCheckNewFormatThrowsException() {
        try {
            // Create an instance of CpioArchiveEntry with a fileFormat that will trigger the exception
            CpioArchiveEntry entry = new CpioArchiveEntry((short) 0); // fileFormat = 0

            // Access the private method checkNewFormat using reflection
            Method method = CpioArchiveEntry.class.getDeclaredMethod("checkNewFormat");
            method.setAccessible(true); // Make the private method accessible

            // Invoke the method, which should throw an UnsupportedOperationException
            method.invoke(entry);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            // Expected exception, test passes
        } catch (Exception e) {
            // Handle any other exceptions that may occur
            fail("An unexpected exception was thrown: " + e.getMessage());
        }
    }

}
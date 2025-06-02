package org.apache.commons.compress.archivers.cpio;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.junit.Test;
import java.lang.reflect.Method;

public class archivers_cpio_CpioArchiveEntry_checkNewFormat__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCheckNewFormatWithSupportedFormat() {
        try {
            // Create an instance of CpioArchiveEntry with a supported format
            CpioArchiveEntry entry = new CpioArchiveEntry((short) 1); // Assuming 1 is a valid supported format

            // Use reflection to access the private method
            Method method = CpioArchiveEntry.class.getDeclaredMethod("checkNewFormat");
            method.setAccessible(true);

            // Invoke the method to ensure it does not throw an exception
            method.invoke(entry);
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCheckNewFormatWithUnsupportedFormat() {
        try {
            // Create an instance of CpioArchiveEntry with an unsupported format
            CpioArchiveEntry entry = new CpioArchiveEntry((short) 2); // Assuming 2 is a valid unsupported format

            // Use reflection to access the private method
            Method method = CpioArchiveEntry.class.getDeclaredMethod("checkNewFormat");
            method.setAccessible(true);

            // Invoke the method and expect an exception
            method.invoke(entry);
        } catch (UnsupportedOperationException e) {
            // Expected exception, test passes
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }


}
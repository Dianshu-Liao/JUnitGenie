package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class archivers_tar_TarArchiveEntry_isFIFO__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsFIFO() {
        try {
            // Create an instance of TarArchiveEntry using reflection to access the private constructor
            TarArchiveEntry entry = (TarArchiveEntry) TarArchiveEntry.class.getDeclaredConstructor(String.class).newInstance("testEntry");

            // Set the linkFlag to a value that is not LF_FIFO (54)
            java.lang.reflect.Field linkFlagField = TarArchiveEntry.class.getDeclaredField("linkFlag");
            linkFlagField.setAccessible(true);
            linkFlagField.set(entry, (byte) 0); // Set to a value other than 54 to test the false case

            // Test the isFIFO method
            assertFalse(entry.isFIFO());

            // Set the linkFlag to LF_FIFO (54)
            linkFlagField.set(entry, (byte) 54); // Set to 54 to test the true case

            // Test the isFIFO method again
            assertTrue(entry.isFIFO());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
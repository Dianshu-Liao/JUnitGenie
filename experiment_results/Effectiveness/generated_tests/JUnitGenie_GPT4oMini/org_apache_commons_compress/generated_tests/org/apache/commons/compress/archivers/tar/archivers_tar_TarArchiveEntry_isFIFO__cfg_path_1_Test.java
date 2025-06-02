package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import java.lang.reflect.Field;

public class archivers_tar_TarArchiveEntry_isFIFO__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsFIFO_WhenLinkFlagIsNotFIFO_ReturnsFalse() {
        try {
            // Instantiate a TarArchiveEntry object using one of the constructors
            TarArchiveEntry entry = new TarArchiveEntry("sample.txt");
            
            // Use reflection to set the private field linkFlag to a value that is not LF_FIFO (54)
            Field linkFlagField = TarArchiveEntry.class.getDeclaredField("linkFlag");
            linkFlagField.setAccessible(true);
            linkFlagField.set(entry, (byte) 0);  // set it to a value different than LF_FIFO

            // Call isFIFO and verify the result
            boolean result = entry.isFIFO();
            assertFalse(result); // Expecting false because linkFlag is not LF_FIFO
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception
        }
    }

}
package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class archivers_tar_TarArchiveEntry_isSymbolicLink__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsSymbolicLinkWhenLinkFlagIsLF_SYMLINK() {
        try {
            // Using reflection to access the private constructor
            TarArchiveEntry entry = (TarArchiveEntry) TarArchiveEntry.class.getDeclaredConstructor(String.class).newInstance("testEntry");
            // Set the linkFlag to LF_SYMLINK (50)
            java.lang.reflect.Field linkFlagField = TarArchiveEntry.class.getDeclaredField("linkFlag");
            linkFlagField.setAccessible(true);
            linkFlagField.set(entry, (byte) 50); // Assuming 50 is the value for LF_SYMLINK

            // Assert that isSymbolicLink returns true
            assertTrue(entry.isSymbolicLink());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsSymbolicLinkWhenLinkFlagIsNotLF_SYMLINK() {
        try {
            // Using reflection to access the private constructor
            TarArchiveEntry entry = (TarArchiveEntry) TarArchiveEntry.class.getDeclaredConstructor(String.class).newInstance("testEntry");
            // Set the linkFlag to a value other than LF_SYMLINK
            java.lang.reflect.Field linkFlagField = TarArchiveEntry.class.getDeclaredField("linkFlag");
            linkFlagField.setAccessible(true);
            linkFlagField.set(entry, (byte) 1); // Setting to a value that is not LF_SYMLINK

            // Assert that isSymbolicLink returns false
            assertFalse(entry.isSymbolicLink());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
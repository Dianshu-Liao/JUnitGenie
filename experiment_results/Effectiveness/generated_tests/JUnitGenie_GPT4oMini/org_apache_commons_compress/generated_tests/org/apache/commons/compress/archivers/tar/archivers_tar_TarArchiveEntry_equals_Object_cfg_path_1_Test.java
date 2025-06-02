package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class archivers_tar_TarArchiveEntry_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        TarArchiveEntry entry = new TarArchiveEntry("test.txt");
        assertFalse(entry.equals(null)); // Testing with null
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        TarArchiveEntry entry = new TarArchiveEntry("test.txt");
        String differentClassObject = "Not a TarArchiveEntry";
        assertFalse(entry.equals(differentClassObject)); // Testing with a different class
    }

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        TarArchiveEntry entry = new TarArchiveEntry("test.txt");
        assertTrue(entry.equals(entry)); // Testing with the same object
    }

    @Test(timeout = 4000)
    public void testEquals_EqualEntries() {
        TarArchiveEntry entry1 = new TarArchiveEntry("test.txt");
        TarArchiveEntry entry2 = new TarArchiveEntry("test.txt");
        assertTrue(entry1.equals(entry2)); // Testing with equal entries
    }

    @Test(timeout = 4000)
    public void testEquals_NonEqualEntries() {
        TarArchiveEntry entry1 = new TarArchiveEntry("test1.txt");
        TarArchiveEntry entry2 = new TarArchiveEntry("test2.txt");
        assertFalse(entry1.equals(entry2)); // Testing with non-equal entries
    }

}
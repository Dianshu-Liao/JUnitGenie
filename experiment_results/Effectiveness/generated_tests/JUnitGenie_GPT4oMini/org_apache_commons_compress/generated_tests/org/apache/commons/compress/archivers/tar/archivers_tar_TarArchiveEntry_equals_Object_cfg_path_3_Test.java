package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class archivers_tar_TarArchiveEntry_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNullInput() {
        TarArchiveEntry entry = new TarArchiveEntry("sample.txt");
        try {
            boolean result = entry.equals(null);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 4000)
    public void testEqualsWithDifferentClass() {
        TarArchiveEntry entry = new TarArchiveEntry("sample.txt");
        Object notATarArchiveEntry = new Object();
        try {
            boolean result = entry.equals(notATarArchiveEntry);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
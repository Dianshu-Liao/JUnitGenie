package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveStructSparse;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class archivers_tar_TarArchiveStructSparse_equals_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        TarArchiveStructSparse tar1 = new TarArchiveStructSparse(100L, 200L);
        assertTrue(tar1.equals(tar1));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        TarArchiveStructSparse tar1 = new TarArchiveStructSparse(100L, 200L);
        assertFalse(tar1.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        TarArchiveStructSparse tar1 = new TarArchiveStructSparse(100L, 200L);
        String differentClassObject = "Not a TarArchiveStructSparse";
        assertFalse(tar1.equals(differentClassObject));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentValues() {
        TarArchiveStructSparse tar1 = new TarArchiveStructSparse(100L, 200L);
        TarArchiveStructSparse tar2 = new TarArchiveStructSparse(150L, 250L);
        assertFalse(tar1.equals(tar2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameValues() {
        TarArchiveStructSparse tar1 = new TarArchiveStructSparse(100L, 200L);
        TarArchiveStructSparse tar2 = new TarArchiveStructSparse(100L, 200L);
        assertTrue(tar1.equals(tar2));
    }

}
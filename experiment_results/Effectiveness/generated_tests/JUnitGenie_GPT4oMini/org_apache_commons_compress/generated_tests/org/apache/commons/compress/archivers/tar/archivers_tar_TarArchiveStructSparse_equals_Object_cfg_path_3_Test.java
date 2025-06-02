package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveStructSparse;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class archivers_tar_TarArchiveStructSparse_equals_Object_cfg_path_3_Test {

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
        String notATar = "Not a TarArchiveStructSparse";
        assertFalse(tar1.equals(notATar));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualObjects() {
        TarArchiveStructSparse tar1 = new TarArchiveStructSparse(100L, 200L);
        TarArchiveStructSparse tar2 = new TarArchiveStructSparse(100L, 200L);
        assertTrue(tar1.equals(tar2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentOffsets() {
        TarArchiveStructSparse tar1 = new TarArchiveStructSparse(100L, 200L);
        TarArchiveStructSparse tar2 = new TarArchiveStructSparse(101L, 200L);
        assertFalse(tar1.equals(tar2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentNumbytes() {
        TarArchiveStructSparse tar1 = new TarArchiveStructSparse(100L, 200L);
        TarArchiveStructSparse tar2 = new TarArchiveStructSparse(100L, 201L);
        assertFalse(tar1.equals(tar2));
    }

}
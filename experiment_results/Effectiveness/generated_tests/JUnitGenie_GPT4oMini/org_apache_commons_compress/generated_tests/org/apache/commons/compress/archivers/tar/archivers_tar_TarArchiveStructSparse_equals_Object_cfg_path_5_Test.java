package org.apache.commons.compress.archivers.tar;
import org.apache.commons.compress.archivers.tar.TarArchiveStructSparse;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class archivers_tar_TarArchiveStructSparse_equals_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        TarArchiveStructSparse instance = new TarArchiveStructSparse(10L, 20L);
        Object nullObject = null;

        try {
            boolean result = instance.equals(nullObject);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}
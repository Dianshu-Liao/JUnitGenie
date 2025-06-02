package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipMethod;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class archivers_zip_ZipMethod_isZstd_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsZstdWithZSTD() {
        int method = ZipMethod.ZSTD.getCode();
        boolean result = ZipMethod.isZstd(method);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsZstdWithZSTD_DEPRECATED() {
        int method = ZipMethod.ZSTD_DEPRECATED.getCode();
        boolean result = ZipMethod.isZstd(method);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsZstdWithInvalidMethod() {
        int method = 99; // An arbitrary value not equal to ZSTD or ZSTD_DEPRECATED
        boolean result = ZipMethod.isZstd(method);
        assertFalse(result);
    }


}
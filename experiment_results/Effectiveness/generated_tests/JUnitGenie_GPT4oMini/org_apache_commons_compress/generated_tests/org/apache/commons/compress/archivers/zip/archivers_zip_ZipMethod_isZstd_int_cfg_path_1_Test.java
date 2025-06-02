package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipMethod;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_zip_ZipMethod_isZstd_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsZstd_TrueForZSTD() {
        int method = ZipMethod.ZSTD.getCode();
        boolean result = ZipMethod.isZstd(method);
        assertTrue(result); // Expected to return true for ZSTD code
    }

    @Test(timeout = 4000)
    public void testIsZstd_TrueForZSTDDeprecated() {
        int method = ZipMethod.ZSTD_DEPRECATED.getCode();
        boolean result = ZipMethod.isZstd(method);
        assertTrue(result); // Expected to return true for ZSTD_DEPRECATED code
    }

    @Test(timeout = 4000)
    public void testIsZstd_FalseForOtherCode() {
        int method = 99; // An arbitrary method code not matching ZSTD or ZSTD_DEPRECATED
        boolean result = ZipMethod.isZstd(method);
        assertFalse(result); // Expected to return false for non-matching code
    }

    @Test(timeout = 4000)
    public void testIsZstd_FalseForNegativeCode() {
        int method = -1; // A negative method code
        boolean result = ZipMethod.isZstd(method);
        assertFalse(result); // Expected to return false for negative method code
    }


}
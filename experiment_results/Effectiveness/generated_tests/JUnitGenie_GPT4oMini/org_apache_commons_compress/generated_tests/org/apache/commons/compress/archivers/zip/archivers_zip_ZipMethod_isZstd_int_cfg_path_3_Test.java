package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipMethod;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class archivers_zip_ZipMethod_isZstd_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsZstd() {
        try {
            ZipMethod zipMethod = ZipMethod.ZSTD; // Creates an instance of ZSTD
            int method = zipMethod.getCode(); // Gets the code from the ZSTD instance
            
            // Test that isZstd returns true for the ZSTD method
            assertTrue(zipMethod.isZstd(method));
        } catch (Exception e) {
            // Handle any potential exceptions
            e.printStackTrace();
        }
    }

}
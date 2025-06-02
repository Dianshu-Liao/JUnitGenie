package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class archivers_zip_ZipEightByteInteger_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEqualsWithSameValue() {
        ZipEightByteInteger zip1 = new ZipEightByteInteger(12345678L);
        ZipEightByteInteger zip2 = new ZipEightByteInteger(12345678L);
        assertTrue(zip1.equals(zip2));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentValue() {
        ZipEightByteInteger zip1 = new ZipEightByteInteger(12345678L);
        ZipEightByteInteger zip2 = new ZipEightByteInteger(87654321L);
        assertFalse(zip1.equals(zip2));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentType() {
        ZipEightByteInteger zip = new ZipEightByteInteger(12345678L);
        String notAZip = "Not a ZipEightByteInteger";
        assertFalse(zip.equals(notAZip));
    }

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        ZipEightByteInteger zip = new ZipEightByteInteger(12345678L);
        assertFalse(zip.equals(null));
    }

}
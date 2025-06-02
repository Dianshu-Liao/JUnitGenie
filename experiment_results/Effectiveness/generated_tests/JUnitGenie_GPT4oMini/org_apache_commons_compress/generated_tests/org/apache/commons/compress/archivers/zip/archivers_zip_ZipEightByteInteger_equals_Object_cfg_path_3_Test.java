package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class archivers_zip_ZipEightByteInteger_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNonZipEightByteInteger() {
        ZipEightByteInteger zipInteger = new ZipEightByteInteger(123L);
        Object nonZipInteger = new Object(); // Non-ZipEightByteInteger object

        // Testing the equals method with a non-ZipEightByteInteger instance
        try {
            assertFalse(zipInteger.equals(nonZipInteger));
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}
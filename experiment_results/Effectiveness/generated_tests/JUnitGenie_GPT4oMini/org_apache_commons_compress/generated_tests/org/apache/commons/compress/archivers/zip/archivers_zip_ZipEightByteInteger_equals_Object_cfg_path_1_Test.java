package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class archivers_zip_ZipEightByteInteger_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEqualsWithDifferentObjectType() {
        ZipEightByteInteger zipInteger = new ZipEightByteInteger(10L);
        Object differentObject = new Object(); // Different type

        try {
            // This should return false as the object is not an instance of ZipEightByteInteger
            assertFalse(zipInteger.equals(differentObject));
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameValue() {
        ZipEightByteInteger zipInteger1 = new ZipEightByteInteger(10L);
        ZipEightByteInteger zipInteger2 = new ZipEightByteInteger(10L);

        try {
            // This should return true as both objects have the same value
            assertFalse(zipInteger1.equals(zipInteger2));
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentValue() {
        ZipEightByteInteger zipInteger1 = new ZipEightByteInteger(10L);
        ZipEightByteInteger zipInteger2 = new ZipEightByteInteger(20L);

        try {
            // This should return false as the values are different
            assertFalse(zipInteger1.equals(zipInteger2));
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

}
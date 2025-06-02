package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class digest_HmacUtils_isAvailable_HmacAlgorithms_cfg_path_2_Test {


    @Test(timeout = 4000)
    public void testIsAvailableWithInvalidAlgorithm() {
        // Since HmacAlgorithms is an enum, we cannot create an instance of it.
        // Instead, we can test with a string that is not a valid algorithm.
        String invalidAlgorithm = "InvalidAlgorithm"; // Use a string to represent an invalid algorithm
        boolean result = HmacUtils.isAvailable(invalidAlgorithm); // Assuming HmacUtils can handle string input
        assertFalse(result);
    }


}

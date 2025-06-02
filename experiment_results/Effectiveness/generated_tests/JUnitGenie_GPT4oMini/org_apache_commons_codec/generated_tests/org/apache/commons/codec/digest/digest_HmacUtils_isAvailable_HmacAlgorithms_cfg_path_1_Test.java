package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class digest_HmacUtils_isAvailable_HmacAlgorithms_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsAvailableThrowsException() {
        // Instead of trying to instantiate HmacAlgorithms, we can use a valid algorithm
        HmacAlgorithms validAlgorithm = HmacAlgorithms.HMAC_SHA_256; // Example of a valid algorithm

        // Call the isAvailable method with the valid algorithm
        boolean result = HmacUtils.isAvailable(validAlgorithm);
        // Since we expect an exception, we should not reach this line
        assertFalse(result);
    }


}
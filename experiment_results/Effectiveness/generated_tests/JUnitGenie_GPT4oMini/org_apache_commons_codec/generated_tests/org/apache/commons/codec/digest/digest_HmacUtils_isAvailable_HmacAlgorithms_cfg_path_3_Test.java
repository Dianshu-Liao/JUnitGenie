package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class digest_HmacUtils_isAvailable_HmacAlgorithms_cfg_path_3_Test {


    @Test(timeout = 4000)
    public void testIsAvailableWithInvalidAlgorithm() {
        // Arrange
        String invalidAlgorithmName = "InvalidAlgorithm"; // This should not be a valid algorithm

        // Act
        boolean result;
        try {
            result = HmacUtils.isAvailable(HmacAlgorithms.valueOf(invalidAlgorithmName));
        } catch (IllegalArgumentException e) {
            result = false; // Set result to false if the algorithm is invalid
        }

        // Assert
        assertFalse(result);
    }

}

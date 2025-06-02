package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_getJaroWinklerDistance_CharSequence_CharSequence_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetJaroWinklerDistance() {
        // Test case 1: Normal case
        CharSequence first = "hello";
        CharSequence second = "hallo";
        double expected = 0.933; // Expected value based on the Jaro-Winkler distance calculation
        double result = StringUtils.getJaroWinklerDistance(first, second);
        assertEquals(expected, result, 0.001);

        // Test case 2: One string is empty
        first = "hello";
        second = "";
        expected = 0.0; // Expected value when one string is empty
        result = StringUtils.getJaroWinklerDistance(first, second);
        assertEquals(expected, result, 0.001);

        // Test case 3: Both strings are null (should throw IllegalArgumentException)
        try {
            StringUtils.getJaroWinklerDistance(null, null);
        } catch (IllegalArgumentException e) {
            assertEquals("Strings must not be null", e.getMessage());
        }

        // Test case 4: Both strings are the same
        first = "test";
        second = "test";
        expected = 1.0; // Expected value when both strings are identical
        result = StringUtils.getJaroWinklerDistance(first, second);
        assertEquals(expected, result, 0.001);
    }

}
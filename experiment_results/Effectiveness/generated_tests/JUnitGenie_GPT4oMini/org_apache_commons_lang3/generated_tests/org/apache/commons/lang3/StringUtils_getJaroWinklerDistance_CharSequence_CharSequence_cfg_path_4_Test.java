package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_getJaroWinklerDistance_CharSequence_CharSequence_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetJaroWinklerDistance() {
        // Test case for two non-null strings
        CharSequence first = "hello";
        CharSequence second = "hallo";
        double expectedDistance = 0.933; // Expected value based on the Jaro-Winkler algorithm
        double actualDistance = StringUtils.getJaroWinklerDistance(first, second);
        assertEquals(expectedDistance, actualDistance, 0.001);
    }

    @Test(timeout = 4000)
    public void testGetJaroWinklerDistanceWithNullFirst() {
        // Test case for first string being null
        try {
            StringUtils.getJaroWinklerDistance(null, "test");
        } catch (IllegalArgumentException e) {
            assertEquals("Strings must not be null", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetJaroWinklerDistanceWithNullSecond() {
        // Test case for second string being null
        try {
            StringUtils.getJaroWinklerDistance("test", null);
        } catch (IllegalArgumentException e) {
            assertEquals("Strings must not be null", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetJaroWinklerDistanceWithBothNull() {
        // Test case for both strings being null
        try {
            StringUtils.getJaroWinklerDistance(null, null);
        } catch (IllegalArgumentException e) {
            assertEquals("Strings must not be null", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetJaroWinklerDistanceWithNoMatches() {
        // Test case for strings with no matches
        CharSequence first = "abc";
        CharSequence second = "xyz";
        double expectedDistance = 0.0; // Expected value when there are no matches
        double actualDistance = StringUtils.getJaroWinklerDistance(first, second);
        assertEquals(expectedDistance, actualDistance, 0.001);
    }

}
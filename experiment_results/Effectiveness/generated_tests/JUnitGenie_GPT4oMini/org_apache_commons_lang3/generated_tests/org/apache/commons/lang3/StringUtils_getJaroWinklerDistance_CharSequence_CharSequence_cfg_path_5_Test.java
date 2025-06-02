package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_getJaroWinklerDistance_CharSequence_CharSequence_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetJaroWinklerDistance() {
        // Test case where both strings are non-null and have some matches
        CharSequence first = "hello";
        CharSequence second = "hallo";
        double expectedDistance = 0.933; // Expected value based on the Jaro-Winkler algorithm
        double actualDistance = StringUtils.getJaroWinklerDistance(first, second);
        assertEquals(expectedDistance, actualDistance, 0.001);
    }

    @Test(timeout = 4000)
    public void testGetJaroWinklerDistanceWithNullFirst() {
        // Test case where the first string is null
        CharSequence first = null;
        CharSequence second = "hallo";
        try {
            StringUtils.getJaroWinklerDistance(first, second);
        } catch (IllegalArgumentException e) {
            assertEquals("Strings must not be null", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetJaroWinklerDistanceWithNullSecond() {
        // Test case where the second string is null
        CharSequence first = "hello";
        CharSequence second = null;
        try {
            StringUtils.getJaroWinklerDistance(first, second);
        } catch (IllegalArgumentException e) {
            assertEquals("Strings must not be null", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetJaroWinklerDistanceWithNoMatches() {
        // Test case where there are no matches
        CharSequence first = "abc";
        CharSequence second = "xyz";
        double expectedDistance = 0.0; // Expected value when there are no matches
        double actualDistance = StringUtils.getJaroWinklerDistance(first, second);
        assertEquals(expectedDistance, actualDistance, 0.001);
    }

}
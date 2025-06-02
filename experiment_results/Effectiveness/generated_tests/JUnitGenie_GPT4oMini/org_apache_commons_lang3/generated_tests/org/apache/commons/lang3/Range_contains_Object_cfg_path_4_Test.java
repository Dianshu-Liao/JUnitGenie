package org.apache.commons.lang3;
import org.apache.commons.lang3.Range;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class Range_contains_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testContainsWithNullElement() {
        // Arrange
        Range<Integer> range = new Range<>(1, 10, Integer::compareTo);
        Integer element = null; // Change Object to Integer

        // Act
        boolean result;
        try {
            result = range.contains(element);
        } catch (Exception e) {
            // Handle exception if thrown
            throw new RuntimeException("Exception thrown during test execution", e);
        }

        // Assert
        assertFalse(result);
    }


}
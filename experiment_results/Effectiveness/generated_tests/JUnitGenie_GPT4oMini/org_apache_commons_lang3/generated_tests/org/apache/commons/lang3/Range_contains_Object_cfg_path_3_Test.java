package org.apache.commons.lang3;
import org.apache.commons.lang3.Range;
import org.junit.Test;
import java.util.Comparator;
import static org.junit.Assert.assertFalse;

public class Range_contains_Object_cfg_path_3_Test {

    private static class TestComparator implements Comparator<Object> {
        @Override
        public int compare(Object o1, Object o2) {
            // Simple comparison logic for testing
            return o1.toString().compareTo(o2.toString());
        }
    }

    @Test(timeout = 4000)
    public void testContainsWithElementLessThanMinimum() {
        // Arrange
        Range<Object> range = new Range<>(1, 10, new TestComparator());
        Object element = 0; // Element is less than minimum (1)

        // Act
        boolean result = range.contains(element);

        // Assert
        assertFalse(result);
    }

}
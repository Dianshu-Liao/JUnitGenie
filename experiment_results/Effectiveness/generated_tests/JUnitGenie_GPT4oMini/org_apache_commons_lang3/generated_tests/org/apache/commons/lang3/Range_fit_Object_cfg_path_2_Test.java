package org.apache.commons.lang3;
import org.apache.commons.lang3.Range;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Range_fit_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFitElementIsBetweenMinimumAndMaximum() {
        // Arrange
        Integer minimum = 1;
        Integer maximum = 10;
        Range<Integer> range = Range.between(minimum, maximum, Integer::compareTo);
        Integer element = 5; // Element is between minimum and maximum

        // Act
        Integer result = range.fit(element);

        // Assert
        assertEquals(element, result);
    }

    @Test(timeout = 4000)
    public void testFitElementIsMinimum() {
        // Arrange
        Integer minimum = 1;
        Integer maximum = 10;
        Range<Integer> range = Range.between(minimum, maximum, Integer::compareTo);
        Integer element = 1; // Element is minimum

        // Act
        Integer result = range.fit(element);

        // Assert
        assertEquals(element, result);
    }

    @Test(timeout = 4000)
    public void testFitElementIsMaximum() {
        // Arrange
        Integer minimum = 1;
        Integer maximum = 10;
        Range<Integer> range = Range.between(minimum, maximum, Integer::compareTo);
        Integer element = 10; // Element is maximum

        // Act
        Integer result = range.fit(element);

        // Assert
        assertEquals(element, result);
    }

    @Test(timeout = 4000)
    public void testFitElementIsAfterRange() {
        // Arrange
        Integer minimum = 1;
        Integer maximum = 10;
        Range<Integer> range = Range.between(minimum, maximum, Integer::compareTo);
        Integer element = 15; // Element is after maximum

        // Act
        Integer result = range.fit(element);

        // Assert
        assertEquals(minimum, result); // Should return minimum
    }

    @Test(timeout = 4000)
    public void testFitElementIsBeforeRange() {
        // Arrange
        Integer minimum = 1;
        Integer maximum = 10;
        Range<Integer> range = Range.between(minimum, maximum, Integer::compareTo);
        Integer element = -5; // Element is before minimum

        // Act
        Integer result = range.fit(element);

        // Assert
        assertEquals(maximum, result); // Should return maximum
    }

    @Test(expected = NullPointerException.class)
    public void testFitElementIsNull() {
        // Arrange
        Integer minimum = 1;
        Integer maximum = 10;
        Range<Integer> range = Range.between(minimum, maximum, Integer::compareTo);
        Integer element = null; // Element is null

        // Act
        range.fit(element); // This should throw NullPointerException
    }

}
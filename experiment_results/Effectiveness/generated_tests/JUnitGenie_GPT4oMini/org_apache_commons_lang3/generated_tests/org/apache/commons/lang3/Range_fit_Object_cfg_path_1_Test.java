package org.apache.commons.lang3;
import org.apache.commons.lang3.Range;
import org.junit.Test;
import static org.junit.Assert.*;

public class Range_fit_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testFitWithValidElement() {
        // Arrange
        Range<Integer> range = new Range<>(1, 10, Integer::compareTo);
        Integer element = 5; // This should be within the range

        // Act
        Integer result = range.fit(element);

        // Assert
        assertEquals(element, result);
    }

    @Test(timeout = 4000)
    public void testFitWithElementAfterRange() {
        // Arrange
        Range<Integer> range = new Range<>(1, 10, Integer::compareTo);
        Integer element = 15; // This is after the range

        // Act
        Integer result = range.fit(element);

        // Assert
        assertEquals(range.getMaximum(), result); // Use getter method instead of direct access
    }

    @Test(timeout = 4000)
    public void testFitWithElementBeforeRange() {
        // Arrange
        Range<Integer> range = new Range<>(1, 10, Integer::compareTo);
        Integer element = -5; // This is before the range

        // Act
        Integer result = range.fit(element);

        // Assert
        assertEquals(range.getMaximum(), result); // Use getter method instead of direct access
    }

    @Test(expected = NullPointerException.class)
    public void testFitWithNullElement() {
        // Arrange
        Range<Integer> range = new Range<>(1, 10, Integer::compareTo);
        
        // Act
        range.fit(null); // This should throw NullPointerException
    }


}
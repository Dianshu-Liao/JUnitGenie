package org.apache.commons.lang3;
import org.apache.commons.lang3.Range;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Range_fit_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testFitWhenElementIsAfterMinimum() {
        // Arrange
        Integer minimum = 5;
        Integer maximum = 10;
        Range<Integer> range = Range.between(minimum, maximum);
        Integer element = 6; // element is after minimum

        // Act
        Integer result = range.fit(element);

        // Assert
        assertEquals(element, result);
    }

    @Test(expected = NullPointerException.class)
    public void testFitWhenElementIsNull() {
        // Arrange
        Range<Integer> range = Range.between(5, 10);
        Integer element = null; // element is null

        // Act
        range.fit(element); // This should throw NullPointerException
    }

}
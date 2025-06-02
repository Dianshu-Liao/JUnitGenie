package org.joda.time;
import org.joda.time.DateTimeComparator;
import org.joda.time.DateTimeFieldType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTimeComparator_toString__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToStringWithNonNullLimits() {
        try {
            // Create instances of DateTimeFieldType with valid names
            DateTimeFieldType lowerLimit = DateTimeFieldType.year(); // Example of a valid DateTimeFieldType
            DateTimeFieldType upperLimit = DateTimeFieldType.monthOfYear(); // Example of a valid DateTimeFieldType

            // Use reflection to access the protected constructor
            DateTimeComparator comparator = (DateTimeComparator) DateTimeComparator.class
                    .getDeclaredConstructor(DateTimeFieldType.class, DateTimeFieldType.class)
                    .newInstance(lowerLimit, upperLimit);

            // Expected output
            String expected = "DateTimeComparator[year-monthOfYear]";
            // Assert the toString output
            assertEquals(expected, comparator.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToStringWithNullLowerLimit() {
        try {
            DateTimeFieldType upperLimit = DateTimeFieldType.monthOfYear(); // Example of a valid DateTimeFieldType

            // Use reflection to access the protected constructor
            DateTimeComparator comparator = (DateTimeComparator) DateTimeComparator.class
                    .getDeclaredConstructor(DateTimeFieldType.class, DateTimeFieldType.class)
                    .newInstance(null, upperLimit);

            // Expected output
            String expected = "DateTimeComparator[-monthOfYear]";
            // Assert the toString output
            assertEquals(expected, comparator.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToStringWithNullUpperLimit() {
        try {
            DateTimeFieldType lowerLimit = DateTimeFieldType.year(); // Example of a valid DateTimeFieldType

            // Use reflection to access the protected constructor
            DateTimeComparator comparator = (DateTimeComparator) DateTimeComparator.class
                    .getDeclaredConstructor(DateTimeFieldType.class, DateTimeFieldType.class)
                    .newInstance(lowerLimit, null);

            // Expected output
            String expected = "DateTimeComparator[year-]";
            // Assert the toString output
            assertEquals(expected, comparator.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToStringWithBothNullLimits() {
        try {
            // Use reflection to access the protected constructor
            DateTimeComparator comparator = (DateTimeComparator) DateTimeComparator.class
                    .getDeclaredConstructor(DateTimeFieldType.class, DateTimeFieldType.class)
                    .newInstance(null, null);

            // Expected output
            String expected = "DateTimeComparator[]";
            // Assert the toString output
            assertEquals(expected, comparator.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
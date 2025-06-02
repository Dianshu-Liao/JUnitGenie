package org.joda.time;
import org.joda.time.DateTimeComparator;
import org.joda.time.DateTimeFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeComparator_toString__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testToStringWithLowerAndUpperLimits() {
        try {
            // Create instances of DateTimeFieldType with valid names
            DateTimeFieldType lowerLimit = DateTimeFieldType.year(); // Example of a valid DateTimeFieldType
            DateTimeFieldType upperLimit = DateTimeFieldType.monthOfYear(); // Example of a valid DateTimeFieldType

            // Use reflection to access the protected constructor of DateTimeComparator
            DateTimeComparator comparator = (DateTimeComparator) DateTimeComparator.class
                    .getDeclaredConstructor(DateTimeFieldType.class, DateTimeFieldType.class)
                    .newInstance(lowerLimit, upperLimit);

            // Expected output
            String expected = "DateTimeComparator[year-monthOfYear]";
            // Assert the toString output
            assertEquals(expected, comparator.toString());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred during test: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testToStringWithOnlyLowerLimit() {
        try {
            // Create an instance of DateTimeFieldType with a valid name
            DateTimeFieldType lowerLimit = DateTimeFieldType.year(); // Example of a valid DateTimeFieldType

            // Use reflection to access the protected constructor of DateTimeComparator
            DateTimeComparator comparator = (DateTimeComparator) DateTimeComparator.class
                    .getDeclaredConstructor(DateTimeFieldType.class, DateTimeFieldType.class)
                    .newInstance(lowerLimit, null);

            // Expected output
            String expected = "DateTimeComparator[year]";
            // Assert the toString output
            assertEquals(expected, comparator.toString());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred during test: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testToStringWithNoLimits() {
        try {
            // Use reflection to access the protected constructor of DateTimeComparator
            DateTimeComparator comparator = (DateTimeComparator) DateTimeComparator.class
                    .getDeclaredConstructor(DateTimeFieldType.class, DateTimeFieldType.class)
                    .newInstance(null, null);

            // Expected output
            String expected = "DateTimeComparator[]";
            // Assert the toString output
            assertEquals(expected, comparator.toString());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred during test: " + e.getMessage());
        }
    }

}
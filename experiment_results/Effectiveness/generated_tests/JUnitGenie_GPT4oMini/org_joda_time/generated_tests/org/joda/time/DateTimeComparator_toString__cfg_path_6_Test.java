package org.joda.time;
import org.joda.time.DateTimeComparator;
import org.joda.time.DateTimeFieldType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTimeComparator_toString__cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testToStringWithDifferentLimits() {
        try {
            // Using reflection to access the protected constructor
            DateTimeFieldType lowerLimit = DateTimeFieldType.year();
            DateTimeFieldType upperLimit = DateTimeFieldType.monthOfYear();
            DateTimeComparator comparator = (DateTimeComparator) DateTimeComparator.class
                    .getDeclaredConstructor(DateTimeFieldType.class, DateTimeFieldType.class)
                    .newInstance(lowerLimit, upperLimit);

            String expected = "DateTimeComparator[year-monthOfYear]";
            String actual = comparator.toString();
            assertEquals(expected, actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToStringWithEqualLimits() {
        try {
            // Using reflection to access the protected constructor
            DateTimeFieldType limit = DateTimeFieldType.year();
            DateTimeComparator comparator = (DateTimeComparator) DateTimeComparator.class
                    .getDeclaredConstructor(DateTimeFieldType.class, DateTimeFieldType.class)
                    .newInstance(limit, limit);

            String expected = "DateTimeComparator[year]";
            String actual = comparator.toString();
            assertEquals(expected, actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToStringWithNullLimits() {
        try {
            // Using reflection to access the protected constructor
            DateTimeComparator comparator = (DateTimeComparator) DateTimeComparator.class
                    .getDeclaredConstructor(DateTimeFieldType.class, DateTimeFieldType.class)
                    .newInstance(null, null);

            String expected = "DateTimeComparator[]";
            String actual = comparator.toString();
            assertEquals(expected, actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
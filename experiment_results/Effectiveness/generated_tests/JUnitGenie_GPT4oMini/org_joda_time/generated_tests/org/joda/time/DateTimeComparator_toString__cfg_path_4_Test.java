package org.joda.time;
import org.joda.time.DateTimeComparator;
import org.joda.time.DateTimeFieldType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTimeComparator_toString__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testToStringWithDifferentLimits() {
        try {
            DateTimeFieldType lowerLimit = DateTimeFieldType.year();
            DateTimeFieldType upperLimit = DateTimeFieldType.monthOfYear();
            DateTimeComparator comparator = createDateTimeComparator(lowerLimit, upperLimit);
            String result = comparator.toString();
            assertEquals("DateTimeComparator[year-monthOfYear]", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToStringWithSameLimits() {
        try {
            DateTimeFieldType limit = DateTimeFieldType.dayOfMonth();
            DateTimeComparator comparator = createDateTimeComparator(limit, limit);
            String result = comparator.toString();
            assertEquals("DateTimeComparator[dayOfMonth]", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToStringWithNullLimits() {
        try {
            DateTimeComparator comparator = createDateTimeComparator(null, null);
            String result = comparator.toString();
            assertEquals("DateTimeComparator[]", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private DateTimeComparator createDateTimeComparator(DateTimeFieldType lower, DateTimeFieldType upper) throws Exception {
        // Use reflection to access the protected constructor
        java.lang.reflect.Constructor<DateTimeComparator> constructor = DateTimeComparator.class.getDeclaredConstructor(DateTimeFieldType.class, DateTimeFieldType.class);
        constructor.setAccessible(true);
        return constructor.newInstance(lower, upper);
    }

}
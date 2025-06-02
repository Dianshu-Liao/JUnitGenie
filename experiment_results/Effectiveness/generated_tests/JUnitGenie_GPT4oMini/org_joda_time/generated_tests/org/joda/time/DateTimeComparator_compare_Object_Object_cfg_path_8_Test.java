package org.joda.time;
import org.joda.time.DateTimeComparator;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.InstantConverter;
import org.joda.time.Chronology;
import org.joda.time.DateTimeFieldType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTimeComparator_compare_Object_Object_cfg_path_8_Test {

    private final DateTimeFieldType lowerLimit = DateTimeFieldType.year();
    private final DateTimeFieldType upperLimit = DateTimeFieldType.year();

    @Test(timeout = 4000)
    public void testCompareWithValidInputs() {
        DateTimeComparator comparator = new DateTimeComparator(lowerLimit, upperLimit);
        Object lhs = new java.util.Date(1000000000000L); // Example date
        Object rhs = new java.util.Date(2000000000000L); // Example date

        try {
            int result = comparator.compare(lhs, rhs);
            assertEquals(-1, result); // Should return -1 since lhs < rhs
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCompareEqualObjects() {
        DateTimeComparator comparator = new DateTimeComparator(lowerLimit, upperLimit);
        Object obj = new java.util.Date(1000000000000L);

        try {
            int result = comparator.compare(obj, obj);
            assertEquals(0, result); // Same objects should return 0
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCompareWithNull() {
        DateTimeComparator comparator = new DateTimeComparator(lowerLimit, upperLimit);

        try {
            int result = comparator.compare(null, new java.util.Date(2000000000000L));
            assertEquals(-1, result); // Null should be less than a valid date
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int result = comparator.compare(new java.util.Date(1000000000000L), null);
            assertEquals(1, result); // A valid date should be greater than null
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
package org.joda.time;
import org.joda.time.DateTimeComparator;
import org.joda.time.DateTimeFieldType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTimeComparator_toString__cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testToStringWithDifferentLimits() {
        try {
            // Create instances of DateTimeFieldType with valid names
            DateTimeFieldType lowerLimit = (DateTimeFieldType) DateTimeFieldType.class.getDeclaredConstructor().newInstance();
            DateTimeFieldType upperLimit = (DateTimeFieldType) DateTimeFieldType.class.getDeclaredConstructor().newInstance();
            
            // Use reflection to set the iLowerLimit and iUpperLimit fields
            java.lang.reflect.Field lowerField = DateTimeComparator.class.getDeclaredField("iLowerLimit");
            lowerField.setAccessible(true);
            java.lang.reflect.Field upperField = DateTimeComparator.class.getDeclaredField("iUpperLimit");
            upperField.setAccessible(true);
            
            // Create an instance of DateTimeComparator
            DateTimeComparator comparator = new DateTimeComparator(lowerLimit, upperLimit);
            lowerField.set(comparator, lowerLimit);
            upperField.set(comparator, upperLimit);
            
            // Set names for the DateTimeFieldType instances
            lowerLimit.getClass().getDeclaredField("iName").set(lowerLimit, "LowerLimitName");
            upperLimit.getClass().getDeclaredField("iName").set(upperLimit, "UpperLimitName");
            
            // Call the toString method and verify the output
            String result = comparator.toString();
            assertEquals("DateTimeComparator[LowerLimitName-UpperLimitName]", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToStringWithEqualLimits() {
        try {
            // Create an instance of DateTimeFieldType with a valid name
            DateTimeFieldType limit = (DateTimeFieldType) DateTimeFieldType.class.getDeclaredConstructor().newInstance();
            
            // Use reflection to set the iLowerLimit and iUpperLimit fields
            java.lang.reflect.Field lowerField = DateTimeComparator.class.getDeclaredField("iLowerLimit");
            lowerField.setAccessible(true);
            java.lang.reflect.Field upperField = DateTimeComparator.class.getDeclaredField("iUpperLimit");
            upperField.setAccessible(true);
            
            // Create an instance of DateTimeComparator
            DateTimeComparator comparator = new DateTimeComparator(limit, limit);
            lowerField.set(comparator, limit);
            upperField.set(comparator, limit);
            
            // Set name for the DateTimeFieldType instance
            limit.getClass().getDeclaredField("iName").set(limit, "EqualLimitName");
            
            // Call the toString method and verify the output
            String result = comparator.toString();
            assertEquals("DateTimeComparator[EqualLimitName]", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
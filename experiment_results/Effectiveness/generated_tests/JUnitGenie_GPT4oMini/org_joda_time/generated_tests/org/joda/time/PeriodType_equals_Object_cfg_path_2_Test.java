package org.joda.time;
import org.joda.time.PeriodType;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class PeriodType_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEqualsWithDifferentObjectType() {
        PeriodType periodType = new PeriodType("Test", new org.joda.time.DurationFieldType[]{}, new int[]{});
        Object differentObject = new Object(); // Different type

        try {
            // This should return false as the object is not an instance of PeriodType
            assertFalse(periodType.equals(differentObject));
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

}
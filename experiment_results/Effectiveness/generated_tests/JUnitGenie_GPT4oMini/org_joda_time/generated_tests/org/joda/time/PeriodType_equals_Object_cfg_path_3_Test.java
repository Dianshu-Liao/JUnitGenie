package org.joda.time;
import org.joda.time.PeriodType;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class PeriodType_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEqualsWithDifferentObjectType() {
        PeriodType periodType = new PeriodType("Test", new org.joda.time.DurationFieldType[]{}, new int[]{});
        Object differentObject = new Object(); // Different type

        try {
            boolean result = periodType.equals(differentObject);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}
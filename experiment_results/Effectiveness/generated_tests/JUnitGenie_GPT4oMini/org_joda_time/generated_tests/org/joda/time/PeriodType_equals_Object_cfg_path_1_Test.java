package org.joda.time;
import org.joda.time.PeriodType;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PeriodType_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        PeriodType periodType = new PeriodType("Test", new DurationFieldType[]{}, new int[]{});
        assertTrue(periodType.equals(periodType));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        PeriodType periodType = new PeriodType("Test", new DurationFieldType[]{}, new int[]{});
        assertFalse(periodType.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        PeriodType periodType = new PeriodType("Test", new DurationFieldType[]{}, new int[]{});
        assertFalse(periodType.equals("Not a PeriodType"));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualObjects() {
        try {
            PeriodType periodType1 = new PeriodType("Test", new DurationFieldType[]{DurationFieldType.years()}, new int[]{1});
            PeriodType periodType2 = new PeriodType("Test", new DurationFieldType[]{DurationFieldType.years()}, new int[]{1});
            assertTrue(periodType1.equals(periodType2));
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testEquals_NonEqualObjects() {
        try {
            PeriodType periodType1 = new PeriodType("Test", new DurationFieldType[]{DurationFieldType.years()}, new int[]{1});
            PeriodType periodType2 = new PeriodType("Test", new DurationFieldType[]{DurationFieldType.months()}, new int[]{1});
            assertFalse(periodType1.equals(periodType2));
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}
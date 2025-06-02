package org.joda.time.base;
import org.joda.time.base.AbstractPeriod;
import org.joda.time.ReadablePeriod;
import org.joda.time.PeriodType;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class base_AbstractPeriod_equals_Object_cfg_path_2_Test {

    private class TestPeriod extends AbstractPeriod {
        private final int[] values;
        private final PeriodType periodType;

        public TestPeriod(int[] values, PeriodType periodType) {
            this.values = values;
            this.periodType = periodType;
        }

        @Override
        public PeriodType getPeriodType() {
            return periodType;
        }

        @Override
        public int getValue(int index) {
            return values[index];
        }

        @Override
        public int size() {
            return values.length;
        }
    }

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        TestPeriod period = new TestPeriod(new int[]{1, 2}, PeriodType.standard());
        assertTrue(period.equals(period));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        TestPeriod period = new TestPeriod(new int[]{1, 2}, PeriodType.standard());
        assertFalse(period.equals(new Object()));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentSize() {
        TestPeriod period1 = new TestPeriod(new int[]{1, 2}, PeriodType.standard());
        TestPeriod period2 = new TestPeriod(new int[]{1}, PeriodType.standard());
        assertFalse(period1.equals(period2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameValuesDifferentFieldTypes() {
        TestPeriod period1 = new TestPeriod(new int[]{1, 2}, PeriodType.standard());
        // Corrected the method call to use a valid PeriodType
        TestPeriod period2 = new TestPeriod(new int[]{1, 2}, PeriodType.forFields(new DurationFieldType[]{DurationFieldType.minutes(), DurationFieldType.seconds()}));
        assertFalse(period1.equals(period2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameValuesSameFieldTypes() {
        TestPeriod period1 = new TestPeriod(new int[]{1, 2}, PeriodType.standard());
        TestPeriod period2 = new TestPeriod(new int[]{1, 2}, PeriodType.standard());
        assertTrue(period1.equals(period2));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualValuesDifferentInstances() {
        TestPeriod period1 = new TestPeriod(new int[]{1, 2}, PeriodType.standard());
        TestPeriod period2 = new TestPeriod(new int[]{1, 2}, PeriodType.standard());
        assertTrue(period1.equals(period2));
    }

}
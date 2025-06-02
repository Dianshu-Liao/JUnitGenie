package org.joda.time.base;
import org.joda.time.base.AbstractPeriod;
import org.joda.time.ReadablePeriod;
import org.junit.Test;
import static org.junit.Assert.*;

public class base_AbstractPeriod_equals_Object_cfg_path_4_Test {

    private class TestPeriod extends AbstractPeriod {
        private final int[] values;
        private final org.joda.time.PeriodType periodType;

        public TestPeriod(int[] values, org.joda.time.PeriodType periodType) {
            this.values = values;
            this.periodType = periodType;
        }

        @Override
        public org.joda.time.PeriodType getPeriodType() {
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
        TestPeriod period = new TestPeriod(new int[]{1, 2}, org.joda.time.PeriodType.yearMonthDay());
        assertTrue(period.equals(period));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        TestPeriod period = new TestPeriod(new int[]{1, 2}, org.joda.time.PeriodType.yearMonthDay());
        assertFalse(period.equals(new Object()));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentSize() {
        TestPeriod period1 = new TestPeriod(new int[]{1, 2}, org.joda.time.PeriodType.yearMonthDay());
        TestPeriod period2 = new TestPeriod(new int[]{1}, org.joda.time.PeriodType.yearMonthDay());
        assertFalse(period1.equals(period2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameValuesDifferentFieldTypes() {
        TestPeriod period1 = new TestPeriod(new int[]{1, 2}, org.joda.time.PeriodType.yearMonthDay());
        TestPeriod period2 = new TestPeriod(new int[]{1, 2}, org.joda.time.PeriodType.dayTime());
        assertFalse(period1.equals(period2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameValuesSameFieldTypes() {
        TestPeriod period1 = new TestPeriod(new int[]{1, 2}, org.joda.time.PeriodType.yearMonthDay());
        TestPeriod period2 = new TestPeriod(new int[]{1, 2}, org.joda.time.PeriodType.yearMonthDay());
        assertTrue(period1.equals(period2));
    }

}
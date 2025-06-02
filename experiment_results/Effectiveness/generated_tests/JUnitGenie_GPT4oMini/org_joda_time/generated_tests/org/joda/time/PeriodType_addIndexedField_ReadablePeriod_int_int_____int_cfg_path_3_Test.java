package org.joda.time;
import org.joda.time.PeriodType;
import org.joda.time.ReadablePeriod;
import org.joda.time.Period;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeriodType_addIndexedField_ReadablePeriod_int_int_____int_cfg_path_3_Test {

    private class TestReadablePeriod implements ReadablePeriod {
        private final int[] values;

        public TestReadablePeriod(int[] values) {
            this.values = values;
        }

        @Override
        public Period toPeriod() {
            return new Period(values);
        }

        @Override
        public PeriodType getPeriodType() {
            return PeriodType.yearMonthDay();
        }

        @Override
        public boolean equals(Object obj) {
            return this == obj;
        }

        @Override
        public int size() {
            return values.length;
        }

        @Override
        public MutablePeriod toMutablePeriod() {
            return new MutablePeriod(values);
        }

        @Override
        public boolean isSupported(DurationFieldType type) {
            return true;
        }

        @Override
        public int get(DurationFieldType type) {
            return 0;
        }

        @Override
        public int getValue(int index) {
            return values[index];
        }

        @Override
        public String toString() {
            return "TestReadablePeriod";
        }

        @Override
        public DurationFieldType getFieldType(int index) {
            return DurationFieldType.years();
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }

    @Test(timeout = 4000)
    public void testAddIndexedField() {
        PeriodType periodType = new PeriodType("Test", new DurationFieldType[]{DurationFieldType.years()}, new int[]{0});
        int[] values = new int[1];
        TestReadablePeriod period = new TestReadablePeriod(values);
        int index = 0;
        int valueToAdd = 5;

        boolean result = periodType.addIndexedField(period, index, values, valueToAdd);
        assertTrue(result);
        assertEquals(5, values[0]);
    }

    @Test(timeout = 4000)
    public void testAddIndexedFieldWithZeroValueToAdd() {
        PeriodType periodType = new PeriodType("Test", new DurationFieldType[]{DurationFieldType.years()}, new int[]{0});
        int[] values = new int[1];
        TestReadablePeriod period = new TestReadablePeriod(values);
        int index = 0;
        int valueToAdd = 0;

        boolean result = periodType.addIndexedField(period, index, values, valueToAdd);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testAddIndexedFieldWithUnsupportedIndex() {
        PeriodType periodType = new PeriodType("Test", new DurationFieldType[]{DurationFieldType.years()}, new int[]{-1});
        int[] values = new int[1];
        TestReadablePeriod period = new TestReadablePeriod(values);
        int index = 0;
        int valueToAdd = 5;

        try {
            periodType.addIndexedField(period, index, values, valueToAdd);
            fail("Expected UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            // Expected exception
        }
    }

}
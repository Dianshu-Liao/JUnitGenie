package org.joda.time;
import org.joda.time.Period;
import org.joda.time.ReadablePeriod;
import org.joda.time.DurationFieldType;
import org.joda.time.PeriodType;
import org.junit.Test;
import static org.junit.Assert.*;

public class Period_minus_ReadablePeriod_cfg_path_1_Test {

    private class TestReadablePeriod implements ReadablePeriod {
        private final int[] values;

        public TestReadablePeriod(int years, int months, int weeks, int days, int hours, int minutes, int seconds, int millis) {
            values = new int[]{years, months, weeks, days, hours, minutes, seconds, millis};
        }

        @Override
        public int get(DurationFieldType type) {
            if (type == DurationFieldType.YEARS_TYPE) return values[0];
            if (type == DurationFieldType.MONTHS_TYPE) return values[1];
            if (type == DurationFieldType.WEEKS_TYPE) return values[2];
            if (type == DurationFieldType.DAYS_TYPE) return values[3];
            if (type == DurationFieldType.HOURS_TYPE) return values[4];
            if (type == DurationFieldType.MINUTES_TYPE) return values[5];
            if (type == DurationFieldType.SECONDS_TYPE) return values[6];
            if (type == DurationFieldType.MILLIS_TYPE) return values[7];
            return 0;
        }

        @Override
        public int size() {
            return values.length;
        }

        @Override
        public PeriodType getPeriodType() {
            return PeriodType.standard();
        }

        @Override
        public boolean isSupported(DurationFieldType type) {
            return true; // Assume all types are supported for this test
        }

        @Override
        public MutablePeriod toMutablePeriod() {
            return new MutablePeriod(values, PeriodType.standard());
        }

        @Override
        public Period toPeriod() {
            return new Period(values, PeriodType.standard());
        }

        @Override
        public boolean equals(Object obj) {
            return this == obj;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public String toString() {
            return "TestReadablePeriod";
        }

        // Implementing the missing method from ReadablePeriod
        @Override
        public int getValue(int index) {
            return values[index];
        }

        // Implementing the missing method from ReadablePeriod
        @Override
        public DurationFieldType getFieldType(int index) {
            switch (index) {
                case 0: return DurationFieldType.YEARS_TYPE;
                case 1: return DurationFieldType.MONTHS_TYPE;
                case 2: return DurationFieldType.WEEKS_TYPE;
                case 3: return DurationFieldType.DAYS_TYPE;
                case 4: return DurationFieldType.HOURS_TYPE;
                case 5: return DurationFieldType.MINUTES_TYPE;
                case 6: return DurationFieldType.SECONDS_TYPE;
                case 7: return DurationFieldType.MILLIS_TYPE;
                default: throw new IndexOutOfBoundsException("Index: " + index);
            }
        }
    }

    @Test(timeout = 4000)
    public void testMinus() {
        TestReadablePeriod periodToSubtract = new TestReadablePeriod(1, 2, 3, 4, 5, 6, 7, 8);
        Period originalPeriod = new Period(10, 10, 10, 10, 10, 10, 10, 10);
        
        Period result = originalPeriod.minus(periodToSubtract);
        
        // Validate the result
        assertNotNull(result);
        assertEquals(9, result.getYears());
        assertEquals(8, result.getMonths());
        assertEquals(7, result.getWeeks());
        assertEquals(6, result.getDays());
        assertEquals(5, result.getHours());
        assertEquals(4, result.getMinutes());
        assertEquals(3, result.getSeconds());
        assertEquals(2, result.getMillis());
    }

    @Test(timeout = 4000)
    public void testMinusWithNull() {
        Period originalPeriod = new Period(10, 10, 10, 10, 10, 10, 10, 10);
        
        Period result = originalPeriod.minus(null);
        
        // Validate that the original period is returned
        assertEquals(originalPeriod, result);
    }

}
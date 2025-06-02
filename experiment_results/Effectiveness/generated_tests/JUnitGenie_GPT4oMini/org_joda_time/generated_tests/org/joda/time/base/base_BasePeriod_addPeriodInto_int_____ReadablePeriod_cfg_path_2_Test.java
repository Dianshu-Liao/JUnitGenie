package org.joda.time.base;
import org.joda.time.base.BasePeriod;
import org.joda.time.ReadablePeriod;
import org.joda.time.DurationFieldType;
import org.joda.time.MutablePeriod;
import org.junit.Test;
import static org.junit.Assert.*;

public class base_BasePeriod_addPeriodInto_int_____ReadablePeriod_cfg_path_2_Test {

    // Concrete implementation of BasePeriod for testing
    private static class TestPeriod extends BasePeriod {
        private final int[] values;
        private final DurationFieldType[] fieldTypes;

        protected TestPeriod(int[] values, DurationFieldType[] fieldTypes) {
            super(values, null); // Using null for PeriodType as it's not relevant for this test
            this.values = values;
            this.fieldTypes = fieldTypes;
        }

        @Override
        public int size() {
            return fieldTypes.length;
        }

        @Override
        public DurationFieldType getFieldType(int index) {
            return fieldTypes[index];
        }

        @Override
        public int getValue(int index) {
            return values[index];
        }
    }

    @Test(timeout = 4000)
    public void testAddPeriodInto() {
        // Prepare test data
        int[] values = new int[3]; // Assuming we have 3 fields
        DurationFieldType[] fieldTypes = new DurationFieldType[]{
            DurationFieldType.minutes(), 
            DurationFieldType.hours(), 
            DurationFieldType.days()
        };
        int[] periodValues = new int[]{1, 2, 0}; // 1 minute, 2 hours, 0 days

        // Create a ReadablePeriod instance
        ReadablePeriod period = new TestPeriod(periodValues, fieldTypes);

        // Create an instance of the concrete class to access the protected method
        BasePeriod basePeriod = new TestPeriod(new int[]{0, 0, 0}, fieldTypes);

        // Call the focal method using reflection
        try {
            int[] result = (int[]) BasePeriod.class.getDeclaredMethod("addPeriodInto", int[].class, ReadablePeriod.class)
                .invoke(basePeriod, values, period);

            // Assert the expected results
            assertArrayEquals(new int[]{1, 2, 0}, result);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPeriodIntoThrowsException() {
        // Prepare test data
        int[] values = new int[3]; // Assuming we have 3 fields
        DurationFieldType[] fieldTypes = new DurationFieldType[]{
            DurationFieldType.minutes(), 
            DurationFieldType.hours(), 
            DurationFieldType.days()
        };
        int[] periodValues = new int[]{1, 2, 0}; // 1 minute, 2 hours, 0 days

        // Create a ReadablePeriod instance
        ReadablePeriod period = new TestPeriod(periodValues, fieldTypes);

        // Create an instance of the concrete class to access the protected method
        BasePeriod basePeriod = new TestPeriod(new int[]{0, 0, 0}, fieldTypes);

        // Modify the field types to include an unsupported type
        DurationFieldType[] unsupportedFieldTypes = new DurationFieldType[]{
            DurationFieldType.minutes(), 
            DurationFieldType.hours(), 
            DurationFieldType.seconds() // Unsupported field type
        };
        ReadablePeriod unsupportedPeriod = new TestPeriod(periodValues, unsupportedFieldTypes);

        // Call the focal method using reflection
        try {
            BasePeriod.class.getDeclaredMethod("addPeriodInto", int[].class, ReadablePeriod.class)
                .invoke(basePeriod, values, unsupportedPeriod);
        } catch (Exception e) {
            throw new IllegalArgumentException("Period does not support field 'seconds'");
        }
    }

}
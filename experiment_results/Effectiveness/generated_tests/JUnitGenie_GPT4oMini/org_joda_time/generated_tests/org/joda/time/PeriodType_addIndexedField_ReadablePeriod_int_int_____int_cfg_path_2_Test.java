package org.joda.time;
import org.joda.time.PeriodType;
import org.joda.time.ReadablePeriod;
import org.joda.time.MutablePeriod;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeriodType_addIndexedField_ReadablePeriod_int_int_____int_cfg_path_2_Test {

    private class TestReadablePeriod implements ReadablePeriod {
        private final int[] values;

        public TestReadablePeriod(int[] values) {
            this.values = values;
        }

        @Override
        public int size() {
            return values.length;
        }

        @Override
        public DurationFieldType getFieldType(int index) {
            return DurationFieldType.days(); // Example implementation
        }

        @Override
        public int getValue(int index) {
            return values[index];
        }

        @Override
        public boolean isSupported(DurationFieldType type) {
            return true; // Example implementation
        }

        @Override
        public int get(DurationFieldType type) {
            return 0; // Example implementation
        }

        @Override
        public MutablePeriod toMutablePeriod() {
            return new MutablePeriod(values); // Example implementation
        }

        @Override
        public org.joda.time.Period toPeriod() {
            return new org.joda.time.Period(values); // Example implementation
        }

        @Override
        public boolean equals(Object obj) {
            return this == obj;
        }

        @Override
        public int hashCode() {
            return values.hashCode();
        }

        @Override
        public String toString() {
            return "TestReadablePeriod"; // Example implementation
        }

        @Override
        public PeriodType getPeriodType() {
            return PeriodType.days(); // Example implementation
        }
    }

    @Test(timeout = 4000)
    public void testAddIndexedField_ThrowsUnsupportedOperationException() {
        PeriodType periodType = new PeriodType("Test", new DurationFieldType[]{}, new int[]{});
        int[] iIndices = new int[]{-1}; // Simulating unsupported index
        setPrivateField(periodType, "iIndices", iIndices);

        TestReadablePeriod period = new TestReadablePeriod(new int[]{1, 2, 3});
        int index = 0;
        int valueToAdd = 5;

        try {
            periodType.addIndexedField(period, index, new int[]{0, 0, 0}, valueToAdd);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Field is not supported", e.getMessage());
        }
    }

    private void setPrivateField(PeriodType periodType, String fieldName, int[] value) {
        try {
            java.lang.reflect.Field field = PeriodType.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(periodType, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
package org.joda.time.base;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;
import org.joda.time.DurationFieldType;
import org.joda.time.ReadablePeriod;
import org.joda.time.base.BasePeriod;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class base_BasePeriod_addPeriodInto_int_____ReadablePeriod_cfg_path_3_Test {

    private class TestReadablePeriod implements ReadablePeriod {
        private final DurationFieldType[] fieldTypes;
        private final int[] values;

        public TestReadablePeriod(DurationFieldType[] fieldTypes, int[] values) {
            this.fieldTypes = fieldTypes;
            this.values = values;
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

        @Override
        public int get(DurationFieldType type) {
            for (int i = 0; i < fieldTypes.length; i++) {
                if (fieldTypes[i].equals(type)) {
                    return values[i];
                }
            }
            return 0; // Return 0 if the type is not supported
        }

        // Implement other required methods with trivial returns or throw UnsupportedOperationException
        @Override
        public org.joda.time.Period toPeriod() { return null; }

        @Override
        public org.joda.time.PeriodType getPeriodType() { return null; }

        @Override
        public boolean equals(Object obj) { return false; }

        @Override
        public org.joda.time.MutablePeriod toMutablePeriod() { return null; }

        @Override
        public boolean isSupported(DurationFieldType type) { return false; }

        @Override
        public int hashCode() { return 0; }

        @Override
        public String toString() { return null; }
    }

    @Test(timeout = 4000)
    public void testAddPeriodInto_ThrowsIllegalArgumentException() {
        try {
            // Create an instance of a concrete class extending BasePeriod
            Class<?> basePeriodClass = Class.forName("org.joda.time.base.BasePeriod");
            Constructor<?> constructor = basePeriodClass.getDeclaredConstructor(int[].class, org.joda.time.PeriodType.class);
            constructor.setAccessible(true);
            Object basePeriodInstance = constructor.newInstance((Object) new int[]{0, 0}, null);

            // Create an instance of TestReadablePeriod with a field type that is not supported
            DurationFieldType[] fieldTypes = {DurationFieldType.hours()};
            int[] values = {1}; // This will not cause a return value of 0 for any index in a supported field type.

            TestReadablePeriod period = new TestReadablePeriod(fieldTypes, values);

            Method method = basePeriodClass.getDeclaredMethod("addPeriodInto", int[].class, ReadablePeriod.class);
            method.setAccessible(true);

            // Prepare a values array for the method call
            int[] valuesArray = new int[1];

            // Invoke the method, which should throw an IllegalArgumentException
            method.invoke(basePeriodInstance, valuesArray, period);

            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Should not have thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAddPeriodInto_SuccessfulExecution() {
        try {
            // Create an instance of a concrete class extending BasePeriod
            Class<?> basePeriodClass = Class.forName("org.joda.time.base.BasePeriod");
            Constructor<?> constructor = basePeriodClass.getDeclaredConstructor(int[].class, org.joda.time.PeriodType.class);
            constructor.setAccessible(true);
            Object basePeriodInstance = constructor.newInstance((Object) new int[]{0, 0}, null);

            // Create an instance of TestReadablePeriod with values that should succeed
            DurationFieldType[] fieldTypes = {DurationFieldType.years(), DurationFieldType.months()};
            int[] values = {1, 2}; // Non-zero values
            TestReadablePeriod period = new TestReadablePeriod(fieldTypes, values);

            Method method = basePeriodClass.getDeclaredMethod("addPeriodInto", int[].class, ReadablePeriod.class);
            method.setAccessible(true);

            // Prepare a values array for the method call
            int[] valuesArray = new int[]{0, 0};

            // Invoke the method, which should succeed
            int[] result = (int[]) method.invoke(basePeriodInstance, valuesArray, period);

            // Expected result
            assertArrayEquals(new int[]{1, 2}, result);
        } catch (Exception e) {
            fail("Should not have thrown: " + e.getMessage());
        }
    }


}
package org.joda.time.base;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.DurationFieldType;
import org.joda.time.PeriodType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class base_BaseSingleFieldPeriod_get_DurationFieldType_cfg_path_2_Test {

    // Concrete implementation of BaseSingleFieldPeriod for testing
    private static class TestSingleFieldPeriod extends BaseSingleFieldPeriod {
        private final DurationFieldType fieldType;
        private final int value;

        protected TestSingleFieldPeriod(int value) {
            super(value);
            this.value = value;
            this.fieldType = DurationFieldType.seconds(); // Example field type
        }

        @Override
        public DurationFieldType getFieldType() {
            return fieldType;
        }

        @Override
        public PeriodType getPeriodType() {
            return PeriodType.standard(); // Example period type
        }

        @Override
        public String toString() {
            return "TestSingleFieldPeriod[value=" + value + "]";
        }
    }

    @Test(timeout = 4000)
    public void testGetReturnsZeroForDifferentFieldType() {
        TestSingleFieldPeriod period = new TestSingleFieldPeriod(5);
        DurationFieldType differentFieldType = DurationFieldType.minutes(); // Different from seconds

        int result = period.get(differentFieldType);
        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testGetReturnsValueForSameFieldType() {
        TestSingleFieldPeriod period = new TestSingleFieldPeriod(5);
        DurationFieldType sameFieldType = DurationFieldType.seconds(); // Same as the field type

        int result = period.get(sameFieldType);
        assertEquals(5, result);
    }


}
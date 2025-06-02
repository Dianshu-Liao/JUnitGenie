package org.joda.time.base;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class base_BaseSingleFieldPeriod_getFieldType_int_cfg_path_1_Test {

    private class ConcreteSingleFieldPeriod extends BaseSingleFieldPeriod {
        protected ConcreteSingleFieldPeriod(int value) {
            super(value);
        }

        @Override
        public org.joda.time.PeriodType getPeriodType() {
            return null; // Implement as needed for your tests
        }

        @Override
        public DurationFieldType getFieldType() {
            return DurationFieldType.seconds(); // Example implementation
        }

        @Override
        public String toString() {
            return "ConcreteSingleFieldPeriod"; // Example implementation
        }
    }

    @Test(timeout = 4000)
    public void testGetFieldTypeWithValidIndex() {
        ConcreteSingleFieldPeriod period = new ConcreteSingleFieldPeriod(1);
        DurationFieldType result = period.getFieldType(0);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testGetFieldTypeWithInvalidIndex() {
        ConcreteSingleFieldPeriod period = new ConcreteSingleFieldPeriod(1);
        try {
            period.getFieldType(1);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Exception is expected, test passes
        }
    }

}
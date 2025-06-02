package org.joda.time.base;
import org.joda.time.base.AbstractPeriod;
import org.joda.time.ReadablePeriod;
import org.joda.time.PeriodType;
import org.junit.Test;
import static org.junit.Assert.*;

public class base_AbstractPeriod_equals_Object_cfg_path_1_Test {

    private class ConcretePeriod extends AbstractPeriod {
        private final int[] values;
        private final PeriodType periodType;

        public ConcretePeriod(int[] values, PeriodType periodType) {
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
        ConcretePeriod period = new ConcretePeriod(new int[]{1, 2}, PeriodType.standard());
        assertTrue(period.equals(period));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        ConcretePeriod period = new ConcretePeriod(new int[]{1, 2}, PeriodType.standard());
        assertFalse(period.equals(new Object()));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentSize() {
        ConcretePeriod period1 = new ConcretePeriod(new int[]{1, 2}, PeriodType.standard());
        ConcretePeriod period2 = new ConcretePeriod(new int[]{1}, PeriodType.standard());
        assertFalse(period1.equals(period2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentValues() {
        ConcretePeriod period1 = new ConcretePeriod(new int[]{1, 2}, PeriodType.standard());
        ConcretePeriod period2 = new ConcretePeriod(new int[]{1, 3}, PeriodType.standard());
        assertFalse(period1.equals(period2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameValues() {
        ConcretePeriod period1 = new ConcretePeriod(new int[]{1, 2}, PeriodType.standard());
        ConcretePeriod period2 = new ConcretePeriod(new int[]{1, 2}, PeriodType.standard());
        assertTrue(period1.equals(period2));
    }

}
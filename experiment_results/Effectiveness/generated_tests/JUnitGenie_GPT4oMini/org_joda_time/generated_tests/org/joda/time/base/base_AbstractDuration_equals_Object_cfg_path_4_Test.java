package org.joda.time.base;
import org.joda.time.base.AbstractDuration;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class base_AbstractDuration_equals_Object_cfg_path_4_Test {

    private class ConcreteDuration extends AbstractDuration {
        private long millis;

        public ConcreteDuration(long millis) {
            this.millis = millis;
        }

        @Override
        public long getMillis() {
            return millis;
        }
    }

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        ConcreteDuration duration = new ConcreteDuration(1000);
        assertTrue(duration.equals(duration));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        ConcreteDuration duration = new ConcreteDuration(1000);
        assertFalse(duration.equals("Not a duration"));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentMillis() {
        ConcreteDuration duration1 = new ConcreteDuration(1000);
        ConcreteDuration duration2 = new ConcreteDuration(2000);
        assertFalse(duration1.equals(duration2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameMillis() {
        ConcreteDuration duration1 = new ConcreteDuration(1000);
        ConcreteDuration duration2 = new ConcreteDuration(1000);
        assertTrue(duration1.equals(duration2));
    }

}
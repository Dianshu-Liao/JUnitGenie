package org.joda.time.base;
import org.joda.time.base.AbstractDuration;
import org.joda.time.ReadableDuration;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class base_AbstractDuration_equals_Object_cfg_path_3_Test {

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
        String notADuration = "Not a duration";
        assertFalse(duration.equals(notADuration));
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
package org.joda.time.base;
import org.joda.time.base.AbstractDuration;
import org.joda.time.ReadableDuration;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class base_AbstractDuration_equals_Object_cfg_path_1_Test {

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
    public void testEquals_DifferentMillis_ReturnsFalse() {
        ConcreteDuration duration1 = new ConcreteDuration(1000);
        ConcreteDuration duration2 = new ConcreteDuration(2000);

        try {
            assertFalse(duration1.equals(duration2));
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}
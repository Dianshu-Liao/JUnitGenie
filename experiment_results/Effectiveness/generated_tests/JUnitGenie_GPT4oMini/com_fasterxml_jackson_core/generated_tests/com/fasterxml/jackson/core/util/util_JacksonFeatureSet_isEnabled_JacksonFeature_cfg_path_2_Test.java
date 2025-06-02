package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.JacksonFeature;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class util_JacksonFeatureSet_isEnabled_JacksonFeature_cfg_path_2_Test {

    private class TestFeature implements JacksonFeature {
        private final int mask;

        public TestFeature(int mask) {
            this.mask = mask;
        }

        @Override
        public int getMask() {
            return mask;
        }

        @Override
        public boolean enabledIn(int value) {
            return (value & mask) != 0;
        }

        @Override
        public boolean enabledByDefault() {
            return false;
        }
    }

    @Test(timeout = 4000)
    public void testIsEnabledWithNoOverlap() {
        try {
            // Create an instance of JacksonFeatureSet with _enabled set to a specific value
            JacksonFeatureSet featureSet = (JacksonFeatureSet) JacksonFeatureSet.class.getDeclaredConstructor(int.class).newInstance(0b0000); // _enabled = 0

            // Create a TestFeature with a mask that does not overlap with _enabled
            TestFeature feature = new TestFeature(0b0001); // mask = 1

            // Call the isEnabled method and assert the result
            assertFalse(featureSet.isEnabled(feature));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
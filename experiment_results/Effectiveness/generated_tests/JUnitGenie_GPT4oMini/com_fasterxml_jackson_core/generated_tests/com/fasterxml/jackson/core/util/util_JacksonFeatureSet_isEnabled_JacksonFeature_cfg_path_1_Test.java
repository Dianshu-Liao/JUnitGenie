package com.fasterxml.jackson.core.util;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;
import com.fasterxml.jackson.core.util.JacksonFeature;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;

public class util_JacksonFeatureSet_isEnabled_JacksonFeature_cfg_path_1_Test {
    private JacksonFeatureSet featureSet;

    private class TestFeature implements JacksonFeature {
        @Override
        public boolean enabledByDefault() {
            return false; // Default behavior, can be adjusted based on needs
        }

        @Override
        public int getMask() {
            return 0; // Ensuring the return value from this method is `0`
        }

        @Override
        public boolean enabledIn(int mask) {
            return (mask & getMask()) != 0; // Simple implementation
        }
    }

    @Before
    public void setUp() throws Exception {
        // Using reflection to create an instance of JacksonFeatureSet with _enabled set to 0
        java.lang.reflect.Constructor<JacksonFeatureSet> constructor = JacksonFeatureSet.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        featureSet = constructor.newInstance(0);
    }

    @Test(timeout = 4000)
    public void testIsEnabledWithZeroMask() {
        TestFeature feature = new TestFeature();
        boolean result = featureSet.isEnabled(feature);
        assertFalse("Feature should not be enabled when mask is 0", result);
    }

}
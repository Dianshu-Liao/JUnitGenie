package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.StreamWriteFeature;
import com.fasterxml.jackson.core.TSFBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class TSFBuilder_disable_StreamWriteFeature_StreamWriteFeature_____cfg_path_1_Test {

    private class TSFBuilderImpl extends TSFBuilder {
        protected TSFBuilderImpl() {
            super(); // Using protected constructor via subclass
        }
        
        @Override
        public JsonFactory build() {
            return null; // Implement this method if needed for concrete class
        }
    }

    @Test(timeout = 4000)
    public void testDisable() {
        // Create an instance of TSFBuilder
        TSFBuilder tsfBuilder = new TSFBuilderImpl();

        // Create an instance of StreamWriteFeature
        StreamWriteFeature feature1 = StreamWriteFeature.IGNORE_UNKNOWN;
        StreamWriteFeature feature2 = StreamWriteFeature.WRITE_BIGDECIMAL_AS_PLAIN;

        // Capture the initial _streamWriteFeatures value
        int initialFeatures = tsfBuilder._streamWriteFeatures;

        // Call the disable method
        TSFBuilder result = null;
        try {
            result = tsfBuilder.disable(feature1, feature2);
        } catch (Exception e) {
            fail("Exception occurred during disable: " + e.getMessage());
        }

        // Verify the result
        assertNotNull(result);
        
        // Now we should check if the feature was disabled correctly
        int expectedFeatures = initialFeatures;
        expectedFeatures &= ~feature1.mappedFeature().getMask();
        expectedFeatures &= ~feature2.mappedFeature().getMask();
        
        assertEquals(expectedFeatures, tsfBuilder._streamWriteFeatures);
    }

}
package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.core.TSFBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class TSFBuilder_disable_StreamReadFeature_StreamReadFeature_____cfg_path_1_Test {

    private class TSFBuilderImpl extends TSFBuilder {
        protected TSFBuilderImpl() {
            super();
        }

        @Override
        public JsonFactory build() {
            return null; // Implement as needed for testing
        }
    }

    @Test(timeout = 4000)
    public void testDisable() {
        TSFBuilderImpl builder = new TSFBuilderImpl();
        
        // Set the _streamReadFeatures to a non-zero value for testing
        try {
            java.lang.reflect.Field field = TSFBuilder.class.getDeclaredField("_streamReadFeatures");
            field.setAccessible(true);
            field.setInt(builder, 15); // Example non-zero value

            // Use the correct StreamReadFeature values
            StreamReadFeature feature1 = StreamReadFeature.valueOf("ALLOW_UNQUOTED_FIELD_NAMES"); // Example feature
            StreamReadFeature feature2 = StreamReadFeature.valueOf("ALLOW_SINGLE_QUOTES"); // Another example feature

            // Call the disable method
            TSFBuilder result = builder.disable(feature1, feature2);

            // Validate the result
            assertNotNull(result);
            // Additional assertions can be added to verify the state of _streamReadFeatures if needed

        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Exception occurred: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            fail("Invalid StreamReadFeature: " + e.getMessage());
        }
    }


}
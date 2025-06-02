package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.core.TSFBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class TSFBuilder_disable_StreamReadFeature_StreamReadFeature_____cfg_path_2_Test {

    private class TSFBuilderImpl extends TSFBuilder {
        protected TSFBuilderImpl() {
            super();
        }

        @Override
        public JsonFactory build() {
            return null; // Implement as needed for testing
        }
    }


    private void setStreamReadFeatures(TSFBuilder builder, int value) {
        try {
            java.lang.reflect.Field field = TSFBuilder.class.getDeclaredField("_streamReadFeatures");
            field.setAccessible(true);
            field.setInt(builder, value);
        } catch (Exception e) {
            fail("Failed to set _streamReadFeatures: " + e.getMessage());
        }
    }

    private int getStreamReadFeatures(TSFBuilder builder) {
        try {
            java.lang.reflect.Field field = TSFBuilder.class.getDeclaredField("_streamReadFeatures");
            field.setAccessible(true);
            return field.getInt(builder);
        } catch (Exception e) {
            fail("Failed to get _streamReadFeatures: " + e.getMessage());
            return -1; // Unreachable, but required for compilation
        }
    }


}

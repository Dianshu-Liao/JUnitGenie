package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.util.RecyclerPool;
import com.fasterxml.jackson.core.JsonFactory.Feature;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class JsonFactory__getRecyclerPool__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetRecyclerPoolWithThreadLocalBufferRecyclingEnabled() {
        // Arrange
        JsonFactory jsonFactory = new JsonFactory();
        // Set the _factoryFeatures to enable the USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING feature
        // Assuming DEFAULT_FACTORY_FEATURE_FLAGS has the feature enabled
        jsonFactory._factoryFeatures |= Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING.getMask();

        // Act
        RecyclerPool<BufferRecycler> recyclerPool = null;
        try {
            recyclerPool = jsonFactory._getRecyclerPool();
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Assert
        assertNotNull(recyclerPool);
    }

    @Test(timeout = 4000)
    public void testGetRecyclerPoolWithThreadLocalBufferRecyclingDisabled() {
        // Arrange
        JsonFactory jsonFactory = new JsonFactory();
        // Set the _factoryFeatures to disable the USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING feature
        jsonFactory._factoryFeatures &= ~Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING.getMask();

        // Act
        RecyclerPool<BufferRecycler> recyclerPool = null;
        try {
            recyclerPool = jsonFactory._getRecyclerPool();
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Assert
        assertNotNull(recyclerPool);
    }


}
package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.*;

class JsonFactory__getRecyclerPool_96_2_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    void testGetRecyclerPool_WithThreadLocalEnabled() throws Exception {
        // Set factory features to enable thread-local buffer recycling
        setFactoryFeatureFlag(jsonFactory, JsonFactory.Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING, true);
        // Invoke the private method _getRecyclerPool
        RecyclerPool<BufferRecycler> recyclerPool = invokeGetRecyclerPool(jsonFactory);
        // Verify that the recycler pool is not null
        assertNotNull(recyclerPool);
    }

    @Test
    void testGetRecyclerPool_WithThreadLocalDisabled() throws Exception {
        // Set factory features to disable thread-local buffer recycling
        setFactoryFeatureFlag(jsonFactory, JsonFactory.Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING, false);
        // Invoke the private method _getRecyclerPool
        RecyclerPool<BufferRecycler> recyclerPool = invokeGetRecyclerPool(jsonFactory);
        // Verify that the recycler pool is the non-recycling pool
        assertEquals(JsonRecyclerPools.nonRecyclingPool(), recyclerPool);
    }

    private void setFactoryFeatureFlag(JsonFactory factory, JsonFactory.Feature feature, boolean enabled) throws Exception {
        Method method = JsonFactory.class.getDeclaredMethod("setFeature", JsonFactory.Feature.class, boolean.class);
        method.setAccessible(true);
        method.invoke(factory, feature, enabled);
    }

    private RecyclerPool<BufferRecycler> invokeGetRecyclerPool(JsonFactory factory) throws Exception {
        Method method = JsonFactory.class.getDeclaredMethod("_getRecyclerPool");
        method.setAccessible(true);
        return (RecyclerPool<BufferRecycler>) method.invoke(factory);
    }
}

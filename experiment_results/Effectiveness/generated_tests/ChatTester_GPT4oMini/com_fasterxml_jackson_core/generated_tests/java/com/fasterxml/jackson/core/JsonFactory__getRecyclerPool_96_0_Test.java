package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.util.*;

public class JsonFactory__getRecyclerPool_96_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testGetRecyclerPool_WithThreadLocalBufferRecyclingEnabled() throws Exception {
        // Mock the Feature class and enable USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING
        setPrivateField(jsonFactory, "_factoryFeatures", JsonFactory.Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING.getMask());
        RecyclerPool<BufferRecycler> recyclerPool = invokePrivateMethod(jsonFactory, "_getRecyclerPool");
        assertNotNull(recyclerPool);
        assertTrue(recyclerPool instanceof RecyclerPool);
    }

    @Test
    public void testGetRecyclerPool_WithThreadLocalBufferRecyclingDisabled() throws Exception {
        // Mock the Feature class and disable USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING
        setPrivateField(jsonFactory, "_factoryFeatures", 0);
        RecyclerPool<BufferRecycler> recyclerPool = invokePrivateMethod(jsonFactory, "_getRecyclerPool");
        assertNotNull(recyclerPool);
        assertEquals(JsonRecyclerPools.nonRecyclingPool(), recyclerPool);
    }

    private void setPrivateField(JsonFactory jsonFactory, String fieldName, int value) throws Exception {
        java.lang.reflect.Field field = JsonFactory.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.setInt(jsonFactory, value);
    }

    private RecyclerPool<BufferRecycler> invokePrivateMethod(JsonFactory jsonFactory, String methodName) throws Exception {
        java.lang.reflect.Method method = JsonFactory.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return (RecyclerPool<BufferRecycler>) method.invoke(jsonFactory);
    }
}

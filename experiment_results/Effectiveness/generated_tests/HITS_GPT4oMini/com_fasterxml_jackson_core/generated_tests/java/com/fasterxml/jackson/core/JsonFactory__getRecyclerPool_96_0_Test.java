package com.fasterxml.jackson.core;

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

public class JsonFactory__getRecyclerPool_96_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testGetRecyclerPool_WhenUseThreadLocalForBufferRecyclingEnabled() {
        // Enable buffer recycling
        jsonFactory._factoryFeatures |= JsonFactory.Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING.getMask();
        // Get the recycler pool
        RecyclerPool<BufferRecycler> recyclerPool = jsonFactory._getRecyclerPool();
        // Assert that the recycler pool is not null and is the default pool
        assertSame(JsonRecyclerPools.defaultPool(), recyclerPool);
    }

    @Test
    public void testGetRecyclerPool_WhenUseThreadLocalForBufferRecyclingDisabled() {
        // Disable buffer recycling
        jsonFactory._factoryFeatures &= ~JsonFactory.Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING.getMask();
        // Get the recycler pool
        RecyclerPool<BufferRecycler> recyclerPool = jsonFactory._getRecyclerPool();
        // Assert that the recycler pool is the non-recycling pool
        assertSame(JsonRecyclerPools.nonRecyclingPool(), recyclerPool);
    }
}

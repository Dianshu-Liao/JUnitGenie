package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.JsonPointer;

class JsonPointerBasedFilter_includeProperty_2_0_Test {

    private JsonPointerBasedFilter filter;

    private JsonPointer mockJsonPointer;

    @BeforeEach
    void setUp() {
        mockJsonPointer = mock(JsonPointer.class);
        filter = new JsonPointerBasedFilter(mockJsonPointer, true);
    }

    @Test
    void testIncludeProperty_NullPointer() {
        when(mockJsonPointer.matchProperty("name")).thenReturn(null);
        TokenFilter result = filter.includeProperty("name");
        assertNull(result);
    }

    @Test
    void testIncludeProperty_Matches() {
        when(mockJsonPointer.matchProperty("name")).thenReturn(mockJsonPointer);
        when(mockJsonPointer.matches()).thenReturn(true);
        TokenFilter result = filter.includeProperty("name");
        assertEquals(TokenFilter.INCLUDE_ALL, result);
    }

    @Test
    void testIncludeProperty_DoesNotMatch() throws Exception {
        when(mockJsonPointer.matchProperty("name")).thenReturn(mockJsonPointer);
        when(mockJsonPointer.matches()).thenReturn(false);
        TokenFilter result = filter.includeProperty("name");
        assertNotNull(result);
        // Accessing the private construct method using reflection
        Method constructMethod = JsonPointerBasedFilter.class.getDeclaredMethod("construct", JsonPointer.class, boolean.class);
        constructMethod.setAccessible(true);
        TokenFilter expectedFilter = (TokenFilter) constructMethod.invoke(filter, mockJsonPointer, true);
        assertEquals(expectedFilter, result);
    }
}

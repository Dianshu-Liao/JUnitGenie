package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import com.fasterxml.jackson.core.*;

class TokenFilterContext_hasCurrentName_16_0_Test {

    private TokenFilterContext context;

    private TokenFilter mockFilter;

    @BeforeEach
    void setUp() {
        mockFilter = Mockito.mock(TokenFilter.class);
        context = TokenFilterContext.createRootContext(mockFilter);
    }

    @Test
    void testHasCurrentName_WhenCurrentNameIsNull() {
        // Ensure _currentName is null
        assertFalse(context.hasCurrentName());
    }

    @Test
    void testHasCurrentName_WhenCurrentNameIsNotNull() throws Exception {
        // Set current name to a non-null value
        setFieldValue(context, "_currentName", "testName");
        assertTrue(context.hasCurrentName());
    }

    @Test
    void testHasCurrentName_AfterReset() throws Exception {
        // Set current name and then reset
        setFieldValue(context, "_currentName", "testName");
        context.reset(0, mockFilter, false);
        assertFalse(context.hasCurrentName());
    }

    @Test
    void testHasCurrentName_AfterChildContextCreation() throws Exception {
        // Set current name and create a child context
        setFieldValue(context, "_currentName", "testName");
        TokenFilterContext childContext = context.createChildObjectContext(mockFilter, true);
        assertTrue(childContext.hasCurrentName());
    }

    @Test
    void testHasCurrentName_AfterChildContextWithoutName() {
        // Create a child context without setting a name
        TokenFilterContext childContext = context.createChildArrayContext(mockFilter, true);
        assertFalse(childContext.hasCurrentName());
    }

    private void setFieldValue(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}

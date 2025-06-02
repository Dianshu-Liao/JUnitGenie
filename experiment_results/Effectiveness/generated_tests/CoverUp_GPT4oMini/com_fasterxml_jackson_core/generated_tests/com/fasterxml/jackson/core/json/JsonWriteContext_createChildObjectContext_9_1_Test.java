package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.DupDetector;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

class JsonWriteContext_createChildObjectContext_9_1_Test {

    private JsonWriteContext context;

    private DupDetector dupDetector;

    @BeforeEach
    void setUp() throws Exception {
        // Use reflection to create an instance of DupDetector
        Constructor<DupDetector> constructor = DupDetector.class.getDeclaredConstructor(Object.class);
        constructor.setAccessible(true);
        dupDetector = constructor.newInstance(new Object());
        // Create the JsonWriteContext instance
        context = new JsonWriteContext(0, null, dupDetector);
    }

    @Test
    void testCreateChildObjectContext_WhenChildIsNull() throws Exception {
        JsonWriteContext childContext = invokeCreateChildObjectContext(context);
        assertNotNull(childContext);
        assertSame(childContext, context._child);
        // Check the parent context
        assertEquals(0, context._child.getParent().getCurrentValue());
    }

    @Test
    void testCreateChildObjectContext_WhenChildIsNotNull() throws Exception {
        // First create a child context
        JsonWriteContext firstChild = invokeCreateChildObjectContext(context);
        // Now invoke createChildObjectContext again
        JsonWriteContext secondChild = invokeCreateChildObjectContext(context);
        // Should return the same child context
        assertSame(firstChild, secondChild);
    }

    @Test
    void testCreateChildObjectContext_WithDupDetector() throws Exception {
        // Create a child context
        JsonWriteContext childContext = invokeCreateChildObjectContext(context);
        // Validate the DupDetector
        assertNotNull(childContext.getDupDetector());
        assertEquals(dupDetector.getSource(), childContext.getDupDetector().getSource());
    }

    private JsonWriteContext invokeCreateChildObjectContext(JsonWriteContext context) throws Exception {
        Method method = JsonWriteContext.class.getDeclaredMethod("createChildObjectContext");
        method.setAccessible(true);
        return (JsonWriteContext) method.invoke(context);
    }
}

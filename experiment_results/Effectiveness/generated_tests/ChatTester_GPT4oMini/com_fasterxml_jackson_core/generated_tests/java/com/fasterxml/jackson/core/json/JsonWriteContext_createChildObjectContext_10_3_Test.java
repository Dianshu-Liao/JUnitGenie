package com.fasterxml.jackson.core.json;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.*;

public class JsonWriteContext_createChildObjectContext_10_3_Test {

    private JsonWriteContext context;

    @BeforeEach
    public void setUp() {
        context = new JsonWriteContext(0, null, null);
    }

    @Test
    public void testCreateChildObjectContextWhenChildIsNull() throws Exception {
        JsonWriteContext result = context.createChildObjectContext("value");
        assertNotNull(result);
        assertEquals(context, result.getParent());
        assertEquals("value", result.getCurrentValue());
        assertNotNull(result.getDupDetector());
    }

    @Test
    public void testCreateChildObjectContextWhenChildIsNotNull() throws Exception {
        // First create a child context
        context.createChildObjectContext("initialValue");
        // Now call createChildObjectContext again to see if it resets correctly
        JsonWriteContext result = context.createChildObjectContext("newValue");
        assertNotNull(result);
        assertEquals(context, result.getParent());
        assertEquals("newValue", result.getCurrentValue());
    }

    @Test
    public void testCreateChildObjectContextWithNullValue() throws Exception {
        JsonWriteContext result = context.createChildObjectContext(null);
        assertNotNull(result);
        assertEquals(context, result.getParent());
        assertNull(result.getCurrentValue());
    }

    // Reflection test for private reset method
    @Test
    public void testResetMethod() throws Exception {
        Method resetMethod = JsonWriteContext.class.getDeclaredMethod("reset", int.class, Object.class);
        resetMethod.setAccessible(true);
        // Create a child context first
        JsonWriteContext child = context.createChildObjectContext("initialValue");
        // Reset the child context
        resetMethod.invoke(child, 0, "resetValue");
        assertEquals("resetValue", child.getCurrentValue());
    }
}

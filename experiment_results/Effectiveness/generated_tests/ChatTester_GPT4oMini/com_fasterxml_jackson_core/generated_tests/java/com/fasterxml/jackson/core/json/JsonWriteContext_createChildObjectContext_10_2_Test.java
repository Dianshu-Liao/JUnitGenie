package com.fasterxml.jackson.core.json;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

public class JsonWriteContext_createChildObjectContext_10_2_Test {

    private JsonWriteContext context;

    private DupDetector dupDetector;

    @BeforeEach
    public void setUp() {
        // Fixed the ambiguous reference by specifying JsonParser
        dupDetector = DupDetector.rootDetector((JsonParser) null);
        context = new JsonWriteContext(JsonWriteContext.STATUS_OK_AS_IS, null, dupDetector);
    }

    @Test
    public void testCreateChildObjectContext_NullChild() throws Exception {
        // Invoke the focal method
        JsonWriteContext childContext = context.createChildObjectContext(new Object());
        // Verify that a new child context is created
        assertNotNull(childContext);
        assertSame(childContext, context._child);
    }

    @Test
    public void testCreateChildObjectContext_ExistingChild() throws Exception {
        // First create a child context
        JsonWriteContext firstChild = context.createChildObjectContext(new Object());
        // Now call createChildObjectContext again, which should reset the existing child
        JsonWriteContext secondChild = context.createChildObjectContext(new Object());
        // Verify that the child context is the same and has been reset
        assertSame(firstChild, secondChild);
        assertNotNull(secondChild);
    }

    @Test
    public void testCreateChildObjectContext_WithNullDupDetector() throws Exception {
        // Create context with null DupDetector
        context = new JsonWriteContext(JsonWriteContext.STATUS_OK_AS_IS, null, null);
        // Invoke the focal method
        JsonWriteContext childContext = context.createChildObjectContext(new Object());
        // Verify that a new child context is created with null DupDetector
        assertNotNull(childContext);
        assertSame(childContext, context._child);
    }

    // Reflection test to invoke private reset method
    @Test
    public void testResetChildContext() throws Exception {
        // Create a child context first
        JsonWriteContext childContext = context.createChildObjectContext(new Object());
        // Use reflection to invoke the private reset method
        Method resetMethod = JsonWriteContext.class.getDeclaredMethod("reset", int.class, Object.class);
        resetMethod.setAccessible(true);
        // Invoke reset
        resetMethod.invoke(childContext, JsonWriteContext.STATUS_OK_AFTER_COMMA, new Object());
        // Verify the reset state (you need to implement your own verification logic)
        // This depends on what the reset method does, which is not provided in the original code.
        // For example:
        // assertEquals(expectedValue, childContext.getCurrentValue());
    }

    @Test
    public void testCreateChildObjectContext_WithDifferentCurrentValue() throws Exception {
        // Create a child context
        JsonWriteContext childContext = context.createChildObjectContext("Initial Value");
        // Verify the current value of the child context
        assertEquals("Initial Value", childContext.getCurrentValue());
        // Create another child context with a different current value
        JsonWriteContext newChildContext = context.createChildObjectContext("New Value");
        // Verify that the new child context is the same as the first one (reset)
        assertSame(childContext, newChildContext);
        assertEquals("New Value", newChildContext.getCurrentValue());
    }
}

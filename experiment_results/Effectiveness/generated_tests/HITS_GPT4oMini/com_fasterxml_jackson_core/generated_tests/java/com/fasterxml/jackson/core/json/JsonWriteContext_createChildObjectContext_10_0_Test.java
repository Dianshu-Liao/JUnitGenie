package com.fasterxml.jackson.core.json;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.*;

public class JsonWriteContext_createChildObjectContext_10_0_Test {

    private JsonWriteContext parentContext;

    private JsonWriteContext childContext;

    @BeforeEach
    public void setUp() {
        // Creating a parent context
        parentContext = new JsonWriteContext(0, null, null);
        childContext = parentContext.createChildObjectContext("currentValue");
    }

    @Test
    public void testCreateChildObjectContext_WhenChildDoesNotExist() {
        // Arrange
        JsonWriteContext context = parentContext;
        // Act
        JsonWriteContext result = context.createChildObjectContext("newValue");
        // Assert
        assertNotNull(result);
        assertEquals("newValue", result.getCurrentValue());
        // Should create a new instance
        assertNotSame(result, context.createChildObjectContext("anotherValue"));
    }

    @Test
    public void testCreateChildObjectContext_WhenChildAlreadyExists() {
        // Arrange
        JsonWriteContext context = childContext;
        // Act
        JsonWriteContext result = context.createChildObjectContext("newValue");
        // Assert
        assertNotNull(result);
        // Should return the existing child context
        assertEquals("currentValue", result.getCurrentValue());
        // Should return the same instance
        assertSame(result, context.createChildObjectContext("anotherValue"));
    }

    @Test
    public void testResetChildContext() {
        // Arrange
        JsonWriteContext context = childContext;
        // Act
        context.reset(0, "resetValue");
        // Assert
        assertEquals("resetValue", context.getCurrentValue());
        // Parent should remain unchanged
        assertEquals(0, context.getParent().getCurrentValue());
    }
}

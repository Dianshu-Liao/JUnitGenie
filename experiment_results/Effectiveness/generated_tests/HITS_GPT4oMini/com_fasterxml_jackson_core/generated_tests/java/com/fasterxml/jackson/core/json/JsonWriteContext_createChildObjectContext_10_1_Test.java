package com.fasterxml.jackson.core.json;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.*;

public class JsonWriteContext_createChildObjectContext_10_1_Test {

    private JsonWriteContext context;

    @BeforeEach
    public void setUp() {
        context = new JsonWriteContext(0, null, null);
    }

    @Test
    public void testCreateChildObjectContext_WhenChildIsNull_CreatesNewChildContext() {
        Object currValue = new Object();
        JsonWriteContext childContext = context.createChildObjectContext(currValue);
        assertNotNull(childContext);
        assertEquals(currValue, childContext.getCurrentValue());
        assertSame(childContext, context._child);
    }

    @Test
    public void testCreateChildObjectContext_WhenChildIsNotNull_ResetsChildContext() {
        Object initialValue = new Object();
        context.createChildObjectContext(initialValue);
        Object newValue = new Object();
        JsonWriteContext childContext = context.createChildObjectContext(newValue);
        assertNotNull(childContext);
        assertEquals(newValue, childContext.getCurrentValue());
        assertSame(childContext, context._child);
    }

    @Test
    public void testCreateChildObjectContext_WhenCalledMultipleTimes_ResetsChildContext() {
        Object firstValue = new Object();
        context.createChildObjectContext(firstValue);
        Object secondValue = new Object();
        JsonWriteContext childContext = context.createChildObjectContext(secondValue);
        assertNotNull(childContext);
        assertEquals(secondValue, childContext.getCurrentValue());
        assertSame(childContext, context._child);
    }

    @Test
    public void testCreateChildObjectContext_DupDetectorInitialization() {
        Object currValue = new Object();
        JsonWriteContext childContext = context.createChildObjectContext(currValue);
        assertNotNull(childContext);
        assertNull(childContext.getDupDetector());
    }

    @Test
    public void testCreateChildObjectContext_WithDupDetector_CreatesChildDupDetector() {
        DupDetector parentDupDetector = Mockito.mock(DupDetector.class);
        context._dups = parentDupDetector;
        Object currValue = new Object();
        JsonWriteContext childContext = context.createChildObjectContext(currValue);
        assertNotNull(childContext);
        assertNotNull(childContext.getDupDetector());
        assertNotSame(parentDupDetector, childContext.getDupDetector());
    }
}

package com.fasterxml.jackson.core.json;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

public class JsonWriteContext_createChildObjectContext_10_0_Test {

    private JsonWriteContext context;

    private DupDetector dupDetector;

    @BeforeEach
    public void setUp() throws Exception {
        // Accessing the private constructor of DupDetector using reflection
        Constructor<DupDetector> constructor = DupDetector.class.getDeclaredConstructor(Object.class);
        constructor.setAccessible(true);
        dupDetector = constructor.newInstance(new Object());
        context = new JsonWriteContext(0, null, dupDetector);
    }

    @Test
    public void testCreateChildObjectContext_NewChild() throws Exception {
        Object currValue = new Object();
        JsonWriteContext childContext = context.createChildObjectContext(currValue);
        assertNotNull(childContext);
        assertSame(childContext, context._child);
        assertEquals(currValue, childContext.getCurrentValue());
    }

    @Test
    public void testCreateChildObjectContext_ExistingChild() throws Exception {
        Object currValue1 = new Object();
        Object currValue2 = new Object();
        // Create first child context
        JsonWriteContext childContext1 = context.createChildObjectContext(currValue1);
        assertNotNull(childContext1);
        assertSame(childContext1, context._child);
        assertEquals(currValue1, childContext1.getCurrentValue());
        // Create second child context
        JsonWriteContext childContext2 = context.createChildObjectContext(currValue2);
        // Should return the same instance
        assertSame(childContext1, childContext2);
        // Should still hold the first value
        assertEquals(currValue1, childContext2.getCurrentValue());
        // Reset the child context
        Method resetMethod = JsonWriteContext.class.getDeclaredMethod("reset", int.class, Object.class);
        resetMethod.setAccessible(true);
        resetMethod.invoke(childContext1, 0, currValue2);
        // Should now hold the new value
        assertEquals(currValue2, childContext2.getCurrentValue());
    }

    @Test
    public void testCreateChildObjectContext_NullValue() throws Exception {
        JsonWriteContext childContext = context.createChildObjectContext(null);
        assertNotNull(childContext);
        assertSame(childContext, context._child);
        assertNull(childContext.getCurrentValue());
    }
}

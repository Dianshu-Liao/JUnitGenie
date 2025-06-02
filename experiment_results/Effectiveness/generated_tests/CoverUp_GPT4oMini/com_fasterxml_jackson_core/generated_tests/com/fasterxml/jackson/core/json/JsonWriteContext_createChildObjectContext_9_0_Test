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

public class JsonWriteContext_createChildObjectContext_9_0_Test {

    private JsonWriteContext context;

    private DupDetector dupDetector;

    @BeforeEach
    public void setUp() throws Exception {
        dupDetector = createDupDetector("source");
        context = new JsonWriteContext(0, null, dupDetector);
    }

    @Test
    public void testCreateChildObjectContext_NoChild() throws Exception {
        // When there is no child, a new child context should be created
        JsonWriteContext childContext = invokeCreateChildObjectContext(context);
        assertNotNull(childContext);
        assertSame(childContext, context._child);
    }

    @Test
    public void testCreateChildObjectContext_WithChild() throws Exception {
        // First create a child context
        JsonWriteContext childContext1 = invokeCreateChildObjectContext(context);
        // Now invoke again, which should return the existing child context
        JsonWriteContext childContext2 = invokeCreateChildObjectContext(context);
        // Ensure both references point to the same object
        assertSame(childContext1, childContext2);
    }

    private JsonWriteContext invokeCreateChildObjectContext(JsonWriteContext context) throws Exception {
        Method method = JsonWriteContext.class.getDeclaredMethod("createChildObjectContext");
        method.setAccessible(true);
        return (JsonWriteContext) method.invoke(context);
    }

    private DupDetector createDupDetector(Object source) throws Exception {
        Constructor<DupDetector> constructor = DupDetector.class.getDeclaredConstructor(Object.class);
        constructor.setAccessible(true);
        return constructor.newInstance(source);
    }
}

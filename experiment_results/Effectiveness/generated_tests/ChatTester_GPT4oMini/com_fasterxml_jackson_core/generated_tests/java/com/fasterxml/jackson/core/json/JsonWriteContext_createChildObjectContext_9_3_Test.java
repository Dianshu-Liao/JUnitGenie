package com.fasterxml.jackson.core.json;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

class JsonWriteContext_createChildObjectContext_9_3_Test {

    private JsonWriteContext context;

    private DupDetector dupDetector;

    @BeforeEach
    void setUp() {
        // Fixed line
        dupDetector = DupDetector.rootDetector(mock(JsonParser.class));
        context = new JsonWriteContext(JsonWriteContext.STATUS_OK_AS_IS, null, dupDetector);
    }

    @Test
    void testCreateChildObjectContext_whenChildIsNull_createsNewChildContext() {
        JsonWriteContext childContext = context.createChildObjectContext();
        assertNotNull(childContext);
        assertSame(childContext, context._child);
    }

    @Test
    void testCreateChildObjectContext_whenChildIsNotNull_returnsExistingChildContext() {
        JsonWriteContext childContext1 = context.createChildObjectContext();
        JsonWriteContext childContext2 = context.createChildObjectContext();
        assertSame(childContext1, childContext2);
    }

    @Test
    void testCreateChildObjectContext_whenChildIsNull_initializesWithDupDetector() {
        JsonWriteContext childContext = context.createChildObjectContext();
        assertNotNull(childContext);
        assertSame(dupDetector.child(), childContext.getDupDetector());
    }

    @Test
    void testCreateChildObjectContext_whenChildExists_resetsChildContext() throws Exception {
        JsonWriteContext childContext = context.createChildObjectContext();
        // Assuming reset method exists and changes the state of the child context
        Method resetMethod = JsonWriteContext.class.getDeclaredMethod("reset", int.class);
        resetMethod.setAccessible(true);
        resetMethod.invoke(childContext, JsonWriteContext.STATUS_EXPECT_VALUE);
        JsonWriteContext newChildContext = context.createChildObjectContext();
        assertSame(childContext, newChildContext);
        // Further assertions can be added based on the expected state after reset
    }
}

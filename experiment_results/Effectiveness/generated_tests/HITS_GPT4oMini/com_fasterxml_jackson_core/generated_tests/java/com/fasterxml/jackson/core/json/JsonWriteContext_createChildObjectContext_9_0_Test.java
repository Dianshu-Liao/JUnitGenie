package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

@ExtendWith(MockitoExtension.class)
public class JsonWriteContext_createChildObjectContext_9_0_Test {

    private JsonWriteContext context;

    @Mock
    private DupDetector parentDupDetector;

    @BeforeEach
    public void setUp() {
        context = new JsonWriteContext(JsonWriteContext.STATUS_OK_AS_IS, null, parentDupDetector);
    }

    @Test
    public void testCreateChildObjectContext() {
        JsonWriteContext childContext = context.createChildObjectContext();
        // Verify that the child context is created
        assertNotNull(childContext);
        // Verify that the child context's parent is the current context
        assertEquals(context, childContext.getParent());
        // Verify that the child context is of the correct type
        assertEquals(JsonWriteContext.STATUS_OK_AS_IS, childContext.getCurrentValue());
    }
}

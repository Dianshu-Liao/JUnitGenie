package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.JsonWriteContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.*;

class JsonWriteContext_writeValue_18_0_Test {

    private JsonWriteContext context;

    @BeforeEach
    public void setUp() {
        context = JsonWriteContext.createRootContext();
    }

    @Test
    public void testWriteValueInObjectContextWithoutName() {
        context.reset(JsonWriteContext.TYPE_OBJECT);
        int result = context.writeValue();
        assertEquals(JsonWriteContext.STATUS_EXPECT_NAME, result);
    }

    @Test
    public void testWriteValueInObjectContextWithName() throws JsonProcessingException {
        context.reset(JsonWriteContext.TYPE_OBJECT);
        context.writeFieldName("test");
        int result = context.writeValue();
        assertEquals(JsonWriteContext.STATUS_OK_AFTER_COLON, result);
    }

    @Test
    public void testWriteValueInArrayContext() {
        context.reset(JsonWriteContext.TYPE_ARRAY);
        int result = context.writeValue();
        assertEquals(JsonWriteContext.STATUS_OK_AS_IS, result);
        // Second write
        result = context.writeValue();
        assertEquals(JsonWriteContext.STATUS_OK_AFTER_COMMA, result);
    }

    @Test
    public void testWriteValueInRootContext() {
        context.reset(JsonWriteContext.TYPE_ROOT);
        int result = context.writeValue();
        assertEquals(JsonWriteContext.STATUS_OK_AS_IS, result);
        // Second write
        result = context.writeValue();
        assertEquals(JsonWriteContext.STATUS_OK_AFTER_SPACE, result);
    }

    @Test
    public void testWriteValueInArrayContextAfterFirstWrite() {
        context.reset(JsonWriteContext.TYPE_ARRAY);
        // First write
        context.writeValue();
        // Second write
        int result = context.writeValue();
        assertEquals(JsonWriteContext.STATUS_OK_AFTER_COMMA, result);
    }

    @Test
    public void testWriteValueInRootContextAfterFirstWrite() {
        context.reset(JsonWriteContext.TYPE_ROOT);
        // First write
        context.writeValue();
        // Second write
        int result = context.writeValue();
        assertEquals(JsonWriteContext.STATUS_OK_AFTER_SPACE, result);
    }
}

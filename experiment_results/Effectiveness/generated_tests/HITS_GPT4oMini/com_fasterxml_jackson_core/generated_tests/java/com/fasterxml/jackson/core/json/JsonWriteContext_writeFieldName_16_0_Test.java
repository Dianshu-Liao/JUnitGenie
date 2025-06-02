package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

public class JsonWriteContext_writeFieldName_16_0_Test {

    private JsonWriteContext context;

    @BeforeEach
    public void setUp() {
        // Creating JsonWriteContext with a null DupDetector
        context = new JsonWriteContext(JsonWriteContext.STATUS_EXPECT_NAME, null, null);
    }

    @Test
    public void testWriteFieldName_NewField() throws JsonProcessingException {
        int status = context.writeFieldName("field1");
        assertEquals(JsonWriteContext.STATUS_OK_AS_IS, status);
    }

    @Test
    public void testWriteFieldName_ExistingField() throws JsonProcessingException {
        context.writeFieldName("field1");
        // Trying to write the same field name again
        int status = context.writeFieldName("field1");
        assertEquals(JsonWriteContext.STATUS_EXPECT_VALUE, status);
    }

    @Test
    public void testWriteFieldName_NullName() {
        assertThrows(JsonProcessingException.class, () -> {
            // Testing with null field name
            context.writeFieldName(null);
        });
    }
}

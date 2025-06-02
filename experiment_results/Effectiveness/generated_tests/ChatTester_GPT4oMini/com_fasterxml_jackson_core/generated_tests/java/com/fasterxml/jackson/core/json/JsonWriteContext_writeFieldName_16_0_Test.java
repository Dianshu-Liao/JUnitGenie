package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

@ExtendWith(MockitoExtension.class)
public class JsonWriteContext_writeFieldName_16_0_Test {

    private JsonWriteContext context;

    private DupDetector dupDetector;

    @BeforeEach
    public void setUp() {
        dupDetector = mock(DupDetector.class);
        // Assuming TYPE_OBJECT is represented by 0
        context = new JsonWriteContext(/* type */
        0, null, dupDetector);
    }

    @Test
    public void testWriteFieldName_ExpectValue() throws JsonProcessingException {
        // Given
        // Initial state
        context._gotName = false;
        // No current name set
        context._currentName = null;
        // When
        int result = context.writeFieldName("fieldName");
        // Then
        assertEquals(JsonWriteContext.STATUS_OK_AS_IS, result);
        assertTrue(context._gotName);
        assertEquals("fieldName", context._currentName);
        verify(dupDetector, never()).isDup(anyString());
    }

    @Test
    public void testWriteFieldName_AfterName() throws JsonProcessingException {
        // Given
        // Already got a name
        context._gotName = true;
        // When
        int result = context.writeFieldName("fieldName");
        // Then
        assertEquals(JsonWriteContext.STATUS_EXPECT_VALUE, result);
        assertFalse(context._gotName);
        assertNull(context._currentName);
    }

    @Test
    public void testWriteFieldName_WithDuplicates() throws JsonProcessingException {
        // Given
        // Initial state
        context._gotName = false;
        // No current name set
        context._currentName = null;
        // Set the dup detector
        context._dups = dupDetector;
        when(dupDetector.isDup("fieldName")).thenReturn(false);
        // When
        int result = context.writeFieldName("fieldName");
        // Then
        assertEquals(JsonWriteContext.STATUS_OK_AS_IS, result);
        assertTrue(context._gotName);
        assertEquals("fieldName", context._currentName);
        verify(dupDetector).isDup("fieldName");
    }

    @Test
    public void testWriteFieldName_AfterComma() throws JsonProcessingException, NoSuchFieldException, IllegalAccessException {
        // Given
        // Initial state
        context._gotName = false;
        context._currentName = null;
        // Fixing the buggy line using reflection to set the protected _index field
        Field indexField = JsonWriteContext.class.getDeclaredField("_index");
        indexField.setAccessible(true);
        // Set _index to 1
        indexField.setInt(context, 1);
        // When
        int result = context.writeFieldName("fieldName");
        // Then
        assertEquals(JsonWriteContext.STATUS_OK_AFTER_COMMA, result);
        assertTrue(context._gotName);
        assertEquals("fieldName", context._currentName);
        verify(dupDetector, never()).isDup(anyString());
    }
}

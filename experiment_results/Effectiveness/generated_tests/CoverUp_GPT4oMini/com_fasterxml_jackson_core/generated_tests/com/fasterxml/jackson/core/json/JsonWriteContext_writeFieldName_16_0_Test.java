package com.fasterxml.jackson.core.json;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

public class JsonWriteContext_writeFieldName_16_0_Test {

    private JsonWriteContext context;

    private DupDetector dupDetector;

    @BeforeEach
    public void setUp() {
        // Create a mock DupDetector since its constructor is private
        dupDetector = mock(DupDetector.class);
        context = new JsonWriteContext(1, null, dupDetector);
    }

    @Test
    public void testWriteFieldNameFirstField() throws Exception {
        int result = invokeWriteFieldName(context, "fieldName");
        assertEquals(JsonWriteContext.STATUS_OK_AS_IS, result);
        assertEquals("fieldName", getFieldValue(context, "_currentName"));
        assertEquals(true, getFieldValue(context, "_gotName"));
    }

    @Test
    public void testWriteFieldNameSubsequentField() throws Exception {
        invokeWriteFieldName(context, "fieldName");
        int result = invokeWriteFieldName(context, "anotherField");
        assertEquals(JsonWriteContext.STATUS_OK_AFTER_COMMA, result);
        assertEquals("anotherField", getFieldValue(context, "_currentName"));
    }

    @Test
    public void testWriteFieldNameWhenGotName() throws Exception {
        invokeWriteFieldName(context, "fieldName");
        int result = invokeWriteFieldName(context, "fieldName");
        assertEquals(JsonWriteContext.STATUS_EXPECT_VALUE, result);
    }

    @Test
    public void testWriteFieldNameWhenNotObjectType() throws Exception {
        Field typeField = JsonWriteContext.class.getDeclaredField("_type");
        typeField.setAccessible(true);
        // Simulate not being an object type
        typeField.set(context, 0);
        int result = invokeWriteFieldName(context, "fieldName");
        assertEquals(JsonWriteContext.STATUS_EXPECT_VALUE, result);
    }

    @Test
    public void testWriteFieldNameWithDupDetector() throws Exception {
        invokeWriteFieldName(context, "fieldName");
        // Simulate a duplicate field name
        when(dupDetector.isDup(anyString())).thenReturn(true);
        JsonProcessingException exception = assertThrows(JsonProcessingException.class, () -> {
            invokeWriteFieldName(context, "fieldName");
        });
        assertEquals("Duplicate field 'fieldName'", exception.getMessage());
    }

    private int invokeWriteFieldName(JsonWriteContext context, String name) throws Exception {
        Method method = JsonWriteContext.class.getDeclaredMethod("writeFieldName", String.class);
        method.setAccessible(true);
        return (int) method.invoke(context, name);
    }

    private Object getFieldValue(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

    private void setFieldValue(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}

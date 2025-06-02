package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import java.io.Closeable;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class ObjectMapper__writeValueAndClose_JsonGenerator_Object_cfg_path_6_Test {

    private ObjectMapper objectMapper;
    private JsonGenerator jsonGenerator;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
        jsonGenerator = mock(JsonGenerator.class);
    }

    @Test(timeout = 4000)
    public void testWriteValueAndClose_WithCloseableValue() {
        try {
            Closeable closeableValue = mock(Closeable.class);
            objectMapper.enable(SerializationFeature.CLOSE_CLOSEABLE); // Corrected line
            // Call the reflective method
            invokeWriteValueAndClose(objectMapper, jsonGenerator, closeableValue);
        } catch (Exception e) {
            e.printStackTrace(); // Handle Exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteValueAndClose_WithSerializableValue() {
        try {
            Object value = "Test String"; // This is a valid object to serialize
            objectMapper.enable(SerializationFeature.CLOSE_CLOSEABLE); // Corrected line
            // Call the reflective method
            invokeWriteValueAndClose(objectMapper, jsonGenerator, value);
        } catch (Exception e) {
            e.printStackTrace(); // Handle Exception
        }
    }

    private void invokeWriteValueAndClose(ObjectMapper objectMapper, JsonGenerator jsonGenerator, Object value) throws Exception {
        // Using reflection to access the protected method
        java.lang.reflect.Method method = ObjectMapper.class.getDeclaredMethod("_writeValueAndClose", JsonGenerator.class, Object.class);
        method.setAccessible(true);
        method.invoke(objectMapper, jsonGenerator, value);
    }


}
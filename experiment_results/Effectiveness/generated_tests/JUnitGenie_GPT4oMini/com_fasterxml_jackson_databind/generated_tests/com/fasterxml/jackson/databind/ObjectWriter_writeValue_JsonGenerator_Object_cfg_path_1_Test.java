package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import java.io.Closeable;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;
import static org.mockito.Mockito.CALLS_REAL_METHODS;

public class ObjectWriter_writeValue_JsonGenerator_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWriteValue_withCloseable() {
        // Create a StringWriter to use as our JsonGenerator
        StringWriter stringWriter = new StringWriter();
        JsonGenerator jsonGenerator = mock(JsonGenerator.class, withSettings().defaultAnswer(CALLS_REAL_METHODS));
        
        // Create a Closeable object as value
        Closeable closeable = mock(Closeable.class);

        // Create ObjectWriter using reflection
        ObjectWriter objectWriter = createObjectWriter();

        try {
            objectWriter.writeValue(jsonGenerator, closeable);
        } catch (IOException e) {
            // Handle the IOException
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteValue_withoutCloseable() {
        // Create a StringWriter to use as our JsonGenerator
        StringWriter stringWriter = new StringWriter();
        JsonGenerator jsonGenerator = mock(JsonGenerator.class, withSettings().defaultAnswer(CALLS_REAL_METHODS));

        // Create a value that is not Closeable
        Object value = new TestObject(); // Changed to a serializable object

        // Create ObjectWriter using reflection
        ObjectWriter objectWriter = createObjectWriter();

        try {
            objectWriter.writeValue(jsonGenerator, value);
        } catch (IOException e) {
            // Handle the IOException
            e.printStackTrace();
        }
    }

    private ObjectWriter createObjectWriter() {
        try {
            // Use reflection to create ObjectWriter
            Constructor<ObjectWriter> constructor = ObjectWriter.class.getDeclaredConstructor(ObjectMapper.class, SerializationConfig.class);
            constructor.setAccessible(true);
            // Create a new ObjectMapper and get its SerializationConfig
            ObjectMapper objectMapper = new ObjectMapper();
            SerializationConfig serializationConfig = objectMapper.getSerializationConfig();
            return constructor.newInstance(objectMapper, serializationConfig);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create ObjectWriter", e);
        }
    }

    // A simple class to serialize
    private static class TestObject {
        private String name = "Test";

        public String getName() {
            return name;
        }
    }

}
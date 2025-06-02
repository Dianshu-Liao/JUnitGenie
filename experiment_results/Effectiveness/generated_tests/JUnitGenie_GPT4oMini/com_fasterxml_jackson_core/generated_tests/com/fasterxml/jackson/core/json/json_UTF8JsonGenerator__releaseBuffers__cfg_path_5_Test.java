package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class json_UTF8JsonGenerator__releaseBuffers__cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testReleaseBuffersWhenBuffersAreNull() {
        try {
            IOContext ioContext = new IOContext(null, new ByteArrayOutputStream(), false);
            ObjectCodec codec = null;
            UTF8JsonGenerator generator = new UTF8JsonGenerator(ioContext, 0, codec, new ByteArrayOutputStream());

            // Accessing protected fields directly for testing purposes
            // Setting the buffers to null
            setProtectedField(generator, "_outputBuffer", null);
            setProtectedField(generator, "_charBuffer", null);

            // Invoking the protected method using reflection
            Method method = UTF8JsonGenerator.class.getDeclaredMethod("_releaseBuffers");
            method.setAccessible(true);
            method.invoke(generator);

            // Validate that method execution did not throw exceptions or cause errors
            assertNull(getProtectedField(generator, "_outputBuffer"));
            assertNull(getProtectedField(generator, "_charBuffer"));
        } catch (Exception e) {
            fail("Exception thrown during test: " + e.getMessage());
        }
    }

    private Object getProtectedField(UTF8JsonGenerator generator, String fieldName) throws Exception {
        return UTF8JsonGenerator.class.getDeclaredField(fieldName).get(generator);
    }

    private void setProtectedField(UTF8JsonGenerator generator, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = UTF8JsonGenerator.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(generator, value);
    }


}
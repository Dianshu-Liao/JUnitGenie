package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.util.RawValue;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import static org.mockito.Mockito.doThrow;

public class util_RawValue__serialize_JsonGenerator_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSerializeWithSerializableString() throws IOException {
        // Arrange
        SerializableString serializableString = Mockito.mock(SerializableString.class);
        JsonGenerator jsonGenerator = Mockito.mock(JsonGenerator.class);
        RawValue rawValue = new RawValue(serializableString);

        // Act
        try {
            rawValue.getClass().getDeclaredMethod("_serialize", JsonGenerator.class).setAccessible(true);
            rawValue.getClass().getDeclaredMethod("_serialize", JsonGenerator.class).invoke(rawValue, jsonGenerator);
        } catch (Exception e) {
            // Handle or assert unexpectedly throwing exceptions
            e.printStackTrace();
        }

        // Assert
        Mockito.verify(jsonGenerator).writeRawValue(serializableString);
    }

    @Test(timeout = 4000)
    public void testSerializeWithNonSerializableString() throws IOException {
        // Arrange
        String nonSerializableValue = "Some non-serializable value";
        JsonGenerator jsonGenerator = Mockito.mock(JsonGenerator.class);
        RawValue rawValue = new RawValue(nonSerializableValue);

        // Act
        try {
            rawValue.getClass().getDeclaredMethod("_serialize", JsonGenerator.class).setAccessible(true);
            rawValue.getClass().getDeclaredMethod("_serialize", JsonGenerator.class).invoke(rawValue, jsonGenerator);
        } catch (Exception e) {
            // Handle or assert unexpectedly throwing exceptions
            e.printStackTrace();
        }

        // Assert
        Mockito.verify(jsonGenerator).writeRawValue(nonSerializableValue);
    }

    @Test(timeout = 4000)
    public void testSerializeThrowsIOException() {
        // Arrange
        String value = "Some value";
        JsonGenerator jsonGenerator = Mockito.mock(JsonGenerator.class);
        RawValue rawValue = new RawValue(value);
        try {
            doThrow(new IOException("Mocked IOException")).when(jsonGenerator).writeRawValue(Mockito.anyString());

            // Act
            rawValue.getClass().getDeclaredMethod("_serialize", JsonGenerator.class).setAccessible(true);
            rawValue.getClass().getDeclaredMethod("_serialize", JsonGenerator.class).invoke(rawValue, jsonGenerator);
        } catch (IOException e) {
            // Assert
            // Expected exception due to mocked IOException
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.util.RawValue;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;

public class util_RawValue__serialize_JsonGenerator_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSerializeWithSerializableString() throws IOException {
        // Create a mock of JsonGenerator
        JsonGenerator jsonGenerator = mock(JsonGenerator.class);
        
        // Create a SerializableString instance
        SerializableString serializableString = Mockito.mock(SerializableString.class);
        
        // Create an instance of RawValue with SerializableString
        RawValue rawValue = new RawValue(serializableString);
        
        // Use reflection to access the protected _serialize method
        try {
            java.lang.reflect.Method method = RawValue.class.getDeclaredMethod("_serialize", JsonGenerator.class);
            method.setAccessible(true); // Make the method accessible
            method.invoke(rawValue, jsonGenerator); // Invoke the method
            
            // Verify that writeRawValue was called with the SerializableString
            verify(jsonGenerator).writeRawValue(serializableString);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception properly
        }
    }
    
    @Test(timeout = 4000)
    public void testSerializeWithNonSerializableString() throws IOException {
        // Create a mock of JsonGenerator
        JsonGenerator jsonGenerator = mock(JsonGenerator.class);
        
        // Create an instance of RawValue with a String representation of a non-Serializable object
        String nonSerializableString = "nonSerializableObject";
        RawValue rawValue = new RawValue(nonSerializableString);
        
        // Use reflection to access the protected _serialize method
        try {
            java.lang.reflect.Method method = RawValue.class.getDeclaredMethod("_serialize", JsonGenerator.class);
            method.setAccessible(true); // Make the method accessible
            method.invoke(rawValue, jsonGenerator); // Invoke the method
            
            // Verify that writeRawValue was called with the String representation of the non-SerializableString
            verify(jsonGenerator).writeRawValue(nonSerializableString);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception properly
        }
    }


}
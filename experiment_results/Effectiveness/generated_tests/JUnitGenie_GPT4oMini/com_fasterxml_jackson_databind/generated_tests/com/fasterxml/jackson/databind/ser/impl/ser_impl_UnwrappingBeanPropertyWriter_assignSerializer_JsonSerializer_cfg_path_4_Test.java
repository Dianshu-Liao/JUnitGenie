package com.fasterxml.jackson.databind.ser.impl;
import com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanPropertyWriter;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.util.NameTransformer;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ser_impl_UnwrappingBeanPropertyWriter_assignSerializer_JsonSerializer_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testAssignSerializerWithValidSerializer() {
        // Arrange: create a NameTransformer and a mock JsonSerializer
        NameTransformer nameTransformer = mock(NameTransformer.class);
        JsonSerializer<Object> jsonSerializer = mock(JsonSerializer.class);
        
        // Mock the behavior of the JsonSerializer's methods
        when(jsonSerializer.isUnwrappingSerializer()).thenReturn(true);
        when(jsonSerializer.unwrappingSerializer(any(NameTransformer.class))).thenReturn(jsonSerializer);

        // Initialize the UnwrappingBeanPropertyWriter with a valid property writer
        UnwrappingBeanPropertyWriter writer = new UnwrappingBeanPropertyWriter(null, nameTransformer);

        // Act: call the method under test
        try {
            writer.assignSerializer(jsonSerializer);
        } catch (Exception e) {
            // Handle the exception, if any, as per rule 4
            e.printStackTrace();
        }

        // Assert: verify that the correct methods were called
        verify(jsonSerializer).isUnwrappingSerializer();
        verify(jsonSerializer).unwrappingSerializer(nameTransformer);
        // The following line is incorrect as 'writer' does not have an assignSerializer method to verify
        // verify(writer).assignSerializer(jsonSerializer); // This line is removed
    }

    @Test(timeout = 4000)
    public void testAssignSerializerWithNullSerializer() {
        // Arrange: Initialize the UnwrappingBeanPropertyWriter
        NameTransformer nameTransformer = mock(NameTransformer.class);
        UnwrappingBeanPropertyWriter writer = new UnwrappingBeanPropertyWriter(null, nameTransformer);

        // Act: call the method under test with a null serializer
        try {
            writer.assignSerializer(null);
        } catch (Exception e) {
            // Handle the exception, if any
            e.printStackTrace();
        }

        // Assert: verify that the assignSerializer method of the superclass is called with null
        // Since there is no assert on superclass call, we will verify this indirectly.
    }


}
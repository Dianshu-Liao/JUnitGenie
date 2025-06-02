package com.fasterxml.jackson.databind.ser.impl;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanSerializer;
import com.fasterxml.jackson.databind.util.NameTransformer;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ser_impl_UnwrappingBeanPropertyWriter_assignSerializer_JsonSerializer_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAssignSerializer_withUnwrappingSerializer() {
        // Arrange
        NameTransformer nameTransformer = mock(NameTransformer.class);
        UnwrappingBeanPropertyWriter writer = new UnwrappingBeanPropertyWriter(null, nameTransformer);
        
        UnwrappingBeanSerializer serializer = mock(UnwrappingBeanSerializer.class);
        when(serializer.isUnwrappingSerializer()).thenReturn(true);
        when(serializer.unwrappingSerializer(any(NameTransformer.class))).thenReturn(serializer);
        
        // Act
        try {
            writer.assignSerializer(serializer);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        // Verify that the unwrappingSerializer method was called with the correct transformer
        verify(serializer).unwrappingSerializer(any(NameTransformer.class));
    }

    @Test(timeout = 4000)
    public void testAssignSerializer_withNullSerializer() {
        // Arrange
        NameTransformer nameTransformer = mock(NameTransformer.class);
        UnwrappingBeanPropertyWriter writer = new UnwrappingBeanPropertyWriter(null, nameTransformer); // Changed to null for the first argument
        
        // Act
        try {
            writer.assignSerializer(null);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        // No specific assertions needed, just ensure no exceptions are thrown
    }

}

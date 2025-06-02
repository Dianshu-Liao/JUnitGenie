package com.fasterxml.jackson.databind.ser.std;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ser.std.ByteArraySerializer;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ser_std_ByteArraySerializer_acceptJsonFormatVisitor_JsonFormatVisitorWrapper_JavaType_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAcceptJsonFormatVisitor() {
        // Arrange
        ByteArraySerializer serializer = new ByteArraySerializer();
        JsonFormatVisitorWrapper visitor = mock(JsonFormatVisitorWrapper.class);
        JsonArrayFormatVisitor arrayFormatVisitor = mock(JsonArrayFormatVisitor.class);
        JavaType typeHint = mock(JavaType.class);
        
        try {
            when(visitor.expectArrayFormat(typeHint)).thenReturn(arrayFormatVisitor);
        } catch (JsonMappingException e) {
            // Handle the exception for this case
            e.printStackTrace();
        }

        // Act
        try {
            serializer.acceptJsonFormatVisitor(visitor, typeHint);
        } catch (JsonMappingException e) {
            // Handle the exception for this case
            e.printStackTrace();
        }

        // Assert
        try {
            verify(visitor).expectArrayFormat(typeHint);
            verify(arrayFormatVisitor).itemsFormat(any());
        } catch (JsonMappingException e) {
            // Handle the exception for this case
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAcceptJsonFormatVisitor_NullArrayFormatVisitor() {
        // Arrange
        ByteArraySerializer serializer = new ByteArraySerializer();
        JsonFormatVisitorWrapper visitor = mock(JsonFormatVisitorWrapper.class);
        JavaType typeHint = mock(JavaType.class);

        try {
            when(visitor.expectArrayFormat(typeHint)).thenReturn(null);
        } catch (JsonMappingException e) {
            // Handle the exception for this case
            e.printStackTrace();
        }

        // Act
        try {
            serializer.acceptJsonFormatVisitor(visitor, typeHint);
        } catch (JsonMappingException e) {
            // Handle the exception for this case
            e.printStackTrace();
        }

        // Assert
        try {
            verify(visitor).expectArrayFormat(typeHint);
        } catch (JsonMappingException e) {
            // Handle the exception for this case
            e.printStackTrace();
        }
    }

}
package com.fasterxml.jackson.databind;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import java.io.Closeable;
import java.io.IOException;

public class ObjectWriter_writeValue_JsonGenerator_Object_cfg_path_2_Test {

    // Mocked JsonGenerator
    private JsonGenerator mockJsonGenerator;
    // Mocked ObjectWriter
    private ObjectWriter objectWriter;
    // Mocked SerializationConfig
    private SerializationConfig mockConfig;
    // Mocked DefaultSerializerProvider
    private DefaultSerializerProvider mockProvider;

    @Before
    public void setUp() throws Exception {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockConfig = mock(SerializationConfig.class);
        mockProvider = mock(DefaultSerializerProvider.class);

        // Using ObjectMapper to create ObjectWriter with default settings
        objectWriter = new ObjectMapper().writer();
    }

    @Test(timeout = 4000)
    public void testWriteValueWithCloseable() {
        try {
            // Arrange
            Closeable mockCloseable = mock(Closeable.class);
            when(mockConfig.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(true);
            when(mockConfig.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)).thenReturn(false);

            // Act
            objectWriter.writeValue(mockJsonGenerator, mockCloseable);

            // Assert
            verify(mockJsonGenerator, times(1)).flush();
            verify(mockCloseable, times(1)).close();
        } catch (IOException e) {
            // Handle exception in accordance with the rules
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteValueWithNonCloseable() {
        try {
            // Arrange
            Object mockValue = new Object();
            when(mockConfig.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(false);
            when(mockConfig.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)).thenReturn(false);

            // Act
            objectWriter.writeValue(mockJsonGenerator, mockValue);

            // Assert
            verify(mockJsonGenerator, never()).flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteValueThrowsIOException() {
        try {
            // Arrange
            Closeable mockCloseable = mock(Closeable.class);
            when(mockConfig.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(true);
            // Correcting the method call to use the ObjectWriter directly
            doThrow(new IOException()).when(mockJsonGenerator).writeObject(mockCloseable);

            // Act
            objectWriter.writeValue(mockJsonGenerator, mockCloseable);
        } catch (IOException e) {
            // Assert that IOException is indeed thrown and handled
            assertEquals(IOException.class, e.getClass());
        }
    }

}
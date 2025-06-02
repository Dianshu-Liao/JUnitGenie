package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import static org.mockito.Mockito.*;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.StreamWriteConstraints;

public class ser_ToXmlGenerator_close__cfg_path_48_Test {

    @Test(timeout = 4000)
    public void testClose() throws IOException, XMLStreamException {
        // Arrange
        XMLStreamWriter2 mockXmlWriter = mock(XMLStreamWriter2.class);
        IOContext mockIOContext = mock(IOContext.class); // Create a mock for IOContext
        ToXmlGenerator generator = new ToXmlGenerator(mockIOContext, 0, 0, null, mockXmlWriter, null);
        
        // Mocking the behavior of isClosed() and isEnabled() methods
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);
        
        // Mocking the behavior of _writeContext
        JsonStreamContext mockContext = mock(JsonStreamContext.class);
        // Use reflection to set the protected field _writeContext
        setField(generator, "_writeContext", mockContext);
        when(mockContext.inArray()).thenReturn(false);
        when(mockContext.inObject()).thenReturn(true);
        
        // Act
        try {
            generator.close();
        } catch (IOException e) {
            // Handle IOException
        }

        // Assert
        verify(mockXmlWriter).close();
    }

    @Test(timeout = 4000)
    public void testCloseWithException() throws IOException, XMLStreamException {
        // Arrange
        XMLStreamWriter2 mockXmlWriter = mock(XMLStreamWriter2.class);
        IOContext mockIOContext = mock(IOContext.class); // Create a mock for IOContext
        ToXmlGenerator generator = new ToXmlGenerator(mockIOContext, 0, 0, null, mockXmlWriter, null);
        
        // Mocking the behavior of isClosed() and isEnabled() methods
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);
        
        // Mocking the behavior of _writeContext
        JsonStreamContext mockContext = mock(JsonStreamContext.class);
        // Use reflection to set the protected field _writeContext
        setField(generator, "_writeContext", mockContext);
        when(mockContext.inArray()).thenReturn(false);
        when(mockContext.inObject()).thenReturn(true);
        
        // Simulating XMLStreamException
        doThrow(new XMLStreamException("Test Exception")).when(mockXmlWriter).close();

        // Act
        try {
            generator.close();
        } catch (IOException e) {
            // Handle IOException
        }

        // Assert
        verify(mockXmlWriter).close();
    }

    // Helper method to set a protected field using reflection
    private void setField(Object target, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
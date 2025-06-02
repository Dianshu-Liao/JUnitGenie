package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonStreamContext;
import org.junit.Test;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.IOException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertNotNull;

public class ser_ToXmlGenerator_close__cfg_path_22_Test {

    @Test(timeout = 4000)
    public void testCloseWithXMLStreamException() throws IOException, XMLStreamException {
        // Arrange
        IOContext ioContext = mock(IOContext.class);
        XMLStreamWriter xmlWriter = mock(XMLStreamWriter.class);
        XmlNameProcessor nameProcessor = mock(XmlNameProcessor.class);
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, 0, 0, null, xmlWriter, nameProcessor);

        // Mocking the behavior of isClosed and isEnabled methods
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(false);
        when(ioContext.isResourceManaged()).thenReturn(false);
        
        // Mocking the behavior of _writeContext
        JsonStreamContext context = mock(JsonStreamContext.class);
        setField(generator, "_writeContext", context);
        
        when(context.inArray()).thenReturn(false);
        when(context.inObject()).thenReturn(false);

        // Simulating XMLStreamException
        doThrow(new XMLStreamException()).when(xmlWriter).close();

        // Act
        try {
            generator.close();
        } catch (IOException e) {
            // Handle the exception if necessary
        }

        // Assert
        verify(xmlWriter).close();
        // The following line was corrected to verify the close method on the generator
        verify(generator, times(1)).close(); // This line is correct as it verifies the close method on the generator
    }

    // Helper method to set a private or protected field using reflection
    private void setField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set field: " + fieldName, e);
        }
    }

}
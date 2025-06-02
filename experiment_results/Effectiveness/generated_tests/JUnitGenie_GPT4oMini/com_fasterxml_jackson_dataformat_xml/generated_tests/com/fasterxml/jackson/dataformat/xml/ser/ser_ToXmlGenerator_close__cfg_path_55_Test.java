package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertTrue;
import java.io.IOException;

public class ser_ToXmlGenerator_close__cfg_path_55_Test {

    @Test(timeout = 4000)
    public void testCloseMethod() throws IOException, XMLStreamException {
        // Arrange
        XMLStreamWriter mockXmlWriter = mock(XMLStreamWriter.class);
        IOContext mockIoContext = mock(IOContext.class);
        ToXmlGenerator generator = new ToXmlGenerator(mockIoContext, 0, 0, null, mockXmlWriter, null);
        
        // Mock the conditions for isClosed() returning false
        when(generator.isClosed()).thenReturn(false);
        
        // Mock the isEnabled method to return false for both AUTO_CLOSE_JSON_CONTENT and AUTO_CLOSE_TARGET
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(false);
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET)).thenReturn(false);

        // Act
        generator.close();
        
        // Assert
        // Verify that the xmlWriter was closed correctly
        verify(mockXmlWriter, times(1)).close();
    }

    @Test(timeout = 4000)
    public void testCloseMethodWithException() throws IOException, XMLStreamException {
        // Arrange
        XMLStreamWriter mockXmlWriter = mock(XMLStreamWriter.class);
        IOContext mockIoContext = mock(IOContext.class);
        ToXmlGenerator generator = new ToXmlGenerator(mockIoContext, 0, 0, null, mockXmlWriter, null);
        
        // Mock the conditions for isClosed() returning false
        when(generator.isClosed()).thenReturn(false);
        
        // Mock the isEnabled method to return false for both AUTO_CLOSE_JSON_CONTENT and AUTO_CLOSE_TARGET
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(false);
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET)).thenReturn(false);
        
        // Mock an exception when close is called on the xmlWriter
        doThrow(new XMLStreamException("Test Exception")).when(mockXmlWriter).close();

        // Act
        try {
            generator.close();
        } catch (IOException e) {
            // Assert the expected exception type is thrown
            assertTrue(e.getCause() instanceof XMLStreamException);
        }
    }


}
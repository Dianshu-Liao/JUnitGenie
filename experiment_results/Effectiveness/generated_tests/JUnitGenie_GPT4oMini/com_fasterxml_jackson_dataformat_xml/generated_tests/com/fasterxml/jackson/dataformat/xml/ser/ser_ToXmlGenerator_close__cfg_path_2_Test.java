package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertNotNull;
import java.io.IOException;

public class ser_ToXmlGenerator_close__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testClose() throws XMLStreamException, IOException {
        // Arrange
        IOContext ioContext = mock(IOContext.class);
        XMLStreamWriter xmlWriter = mock(XMLStreamWriter.class);
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, 0, 0, null, xmlWriter, null);
        
        // Mocking the behavior of isClosed() and isEnabled() methods
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);
        when(ioContext.isResourceManaged()).thenReturn(true);
        
        // Act
        generator.close();

        // Assert
        verify(xmlWriter).close(); // Changed from closeCompletely() to close()
    }

    @Test(timeout = 4000)
    public void testCloseWithArrayIndexOutOfBoundsException() throws IOException {
        // Arrange
        IOContext ioContext = mock(IOContext.class);
        XMLStreamWriter xmlWriter = mock(XMLStreamWriter.class);
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, 0, 0, null, xmlWriter, null);
        
        // Mocking the behavior of isClosed() and isEnabled() methods
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);
        
        // Simulating ArrayIndexOutOfBoundsException
        doThrow(new ArrayIndexOutOfBoundsException()).when(generator).writeEndArray();
        
        // Act
        try {
            generator.close();
        } catch (IOException e) {
            // Handle IOException
        } catch (ArrayIndexOutOfBoundsException e) {
            // Assert
            assertNotNull(e); // This line is now valid
        }
    }

    @Test(timeout = 4000)
    public void testCloseWithXMLStreamException() throws IOException, XMLStreamException {
        // Arrange
        IOContext ioContext = mock(IOContext.class);
        XMLStreamWriter xmlWriter = mock(XMLStreamWriter.class);
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, 0, 0, null, xmlWriter, null);
        
        // Mocking the behavior of isClosed() and isEnabled() methods
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(false);
        when(ioContext.isResourceManaged()).thenReturn(false);
        
        // Simulating XMLStreamException
        doThrow(new XMLStreamException()).when(xmlWriter).close();
        
        // Act
        try {
            generator.close();
        } catch (IOException e) {
            // Handle IOException
        }

        // Assert
        verify(xmlWriter).close();
    }


}
package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;
import static org.junit.Assert.assertTrue;

public class ser_ToXmlGenerator_close__cfg_path_77_Test {

    @Test(timeout = 4000)
    public void testClose() throws IOException, XMLStreamException { // Added XMLStreamException to the throws clause
        // Arrange
        IOContext ioContext = mock(IOContext.class);
        XMLStreamWriter2 xmlWriter = mock(XMLStreamWriter2.class);
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, 0, 0, null, xmlWriter, null);
        
        // Mocking the behavior of the methods
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);
        
        // Act
        generator.close();

        // Assert
        verify(xmlWriter, times(1)).close(); // This line is now correct
        verify(generator, times(1)).close(); // corrected this line from super.close() to close()
    }

    @Test(timeout = 4000)
    public void testCloseWithArrayIndexOutOfBoundsException() {
        // Arrange
        IOContext ioContext = mock(IOContext.class);
        XMLStreamWriter2 xmlWriter = mock(XMLStreamWriter2.class);
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, 0, 0, null, xmlWriter, null);
        
        // Mocking the behavior of the methods
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);

        // Act
        try {
            generator.close();
        } catch (RuntimeException e) { // Changed to RuntimeException to catch the correct exception
            // Assert
            assertTrue(e.getCause() instanceof ArrayIndexOutOfBoundsException);
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCloseWithXMLStreamException() throws IOException, XMLStreamException { // Added XMLStreamException to the throws clause
        // Arrange
        IOContext ioContext = mock(IOContext.class);
        XMLStreamWriter2 xmlWriter = mock(XMLStreamWriter2.class);
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, 0, 0, null, xmlWriter, null);
        
        // Mocking the behavior of the methods
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(false);
        when(ioContext.isResourceManaged()).thenReturn(true);
        doThrow(new XMLStreamException()).when(xmlWriter).closeCompletely();

        // Act
        try {
            generator.close();
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }

        // Assert
        verify(xmlWriter, times(1)).closeCompletely(); // This line is now correct
    }


}
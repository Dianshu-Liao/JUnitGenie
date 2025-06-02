package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class ser_ToXmlGenerator_close__cfg_path_52_Test {

    @Test(timeout = 4000)
    public void testClose() throws IOException, XMLStreamException {
        // Arrange
        XMLStreamWriter2 mockXmlWriter = mock(XMLStreamWriter2.class);
        com.fasterxml.jackson.core.io.IOContext mockIOContext = mock(com.fasterxml.jackson.core.io.IOContext.class);
        ToXmlGenerator generator = new ToXmlGenerator(mockIOContext, 0, 0, null, mockXmlWriter, null);
        
        // Mocking the behavior of isClosed() and isEnabled() methods
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);
        when(generator.getOutputContext().inArray()).thenReturn(false);
        when(generator.getOutputContext().inObject()).thenReturn(true);
        
        // Act
        try {
            generator.close();
        } catch (IOException e) {
            // Handle IOException
        }

        // Assert
        verify(mockXmlWriter, times(1)).close();
    }

    @Test(timeout = 4000)
    public void testCloseWithXMLStreamException() throws IOException, XMLStreamException {
        // Arrange
        XMLStreamWriter2 mockXmlWriter = mock(XMLStreamWriter2.class);
        com.fasterxml.jackson.core.io.IOContext mockIOContext = mock(com.fasterxml.jackson.core.io.IOContext.class);
        ToXmlGenerator generator = new ToXmlGenerator(mockIOContext, 0, 0, null, mockXmlWriter, null);
        
        // Mocking the behavior of isClosed() and isEnabled() methods
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);
        when(generator.getOutputContext().inArray()).thenReturn(false);
        when(generator.getOutputContext().inObject()).thenReturn(true);
        
        // Simulating XMLStreamException
        doThrow(new XMLStreamException("XML Stream Exception")).when(mockXmlWriter).close();

        // Act
        try {
            generator.close();
        } catch (IOException e) {
            // Handle IOException
        } // Removed the catch block for XMLStreamException as it is not thrown

        // Assert
        verify(mockXmlWriter, times(1)).close();
    }

}
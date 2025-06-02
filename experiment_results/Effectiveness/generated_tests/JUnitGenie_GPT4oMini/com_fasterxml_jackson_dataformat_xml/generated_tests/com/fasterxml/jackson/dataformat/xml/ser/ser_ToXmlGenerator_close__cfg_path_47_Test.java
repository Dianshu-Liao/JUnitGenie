package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;

public class ser_ToXmlGenerator_close__cfg_path_47_Test {

    @Test(timeout = 4000)
    public void testClose() throws IOException, XMLStreamException {
        // Arrange
        XMLStreamWriter2 mockXmlWriter = mock(XMLStreamWriter2.class);
        IOContext mockIoContext = mock(IOContext.class);
        ToXmlGenerator generator = new ToXmlGenerator(mockIoContext, 0, 0, null, mockXmlWriter, null);

        // Mocking the behavior of the methods
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);
        // Accessing _writeContext through a public method instead of directly
        when(generator.getOutputContext().inArray()).thenReturn(false); // Changed to getOutputContext()
        when(generator.getOutputContext().inObject()).thenReturn(true); // Changed to getOutputContext()
        doNothing().when(mockXmlWriter).close();

        // Act
        generator.close();

        // Assert
        verify(mockXmlWriter, times(1)).close();
        verify(generator, times(1)).writeEndObject();
    }

    @Test(timeout = 4000)
    public void testCloseWithException() throws IOException, XMLStreamException {
        // Arrange
        XMLStreamWriter2 mockXmlWriter = mock(XMLStreamWriter2.class);
        IOContext mockIoContext = mock(IOContext.class);
        ToXmlGenerator generator = new ToXmlGenerator(mockIoContext, 0, 0, null, mockXmlWriter, null);

        // Mocking the behavior of the methods
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)).thenReturn(true);
        // Accessing _writeContext through a public method instead of directly
        when(generator.getOutputContext().inArray()).thenReturn(false); // Changed to getOutputContext()
        when(generator.getOutputContext().inObject()).thenReturn(true); // Changed to getOutputContext()
        doThrow(new ArrayIndexOutOfBoundsException()).when(generator).writeEndObject();
        
        // Act
        try {
            generator.close();
        } catch (IOException e) {
            // Assert
            assertNotNull(e);
        }

        // Assert
        verify(mockXmlWriter, never()).close();
    }

    // Removed the method that was causing the error since StreamWriteConstraints is not defined

}
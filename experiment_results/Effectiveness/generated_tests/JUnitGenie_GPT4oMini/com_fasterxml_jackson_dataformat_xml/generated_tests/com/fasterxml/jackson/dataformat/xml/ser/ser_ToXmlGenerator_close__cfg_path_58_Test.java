package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import javax.xml.stream.XMLStreamWriter;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerationException;
import javax.xml.stream.XMLStreamException;
import static org.junit.Assert.assertNotNull;

public class ser_ToXmlGenerator_close__cfg_path_58_Test {

    @Test(timeout = 4000)
    public void testClose() throws IOException, XMLStreamException {
        // Arrange
        IOContext ioContext = mock(IOContext.class);
        ObjectCodec objectCodec = mock(ObjectCodec.class);
        XMLStreamWriter2 xmlWriter = mock(XMLStreamWriter2.class);
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, 0, 0, objectCodec, xmlWriter, null);

        // Mocking the behavior of the methods used in the close() method
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(ToXmlGenerator.Feature.WRITE_XML_DECLARATION)).thenReturn(true);

        // Act
        try {
            generator.close();
        } catch (IOException e) {
            // Handle the exception if necessary
        }

        // Assert
        verify(xmlWriter, times(1)).close();
    }


    @Test(timeout = 4000)
    public void testCloseWithXMLStreamException() throws IOException, XMLStreamException {
        // Arrange
        IOContext ioContext = mock(IOContext.class);
        ObjectCodec objectCodec = mock(ObjectCodec.class);
        XMLStreamWriter2 xmlWriter = mock(XMLStreamWriter2.class);
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, 0, 0, objectCodec, xmlWriter, null);

        // Mocking the behavior of the methods used in the close() method
        when(generator.isClosed()).thenReturn(false);
        when(generator.isEnabled(ToXmlGenerator.Feature.WRITE_XML_DECLARATION)).thenReturn(false);

        // Simulate an XMLStreamException
        doThrow(new XMLStreamException()).when(xmlWriter).close();

        // Act
        try {
            generator.close();
        } catch (IOException e) {
            // Handle the exception if necessary
        }

        // Assert
        verify(xmlWriter, times(1)).close();
    }


}
package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class deser_FromXmlParser_close__cfg_path_19_Test {

    @Test(timeout = 4000)
    public void testClose() throws IOException, XMLStreamException {
        // Arrange
        IOContext mockIOContext = mock(IOContext.class);
        XmlTokenStream mockXmlTokens = mock(XmlTokenStream.class);
        XMLStreamReader mockXmlStreamReader = mock(XMLStreamReader.class);
        XmlNameProcessor mockXmlNameProcessor = mock(XmlNameProcessor.class);

        // Simulate the XMLStreamReader pointing to a START_ELEMENT
        when(mockXmlStreamReader.getEventType()).thenReturn(XMLStreamReader.START_ELEMENT);

        FromXmlParser parser = new FromXmlParser(mockIOContext, 0, 0, null, mockXmlStreamReader, mockXmlNameProcessor);
        parser._closed = false; // Set to false to enter the close logic
        when(mockIOContext.isResourceManaged()).thenReturn(true); // Simulate resource management

        // Act
        try {
            parser.close();
        } catch (IOException e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }

        // Assert
        verify(mockXmlTokens).closeCompletely(); // Verify that closeCompletely was called
    }

    @Test(timeout = 4000)
    public void testCloseWithException() throws IOException, XMLStreamException {
        // Arrange
        IOContext mockIOContext = mock(IOContext.class);
        XmlTokenStream mockXmlTokens = mock(XmlTokenStream.class);
        XMLStreamReader mockXmlStreamReader = mock(XMLStreamReader.class);
        XmlNameProcessor mockXmlNameProcessor = mock(XmlNameProcessor.class);

        // Simulate the XMLStreamReader pointing to a START_ELEMENT
        when(mockXmlStreamReader.getEventType()).thenReturn(XMLStreamReader.START_ELEMENT);

        FromXmlParser parser = new FromXmlParser(mockIOContext, 0, 0, null, mockXmlStreamReader, mockXmlNameProcessor);
        parser._closed = false; // Set to false to enter the close logic
        when(mockIOContext.isResourceManaged()).thenReturn(true); // Simulate resource management
        doThrow(new XMLStreamException("Test Exception")).when(mockXmlTokens).closeCompletely(); // Simulate exception

        // Act
        try {
            parser.close();
        } catch (IOException e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }

        // Assert
        verify(mockXmlTokens).closeCompletely(); // Verify that closeCompletely was called
    }


}
package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamReader;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;

public class deser_FromXmlParser_close__cfg_path_28_Test {

    @Test(timeout = 4000)
    public void testClose() throws IOException, XMLStreamException {
        // Arrange
        IOContext mockIOContext = mock(IOContext.class);
        XmlTokenStream mockXmlTokenStream = mock(XmlTokenStream.class);
        XMLStreamReader mockXMLStreamReader = mock(XMLStreamReader.class);
        XmlNameProcessor mockXmlNameProcessor = mock(XmlNameProcessor.class);
        
        // Mock the behavior of XMLStreamReader to point to START_ELEMENT
        when(mockXMLStreamReader.getEventType()).thenReturn(XMLStreamReader.START_ELEMENT);
        
        FromXmlParser parser = new FromXmlParser(mockIOContext, 0, 0, null, mockXMLStreamReader, mockXmlNameProcessor);

        // Mock the behavior of isResourceManaged
        when(mockIOContext.isResourceManaged()).thenReturn(true);
        doNothing().when(mockXmlTokenStream).closeCompletely(); // Mocking the behavior

        // Act
        try {
            parser.close();
        } catch (IOException e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }

        // Assert
        verify(mockXmlTokenStream).closeCompletely();
    }

    @Test(timeout = 4000)
    public void testCloseWithException() throws IOException, XMLStreamException {
        // Arrange
        IOContext mockIOContext = mock(IOContext.class);
        XmlTokenStream mockXmlTokenStream = mock(XmlTokenStream.class);
        XMLStreamReader mockXMLStreamReader = mock(XMLStreamReader.class);
        XmlNameProcessor mockXmlNameProcessor = mock(XmlNameProcessor.class);
        
        // Mock the behavior of XMLStreamReader to point to START_ELEMENT
        when(mockXMLStreamReader.getEventType()).thenReturn(XMLStreamReader.START_ELEMENT);
        
        FromXmlParser parser = new FromXmlParser(mockIOContext, 0, 0, null, mockXMLStreamReader, mockXmlNameProcessor);

        // Mock the behavior of isResourceManaged
        when(mockIOContext.isResourceManaged()).thenReturn(true);
        doThrow(new XMLStreamException("Test Exception")).when(mockXmlTokenStream).closeCompletely();

        // Act
        try {
            parser.close();
        } catch (IOException e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }

        // Assert
        verify(mockXmlTokenStream).closeCompletely();
    }

}
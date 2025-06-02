package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class deser_FromXmlParser_close__cfg_path_44_Test {

    @Test(timeout = 4000)
    public void testClose() throws IOException, XMLStreamException {
        // Arrange
        IOContext mockIOContext = mock(IOContext.class);
        XmlTokenStream mockXmlTokens = mock(XmlTokenStream.class);
        XMLStreamReader mockXMLStreamReader = mock(XMLStreamReader.class);
        
        // Simulate that the XMLStreamReader is pointing to a START_ELEMENT
        when(mockXMLStreamReader.getEventType()).thenReturn(XMLStreamReader.START_ELEMENT);
        
        FromXmlParser parser = new FromXmlParser(mockIOContext, 0, 0, null, mockXMLStreamReader, mock(XmlNameProcessor.class));
        
        // Set the internal state to simulate that the parser is not closed
        parser._closed = false;
        when(mockIOContext.isResourceManaged()).thenReturn(true);
        when(parser.isEnabled(FromXmlParser.Feature.values()[0])).thenReturn(false); // Specify the feature explicitly

        // Act
        try {
            parser.close();
        } catch (IOException e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }

        // Assert
        verify(mockXmlTokens).closeCompletely();
    }

    @Test(timeout = 4000)
    public void testCloseWithXMLStreamException() throws IOException, XMLStreamException {
        // Arrange
        IOContext mockIOContext = mock(IOContext.class);
        XmlTokenStream mockXmlTokens = mock(XmlTokenStream.class);
        XMLStreamReader mockXMLStreamReader = mock(XMLStreamReader.class);
        
        // Simulate that the XMLStreamReader is pointing to a START_ELEMENT
        when(mockXMLStreamReader.getEventType()).thenReturn(XMLStreamReader.START_ELEMENT);
        
        FromXmlParser parser = new FromXmlParser(mockIOContext, 0, 0, null, mockXMLStreamReader, mock(XmlNameProcessor.class));
        
        // Set the internal state to simulate that the parser is not closed
        parser._closed = false;
        when(mockIOContext.isResourceManaged()).thenReturn(true);
        when(parser.isEnabled(FromXmlParser.Feature.values()[0])).thenReturn(false); // Specify the feature explicitly
        doThrow(new XMLStreamException("Test Exception")).when(mockXmlTokens).closeCompletely();

        // Act
        try {
            parser.close();
        } catch (IOException e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }

        // Assert
        verify(mockXmlTokens).closeCompletely();
    }


}
package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class deser_FromXmlParser_close__cfg_path_20_Test {

    @Test(timeout = 4000)
    public void testClose() throws IOException, XMLStreamException {
        // Arrange
        IOContext mockIOContext = mock(IOContext.class);
        XmlTokenStream mockXmlTokens = mock(XmlTokenStream.class);
        XMLStreamReader mockXmlStreamReader = mock(XMLStreamReader.class);
        when(mockXmlStreamReader.getEventType()).thenReturn(XMLStreamReader.START_ELEMENT);
        
        FromXmlParser parser = new FromXmlParser(mockIOContext, 0, 0, mock(ObjectCodec.class), mockXmlStreamReader, null);
        
        // Set the internal state to simulate that the parser is not closed
        parser._closed = false;
        when(mockIOContext.isResourceManaged()).thenReturn(true);
        
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
    public void testCloseThrowsXMLStreamException() throws IOException, XMLStreamException {
        // Arrange
        IOContext mockIOContext = mock(IOContext.class);
        XmlTokenStream mockXmlTokens = mock(XmlTokenStream.class);
        XMLStreamReader mockXmlStreamReader = mock(XMLStreamReader.class);
        when(mockXmlStreamReader.getEventType()).thenReturn(XMLStreamReader.START_ELEMENT);
        
        FromXmlParser parser = new FromXmlParser(mockIOContext, 0, 0, mock(ObjectCodec.class), mockXmlStreamReader, null);
        
        // Set the internal state to simulate that the parser is not closed
        parser._closed = false;
        when(mockIOContext.isResourceManaged()).thenReturn(true);
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
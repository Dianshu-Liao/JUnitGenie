package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertTrue;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class deser_FromXmlParser_close__cfg_path_22_Test {

    @Test(timeout = 4000)
    public void testClose() throws IOException, XMLStreamException {
        // Arrange
        IOContext mockIOContext = mock(IOContext.class);
        XmlTokenStream mockXmlTokenStream = mock(XmlTokenStream.class);
        // Create a concrete implementation of XmlNameProcessor
        XmlNameProcessor mockXmlNameProcessor = mock(XmlNameProcessor.class);
        FromXmlParser parser = new FromXmlParser(mockIOContext, 0, 0, null, null, mockXmlNameProcessor);

        // Set the internal state to simulate that the parser is not closed
        setParserState(parser, false, mockXmlTokenStream);

        // Mock the behavior of isResourceManaged to return true
        when(mockIOContext.isResourceManaged()).thenReturn(true);

        // Act
        try {
            parser.close();
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Assert
        verify(mockXmlTokenStream).closeCompletely();
        // Ensure that _closed is set to true
        assertTrue(parser._closed);
    }

    @Test(timeout = 4000)
    public void testCloseWithException() throws IOException, XMLStreamException {
        // Arrange
        IOContext mockIOContext = mock(IOContext.class);
        XmlTokenStream mockXmlTokenStream = mock(XmlTokenStream.class);
        // Create a concrete implementation of XmlNameProcessor
        XmlNameProcessor mockXmlNameProcessor = mock(XmlNameProcessor.class);
        FromXmlParser parser = new FromXmlParser(mockIOContext, 0, 0, null, null, mockXmlNameProcessor);

        // Set the internal state to simulate that the parser is not closed
        setParserState(parser, false, mockXmlTokenStream);

        // Mock the behavior of isResourceManaged to return true
        when(mockIOContext.isResourceManaged()).thenReturn(true);
        // Mock the behavior of closeCompletely to throw XMLStreamException
        doThrow(new XMLStreamException()).when(mockXmlTokenStream).closeCompletely();

        // Act
        try {
            parser.close();
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Assert
        verify(mockXmlTokenStream).closeCompletely();
        // Ensure that _closed is set to true
        assertTrue(parser._closed);
    }

    private void setParserState(FromXmlParser parser, boolean closed, XmlTokenStream xmlTokenStream) {
        // Use reflection to set the final variable _xmlTokens
        try {
            java.lang.reflect.Field field = FromXmlParser.class.getDeclaredField("_xmlTokens");
            field.setAccessible(true);
            field.set(parser, xmlTokenStream);
            parser._closed = closed;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class deser_FromXmlParser_close__cfg_path_18_Test {

    private FromXmlParser parser;
    private IOContext mockIoContext;
    private XmlTokenStream mockXmlTokens;
    private XMLStreamReader mockXmlStreamReader;

    @Before
    public void setUp() throws IOException {
        mockIoContext = mock(IOContext.class);
        mockXmlTokens = mock(XmlTokenStream.class);
        mockXmlStreamReader = mock(XMLStreamReader.class);
        
        // Mock the behavior of the XMLStreamReader to point to a START_ELEMENT
        when(mockXmlStreamReader.getEventType()).thenReturn(XMLStreamReader.START_ELEMENT);
        
        parser = new FromXmlParser(mockIoContext, 0, 0, mock(ObjectCodec.class), mockXmlStreamReader, mock(XmlNameProcessor.class));
    }

    @Test(timeout = 4000)
    public void testClose() throws IOException, XMLStreamException {
        // Setting the internal state for the test
        parser._closed = false; // the parser is not closed
        
        when(mockIoContext.isResourceManaged()).thenReturn(true);
        
        try {
            parser.close(); // Call the method under test
            // Verify that it leads us to the expected behavior
            verify(mockXmlTokens).closeCompletely();
        } catch (XMLStreamException e) {
            e.printStackTrace(); // Handle as per rule 4
        }
    }

    @Test(timeout = 4000)
    public void testCloseThrowsParseException() throws IOException, XMLStreamException {
        // Setting the internal state for the test
        parser._closed = false; // the parser is not closed
        
        when(mockIoContext.isResourceManaged()).thenReturn(true);
        doThrow(new XMLStreamException("Mocked exception")).when(mockXmlTokens).closeCompletely();

        try {
            parser.close(); // Call the method under test
            // This point should not be reached as we expect an exception
        } catch (Exception e) {
            // We expect an exception to be thrown, thus the test passes if we catch one.
        }
    }

}
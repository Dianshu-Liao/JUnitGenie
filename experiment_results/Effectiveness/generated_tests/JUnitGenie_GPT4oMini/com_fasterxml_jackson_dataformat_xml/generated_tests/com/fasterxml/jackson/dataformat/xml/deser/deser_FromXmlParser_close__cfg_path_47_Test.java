package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import org.junit.Before;
import org.junit.Test;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class deser_FromXmlParser_close__cfg_path_47_Test {

    private FromXmlParser xmlParser;
    private IOContext mockIoContext;
    private XmlTokenStream mockXmlTokens;

    @Before
    public void setUp() throws IOException, XMLStreamException { // Declare IOException and XMLStreamException in the setUp method
        mockIoContext = mock(IOContext.class);
        mockXmlTokens = mock(XmlTokenStream.class);
        
        // Mocking an XMLStreamReader that is pointing to a START_ELEMENT
        javax.xml.stream.XMLStreamReader mockXmlStreamReader = mock(javax.xml.stream.XMLStreamReader.class);
        when(mockXmlStreamReader.getEventType()).thenReturn(javax.xml.stream.XMLStreamConstants.START_ELEMENT);
        
        // Assuming constructors parameters are valid
        xmlParser = new FromXmlParser(mockIoContext, 0, 0, mock(ObjectCodec.class), mockXmlStreamReader, mock(XmlNameProcessor.class));
        
        xmlParser._closed = false;  // Set initial state to allow closing
    }

    @Test(timeout = 4000)
    public void testCloseResourceManaged() throws Exception {
        when(mockIoContext.isResourceManaged()).thenReturn(true);
        xmlParser.close();

        verify(mockXmlTokens, times(1)).closeCompletely();
    }

    @Test(timeout = 4000)
    public void testCloseNotResourceManaged() throws Exception {
        when(mockIoContext.isResourceManaged()).thenReturn(false);
        when(xmlParser.isEnabled(any(com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser.Feature.class))).thenReturn(false); // Specify the correct method

        xmlParser.close();

        verify(mockXmlTokens, times(1)).close();
    }

    @Test(timeout = 4000)
    public void testCloseHandlesXMLStreamException() throws Exception {
        when(mockIoContext.isResourceManaged()).thenReturn(true);
        doThrow(new XMLStreamException()).when(mockXmlTokens).closeCompletely();
        
        try {
            xmlParser.close();
        } catch (Exception e) {
            // Exception handling
        }

        verify(mockXmlTokens, times(1)).closeCompletely();
    }

}
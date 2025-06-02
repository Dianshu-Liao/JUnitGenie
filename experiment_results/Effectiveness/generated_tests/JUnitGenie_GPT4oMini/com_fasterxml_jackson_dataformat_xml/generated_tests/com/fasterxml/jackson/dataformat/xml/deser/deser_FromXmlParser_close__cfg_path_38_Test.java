package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class deser_FromXmlParser_close__cfg_path_38_Test {

    private FromXmlParser fromXmlParser;
    private IOContext ioContext;
    private XMLStreamReader xmlStreamReader;
    private XmlTokenStream xmlTokens;

    @Before
    public void setUp() throws IOException, XMLStreamException {
        // Mock the IOContext and XMLStreamReader for the test
        ioContext = mock(IOContext.class);
        xmlStreamReader = mock(XMLStreamReader.class);
        xmlTokens = mock(XmlTokenStream.class);

        // Initialize the FromXmlParser with mocked dependencies
        // Set up the XMLStreamReader to point to a START_ELEMENT
        when(xmlStreamReader.getEventType()).thenReturn(XMLStreamReader.START_ELEMENT);
        
        fromXmlParser = new FromXmlParser(ioContext, 0, 0, (ObjectCodec) null, xmlStreamReader, null);
        setInternalState(fromXmlParser, "_xmlTokens", xmlTokens);
    }

    @Test(timeout = 4000)
    public void testClose_whenNotClosedAndResourceManaged() throws Exception {
        setInternalState(fromXmlParser, "_closed", false);
        when(ioContext.isResourceManaged()).thenReturn(true);
        
        doNothing().when(xmlTokens).closeCompletely();
        
        fromXmlParser.close();
        
        verify(xmlTokens, times(1)).closeCompletely();
    }

    @Test(timeout = 4000)
    public void testClose_whenExceptionThrown() throws Exception {
        setInternalState(fromXmlParser, "_closed", false);
        when(ioContext.isResourceManaged()).thenReturn(false);
        
        doThrow(new XMLStreamException("Mock Exception")).when(xmlTokens).close();
        
        try {
            fromXmlParser.close();
        } catch (IOException e) {
            // Handle the expected exception
        }

        verify(fromXmlParser, times(1))._releaseBuffers();
    }

    @After
    public void tearDown() {
        fromXmlParser = null;
        ioContext = null;
        xmlStreamReader = null;
        xmlTokens = null;
    }

    private void setInternalState(FromXmlParser parser, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = parser.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            if (value instanceof Boolean) {
                field.setBoolean(parser, (Boolean) value);
            } else {
                field.set(parser, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
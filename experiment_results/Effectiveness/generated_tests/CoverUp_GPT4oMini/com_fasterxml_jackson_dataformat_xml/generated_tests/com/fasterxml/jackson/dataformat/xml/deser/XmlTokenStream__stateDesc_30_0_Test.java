package com.fasterxml.jackson.dataformat.xml.deser;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.stream.*;
import org.codehaus.stax2.XMLStreamLocation2;
import org.codehaus.stax2.XMLStreamReader2;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter;

public class XmlTokenStream__stateDesc_30_0_Test {

    private XmlTokenStream xmlTokenStream;

    @BeforeEach
    public void setUp() {
        XMLStreamReader xmlReader = mock(XMLStreamReader.class);
        xmlTokenStream = new XmlTokenStream(xmlReader, null, 0, null);
    }

    @Test
    public void testStateDesc_XML_START_ELEMENT() {
        String result = invokeStateDesc(XmlTokenStream.XML_START_ELEMENT);
        assertEquals("XML_START_ELEMENT", result);
    }

    @Test
    public void testStateDesc_XML_END_ELEMENT() {
        String result = invokeStateDesc(XmlTokenStream.XML_END_ELEMENT);
        assertEquals("XML_END_ELEMENT", result);
    }

    @Test
    public void testStateDesc_XML_ATTRIBUTE_NAME() {
        String result = invokeStateDesc(XmlTokenStream.XML_ATTRIBUTE_NAME);
        assertEquals("XML_ATTRIBUTE_NAME", result);
    }

    @Test
    public void testStateDesc_XML_ATTRIBUTE_VALUE() {
        String result = invokeStateDesc(XmlTokenStream.XML_ATTRIBUTE_VALUE);
        assertEquals("XML_ATTRIBUTE_VALUE", result);
    }

    @Test
    public void testStateDesc_XML_TEXT() {
        String result = invokeStateDesc(XmlTokenStream.XML_TEXT);
        assertEquals("XML_TEXT", result);
    }

    @Test
    public void testStateDesc_XML_ROOT_TEXT() {
        String result = invokeStateDesc(XmlTokenStream.XML_ROOT_TEXT);
        assertEquals("XML_ROOT_TEXT", result);
    }

    @Test
    public void testStateDesc_XML_END() {
        String result = invokeStateDesc(XmlTokenStream.XML_END);
        assertEquals("XML_END", result);
    }

    @Test
    public void testStateDesc_InvalidState() {
        // Some invalid state
        int invalidState = 999;
        String result = invokeStateDesc(invalidState);
        // _currentState should be 0 by default
        assertEquals("N/A (0)", result);
    }

    private String invokeStateDesc(int state) {
        try {
            java.lang.reflect.Method method = XmlTokenStream.class.getDeclaredMethod("_stateDesc", int.class);
            method.setAccessible(true);
            return (String) method.invoke(xmlTokenStream, state);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

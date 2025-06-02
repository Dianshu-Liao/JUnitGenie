package com.fasterxml.jackson.dataformat.xml.deser;

import org.codehaus.stax2.XMLStreamReader2;
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
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter;

public class XmlTokenStream_skipAttributes_16_0_Test {

    private XmlTokenStream xmlTokenStream;

    private XMLStreamReader2 xmlStreamReaderMock;

    @BeforeEach
    public void setUp() {
        xmlStreamReaderMock = mock(XMLStreamReader2.class);
        xmlTokenStream = new XmlTokenStream(xmlStreamReaderMock, null, 0, null);
    }

    @Test
    public void testSkipAttributesWhenCurrentStateIsAttributeName() {
        xmlTokenStream._currentState = XmlTokenStream.XML_ATTRIBUTE_NAME;
        // Simulate some attributes present
        xmlTokenStream._attributeCount = 5;
        xmlTokenStream.skipAttributes();
        assertEquals(0, xmlTokenStream._attributeCount);
        assertEquals(XmlTokenStream.XML_START_ELEMENT, xmlTokenStream._currentState);
    }

    @Test
    public void testSkipAttributesWhenCurrentStateIsStartElement() {
        xmlTokenStream._currentState = XmlTokenStream.XML_START_ELEMENT;
        xmlTokenStream.skipAttributes();
        assertEquals(XmlTokenStream.XML_START_ELEMENT, xmlTokenStream._currentState);
    }

    @Test
    public void testSkipAttributesWhenCurrentStateIsText() {
        xmlTokenStream._currentState = XmlTokenStream.XML_TEXT;
        xmlTokenStream.skipAttributes();
        assertEquals(XmlTokenStream.XML_TEXT, xmlTokenStream._currentState);
    }

    @Test
    public void testSkipAttributesThrowsExceptionForInvalidState() {
        // Invalid state
        xmlTokenStream._currentState = 99;
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            xmlTokenStream.skipAttributes();
        });
        assertEquals("Current state not XML_START_ELEMENT or XML_ATTRIBUTE_NAME but " + xmlTokenStream._currentStateDesc(), exception.getMessage());
    }
}

package com.fasterxml.jackson.dataformat.xml.deser;

import org.codehaus.stax2.XMLStreamReader2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.stream.*;
import org.codehaus.stax2.XMLStreamLocation2;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter;

@ExtendWith(MockitoExtension.class)
class XmlTokenStream__handleRepeatElement_25_0_Test {

    private XmlTokenStream xmlTokenStream;

    private XMLStreamReader2 mockXmlReader;

    private ElementWrapper mockWrapper;

    private static final int REPLAY_START_DUP = 1;

    private static final int REPLAY_END = 2;

    private static final int REPLAY_START_DELAYED = 3;

    @BeforeEach
    void setUp() {
        mockXmlReader = Mockito.mock(XMLStreamReader2.class);
        mockWrapper = Mockito.mock(ElementWrapper.class);
        xmlTokenStream = new XmlTokenStream(mockXmlReader, null, 0, null);
        xmlTokenStream._currentWrapper = mockWrapper;
    }

    @Test
    void testHandleRepeatElementReplayStartDup() throws XMLStreamException {
        xmlTokenStream._repeatElement = REPLAY_START_DUP;
        int result = xmlTokenStream._handleRepeatElement();
        assertEquals(XmlTokenStream.XML_START_ELEMENT, result);
        assertNotNull(xmlTokenStream._currentWrapper);
    }

    @Test
    void testHandleRepeatElementReplayEnd() throws XMLStreamException {
        xmlTokenStream._repeatElement = REPLAY_END;
        xmlTokenStream._localName = "testLocalName";
        xmlTokenStream._namespaceURI = "testNamespaceURI";
        int result = xmlTokenStream._handleRepeatElement();
        assertEquals(XmlTokenStream.XML_END_ELEMENT, result);
        assertNotNull(xmlTokenStream._currentWrapper);
        assertEquals("testWrapper", xmlTokenStream._currentWrapper.getWrapperLocalName());
    }

    @Test
    void testHandleRepeatElementReplayStartDelayed() throws XMLStreamException {
        xmlTokenStream._repeatElement = REPLAY_START_DELAYED;
        xmlTokenStream._nextLocalName = "nextLocalName";
        xmlTokenStream._nextNamespaceURI = "nextNamespaceURI";
        int result = xmlTokenStream._handleRepeatElement();
        assertEquals(XmlTokenStream.XML_START_ELEMENT, result);
        assertNotNull(xmlTokenStream._currentWrapper);
        assertEquals("nextLocalName", xmlTokenStream._localName);
        assertEquals("nextNamespaceURI", xmlTokenStream._namespaceURI);
    }

    @Test
    void testHandleRepeatElementUnrecognizedType() {
        xmlTokenStream._repeatElement = 99;
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            xmlTokenStream._handleRepeatElement();
        });
        assertEquals("Unrecognized type to repeat: 99", exception.getMessage());
    }
}

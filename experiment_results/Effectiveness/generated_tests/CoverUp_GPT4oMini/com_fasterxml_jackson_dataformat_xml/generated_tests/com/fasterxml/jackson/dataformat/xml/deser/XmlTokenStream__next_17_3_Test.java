package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.ri.Stax2ReaderAdapter;
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
import com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter;

class XmlTokenStream__next_17_3_Test {

    private XmlTokenStream xmlTokenStream;

    private XMLStreamReader2 xmlStreamReaderMock;

    private ContentReference contentReferenceMock;

    private XmlNameProcessor xmlNameProcessorMock;

    @BeforeEach
    void setUp() {
        xmlStreamReaderMock = mock(XMLStreamReader2.class);
        contentReferenceMock = mock(ContentReference.class);
        xmlNameProcessorMock = mock(XmlNameProcessor.class);
        xmlTokenStream = new XmlTokenStream(xmlStreamReaderMock, contentReferenceMock, 0, xmlNameProcessorMock);
    }

    @Test
    void testNext_StartElement() throws XMLStreamException {
        when(xmlStreamReaderMock.getEventType()).thenReturn(XMLStreamReader.START_ELEMENT);
        when(xmlStreamReaderMock.hasNext()).thenReturn(true);
        when(xmlStreamReaderMock.next()).thenReturn(XMLStreamReader.START_ELEMENT);
        int result = invokeNext();
        assertEquals(XmlTokenStream.XML_START_ELEMENT, result);
    }

    @Test
    void testNext_EndElement() throws XMLStreamException {
        when(xmlStreamReaderMock.getEventType()).thenReturn(XMLStreamReader.END_ELEMENT);
        when(xmlStreamReaderMock.hasNext()).thenReturn(true);
        when(xmlStreamReaderMock.next()).thenReturn(XMLStreamReader.END_ELEMENT);
        int result = invokeNext();
        assertEquals(XmlTokenStream.XML_END_ELEMENT, result);
    }

    @Test
    void testNext_AttributeValue() throws XMLStreamException {
        xmlTokenStream._currentState = XmlTokenStream.XML_ATTRIBUTE_VALUE;
        xmlTokenStream._nextAttributeIndex = 0;
        xmlTokenStream._attributeCount = 1;
        when(xmlStreamReaderMock.getAttributeNamespace(0)).thenReturn("namespace");
        when(xmlStreamReaderMock.getAttributeLocalName(0)).thenReturn("attributeName");
        when(xmlStreamReaderMock.getAttributeValue(0)).thenReturn("attributeValue");
        int result = invokeNext();
        assertEquals(XmlTokenStream.XML_ATTRIBUTE_NAME, result);
        assertEquals("attributeValue", xmlTokenStream.getText());
    }

    @Test
    void testNext_Text() throws XMLStreamException {
        xmlTokenStream._currentState = XmlTokenStream.XML_TEXT;
        xmlTokenStream._startElementAfterText = true;
        when(xmlStreamReaderMock.getEventType()).thenReturn(XMLStreamReader.END_ELEMENT);
        when(xmlStreamReaderMock.hasNext()).thenReturn(true);
        when(xmlStreamReaderMock.next()).thenReturn(XMLStreamReader.END_ELEMENT);
        int result = invokeNext();
        assertEquals(XmlTokenStream.XML_END_ELEMENT, result);
    }

    @Test
    void testNext_XsiNilFound() throws XMLStreamException {
        xmlTokenStream._xsiNilFound = true;
        when(xmlStreamReaderMock.getEventType()).thenReturn(XMLStreamReader.START_ELEMENT);
        int result = invokeNext();
        assertEquals(XmlTokenStream.XML_END_ELEMENT, result);
        assertFalse(xmlTokenStream._xsiNilFound);
    }

    private int invokeNext() {
        try {
            java.lang.reflect.Method method = XmlTokenStream.class.getDeclaredMethod("_next");
            method.setAccessible(true);
            return (int) method.invoke(xmlTokenStream);
        } catch (Exception e) {
            fail("Invocation failed: " + e.getMessage());
            // unreachable
            return -1;
        }
    }
}

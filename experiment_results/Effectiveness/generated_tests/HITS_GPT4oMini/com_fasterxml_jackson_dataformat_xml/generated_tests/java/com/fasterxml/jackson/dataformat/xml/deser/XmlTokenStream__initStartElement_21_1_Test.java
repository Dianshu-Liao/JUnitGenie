package com.fasterxml.jackson.dataformat.xml.deser;

import org.codehaus.stax2.XMLStreamReader2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import javax.xml.XMLConstants;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.xml.stream.*;
import org.codehaus.stax2.XMLStreamLocation2;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter;

public class XmlTokenStream__initStartElement_21_1_Test {

    private XmlTokenStream xmlTokenStream;

    private XMLStreamReader2 mockXmlReader;

    private ContentReference mockContentReference;

    private XmlNameProcessor mockNameProcessor;

    @BeforeEach
    public void setUp() throws XMLStreamException {
        mockXmlReader = mock(XMLStreamReader2.class);
        mockContentReference = mock(ContentReference.class);
        mockNameProcessor = mock(XmlNameProcessor.class);
        xmlTokenStream = new XmlTokenStream(mockXmlReader, mockContentReference, 0, mockNameProcessor);
    }

    private int invokeInitStartElement() throws Exception {
        Method method = XmlTokenStream.class.getDeclaredMethod("_initStartElement");
        method.setAccessible(true);
        return (int) method.invoke(xmlTokenStream);
    }

    private int getReplayStartDelayed() throws Exception {
        Field field = XmlTokenStream.class.getDeclaredField("REPLAY_START_DELAYED");
        field.setAccessible(true);
        return (int) field.get(null);
    }

    @Test
    public void testInitStartElement_WithMatchingWrapper() throws Exception {
        ElementWrapper mockWrapper = mock(ElementWrapper.class);
        when(mockWrapper.matchesWrapper(anyString(), anyString())).thenReturn(true);
        xmlTokenStream._currentWrapper = mockWrapper;
        when(mockXmlReader.getNamespaceURI()).thenReturn("namespace");
        when(mockXmlReader.getLocalName()).thenReturn("localName");
        int result = invokeInitStartElement();
        assertEquals(XmlTokenStream.XML_START_ELEMENT, result);
        assertSame(mockWrapper, xmlTokenStream._currentWrapper);
    }

    @Test
    public void testInitStartElement_WithNonMatchingWrapper() throws Exception {
        ElementWrapper mockWrapper = mock(ElementWrapper.class);
        when(mockWrapper.matchesWrapper(anyString(), anyString())).thenReturn(false);
        when(mockWrapper.getWrapperLocalName()).thenReturn("wrapperLocalName");
        when(mockWrapper.getWrapperNamespace()).thenReturn("wrapperNamespace");
        xmlTokenStream._currentWrapper = mockWrapper;
        when(mockXmlReader.getNamespaceURI()).thenReturn("namespace");
        when(mockXmlReader.getLocalName()).thenReturn("localName");
        int result = invokeInitStartElement();
        assertEquals(XmlTokenStream.XML_END_ELEMENT, result);
        assertEquals("wrapperLocalName", xmlTokenStream._localName);
        assertEquals("wrapperNamespace", xmlTokenStream._namespaceURI);
        assertNull(xmlTokenStream._currentWrapper);
        assertEquals(getReplayStartDelayed(), xmlTokenStream._repeatElement);
    }

    @Test
    public void testInitStartElement_WithNoWrapper() throws Exception {
        xmlTokenStream._currentWrapper = null;
        when(mockXmlReader.getNamespaceURI()).thenReturn("namespace");
    }
}

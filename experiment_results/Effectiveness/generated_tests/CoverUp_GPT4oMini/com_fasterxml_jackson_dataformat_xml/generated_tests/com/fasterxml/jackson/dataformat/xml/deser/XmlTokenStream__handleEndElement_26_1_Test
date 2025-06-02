package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.dataformat.xml.deser.ElementWrapper;
import com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter;
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

class XmlTokenStream__handleEndElement_26_1_Test {

    private XmlTokenStream xmlTokenStream;

    private XMLStreamReader2 mockXmlReader;

    private ElementWrapper mockWrapper;

    @BeforeEach
    void setUp() {
        // Mocking the XMLStreamReader2 and ElementWrapper
        mockXmlReader = mock(XMLStreamReader2.class);
        mockWrapper = mock(ElementWrapper.class);
        // Initializing XmlTokenStream with mocked dependencies
        xmlTokenStream = new XmlTokenStream(mockXmlReader, null, 0, null);
    }

    @Test
    void testHandleEndElementWithMatchingWrapper() throws Exception {
        // Setup the state to simulate a matching wrapper
        when(mockWrapper.isMatching()).thenReturn(true);
        when(mockWrapper.getWrapperLocalName()).thenReturn("testLocalName");
        when(mockWrapper.getWrapperNamespace()).thenReturn("testNamespace");
        xmlTokenStream._currentWrapper = mockWrapper;
        // Invoke the private method using reflection
        java.lang.reflect.Method method = XmlTokenStream.class.getDeclaredMethod("_handleEndElement");
        method.setAccessible(true);
        int result = (int) method.invoke(xmlTokenStream);
        // Verify the state after method invocation
        assertEquals(XmlTokenStream.XML_END_ELEMENT, result);
        assertEquals("testLocalName", xmlTokenStream._localName);
        assertEquals("testNamespace", xmlTokenStream._namespaceURI);
        // REPLAY_END
        assertEquals(2, xmlTokenStream._repeatElement);
        // Parent should still be the same
        assertEquals(mockWrapper, xmlTokenStream._currentWrapper);
    }

    @Test
    void testHandleEndElementWithNonMatchingWrapper() throws Exception {
        // Setup the state to simulate a non-matching wrapper
        when(mockWrapper.isMatching()).thenReturn(false);
        xmlTokenStream._currentWrapper = mockWrapper;
        // Invoke the private method using reflection
        java.lang.reflect.Method method = XmlTokenStream.class.getDeclaredMethod("_handleEndElement");
        method.setAccessible(true);
        int result = (int) method.invoke(xmlTokenStream);
        // Verify the state after method invocation
        assertEquals(XmlTokenStream.XML_END_ELEMENT, result);
        assertEquals("", xmlTokenStream._localName);
        assertEquals("", xmlTokenStream._namespaceURI);
        // Current wrapper should be the parent
        assertEquals(mockWrapper.getParent(), xmlTokenStream._currentWrapper);
    }

    @Test
    void testHandleEndElementWithNullWrapper() throws Exception {
        // Setup the state to simulate a null wrapper
        xmlTokenStream._currentWrapper = null;
        // Invoke the private method using reflection
        java.lang.reflect.Method method = XmlTokenStream.class.getDeclaredMethod("_handleEndElement");
        method.setAccessible(true);
        int result = (int) method.invoke(xmlTokenStream);
        // Verify the state after method invocation
        assertEquals(XmlTokenStream.XML_END_ELEMENT, result);
        assertEquals("", xmlTokenStream._localName);
        assertEquals("", xmlTokenStream._namespaceURI);
        // Should remain null
        assertEquals(null, xmlTokenStream._currentWrapper);
    }
}

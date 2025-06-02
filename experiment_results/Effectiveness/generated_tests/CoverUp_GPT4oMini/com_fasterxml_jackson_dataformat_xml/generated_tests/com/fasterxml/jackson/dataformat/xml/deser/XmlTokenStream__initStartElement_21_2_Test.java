package com.fasterxml.jackson.dataformat.xml.deser;

import javax.xml.XMLConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.codehaus.stax2.XMLStreamReader2;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.deser.ElementWrapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import org.codehaus.stax2.XMLStreamLocation2;
import com.fasterxml.jackson.core.JsonLocation;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.xml.stream.*;
import com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter;

class XmlTokenStream__initStartElement_21_2_Test {

    private XmlTokenStream xmlTokenStream;

    private XMLStreamReader2 mockXmlReader;

    private ContentReference mockContentReference;

    private XmlNameProcessor mockNameProcessor;

    @BeforeEach
    void setUp() {
        mockXmlReader = mock(XMLStreamReader2.class);
        mockContentReference = mock(ContentReference.class);
        mockNameProcessor = mock(XmlNameProcessor.class);
        xmlTokenStream = new XmlTokenStream(mockXmlReader, mockContentReference, 0, mockNameProcessor);
    }

    @Test
    void testInitStartElementWithMatchingWrapper() throws Exception {
        // Arrange
        String localName = "element";
        String namespaceURI = "namespace";
        ElementWrapper wrapper = createElementWrapper(localName, namespaceURI);
        xmlTokenStream._currentWrapper = wrapper;
        when(mockXmlReader.getNamespaceURI()).thenReturn(namespaceURI);
        when(mockXmlReader.getLocalName()).thenReturn(localName);
        // Act
        invokePrivateInitStartElement();
        // Assert
        assertEquals(XmlTokenStream.XML_START_ELEMENT, xmlTokenStream.getCurrentToken());
    }

    @Test
    void testInitStartElementWithNonMatchingWrapper() throws Exception {
        // Arrange
        String localName = "element";
        String namespaceURI = "namespace";
        ElementWrapper wrapper = createElementWrapper("differentElement", "differentNamespace");
        xmlTokenStream._currentWrapper = wrapper;
        when(mockXmlReader.getNamespaceURI()).thenReturn(namespaceURI);
        when(mockXmlReader.getLocalName()).thenReturn(localName);
        when(mockXmlReader.getAttributeCount()).thenReturn(0);
        // Act
        int result = invokePrivateInitStartElement();
        // Assert
        assertEquals(XmlTokenStream.XML_END_ELEMENT, result);
        assertEquals(localName, xmlTokenStream._nextLocalName);
        assertEquals(namespaceURI, xmlTokenStream._nextNamespaceURI);
    }

    @Test
    void testInitStartElementWithNullWrapper() throws Exception {
        // Arrange
        xmlTokenStream._currentWrapper = null;
        String localName = "element";
        String namespaceURI = "namespace";
        when(mockXmlReader.getNamespaceURI()).thenReturn(namespaceURI);
        when(mockXmlReader.getLocalName()).thenReturn(localName);
        // Act
        invokePrivateInitStartElement();
        // Assert
        assertEquals(XmlTokenStream.XML_START_ELEMENT, xmlTokenStream.getCurrentToken());
    }

    private int invokePrivateInitStartElement() throws Exception {
        Method method = XmlTokenStream.class.getDeclaredMethod("_initStartElement");
        method.setAccessible(true);
        return (int) method.invoke(xmlTokenStream);
    }

    private ElementWrapper createElementWrapper(String localName, String namespaceURI) throws Exception {
        // Use reflection to access the private constructor of ElementWrapper
        Class<?> clazz = ElementWrapper.class;
        Constructor<?> constructor = clazz.getDeclaredConstructor(ElementWrapper.class, String.class, String.class);
        constructor.setAccessible(true);
        return (ElementWrapper) constructor.newInstance(null, localName, namespaceURI);
    }
}

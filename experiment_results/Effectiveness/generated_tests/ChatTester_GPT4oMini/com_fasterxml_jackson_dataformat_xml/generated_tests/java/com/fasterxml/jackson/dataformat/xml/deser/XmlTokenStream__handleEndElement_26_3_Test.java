package com.fasterxml.jackson.dataformat.xml.deser;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import javax.xml.XMLConstants;
import org.codehaus.stax2.XMLStreamLocation2;
import org.codehaus.stax2.XMLStreamReader2;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.xml.stream.*;

class XmlTokenStream__handleEndElement_26_3_Test {

    private XMLStreamReader xmlReader;

    private ContentReference sourceReference;

    private XmlNameProcessor nameProcessor;

    private XmlTokenStream xmlTokenStream;

    @BeforeEach
    void setUp() {
        xmlReader = mock(XMLStreamReader.class);
        sourceReference = mock(ContentReference.class);
        nameProcessor = mock(XmlNameProcessor.class);
        xmlTokenStream = new XmlTokenStream(xmlReader, sourceReference, 0, nameProcessor);
    }

    @Test
    void testHandleEndElementWithMatchingWrapper() throws Exception {
        // Setup mock for _currentWrapper
        ElementWrapper matchingWrapper = mock(ElementWrapper.class);
        when(matchingWrapper.isMatching()).thenReturn(true);
        when(matchingWrapper.getWrapperLocalName()).thenReturn("localName");
        when(matchingWrapper.getWrapperNamespace()).thenReturn("namespaceURI");
        // Use reflection to set the private field _currentWrapper
        setPrivateField(xmlTokenStream, "_currentWrapper", matchingWrapper);
        // Invoke the private method _handleEndElement
        int result = invokePrivateMethod(xmlTokenStream, "_handleEndElement");
        // Verify the state and the result
        assertEquals(XmlTokenStream.XML_END_ELEMENT, result);
        assertEquals("localName", getPrivateField(xmlTokenStream, "_localName"));
        assertEquals("namespaceURI", getPrivateField(xmlTokenStream, "_namespaceURI"));
        assertEquals(1, getPrivateField(xmlTokenStream, "_repeatElement"));
    }

    @Test
    void testHandleEndElementWithNonMatchingWrapper() throws Exception {
        // Setup mock for _currentWrapper
        ElementWrapper nonMatchingWrapper = mock(ElementWrapper.class);
        when(nonMatchingWrapper.isMatching()).thenReturn(false);
        // Use reflection to set the private field _currentWrapper
        setPrivateField(xmlTokenStream, "_currentWrapper", nonMatchingWrapper);
        // Invoke the private method _handleEndElement
        int result = invokePrivateMethod(xmlTokenStream, "_handleEndElement");
        // Verify the state and the result
        assertEquals(XmlTokenStream.XML_END_ELEMENT, result);
        assertEquals("", getPrivateField(xmlTokenStream, "_localName"));
        assertEquals("", getPrivateField(xmlTokenStream, "_namespaceURI"));
    }

    @Test
    void testHandleEndElementWithNoCurrentWrapper() throws Exception {
        // Use reflection to set the private field _currentWrapper to null
        setPrivateField(xmlTokenStream, "_currentWrapper", null);
        // Invoke the private method _handleEndElement
        int result = invokePrivateMethod(xmlTokenStream, "_handleEndElement");
        // Verify the state and the result
        assertEquals(XmlTokenStream.XML_END_ELEMENT, result);
        assertEquals("", getPrivateField(xmlTokenStream, "_localName"));
        assertEquals("", getPrivateField(xmlTokenStream, "_namespaceURI"));
    }

    // Reflection utility methods
    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private Object getPrivateField(Object obj, String fieldName) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

    private int invokePrivateMethod(Object obj, String methodName) throws Exception {
        java.lang.reflect.Method method = obj.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        return (int) method.invoke(obj);
    }
}

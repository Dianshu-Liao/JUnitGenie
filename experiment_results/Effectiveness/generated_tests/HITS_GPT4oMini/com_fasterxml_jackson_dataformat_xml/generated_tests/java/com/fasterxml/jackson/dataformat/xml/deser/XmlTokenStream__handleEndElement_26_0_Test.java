package com.fasterxml.jackson.dataformat.xml.deser;

import org.codehaus.stax2.XMLStreamReader2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import javax.xml.XMLConstants;
import org.codehaus.stax2.XMLStreamLocation2;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.xml.stream.*;

public class XmlTokenStream__handleEndElement_26_0_Test {

    private XmlTokenStream xmlTokenStream;

    private ElementWrapper mockWrapper;

    @Mock
    private XMLStreamReader2 mockStreamReader;

    @Mock
    private ContentReference mockContentReference;

    @Mock
    private XmlNameProcessor mockNameProcessor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // Initialize the XmlTokenStream with required parameters
        xmlTokenStream = new XmlTokenStream(mockStreamReader, mockContentReference, 0, mockNameProcessor);
        mockWrapper = mock(ElementWrapper.class);
        xmlTokenStream._currentWrapper = mockWrapper;
    }

    private int invokeHandleEndElement() throws Exception {
        Method method = XmlTokenStream.class.getDeclaredMethod("_handleEndElement");
        method.setAccessible(true);
        return (int) method.invoke(xmlTokenStream);
    }

    @Test
    public void test_handleEndElement_WhenWrapperIsMatching() throws Exception {
        // Arrange
        when(mockWrapper.isMatching()).thenReturn(true);
        when(mockWrapper.getWrapperLocalName()).thenReturn("localName");
        when(mockWrapper.getWrapperNamespace()).thenReturn("namespaceURI");
        when(mockWrapper.getParent()).thenReturn(null);
        // Act
        int result = invokeHandleEndElement();
        // Assert
        assertEquals(XmlTokenStream.XML_END_ELEMENT, result);
        assertEquals("localName", xmlTokenStream._localName);
        assertEquals("namespaceURI", xmlTokenStream._namespaceURI);
        assertNull(xmlTokenStream._currentWrapper);
    }

    @Test
    public void test_handleEndElement_WhenWrapperIsNotMatching() throws Exception {
        // Arrange
        when(mockWrapper.isMatching()).thenReturn(false);
        when(mockWrapper.getParent()).thenReturn(null);
        // Act
        int result = invokeHandleEndElement();
        // Assert
        assertEquals(XmlTokenStream.XML_END_ELEMENT, result);
        assertEquals("", xmlTokenStream._localName);
        assertEquals("", xmlTokenStream._namespaceURI);
        assertNull(xmlTokenStream._currentWrapper);
    }
}

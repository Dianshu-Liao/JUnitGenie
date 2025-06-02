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

public class XmlTokenStream__decodeElementName_23_1_Test {

    @Mock
    private XMLStreamReader xmlReader;

    @Mock
    private ContentReference sourceReference;

    @Mock
    private XmlNameProcessor nameProcessor;

    private XmlTokenStream xmlTokenStream;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        xmlTokenStream = new XmlTokenStream(xmlReader, sourceReference, 0, nameProcessor);
    }

    @Test
    public void testDecodeElementName_WithXsiType() throws Exception {
        // Setup
        xmlTokenStream._cfgProcessXsiType = true;
        String namespaceURI = XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI;
        String localName = "type";
        // Invoke the method using reflection
        invokeDecodeElementName(namespaceURI, localName);
        // Verify the results
        assertEquals("xsi:type", xmlTokenStream._localName);
        assertEquals("", xmlTokenStream._namespaceURI);
    }

    @Test
    public void testDecodeElementName_WithoutXsiType() throws Exception {
        // Setup
        xmlTokenStream._cfgProcessXsiType = false;
        String namespaceURI = "http://example.com";
        String localName = "element";
        // Invoke the method using reflection
        invokeDecodeElementName(namespaceURI, localName);
        // Verify the results
        assertEquals("element", xmlTokenStream._localName);
        assertEquals(namespaceURI, xmlTokenStream._namespaceURI);
        verify(nameProcessor).decodeName(xmlTokenStream._nameToDecode);
    }

    @Test
    public void testDecodeElementName_WithDifferentNamespace() throws Exception {
        // Setup
        xmlTokenStream._cfgProcessXsiType = false;
        String namespaceURI = "http://different.com";
        String localName = "anotherElement";
        // Invoke the method using reflection
        invokeDecodeElementName(namespaceURI, localName);
        // Verify the results
        assertEquals("anotherElement", xmlTokenStream._localName);
        assertEquals(namespaceURI, xmlTokenStream._namespaceURI);
        verify(nameProcessor).decodeName(xmlTokenStream._nameToDecode);
    }

    private void invokeDecodeElementName(String namespaceURI, String localName) throws Exception {
        java.lang.reflect.Method method = XmlTokenStream.class.getDeclaredMethod("_decodeElementName", String.class, String.class);
        method.setAccessible(true);
        method.invoke(xmlTokenStream, namespaceURI, localName);
    }
}

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

class XmlTokenStream__decodeAttributeName_24_0_Test {

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
    void testDecodeAttributeName_WithXsiType() throws Exception {
        // Set the configuration to process xsi:type
        setPrivateField(xmlTokenStream, "_cfgProcessXsiType", true);
        // Call the focal method with xsi:type
        String namespaceURI = XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI;
        String localName = "type";
        xmlTokenStream._decodeAttributeName(namespaceURI, localName);
        // Validate the state after the method call
        assertEquals("xsi:type", getPrivateField(xmlTokenStream, "_localName"));
        assertEquals("", getPrivateField(xmlTokenStream, "_namespaceURI"));
    }

    @Test
    void testDecodeAttributeName_WithDifferentLocalName() throws Exception {
        // Set the configuration to process xsi:type
        setPrivateField(xmlTokenStream, "_cfgProcessXsiType", true);
        // Call the focal method with a different local name
        String namespaceURI = XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI;
        String localName = "other";
        xmlTokenStream._decodeAttributeName(namespaceURI, localName);
        // Validate the state after the method call
        assertEquals("other", getPrivateField(xmlTokenStream, "_localName"));
        assertEquals(namespaceURI, getPrivateField(xmlTokenStream, "_namespaceURI"));
        verify(nameProcessor).decodeName(any(XmlNameProcessor.XmlName.class));
    }

    @Test
    void testDecodeAttributeName_WithNonXsiType() throws Exception {
        // Set the configuration to not process xsi:type
        setPrivateField(xmlTokenStream, "_cfgProcessXsiType", false);
        // Call the focal method with xsi:type
        String namespaceURI = XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI;
        String localName = "type";
        xmlTokenStream._decodeAttributeName(namespaceURI, localName);
        // Validate the state after the method call
        assertEquals("type", getPrivateField(xmlTokenStream, "_localName"));
        assertEquals(namespaceURI, getPrivateField(xmlTokenStream, "_namespaceURI"));
        verify(nameProcessor).decodeName(any(XmlNameProcessor.XmlName.class));
    }

    @Test
    void testDecodeAttributeName_WithDifferentNamespace() throws Exception {
        // Set the configuration to process xsi:type
        setPrivateField(xmlTokenStream, "_cfgProcessXsiType", true);
        // Call the focal method with a different namespace
        String namespaceURI = "http://example.com/other";
        String localName = "attribute";
        xmlTokenStream._decodeAttributeName(namespaceURI, localName);
        // Validate the state after the method call
        assertEquals("attribute", getPrivateField(xmlTokenStream, "_localName"));
        assertEquals(namespaceURI, getPrivateField(xmlTokenStream, "_namespaceURI"));
        verify(nameProcessor).decodeName(any(XmlNameProcessor.XmlName.class));
    }

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
}

package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream;
import com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter;
import org.codehaus.stax2.XMLStreamReader2;
import javax.xml.XMLConstants;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import javax.xml.stream.*;
import org.codehaus.stax2.XMLStreamLocation2;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;

class XmlTokenStream__decodeElementName_23_2_Test {

    private XmlTokenStream xmlTokenStream;

    private XMLStreamReader2 mockXmlReader;

    private ContentReference mockContentReference;

    private XmlNameProcessor mockNameProcessor;

    @BeforeEach
    void setUp() {
        mockXmlReader = Stax2JacksonReaderAdapter.wrapIfNecessary(mock(XMLStreamReader.class));
        mockContentReference = mock(ContentReference.class);
        mockNameProcessor = mock(XmlNameProcessor.class);
        xmlTokenStream = new XmlTokenStream(mockXmlReader, mockContentReference, 0, mockNameProcessor);
    }

    @Test
    void testDecodeElementNameWithXsiType() throws Exception {
        // Set up the conditions for xsi:type processing
        xmlTokenStream.setFormatFeatures(FromXmlParser.Feature.AUTO_DETECT_XSI_TYPE.getMask());
        String namespaceURI = XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI;
        String localName = "type";
        // Call the private method using reflection
        invokePrivateMethod(xmlTokenStream, "_decodeElementName", namespaceURI, localName);
        // Validate that the localName and namespaceURI have been updated as expected
        assertEquals("xsi:type", xmlTokenStream.getLocalName());
        assertEquals("", xmlTokenStream.getNamespaceURI());
    }

    @Test
    void testDecodeElementNameWithoutXsiType() throws Exception {
        // Ensure xsi:type processing is disabled
        xmlTokenStream.setFormatFeatures(0);
        String namespaceURI = "http://example.com/namespace";
        String localName = "element";
        // Call the private method using reflection
        invokePrivateMethod(xmlTokenStream, "_decodeElementName", namespaceURI, localName);
        // Validate that the localName and namespaceURI are set correctly
        assertEquals(localName, xmlTokenStream.getLocalName());
        assertEquals(namespaceURI, xmlTokenStream.getNamespaceURI());
    }

    private void invokePrivateMethod(XmlTokenStream instance, String methodName, String namespaceURI, String localName) throws Exception {
        java.lang.reflect.Method method = XmlTokenStream.class.getDeclaredMethod(methodName, String.class, String.class);
        method.setAccessible(true);
        method.invoke(instance, namespaceURI, localName);
    }
}

package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamReader2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import javax.xml.XMLConstants;
import org.codehaus.stax2.XMLStreamLocation2;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.xml.stream.*;

class XmlTokenStream__decodeAttributeName_24_1_Test {

    private XmlTokenStream xmlTokenStream;

    private XMLStreamReader2 xmlStreamReader;

    private ContentReference contentReference;

    private XmlNameProcessor xmlNameProcessor;

    @BeforeEach
    void setUp() throws XMLStreamException {
        xmlStreamReader = mock(XMLStreamReader2.class);
        contentReference = mock(ContentReference.class);
        // Use mock for XmlNameProcessor
        xmlNameProcessor = mock(XmlNameProcessor.class);
        xmlTokenStream = new XmlTokenStream(xmlStreamReader, contentReference, 0, xmlNameProcessor);
    }

    @Test
    void testDecodeAttributeNameXsiType() {
        String namespaceURI = "http://www.w3.org/2001/XMLSchema-instance";
        String localName = "type";
        // Set the configuration to process xsi:type
        xmlTokenStream._cfgProcessXsiType = true;
        xmlTokenStream._decodeAttributeName(namespaceURI, localName);
        // Check if the local name and namespace URI are set correctly
        assertEquals("xsi:type", xmlTokenStream._localName);
        assertEquals("", xmlTokenStream._namespaceURI);
    }

    @Test
    void testDecodeAttributeNameRegular() {
        String namespaceURI = "http://example.com";
        String localName = "attribute";
        xmlTokenStream._decodeAttributeName(namespaceURI, localName);
        // Check if the local name and namespace URI are set correctly
        assertEquals("attribute", xmlTokenStream._localName);
        assertEquals("http://example.com", xmlTokenStream._namespaceURI);
    }
}

package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamReader2;
import org.codehaus.stax2.XMLStreamLocation2;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.stream.*;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter;

class // Additional tests can be added to cover more scenarios if needed
XmlTokenStream_skipAttributes_16_2_Test {

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
    void testSkipAttributesWithAttributeNameState() {
        xmlTokenStream._currentState = XmlTokenStream.XML_ATTRIBUTE_NAME;
        xmlTokenStream.skipAttributes();
        assertEquals(0, xmlTokenStream._attributeCount);
        assertEquals(XmlTokenStream.XML_START_ELEMENT, xmlTokenStream._currentState);
    }

    @Test
    void testSkipAttributesWithStartElementState() {
        xmlTokenStream._currentState = XmlTokenStream.XML_START_ELEMENT;
        xmlTokenStream.skipAttributes();
        // should remain the same
        assertEquals(XmlTokenStream.XML_START_ELEMENT, xmlTokenStream._currentState);
    }

    @Test
    void testSkipAttributesWithTextState() {
        xmlTokenStream._currentState = XmlTokenStream.XML_TEXT;
        xmlTokenStream.skipAttributes();
        // should remain the same
        assertEquals(XmlTokenStream.XML_TEXT, xmlTokenStream._currentState);
    }

    @Test
    void testSkipAttributesWithInvalidState() {
        // an invalid state
        xmlTokenStream._currentState = 999;
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            xmlTokenStream.skipAttributes();
        });
        assertEquals("Current state not XML_START_ELEMENT or XML_ATTRIBUTE_NAME but " + xmlTokenStream._currentStateDesc(), exception.getMessage());
    }
}

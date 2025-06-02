package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext;
import com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.PackageVersion;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.Writer;
import java.util.Set;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.*;

@ExtendWith(MockitoExtension.class)
class FromXmlParser_FromXmlParser_64_0_Test {

    private IOContext ioContext;

    private ObjectCodec objectCodec;

    private XMLStreamReader xmlStreamReader;

    private XmlNameProcessor xmlNameProcessor;

    private FromXmlParser fromXmlParser;

    @BeforeEach
    void setUp() throws Exception {
        ioContext = mock(IOContext.class);
        objectCodec = mock(ObjectCodec.class);
        xmlStreamReader = mock(XMLStreamReader.class);
        xmlNameProcessor = mock(XmlNameProcessor.class);
    }

    @Test
    void testConstructor_withStartElement() throws Exception {
        when(xmlStreamReader.getEventType()).thenReturn(XmlTokenStream.XML_START_ELEMENT);
        when(xmlStreamReader.getLocalName()).thenReturn("root");
        when(xmlStreamReader.getNamespaceURI()).thenReturn("namespace");
        fromXmlParser = new FromXmlParser(ioContext, 0, 0, objectCodec, xmlStreamReader, xmlNameProcessor);
        assertNotNull(fromXmlParser);
        assertEquals("root", fromXmlParser.getParsingContext().getCurrentName());
        assertEquals(JsonToken.START_OBJECT, invokeGetNextToken(fromXmlParser));
    }

    @Test
    void testConstructor_withRootText() throws Exception {
        when(xmlStreamReader.getEventType()).thenReturn(XmlTokenStream.XML_ROOT_TEXT);
        when(xmlStreamReader.getLocalName()).thenReturn("text");
        when(xmlStreamReader.getNamespaceURI()).thenReturn("namespace");
        when(xmlStreamReader.getText()).thenReturn("Some text");
        fromXmlParser = new FromXmlParser(ioContext, 0, 0, objectCodec, xmlStreamReader, xmlNameProcessor);
        assertNotNull(fromXmlParser);
        assertEquals("Some text", fromXmlParser.getText());
        assertEquals(JsonToken.VALUE_STRING, invokeGetNextToken(fromXmlParser));
    }

    @Test
    void testConstructor_withXsiNil() throws Exception {
        when(xmlStreamReader.getEventType()).thenReturn(XmlTokenStream.XML_START_ELEMENT);
        when(xmlStreamReader.getLocalName()).thenReturn("root");
        when(xmlStreamReader.getNamespaceURI()).thenReturn("namespace");
        when(xmlStreamReader.getAttributeValue(anyString(), anyString())).thenReturn(null);
        fromXmlParser = new FromXmlParser(ioContext, 0, 0, objectCodec, xmlStreamReader, xmlNameProcessor);
        assertNotNull(fromXmlParser);
        assertEquals(JsonToken.VALUE_NULL, invokeGetNextToken(fromXmlParser));
    }

    @Test
    void testConstructor_withXMLStreamException() throws Exception {
        when(xmlStreamReader.getEventType()).thenThrow(new XMLStreamException("Error"));
        Exception exception = assertThrows(IOException.class, () -> {
            new FromXmlParser(ioContext, 0, 0, objectCodec, xmlStreamReader, xmlNameProcessor);
        });
        assertTrue(exception.getMessage().contains("Error"));
    }

    private JsonToken invokeGetNextToken(FromXmlParser parser) throws Exception {
        return (JsonToken) parser.getClass().getMethod("getNextToken").invoke(parser);
    }
}

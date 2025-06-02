package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext;
import com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.PackageVersion;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;

class FromXmlParser_nextTextValue_29_1_Test {

    private FromXmlParser parser;

    private XMLStreamReader xmlStreamReader;

    private ObjectCodec objectCodec;

    private XmlReadContext xmlReadContext;

    @BeforeEach
    void setUp() throws Exception {
        xmlStreamReader = mock(XMLStreamReader.class);
        objectCodec = mock(ObjectCodec.class);
        xmlReadContext = mock(XmlReadContext.class);
        // Assuming IOContext and XmlNameProcessor are also required
        IOContext ioContext = mock(IOContext.class);
        XmlNameProcessor xmlNameProcessor = mock(XmlNameProcessor.class);
        parser = new FromXmlParser(ioContext, 0, 0, objectCodec, xmlStreamReader, xmlNameProcessor);
    }

    @Test
    void testNextTextValueWithStringValue() throws Exception {
        when(xmlStreamReader.getLocalName()).thenReturn("testElement");
        when(xmlStreamReader.next()).thenReturn(XmlTokenStream.XML_TEXT);
        when(xmlStreamReader.getText()).thenReturn("StringValue");
        String result = parser.nextTextValue();
        assertEquals("StringValue", result);
    }

    @Test
    void testNextTextValueWithEndElement() throws Exception {
        when(xmlStreamReader.getLocalName()).thenReturn("testElement");
        when(xmlStreamReader.next()).thenReturn(XmlTokenStream.XML_END_ELEMENT);
        String result = parser.nextTextValue();
        assertNull(result);
    }

    @Test
    void testNextTextValueWithAttributeValue() throws Exception {
        when(xmlStreamReader.getLocalName()).thenReturn("testElement");
        when(xmlStreamReader.next()).thenReturn(XmlTokenStream.XML_ATTRIBUTE_VALUE);
        when(xmlStreamReader.getText()).thenReturn("AttributeValue");
        String result = parser.nextTextValue();
        assertEquals("AttributeValue", result);
    }

    @Test
    void testNextTextValueWithNull() throws Exception {
        when(xmlStreamReader.getLocalName()).thenReturn("testElement");
        when(xmlStreamReader.next()).thenReturn(XmlTokenStream.XML_TEXT);
        when(xmlStreamReader.getText()).thenReturn(null);
        String result = parser.nextTextValue();
        assertNull(result);
    }

    @Test
    void testNextTextValueWithFieldName() throws Exception {
        when(xmlStreamReader.getLocalName()).thenReturn("testElement");
        when(xmlStreamReader.next()).thenReturn(XmlTokenStream.XML_ATTRIBUTE_NAME);
        String result = parser.nextTextValue();
        assertNull(result);
    }

    @Test
    void testNextTextValueWithUnexpectedToken() throws Exception {
        when(xmlStreamReader.getLocalName()).thenReturn("testElement");
        // Some unexpected token
        when(xmlStreamReader.next()).thenReturn(99);
        Exception exception = assertThrows(IOException.class, () -> {
            parser.nextTextValue();
        });
        assertTrue(exception.getMessage().contains("Internal error: unrecognized XmlTokenStream token"));
    }
}

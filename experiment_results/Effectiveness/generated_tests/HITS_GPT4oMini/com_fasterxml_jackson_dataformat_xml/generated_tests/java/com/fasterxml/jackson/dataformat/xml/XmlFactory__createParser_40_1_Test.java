package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import javax.xml.stream.*;
import org.codehaus.stax2.XMLInputFactory2;
import org.codehaus.stax2.io.Stax2ByteArraySource;
import org.codehaus.stax2.io.Stax2CharArraySource;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class XmlFactory__createParser_40_1_Test {

    private XmlFactory xmlFactory;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        xmlFactory = new XmlFactory();
        ioContext = mock(IOContext.class);
    }

    @Test
    public void testCreateParser_ValidInput() throws IOException {
        String xmlInput = "<root><element>value</element></root>";
        Reader reader = new StringReader(xmlInput);
        FromXmlParser parser = xmlFactory._createParser(reader, ioContext);
        assertNotNull(parser);
        assertEquals(ioContext, parser.getCodec());
    }

    @Test
    public void testCreateParser_EmptyInput() throws IOException {
        String xmlInput = "";
        Reader reader = new StringReader(xmlInput);
        FromXmlParser parser = xmlFactory._createParser(reader, ioContext);
        assertNotNull(parser);
        assertEquals(ioContext, parser.getCodec());
    }

    @Test
    public void testCreateParser_InvalidXml() {
        // missing closing tag
        String xmlInput = "<root><element>value</element>";
        Reader reader = new StringReader(xmlInput);
        assertThrows(JsonParseException.class, () -> {
            xmlFactory._createParser(reader, ioContext);
        });
    }

    @Test
    public void testCreateParser_XMLStreamException() throws XMLStreamException {
        XMLInputFactory mockFactory = mock(XMLInputFactory.class);
        xmlFactory._xmlInputFactory = mockFactory;
        when(mockFactory.createXMLStreamReader(any(Reader.class))).thenThrow(new XMLStreamException("Stream exception"));
        String xmlInput = "<root><element>value</element></root>";
        Reader reader = new StringReader(xmlInput);
        assertThrows(JsonParseException.class, () -> {
            xmlFactory._createParser(reader, ioContext);
        });
    }

    @Test
    public void testCreateParser_WithTextElementName() throws IOException {
        String xmlInput = "<root><element>value</element></root>";
        Reader reader = new StringReader(xmlInput);
        xmlFactory.setXMLTextElementName("element");
        FromXmlParser parser = xmlFactory._createParser(reader, ioContext);
        assertNotNull(parser);
        assertEquals("element", parser.getParsingContext().getCurrentName());
    }
}

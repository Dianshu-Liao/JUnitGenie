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

public class XmlFactory__createParser_39_2_Test {

    private XmlFactory xmlFactory;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        xmlFactory = new XmlFactory();
        ioContext = new IOContext(null, null, false);
    }

    @Test
    public void testCreateParser_ValidInputStream() throws IOException {
        String xmlInput = "<root><element>value</element></root>";
        InputStream inputStream = new ByteArrayInputStream(xmlInput.getBytes());
        FromXmlParser parser = xmlFactory._createParser(inputStream, ioContext);
        assertNotNull(parser, "Parser should not be null for valid input.");
    }

    @Test
    public void testCreateParser_EmptyInputStream() throws IOException {
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        FromXmlParser parser = xmlFactory._createParser(inputStream, ioContext);
        assertNotNull(parser, "Parser should not be null for empty input.");
    }

    @Test
    public void testCreateParser_InvalidXml() {
        String invalidXmlInput = "<root><element>value</element>";
        InputStream inputStream = new ByteArrayInputStream(invalidXmlInput.getBytes());
        assertThrows(JsonParseException.class, () -> {
            try {
                xmlFactory._createParser(inputStream, ioContext);
            } catch (IOException e) {
                throw new JsonParseException(null, "IOException thrown while parsing", e);
            }
        }, "Expected JsonParseException for invalid XML input.");
    }

    @Test
    public void testCreateParser_XMLStreamException() {
        XMLInputFactory mockFactory = Mockito.mock(XMLInputFactory.class);
        try {
            Mockito.when(mockFactory.createXMLStreamReader(Mockito.any(InputStream.class))).thenThrow(new XMLStreamException("Mock XMLStreamException"));
            xmlFactory = new XmlFactory(mockFactory);
            String xmlInput = "<root><element>value</element></root>";
            InputStream inputStream = new ByteArrayInputStream(xmlInput.getBytes());
            assertThrows(JsonParseException.class, () -> {
                try {
                    xmlFactory._createParser(inputStream, ioContext);
                } catch (IOException e) {
                    throw new JsonParseException(null, "IOException thrown while parsing", e);
                }
            }, "Expected JsonParseException due to XMLStreamException.");
        } catch (XMLStreamException e) {
            fail("Unexpected XMLStreamException: " + e.getMessage());
        }
    }
}

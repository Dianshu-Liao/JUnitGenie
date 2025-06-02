package com.fasterxml.jackson.dataformat.xml;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import javax.xml.stream.*;
import org.codehaus.stax2.XMLInputFactory2;
import org.codehaus.stax2.io.Stax2ByteArraySource;
import org.codehaus.stax2.io.Stax2CharArraySource;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class XmlFactory__createParser_39_1_Test {

    private XmlFactory xmlFactory;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        xmlFactory = new XmlFactory();
        ioContext = mock(IOContext.class);
    }

    @Test
    public void testCreateParser_ValidInputStream() throws IOException {
        String xmlInput = "<root></root>";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(xmlInput.getBytes());
        FromXmlParser parser = xmlFactory._createParser(inputStream, ioContext);
        assertNotNull(parser);
        assertEquals(ioContext, parser.getCodec());
    }

    @Test
    public void testCreateParser_ThrowsParseException() {
        // Malformed XML
        String invalidXmlInput = "<root><child></root>";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(invalidXmlInput.getBytes());
        JsonParseException exception = assertThrows(JsonParseException.class, () -> {
            xmlFactory._createParser(inputStream, ioContext);
        });
        assertTrue(exception.getMessage().contains("Unexpected end of document"));
    }

    @Test
    public void testCreateParser_WithTextElementName() throws IOException {
        String xmlInput = "<root></root>";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(xmlInput.getBytes());
        xmlFactory.setXMLTextElementName("textElement");
        FromXmlParser parser = xmlFactory._createParser(inputStream, ioContext);
        assertNotNull(parser);
        assertEquals("textElement", parser.getCodec());
    }
}

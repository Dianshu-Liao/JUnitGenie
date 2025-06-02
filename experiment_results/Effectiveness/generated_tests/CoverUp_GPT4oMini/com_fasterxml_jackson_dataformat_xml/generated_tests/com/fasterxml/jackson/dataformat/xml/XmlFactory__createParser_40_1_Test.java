package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.codehaus.stax2.XMLInputFactory2;
import org.codehaus.stax2.io.Stax2ByteArraySource;
import org.codehaus.stax2.io.Stax2CharArraySource;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import javax.xml.stream.*;
import com.fasterxml.jackson.core.*;

class XmlFactory__createParser_40_1_Test {

    private XmlFactory xmlFactory;

    private IOContext ioContext;

    @BeforeEach
    void setUp() {
        xmlFactory = new XmlFactory();
        ioContext = mock(IOContext.class);
    }

    @Test
    void testCreateParser_ValidReader_ReturnsFromXmlParser() throws IOException {
        String xmlInput = "<root></root>";
        Reader reader = new StringReader(xmlInput);
        FromXmlParser parser = invokeCreateParser(reader, ioContext);
        assertNotNull(parser);
        assertEquals(xmlInput, parser.getText());
    }

    @Test
    void testCreateParser_ReaderThrowsXMLStreamException_ReturnsParseException() throws XMLStreamException {
        Reader reader = mock(Reader.class);
        doThrow(new XMLStreamException("XMLStreamException")).when(xmlFactory.getXMLInputFactory()).createXMLStreamReader(reader);
        assertThrows(IOException.class, () -> invokeCreateParser(reader, ioContext));
    }

    @Test
    void testCreateParser_WithTextElementName_SetsTextElementName() throws IOException {
        String xmlInput = "<root></root>";
        Reader reader = new StringReader(xmlInput);
        String textElementName = "name";
        xmlFactory.setXMLTextElementName(textElementName);
        FromXmlParser parser = invokeCreateParser(reader, ioContext);
        assertNotNull(parser);
        assertEquals(textElementName, xmlFactory.getXMLTextElementName());
    }

    @Test
    void testCreateParser_NullReader_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> invokeCreateParser(null, ioContext));
    }

    @Test
    void testCreateParser_NullIOContext_ThrowsNullPointerException() {
        String xmlInput = "<root></root>";
        Reader reader = new StringReader(xmlInput);
        assertThrows(NullPointerException.class, () -> invokeCreateParser(reader, null));
    }

    private FromXmlParser invokeCreateParser(Reader reader, IOContext ctxt) throws IOException {
        try {
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", Reader.class, IOContext.class);
            method.setAccessible(true);
            return (FromXmlParser) method.invoke(xmlFactory, reader, ctxt);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}

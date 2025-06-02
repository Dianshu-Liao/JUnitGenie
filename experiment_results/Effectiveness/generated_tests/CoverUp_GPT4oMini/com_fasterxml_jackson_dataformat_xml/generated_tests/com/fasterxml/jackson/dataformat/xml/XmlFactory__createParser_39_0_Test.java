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

class XmlFactory__createParser_39_0_Test {

    private XmlFactory xmlFactory;

    private IOContext ioContext;

    @BeforeEach
    void setUp() {
        xmlFactory = new XmlFactory();
        ioContext = mock(IOContext.class);
        xmlFactory.setXMLTextElementName("textElement");
    }

    @Test
    void testCreateParser_ValidInputStream() throws Exception {
        String xml = "<root><textElement>value</textElement></root>";
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        FromXmlParser parser = invokeCreateParser(inputStream, ioContext);
        assertNotNull(parser);
        assertEquals("textElement", xmlFactory.getXMLTextElementName());
    }

    @Test
    void testCreateParser_XMLStreamException() throws Exception {
        XMLInputFactory xmlInputFactory = mock(XMLInputFactory.class);
        xmlFactory.setXMLInputFactory(xmlInputFactory);
        when(xmlInputFactory.createXMLStreamReader(any(InputStream.class))).thenThrow(new XMLStreamException("Error"));
        InputStream inputStream = new ByteArrayInputStream("<root/>".getBytes());
        assertThrows(IOException.class, () -> invokeCreateParser(inputStream, ioContext));
    }

    private FromXmlParser invokeCreateParser(InputStream in, IOContext ctxt) throws Exception {
        return (FromXmlParser) XmlFactory.class.getDeclaredMethod("_createParser", InputStream.class, IOContext.class).invoke(xmlFactory, in, ctxt);
    }
}

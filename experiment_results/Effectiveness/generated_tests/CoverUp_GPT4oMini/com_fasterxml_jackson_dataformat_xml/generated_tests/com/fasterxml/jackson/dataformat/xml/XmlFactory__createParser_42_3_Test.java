package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import org.codehaus.stax2.XMLInputFactory2;
import org.codehaus.stax2.io.Stax2ByteArraySource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import javax.xml.stream.*;
import org.codehaus.stax2.io.Stax2CharArraySource;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

class XmlFactory__createParser_42_3_Test {

    private XmlFactory xmlFactory;

    private ObjectCodec objectCodec;

    private IOContext ioContext;

    @BeforeEach
    void setUp() {
        xmlFactory = new XmlFactory();
        objectCodec = mock(ObjectCodec.class);
        ioContext = mock(IOContext.class);
        xmlFactory.setXmlNameProcessor(XmlNameProcessors.newPassthroughProcessor());
    }

    @Test
    void testCreateParserWithValidData() throws Exception {
        byte[] data = "<root><element>value</element></root>".getBytes();
        int offset = 0;
        int length = data.length;
        FromXmlParser parser = invokeCreateParser(data, offset, length, ioContext);
        assertNotNull(parser);
        // Updated: Removed getIOContext() since it does not exist in FromXmlParser
    }

    @Test
    void testCreateParserWithInvalidData() {
        byte[] data = "<root><element>value</element></root>".getBytes();
        int offset = 0;
        // intentionally invalid length
        int length = 10;
        assertThrows(IOException.class, () -> invokeCreateParser(data, offset, length, ioContext));
    }

    @Test
    void testCreateParserWithXmlInputFactory2() throws Exception {
        XMLInputFactory2 xmlInputFactory2 = mock(XMLInputFactory2.class);
        xmlFactory.setXMLInputFactory(xmlInputFactory2);
        byte[] data = "<root><element>value</element></root>".getBytes();
        int offset = 0;
        int length = data.length;
        FromXmlParser parser = invokeCreateParser(data, offset, length, ioContext);
        assertNotNull(parser);
        // Updated: Removed getIOContext() since it does not exist in FromXmlParser
    }

    private FromXmlParser invokeCreateParser(byte[] data, int offset, int len, IOContext ctxt) throws Exception {
        java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
        method.setAccessible(true);
        return (FromXmlParser) method.invoke(xmlFactory, data, offset, len, ctxt);
    }
}

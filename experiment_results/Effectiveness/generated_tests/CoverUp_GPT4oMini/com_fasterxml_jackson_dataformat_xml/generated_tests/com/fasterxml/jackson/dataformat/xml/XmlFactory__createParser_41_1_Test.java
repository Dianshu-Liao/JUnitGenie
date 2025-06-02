package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import org.codehaus.stax2.XMLInputFactory2;
import org.codehaus.stax2.io.Stax2CharArraySource;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import javax.xml.stream.*;
import org.codehaus.stax2.io.Stax2ByteArraySource;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

class XmlFactory__createParser_41_1_Test {

    private XmlFactory xmlFactory;

    private IOContext ioContext;

    @BeforeEach
    void setUp() {
        xmlFactory = new XmlFactory();
        ioContext = mock(IOContext.class);
        xmlFactory.setXmlNameProcessor(XmlNameProcessors.newPassthroughProcessor());
    }

    @Test
    void testCreateParserWithStax2() throws Exception {
        char[] data = "<root></root>".toCharArray();
        int offset = 0;
        int len = data.length;
        // Mock the XMLInputFactory to return a Stax2 implementation
        XMLInputFactory2 xmlInputFactory2 = mock(XMLInputFactory2.class);
        when(xmlFactory.getXMLInputFactory()).thenReturn(xmlInputFactory2);
        XMLStreamReader xmlStreamReader = mock(XMLStreamReader.class);
        when(xmlInputFactory2.createXMLStreamReader(any(Stax2CharArraySource.class))).thenReturn(xmlStreamReader);
        FromXmlParser parser = invokeCreateParser(data, offset, len, ioContext, false);
        assertNotNull(parser);
        verify(xmlInputFactory2).createXMLStreamReader(any(Stax2CharArraySource.class));
    }

    @Test
    void testCreateParserWithNonStax2() throws Exception {
        char[] data = "<root></root>".toCharArray();
        int offset = 0;
        int len = data.length;
        // Mock the XMLInputFactory to return a non-Stax2 implementation
        XMLInputFactory xmlInputFactory = mock(XMLInputFactory.class);
        when(xmlFactory.getXMLInputFactory()).thenReturn(xmlInputFactory);
        XMLStreamReader xmlStreamReader = mock(XMLStreamReader.class);
        when(xmlInputFactory.createXMLStreamReader(any(CharArrayReader.class))).thenReturn(xmlStreamReader);
        FromXmlParser parser = invokeCreateParser(data, offset, len, ioContext, false);
        assertNotNull(parser);
        verify(xmlInputFactory).createXMLStreamReader(any(CharArrayReader.class));
    }

    @Test
    void testCreateParserThrowsException() throws Exception {
        char[] data = "<root></root>".toCharArray();
        int offset = 0;
        int len = data.length;
        // Mock the XMLInputFactory to throw XMLStreamException
        XMLInputFactory2 xmlInputFactory2 = mock(XMLInputFactory2.class);
        when(xmlFactory.getXMLInputFactory()).thenReturn(xmlInputFactory2);
        when(xmlInputFactory2.createXMLStreamReader(any(Stax2CharArraySource.class))).thenThrow(new XMLStreamException("Test Exception"));
        try {
            invokeCreateParser(data, offset, len, ioContext, false);
        } catch (IOException e) {
            // Expected
        }
    }

    private FromXmlParser invokeCreateParser(char[] data, int offset, int len, IOContext ctxt, boolean recycleBuffer) throws Exception {
        // Use reflection to invoke the private _createParser method
        return (FromXmlParser) XmlFactory.class.getDeclaredMethod("_createParser", char[].class, int.class, int.class, IOContext.class, boolean.class).invoke(xmlFactory, data, offset, len, ctxt, recycleBuffer);
    }
}

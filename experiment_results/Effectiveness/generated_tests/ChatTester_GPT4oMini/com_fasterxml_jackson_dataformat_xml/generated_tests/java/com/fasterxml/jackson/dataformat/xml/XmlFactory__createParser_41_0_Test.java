// Test method
package com.fasterxml.jackson.dataformat.xml;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.codehaus.stax2.XMLInputFactory2;
import org.codehaus.stax2.io.Stax2ByteArraySource;
import org.codehaus.stax2.io.Stax2CharArraySource;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import javax.xml.stream.*;
import com.fasterxml.jackson.core.*;

class XmlFactory__createParser_41_0_Test {

    private XmlFactory xmlFactory;

    private IOContext mockIOContext;

    private XMLInputFactory mockXmlInputFactory;

    @BeforeEach
    void setUp() {
        mockIOContext = mock(IOContext.class);
        mockXmlInputFactory = mock(XMLInputFactory.class);
        xmlFactory = new XmlFactory(mockXmlInputFactory);
    }

    @Test
    void testCreateParserWithStax2() throws Exception {
        char[] data = "<test></test>".toCharArray();
        int offset = 0;
        int len = data.length;
        XMLStreamReader mockXmlStreamReader = mock(XMLStreamReader.class);
        when(mockXmlInputFactory.createXMLStreamReader(any(Stax2CharArraySource.class))).thenReturn(mockXmlStreamReader);
        when(mockXmlInputFactory instanceof XMLInputFactory2).thenReturn(true);
        FromXmlParser parser = invokeCreateParser(data, offset, len, mockIOContext, false);
        assertNotNull(parser);
        verify(mockXmlInputFactory).createXMLStreamReader(any(Stax2CharArraySource.class));
    }

    @Test
    void testCreateParserWithNonStax2() throws Exception {
        char[] data = "<test></test>".toCharArray();
        int offset = 0;
        int len = data.length;
        XMLStreamReader mockXmlStreamReader = mock(XMLStreamReader.class);
        when(mockXmlInputFactory.createXMLStreamReader(any(CharArrayReader.class))).thenReturn(mockXmlStreamReader);
        when(mockXmlInputFactory instanceof XMLInputFactory2).thenReturn(false);
        FromXmlParser parser = invokeCreateParser(data, offset, len, mockIOContext, false);
        assertNotNull(parser);
        verify(mockXmlInputFactory).createXMLStreamReader(any(CharArrayReader.class));
    }

    @Test
    void testCreateParserThrowsException() throws Exception {
        char[] data = "<test></test>".toCharArray();
        int offset = 0;
        int len = data.length;
        when(mockXmlInputFactory.createXMLStreamReader(any(CharArrayReader.class))).thenThrow(new XMLStreamException("Error"));
        Exception exception = assertThrows(IOException.class, () -> {
            invokeCreateParser(data, offset, len, mockIOContext, false);
        });
        assertTrue(exception.getCause() instanceof XMLStreamException);
        assertEquals("Error", exception.getCause().getMessage());
    }

    private FromXmlParser invokeCreateParser(char[] data, int offset, int len, IOContext ctxt, boolean recycleBuffer) throws Exception {
        // Fixed line: Removed 'var' and replaced with 'java.lang.reflect.Method'
        java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", char[].class, int.class, int.class, IOContext.class, boolean.class);
        method.setAccessible(true);
        return (FromXmlParser) method.invoke(xmlFactory, data, offset, len, ctxt, recycleBuffer);
    }
}

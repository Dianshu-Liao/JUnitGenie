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

class XmlFactory__createParser_42_2_Test {

    private XmlFactory xmlFactory;

    private XMLInputFactory mockXmlInputFactory;

    private IOContext mockIOContext;

    @BeforeEach
    void setUp() {
        mockXmlInputFactory = mock(XMLInputFactory.class);
        xmlFactory = new XmlFactory(mockXmlInputFactory);
        mockIOContext = mock(IOContext.class);
    }

    @Test
    void testCreateParser_Stax2Implementation() throws Exception {
        // Arrange
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;
        XMLStreamReader mockXmlStreamReader = mock(XMLStreamReader.class);
        when(mockXmlInputFactory.createXMLStreamReader(any(Stax2ByteArraySource.class))).thenReturn(mockXmlStreamReader);
        // Act
        FromXmlParser parser = invokeCreateParser(data, offset, len, mockIOContext);
        // Assert
        assertNotNull(parser);
        // Fixed Line: Accessing the method to get the XMLStreamReader from FromXmlParser
        assertEquals(mockXmlStreamReader, parser.getStaxReader());
    }

    @Test
    void testCreateParser_JdkImplementation_ThrowsException() throws Exception {
        // Arrange
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;
        when(mockXmlInputFactory.createXMLStreamReader(any(ByteArrayInputStream.class))).thenThrow(new ArrayIndexOutOfBoundsException("Mocked Exception"));
        // Act & Assert
        JsonParseException exception = assertThrows(JsonParseException.class, () -> {
            invokeCreateParser(data, offset, len, mockIOContext);
        });
        assertTrue(exception.getMessage().contains("Internal processing error by `XMLInputFactory`"));
    }

    @Test
    void testCreateParser_XMLStreamException() throws Exception {
        // Arrange
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;
        when(mockXmlInputFactory.createXMLStreamReader(any(ByteArrayInputStream.class))).thenThrow(new XMLStreamException("Mocked XMLStreamException"));
        // Act & Assert
        JsonParseException exception = assertThrows(JsonParseException.class, () -> {
            invokeCreateParser(data, offset, len, mockIOContext);
        });
        assertTrue(exception.getMessage().contains("Mocked XMLStreamException"));
    }

    @Test
    void testCreateParser_WithTextElementName() throws Exception {
        // Arrange
        byte[] data = "<root></root>".getBytes();
        int offset = 0;
        int len = data.length;
        String expectedTextElementName = "root";
        xmlFactory.setXMLTextElementName(expectedTextElementName);
        XMLStreamReader mockXmlStreamReader = mock(XMLStreamReader.class);
        when(mockXmlInputFactory.createXMLStreamReader(any(Stax2ByteArraySource.class))).thenReturn(mockXmlStreamReader);
        // Act
        FromXmlParser parser = invokeCreateParser(data, offset, len, mockIOContext);
        // Fixed Line: Accessing the XML text element name from the XmlFactory
        assertNotNull(parser);
        assertEquals(expectedTextElementName, xmlFactory.getXMLTextElementName());
    }

    private FromXmlParser invokeCreateParser(byte[] data, int offset, int len, IOContext ctxt) throws Exception {
        // Use reflection to access the protected method
        java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
        method.setAccessible(true);
        return (FromXmlParser) method.invoke(xmlFactory, data, offset, len, ctxt);
    }
}

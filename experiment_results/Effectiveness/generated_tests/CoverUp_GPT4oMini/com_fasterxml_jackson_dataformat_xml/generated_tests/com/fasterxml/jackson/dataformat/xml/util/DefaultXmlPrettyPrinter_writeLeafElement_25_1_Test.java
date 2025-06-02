package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.typed.Base64Variant;
import javax.xml.stream.XMLStreamException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

public class DefaultXmlPrettyPrinter_writeLeafElement_25_1_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    private String namespaceURI;

    private String localName;

    private Base64Variant base64Variant;

    private byte[] data;

    private int offset;

    private int length;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
        namespaceURI = "http://example.com/ns";
        localName = "exampleElement";
        base64Variant = mock(Base64Variant.class);
        data = new byte[] { 1, 2, 3, 4 };
        offset = 0;
        length = data.length;
    }

    @Test
    public void testWriteLeafElement_WithIndentation() throws Exception {
        // Arrange
        prettyPrinter._objectIndenter = mock(DefaultXmlPrettyPrinter.Indenter.class);
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(false);
        // Act
        invokeWriteLeafElement(prettyPrinter, xmlStreamWriter, namespaceURI, localName, base64Variant, data, offset, length);
        // Assert
        verify(prettyPrinter._objectIndenter).writeIndentation(xmlStreamWriter, prettyPrinter._nesting);
        verify(xmlStreamWriter).writeStartElement(namespaceURI, localName);
        verify(xmlStreamWriter).writeBinary(base64Variant, data, offset, length);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WithoutIndentation() throws Exception {
        // Arrange
        prettyPrinter._objectIndenter = mock(DefaultXmlPrettyPrinter.Indenter.class);
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(true);
        // Act
        invokeWriteLeafElement(prettyPrinter, xmlStreamWriter, namespaceURI, localName, base64Variant, data, offset, length);
        // Assert
        verify(prettyPrinter._objectIndenter, never()).writeIndentation(any(XMLStreamWriter2.class), anyInt());
        verify(xmlStreamWriter).writeStartElement(namespaceURI, localName);
        verify(xmlStreamWriter).writeBinary(base64Variant, data, offset, length);
        verify(xmlStreamWriter).writeEndElement();
    }

    private void invokeWriteLeafElement(DefaultXmlPrettyPrinter printer, XMLStreamWriter2 sw, String nsURI, String localName, Base64Variant base64variant, byte[] data, int offset, int len) throws Exception {
        Method method = DefaultXmlPrettyPrinter.class.getDeclaredMethod("writeLeafElement", XMLStreamWriter2.class, String.class, String.class, Base64Variant.class, byte[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(printer, sw, nsURI, localName, base64variant, data, offset, len);
    }
}

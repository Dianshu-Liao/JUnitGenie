package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.typed.Base64Variant;
import javax.xml.stream.XMLStreamException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

class DefaultXmlPrettyPrinter_writeLeafElement_25_0_Test {

    private DefaultXmlPrettyPrinter printer;

    private XMLStreamWriter2 xmlStreamWriter;

    private Base64Variant base64Variant;

    @BeforeEach
    void setUp() {
        printer = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
        base64Variant = mock(Base64Variant.class);
    }

    @Test
    void testWriteLeafElement() throws Exception {
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        byte[] data = "testData".getBytes();
        int offset = 0;
        int len = data.length;
        // Invoke the private method using reflection
        Method method = DefaultXmlPrettyPrinter.class.getDeclaredMethod("writeLeafElement", XMLStreamWriter2.class, String.class, String.class, Base64Variant.class, byte[].class, int.class, int.class);
        method.setAccessible(true);
        // Test when _objectIndenter is not inline
        when(printer._objectIndenter.isInline()).thenReturn(false);
        // Set nesting level
        printer._nesting = 1;
        method.invoke(printer, xmlStreamWriter, nsURI, localName, base64Variant, data, offset, len);
        // Verify interactions
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeBinary(base64Variant, data, offset, len);
        verify(xmlStreamWriter).writeEndElement();
        verifyNoMoreInteractions(xmlStreamWriter);
        // Check the state change
        assert !printer._justHadStartElement;
    }

    @Test
    void testWriteLeafElementInline() throws Exception {
        String nsURI = "http://example.com";
        String localName = "inlineElement";
        byte[] data = "inlineData".getBytes();
        int offset = 0;
        int len = data.length;
        // Invoke the private method using reflection
        Method method = DefaultXmlPrettyPrinter.class.getDeclaredMethod("writeLeafElement", XMLStreamWriter2.class, String.class, String.class, Base64Variant.class, byte[].class, int.class, int.class);
        method.setAccessible(true);
        // Test when _objectIndenter is inline
        when(printer._objectIndenter.isInline()).thenReturn(true);
        method.invoke(printer, xmlStreamWriter, nsURI, localName, base64Variant, data, offset, len);
        // Verify interactions
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeBinary(base64Variant, data, offset, len);
        verify(xmlStreamWriter).writeEndElement();
        verifyNoMoreInteractions(xmlStreamWriter);
        // Check the state change
        assert !printer._justHadStartElement;
    }
}

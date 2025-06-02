package com.fasterxml.jackson.dataformat.xml.util;

import java.math.BigInteger;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

public class DefaultXmlPrettyPrinter_writeLeafElement_23_0_Test {

    private DefaultXmlPrettyPrinter printer;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        printer = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement() throws Exception {
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        BigInteger value = BigInteger.valueOf(42);
        // Test when _objectIndenter.isInline() is false
        when(printer._objectIndenter.isInline()).thenReturn(false);
        // Invoke the private method using reflection
        java.lang.reflect.Method method = DefaultXmlPrettyPrinter.class.getDeclaredMethod("writeLeafElement", XMLStreamWriter2.class, String.class, String.class, BigInteger.class);
        method.setAccessible(true);
        method.invoke(printer, xmlStreamWriter, nsURI, localName, value);
        // Verify the interactions
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeInteger(value);
        verify(xmlStreamWriter).writeEndElement();
        assertFalse(printer._justHadStartElement);
    }

    @Test
    public void testWriteLeafElementInline() throws Exception {
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        BigInteger value = BigInteger.valueOf(42);
        // Test when _objectIndenter.isInline() is true
        when(printer._objectIndenter.isInline()).thenReturn(true);
        // Invoke the private method using reflection
        java.lang.reflect.Method method = DefaultXmlPrettyPrinter.class.getDeclaredMethod("writeLeafElement", XMLStreamWriter2.class, String.class, String.class, BigInteger.class);
        method.setAccessible(true);
        method.invoke(printer, xmlStreamWriter, nsURI, localName, value);
        // Verify the interactions
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeInteger(value);
        verify(xmlStreamWriter).writeEndElement();
        assertFalse(printer._justHadStartElement);
    }
}

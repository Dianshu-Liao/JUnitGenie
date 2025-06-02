package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.typed.Base64Variant;
import javax.xml.stream.XMLStreamException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

@ExtendWith(MockitoExtension.class)
public class DefaultXmlPrettyPrinter_writeLeafElement_25_4_Test {

    private DefaultXmlPrettyPrinter printer;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() throws Exception {
        printer = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement() throws Exception {
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        Base64Variant base64Variant = createBase64Variant();
        byte[] data = "testData".getBytes();
        int offset = 0;
        int len = data.length;
        // Call the method under test
        invokeWriteLeafElement(nsURI, localName, base64Variant, data, offset, len);
        // Verify the interactions
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeBinary(base64Variant, data, offset, len);
        verify(xmlStreamWriter).writeEndElement();
        verifyNoMoreInteractions(xmlStreamWriter);
    }

    @Test
    public void testWriteLeafElementWithDifferentData() throws Exception {
        String nsURI = "http://example.com/ns";
        String localName = "anotherElement";
        Base64Variant base64Variant = createBase64Variant();
        byte[] data = "differentData".getBytes();
        int offset = 0;
        int len = data.length;
        // Call the method under test
        invokeWriteLeafElement(nsURI, localName, base64Variant, data, offset, len);
        // Verify the interactions
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeBinary(base64Variant, data, offset, len);
        verify(xmlStreamWriter).writeEndElement();
        verifyNoMoreInteractions(xmlStreamWriter);
    }

    private Base64Variant createBase64Variant() {
        try {
            Method method = Base64Variant.class.getDeclaredMethod("getDefaultVariant");
            method.setAccessible(true);
            return (Base64Variant) method.invoke(null);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Base64Variant", e);
        }
    }

    private void invokeWriteLeafElement(String nsURI, String localName, Base64Variant base64Variant, byte[] data, int offset, int len) throws Exception {
        Method method = DefaultXmlPrettyPrinter.class.getDeclaredMethod("writeLeafElement", XMLStreamWriter2.class, String.class, String.class, Base64Variant.class, byte[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(printer, xmlStreamWriter, nsURI, localName, base64Variant, data, offset, len);
    }
}

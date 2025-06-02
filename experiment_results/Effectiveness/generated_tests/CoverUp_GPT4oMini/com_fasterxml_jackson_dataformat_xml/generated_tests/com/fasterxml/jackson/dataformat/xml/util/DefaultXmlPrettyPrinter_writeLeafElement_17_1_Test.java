package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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

public class DefaultXmlPrettyPrinter_writeLeafElement_17_1_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        mockWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElementWithCData() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "element";
        char[] buffer = "CData content".toCharArray();
        int offset = 0;
        int len = buffer.length;
        boolean isCData = true;
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCData(buffer, offset, len);
        verify(mockWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElementWithoutCData() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "element";
        char[] buffer = "Regular content".toCharArray();
        int offset = 0;
        int len = buffer.length;
        boolean isCData = false;
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCharacters(buffer, offset, len);
        verify(mockWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElementWithIndentation() throws XMLStreamException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        // Assuming _objectIndenter is not inline
        Class<?> indenterClass = Class.forName("com.fasterxml.jackson.dataformat.xml.util.Indenter");
        Object mockIndenter = mock(indenterClass);
        when((Boolean) indenterClass.getMethod("isInline").invoke(mockIndenter)).thenReturn(false);
        Field indenterField = DefaultXmlPrettyPrinter.class.getDeclaredField("_objectIndenter");
        indenterField.setAccessible(true);
        indenterField.set(prettyPrinter, mockIndenter);
        String nsURI = "http://example.com/ns";
        String localName = "element";
        char[] buffer = "Indented content".toCharArray();
        int offset = 0;
        int len = buffer.length;
        boolean isCData = false;
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        indenterClass.getMethod("writeIndentation", XMLStreamWriter2.class, int.class).invoke(mockIndenter, mockWriter, prettyPrinter._nesting);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCharacters(buffer, offset, len);
        verify(mockWriter).writeEndElement();
    }
}

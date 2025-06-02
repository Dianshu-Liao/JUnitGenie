package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
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

public class DefaultXmlPrettyPrinter_writeLeafElement_20_3_Test {

    private DefaultXmlPrettyPrinter printer;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        printer = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WithIndentation() throws Exception {
        // Set up mock behavior
        when(printer._objectIndenter.isInline()).thenReturn(false);
        // Call the method using reflection
        Method method = DefaultXmlPrettyPrinter.class.getDeclaredMethod("writeLeafElement", XMLStreamWriter2.class, String.class, String.class, long.class);
        method.setAccessible(true);
        // Execute the method
        method.invoke(printer, xmlStreamWriter, "http://example.com/ns", "elementName", 12345L);
        // Verify interactions
        verify(printer._objectIndenter).writeIndentation(xmlStreamWriter, printer._nesting);
        verify(xmlStreamWriter).writeStartElement("http://example.com/ns", "elementName");
        verify(xmlStreamWriter).writeLong(12345L);
        verify(xmlStreamWriter).writeEndElement();
        assertFalse(printer._justHadStartElement);
    }

    @Test
    public void testWriteLeafElement_WithoutIndentation() throws Exception {
        // Set up mock behavior
        when(printer._objectIndenter.isInline()).thenReturn(true);
        // Call the method using reflection
        Method method = DefaultXmlPrettyPrinter.class.getDeclaredMethod("writeLeafElement", XMLStreamWriter2.class, String.class, String.class, long.class);
        method.setAccessible(true);
        // Execute the method
        method.invoke(printer, xmlStreamWriter, "http://example.com/ns", "elementName", 67890L);
        // Verify interactions
        verify(xmlStreamWriter).writeStartElement("http://example.com/ns", "elementName");
        verify(xmlStreamWriter).writeLong(67890L);
        verify(xmlStreamWriter).writeEndElement();
        assertFalse(printer._justHadStartElement);
    }
}

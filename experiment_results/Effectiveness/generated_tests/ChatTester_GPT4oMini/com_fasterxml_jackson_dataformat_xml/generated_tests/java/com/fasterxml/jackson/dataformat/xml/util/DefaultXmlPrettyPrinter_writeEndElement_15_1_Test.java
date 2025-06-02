package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import org.codehaus.stax2.XMLStreamWriter2;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

public class DefaultXmlPrettyPrinter_writeEndElement_15_1_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        mockWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteEndElement_WithInlineIndenter() throws XMLStreamException {
        prettyPrinter._objectIndenter = mock(DefaultXmlPrettyPrinter.Indenter.class);
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(true);
        prettyPrinter.writeEndElement(mockWriter, 0);
        verify(prettyPrinter._objectIndenter, never()).writeIndentation(mockWriter, anyInt());
        verify(mockWriter).writeEndElement();
    }

    @Test
    public void testWriteEndElement_WithNonInlineIndenter() throws XMLStreamException {
        prettyPrinter._objectIndenter = mock(DefaultXmlPrettyPrinter.Indenter.class);
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(false);
        prettyPrinter._nesting = 1;
        prettyPrinter.writeEndElement(mockWriter, 0);
        verify(prettyPrinter._objectIndenter).writeIndentation(mockWriter, 1);
        verify(mockWriter).writeEndElement();
    }

    @Test
    public void testWriteEndElement_WhenJustHadStartElement() throws XMLStreamException {
        prettyPrinter._justHadStartElement = true;
        prettyPrinter.writeEndElement(mockWriter, 0);
        verify(prettyPrinter._objectIndenter, never()).writeIndentation(mockWriter, anyInt());
        verify(mockWriter).writeEndElement();
        assertFalse(prettyPrinter._justHadStartElement);
    }

    @Test
    public void testWriteEndElement_WhenNotJustHadStartElement() throws XMLStreamException {
        prettyPrinter._justHadStartElement = false;
        prettyPrinter._nesting = 1;
        prettyPrinter.writeEndElement(mockWriter, 0);
        verify(prettyPrinter._objectIndenter).writeIndentation(mockWriter, 1);
        verify(mockWriter).writeEndElement();
    }
}

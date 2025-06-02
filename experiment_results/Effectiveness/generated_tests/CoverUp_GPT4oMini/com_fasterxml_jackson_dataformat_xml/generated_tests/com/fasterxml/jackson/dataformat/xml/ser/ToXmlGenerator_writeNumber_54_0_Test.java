package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

class ToXmlGenerator_writeNumber_54_0_Test {

    private ToXmlGenerator generator;

    private XMLStreamWriter2 xmlWriter;

    private StringWriter stringWriter;

    private QName qName;

    @BeforeEach
    void setUp() throws Exception {
        stringWriter = new StringWriter();
        xmlWriter = mock(XMLStreamWriter2.class);
        IOContext ctxt = mock(IOContext.class);
        XmlNameProcessor nameProcessor = mock(XmlNameProcessor.class);
        generator = new ToXmlGenerator(ctxt, 0, 0, null, xmlWriter, nameProcessor);
        qName = new QName("namespace", "localPart");
    }

    @Test
    void testWriteNumber() throws Exception {
        generator.setNextName(qName);
        generator.writeNumber(123);
        verify(xmlWriter).writeStartElement("namespace", "localPart");
        verify(xmlWriter).writeLong(123);
        verify(xmlWriter).writeEndElement();
    }

    @Test
    void testWriteNumberAsAttribute() throws Exception {
        generator.setNextName(qName);
        generator.setNextIsAttribute(true);
        generator.writeNumber(456);
        verify(xmlWriter).writeLongAttribute(null, "namespace", "localPart", 456);
    }

    @Test
    void testWriteNumberUnwrapped() throws Exception {
        generator.setNextName(qName);
        generator.setNextIsUnwrapped(true);
        generator.writeNumber(789);
        verify(xmlWriter).writeLong(789);
    }

    @Test
    void testWriteNumberWithPrettyPrinter() throws Exception {
        generator.setNextName(qName);
        generator.setPrettyPrinter(mock(XmlPrettyPrinter.class));
        generator.writeNumber(101112);
        verify(xmlWriter).writeStartElement("namespace", "localPart");
        verify(xmlWriter).writeLong(101112);
        verify(xmlWriter).writeEndElement();
    }

    @Test
    void testWriteNumberThrowsExceptionWhenNameMissing() {
        assertThrows(IllegalStateException.class, () -> generator.writeNumber(123));
    }

    @Test
    void testWriteNumberThrowsXMLStreamException() throws Exception {
        generator.setNextName(qName);
        doThrow(new XMLStreamException("Test Exception")).when(xmlWriter).writeLong(anyLong());
        Exception exception = assertThrows(IOException.class, () -> generator.writeNumber(123));
        assertTrue(exception.getCause() instanceof XMLStreamException);
    }
}

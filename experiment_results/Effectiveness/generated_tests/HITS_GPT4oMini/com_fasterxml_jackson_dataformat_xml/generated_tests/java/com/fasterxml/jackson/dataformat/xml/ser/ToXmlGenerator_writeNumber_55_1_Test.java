package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.namespace.QName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.XMLConstants;
import org.codehaus.stax2.XMLStreamWriter2;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.*;

public class ToXmlGenerator_writeNumber_55_1_Test {

    private XMLStreamWriter2 xmlWriter;

    private ToXmlGenerator toXmlGenerator;

    @BeforeEach
    public void setUp() throws Exception {
        xmlWriter = mock(XMLStreamWriter2.class);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, xmlWriter, null);
    }

    @Test
    public void testWriteNumber_ValidDouble() throws Exception {
        toXmlGenerator.setNextName(new QName("testNamespace", "testElement"));
        toXmlGenerator.writeNumber(123.45);
        verify(xmlWriter).writeStartElement("testNamespace", "testElement");
        verify(xmlWriter).writeDouble(123.45);
        verify(xmlWriter).writeEndElement();
    }

    @Test
    public void testWriteNumber_InfiniteDouble() throws Exception {
        toXmlGenerator.setNextName(new QName("testNamespace", "testElement"));
        toXmlGenerator.setNextIsAttribute(false);
        toXmlGenerator.writeNumber(Double.POSITIVE_INFINITY);
        verify(xmlWriter).writeStartElement("testNamespace", "testElement");
        verify(xmlWriter).writeDouble(Double.POSITIVE_INFINITY);
        verify(xmlWriter).writeEndElement();
    }

    @Test
    public void testWriteNumber_NegativeInfiniteDouble() throws Exception {
        toXmlGenerator.setNextName(new QName("testNamespace", "testElement"));
        toXmlGenerator.setNextIsAttribute(false);
        toXmlGenerator.writeNumber(Double.NEGATIVE_INFINITY);
        verify(xmlWriter).writeStartElement("testNamespace", "testElement");
        verify(xmlWriter).writeDouble(Double.NEGATIVE_INFINITY);
        verify(xmlWriter).writeEndElement();
    }

    @Test
    public void testWriteNumber_MissingNameThrowsException() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            toXmlGenerator.writeNumber(123.45);
        });
        assertEquals("No element/attribute name specified when trying to output element", exception.getMessage());
    }

    @Test
    public void testWriteNumber_AttributeWrite() throws Exception {
        toXmlGenerator.setNextName(new QName("testNamespace", "testAttribute"));
        toXmlGenerator.setNextIsAttribute(true);
        toXmlGenerator.writeNumber(123.45);
        verify(xmlWriter).writeDoubleAttribute(null, "testNamespace", "testAttribute", 123.45);
    }
}

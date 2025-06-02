package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamException;
import javax.xml.namespace.QName;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamWriter;
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

public class ToXmlGenerator_writeNumber_55_0_Test {

    private ToXmlGenerator toXmlGenerator;

    private XMLStreamWriter2 xmlWriter;

    @BeforeEach
    public void setUp() throws Exception {
        xmlWriter = mock(XMLStreamWriter2.class);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, xmlWriter, null);
    }

    @Test
    public void testWriteNumber_ValidDouble() throws IOException, XMLStreamException {
        toXmlGenerator.setNextName(new QName("namespace", "element"));
        toXmlGenerator.writeNumber(123.45);
        verify(xmlWriter).writeStartElement("namespace", "element");
        verify(xmlWriter).writeDouble(123.45);
        verify(xmlWriter).writeEndElement();
    }

    @Test
    public void testWriteNumber_InfinitePositive() throws IOException, XMLStreamException {
        toXmlGenerator.setNextName(new QName("namespace", "element"));
        when(toXmlGenerator.isEnabled(ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS)).thenReturn(true);
        toXmlGenerator.writeNumber(Double.POSITIVE_INFINITY);
        verify(xmlWriter).writeStartElement("namespace", "element");
        verify(xmlWriter).writeDouble(Double.POSITIVE_INFINITY);
        verify(xmlWriter).writeEndElement();
    }

    @Test
    public void testWriteNumber_InfiniteNegative() throws IOException, XMLStreamException {
        toXmlGenerator.setNextName(new QName("namespace", "element"));
        when(toXmlGenerator.isEnabled(ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS)).thenReturn(true);
        toXmlGenerator.writeNumber(Double.NEGATIVE_INFINITY);
        verify(xmlWriter).writeStartElement("namespace", "element");
        verify(xmlWriter).writeDouble(Double.NEGATIVE_INFINITY);
        verify(xmlWriter).writeEndElement();
    }

    @Test
    public void testWriteNumber_NullName() {
        toXmlGenerator.setNextName(null);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            toXmlGenerator.writeNumber(123.45);
        });
        String expectedMessage = "No element/attribute name specified when trying to output element";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testWriteNumber_Attribute() throws IOException, XMLStreamException {
        toXmlGenerator.setNextName(new QName("namespace", "attribute"));
        toXmlGenerator.setNextIsAttribute(true);
        toXmlGenerator.writeNumber(456.78);
    }
}

package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamException;
import javax.xml.namespace.QName;
import org.codehaus.stax2.XMLStreamWriter2;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamWriter;
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

public class ToXmlGenerator_writeNumber_56_0_Test {

    private ToXmlGenerator toXmlGenerator;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() throws Exception {
        xmlStreamWriter = mock(XMLStreamWriter2.class);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, xmlStreamWriter, null);
    }

    @Test
    public void testWriteNumber_ValidFloat() throws Exception {
        toXmlGenerator.setNextName(new QName("namespace", "element"));
        toXmlGenerator.writeNumber(1.23f);
        verify(xmlStreamWriter).writeStartElement("namespace", "element");
        verify(xmlStreamWriter).writeFloat(1.23f);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteNumber_InfiniteFloat() throws Exception {
        toXmlGenerator.setNextName(new QName("namespace", "element"));
        toXmlGenerator.setNextIsAttribute(false);
        toXmlGenerator.writeNumber(Float.POSITIVE_INFINITY);
        verify(xmlStreamWriter).writeStartElement("namespace", "element");
        verify(xmlStreamWriter).writeFloat(Float.POSITIVE_INFINITY);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteNumber_NegativeInfiniteFloat() throws Exception {
        toXmlGenerator.setNextName(new QName("namespace", "element"));
        toXmlGenerator.setNextIsAttribute(false);
        toXmlGenerator.writeNumber(Float.NEGATIVE_INFINITY);
        verify(xmlStreamWriter).writeStartElement("namespace", "element");
        verify(xmlStreamWriter).writeFloat(Float.NEGATIVE_INFINITY);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteNumber_Attribute() throws Exception {
        toXmlGenerator.setNextName(new QName("namespace", "attribute"));
        toXmlGenerator.setNextIsAttribute(true);
        toXmlGenerator.writeNumber(5.67f);
        verify(xmlStreamWriter).writeFloatAttribute(null, "namespace", "attribute", 5.67f);
    }

    @Test
    public void testWriteNumber_Unwrapped() throws Exception {
        toXmlGenerator.setNextName(new QName("namespace", "element"));
        toXmlGenerator.setNextIsUnwrapped(true);
        toXmlGenerator.writeNumber(8.9f);
        verify(xmlStreamWriter).writeFloat(8.9f);
    }

    @Test
    public void testWriteNumber_MissingName() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            toXmlGenerator.writeNumber(3.14f);
        });
    }
}

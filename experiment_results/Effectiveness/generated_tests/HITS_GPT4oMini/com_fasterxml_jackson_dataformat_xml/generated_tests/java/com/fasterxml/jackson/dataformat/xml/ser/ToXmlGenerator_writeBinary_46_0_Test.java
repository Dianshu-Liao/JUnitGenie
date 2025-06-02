package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;

public class ToXmlGenerator_writeBinary_46_0_Test {

    private XMLStreamWriter2 xmlWriterMock;

    private ToXmlGenerator toXmlGenerator;

    @BeforeEach
    public void setUp() throws Exception {
        xmlWriterMock = mock(XMLStreamWriter2.class);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, xmlWriterMock, null);
    }

    @Test
    public void testWriteBinary_NullData() throws IOException, XMLStreamException {
        toXmlGenerator.writeBinary(Base64Variants.getDefaultVariant(), null, 0, 0);
        verify(xmlWriterMock, times(1)).writeStartElement(anyString(), anyString());
        verify(xmlWriterMock, times(1)).writeEndElement();
    }

    @Test
    public void testWriteBinary_EmptyData() throws IOException, XMLStreamException {
        byte[] data = new byte[0];
        toXmlGenerator.setNextName(new QName("testNamespace", "testElement"));
        toXmlGenerator.writeBinary(Base64Variants.getDefaultVariant(), data, 0, data.length);
        verify(xmlWriterMock, times(1)).writeStartElement("testNamespace", "testElement");
        verify(xmlWriterMock, times(1)).writeBinary(any(), eq(data), eq(0), eq(data.length));
        verify(xmlWriterMock, times(1)).writeEndElement();
    }

    @Test
    public void testWriteBinary_ValidData() throws IOException, XMLStreamException {
        byte[] data = { 1, 2, 3, 4, 5 };
        toXmlGenerator.setNextName(new QName("testNamespace", "testElement"));
        toXmlGenerator.writeBinary(Base64Variants.getDefaultVariant(), data, 0, data.length);
        verify(xmlWriterMock, times(1)).writeStartElement("testNamespace", "testElement");
        verify(xmlWriterMock, times(1)).writeBinary(any(), eq(data), eq(0), eq(data.length));
        verify(xmlWriterMock, times(1)).writeEndElement();
    }

    @Test
    public void testWriteBinary_Attribute() throws IOException, XMLStreamException {
        byte[] data = { 1, 2, 3, 4, 5 };
        toXmlGenerator.setNextName(new QName("testNamespace", "testAttribute"));
        toXmlGenerator.setNextIsAttribute(true);
        toXmlGenerator.writeBinary(Base64Variants.getDefaultVariant(), data, 0, data.length);
        verify(xmlWriterMock, times(1)).writeBinaryAttribute(any(), eq(""), eq("testNamespace"), eq("testAttribute"), any());
    }

    @Test
    public void testWriteBinary_Unwrapped() throws IOException, XMLStreamException {
        byte[] data = { 1, 2, 3, 4, 5 };
        toXmlGenerator.setNextName(new QName("testNamespace", "testElement"));
        toXmlGenerator.setNextIsUnwrapped(true);
    }
}

package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
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
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;

public class ToXmlGenerator_writeNumber_55_0_Test {

    private ToXmlGenerator generator;

    private XMLStreamWriter2 xmlWriter;

    @BeforeEach
    public void setUp() throws Exception {
        StringWriter stringWriter = new StringWriter();
        xmlWriter = mock(XMLStreamWriter2.class);
        generator = new ToXmlGenerator(null, 0, 0, null, xmlWriter, null);
        generator.setNextName(new QName("http://example.com", "number"));
    }

    @Test
    public void testWriteNumber_ValidDouble() throws Exception {
        generator.writeNumber(10.5);
        verify(xmlWriter).writeStartElement("http://example.com", "number");
        verify(xmlWriter).writeDouble(10.5);
        verify(xmlWriter).writeEndElement();
    }

    @Test
    public void testWriteNumber_InfinitePositive() throws Exception {
        generator.setNextIsAttribute(true);
        generator.writeNumber(Double.POSITIVE_INFINITY);
        verify(xmlWriter).writeDoubleAttribute(null, "http://example.com", "number", Double.POSITIVE_INFINITY);
    }

    @Test
    public void testWriteNumber_InfiniteNegative() throws Exception {
        generator.setNextIsAttribute(true);
        generator.writeNumber(Double.NEGATIVE_INFINITY);
        verify(xmlWriter).writeDoubleAttribute(null, "http://example.com", "number", Double.NEGATIVE_INFINITY);
    }

    @Test
    public void testWriteNumber_NullNextName() {
        generator.setNextName(null);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            generator.writeNumber(10.5);
        });
        assertEquals("No element/attribute name specified when trying to output element", exception.getMessage());
    }

    @Test
    public void testWriteNumber_XMLStreamException() throws Exception {
        doThrow(new XMLStreamException("Stream Error")).when(xmlWriter).writeDouble(anyDouble());
        Exception exception = assertThrows(IOException.class, () -> {
            generator.writeNumber(10.5);
        });
        assertTrue(exception.getCause() instanceof XMLStreamException);
    }

    @Test
    public void testWriteNumber_WithPrettyPrinter() throws Exception {
        // Assuming XmlPrettyPrinter is initialized and set
        // This is a placeholder as the actual implementation of pretty printing is not provided
        // You would need to mock the pretty printer behavior here
        // generator.setPrettyPrinter(mockedPrettyPrinter);
        // generator.writeNumber(10.5);
        // verify(mockedPrettyPrinter).writeLeafElement(any(), any(), any(), anyDouble());
    }
}

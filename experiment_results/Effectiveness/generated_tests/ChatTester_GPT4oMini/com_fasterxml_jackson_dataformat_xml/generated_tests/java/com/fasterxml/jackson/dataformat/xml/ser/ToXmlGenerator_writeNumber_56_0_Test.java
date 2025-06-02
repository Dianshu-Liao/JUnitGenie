package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamWriter2;
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

    private XMLStreamWriter2 mockXmlWriter;

    private XmlNameProcessor mockNameProcessor;

    private XmlPrettyPrinter mockPrettyPrinter;

    @BeforeEach
    public void setUp() {
        mockXmlWriter = mock(XMLStreamWriter2.class);
        mockNameProcessor = mock(XmlNameProcessor.class);
        mockPrettyPrinter = mock(XmlPrettyPrinter.class);
        IOContext mockContext = mock(IOContext.class);
        ObjectCodec mockCodec = mock(ObjectCodec.class);
        toXmlGenerator = new ToXmlGenerator(mockContext, 0, 0, mockCodec, mockXmlWriter, mockNameProcessor);
        toXmlGenerator._nextName = new QName("namespaceURI", "localPart");
        toXmlGenerator._xmlPrettyPrinter = mockPrettyPrinter;
    }

    @Test
    public void testWriteNumber_ValidFloat() throws IOException, XMLStreamException {
        float testValue = 1.23f;
        toXmlGenerator.writeNumber(testValue);
        verify(mockXmlWriter).writeStartElement("namespaceURI", "localPart");
        verify(mockXmlWriter).writeFloat(testValue);
        verify(mockXmlWriter).writeEndElement();
    }

    @Test
    public void testWriteNumber_NextIsAttribute() throws IOException, XMLStreamException {
        float testValue = 1.23f;
        toXmlGenerator._nextIsAttribute = true;
        toXmlGenerator.writeNumber(testValue);
        verify(mockXmlWriter).writeFloatAttribute(null, "namespaceURI", "localPart", testValue);
    }

    @Test
    public void testWriteNumber_NextIsUnwrapped() throws IOException, XMLStreamException {
        float testValue = 1.23f;
        toXmlGenerator._nextIsUnwrapped = true;
        toXmlGenerator.writeNumber(testValue);
        verify(mockXmlWriter).writeFloat(testValue);
    }

    @Test
    public void testWriteNumber_InfiniteFloat() throws IOException, XMLStreamException {
        float testValue = Float.POSITIVE_INFINITY;
        toXmlGenerator._nextName = new QName("namespaceURI", "localPart");
        when(toXmlGenerator.isEnabled(ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS)).thenReturn(true);
        toXmlGenerator.writeNumber(testValue);
        verify(mockXmlWriter).writeStartElement("namespaceURI", "localPart");
        // Fixed line
        verify(mockXmlWriter).writeCharacters("INF");
        verify(mockXmlWriter).writeEndElement();
    }

    @Test
    public void testWriteNumber_NegativeInfiniteFloat() throws IOException, XMLStreamException {
        float testValue = Float.NEGATIVE_INFINITY;
        toXmlGenerator._nextName = new QName("namespaceURI", "localPart");
        when(toXmlGenerator.isEnabled(ToXmlGenerator.Feature.WRITE_XML_SCHEMA_CONFORMING_FLOATS)).thenReturn(true);
        toXmlGenerator.writeNumber(testValue);
        verify(mockXmlWriter).writeStartElement("namespaceURI", "localPart");
        // Fixed line
        verify(mockXmlWriter).writeCharacters("-INF");
        verify(mockXmlWriter).writeEndElement();
    }

    @Test
    public void testWriteNumber_XMLStreamException() throws IOException, XMLStreamException {
        float testValue = 1.23f;
        doThrow(new XMLStreamException()).when(mockXmlWriter).writeStartElement(anyString(), anyString());
        assertThrows(IOException.class, () -> {
            toXmlGenerator.writeNumber(testValue);
        });
    }

    @Test
    public void testWriteNumber_MissingName() throws IOException, XMLStreamException {
        toXmlGenerator._nextName = null;
        assertThrows(IOException.class, () -> {
            toXmlGenerator.writeNumber(1.23f);
        });
    }
}

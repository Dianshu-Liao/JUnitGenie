package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.codehaus.stax2.XMLStreamWriter2;
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
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class ToXmlGenerator_startWrappedValue_21_0_Test {

    private XMLStreamWriter2 mockXmlWriter;

    private ToXmlGenerator toXmlGenerator;

    @BeforeEach
    public void setUp() throws Exception {
        mockXmlWriter = mock(XMLStreamWriter2.class);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, mockXmlWriter, null);
    }

    @Test
    public void testStartWrappedValue_WithWrapperName() throws IOException, XMLStreamException {
        QName wrapperName = new QName("http://example.com", "wrapper");
        QName wrappedName = new QName("http://example.com", "wrapped");
        toXmlGenerator.startWrappedValue(wrapperName, wrappedName);
        verify(mockXmlWriter).writeStartElement(wrapperName.getNamespaceURI(), wrapperName.getLocalPart());
        assertEquals(wrappedName, toXmlGenerator._nextName);
    }

    @Test
    public void testStartWrappedValue_WithNullWrapperName() throws IOException, XMLStreamException {
        QName wrappedName = new QName("http://example.com", "wrapped");
        toXmlGenerator.startWrappedValue(null, wrappedName);
        verify(mockXmlWriter, never()).writeStartElement(anyString(), anyString());
        assertEquals(wrappedName, toXmlGenerator._nextName);
    }

    @Test
    public void testStartWrappedValue_ThrowsXMLStreamException() throws IOException, XMLStreamException {
        QName wrapperName = new QName("http://example.com", "wrapper");
        QName wrappedName = new QName("http://example.com", "wrapped");
        doThrow(new XMLStreamException("Error")).when(mockXmlWriter).writeStartElement(anyString(), anyString());
        Exception exception = assertThrows(IOException.class, () -> {
            toXmlGenerator.startWrappedValue(wrapperName, wrappedName);
        });
        assertTrue(exception.getCause() instanceof XMLStreamException);
        assertEquals("Error", exception.getCause().getMessage());
    }
}

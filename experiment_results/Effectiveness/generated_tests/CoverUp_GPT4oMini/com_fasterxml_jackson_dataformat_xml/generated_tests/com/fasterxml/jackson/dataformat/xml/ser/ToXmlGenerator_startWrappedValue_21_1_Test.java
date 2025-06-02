package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
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

class ToXmlGenerator_startWrappedValue_21_1_Test {

    private ToXmlGenerator toXmlGenerator;

    private XMLStreamWriter2 xmlStreamWriter;

    private XMLStreamWriter originalXmlWriter;

    private XmlNameProcessor nameProcessor;

    @BeforeEach
    void setUp() {
        StringWriter stringWriter = new StringWriter();
        originalXmlWriter = mock(XMLStreamWriter.class);
        xmlStreamWriter = Stax2WriterAdapter.wrapIfNecessary(originalXmlWriter);
        nameProcessor = mock(XmlNameProcessor.class);
        IOContext ioContext = mock(IOContext.class);
        when(ioContext.streamWriteConstraints()).thenReturn(null);
        toXmlGenerator = new ToXmlGenerator(ioContext, 0, 0, mock(ObjectCodec.class), xmlStreamWriter, nameProcessor);
    }

    @Test
    void testStartWrappedValue_WithWrapperName() throws Exception {
        QName wrapperName = new QName("http://example.com", "wrapper");
        QName wrappedName = new QName("http://example.com", "wrapped");
        toXmlGenerator.startWrappedValue(wrapperName, wrappedName);
        verify(originalXmlWriter).writeStartElement(wrapperName.getNamespaceURI(), wrapperName.getLocalPart());
        assertNotNull(toXmlGenerator.getClass().getDeclaredField("_nextName").get(toXmlGenerator));
    }

    @Test
    void testStartWrappedValue_WithoutWrapperName() throws Exception {
        QName wrappedName = new QName("http://example.com", "wrapped");
        toXmlGenerator.startWrappedValue(null, wrappedName);
        verify(originalXmlWriter, never()).writeStartElement(anyString(), anyString());
        assertNotNull(toXmlGenerator.getClass().getDeclaredField("_nextName").get(toXmlGenerator));
    }

    @Test
    void testStartWrappedValue_XMLStreamException() throws Exception {
        QName wrapperName = new QName("http://example.com", "wrapper");
        QName wrappedName = new QName("http://example.com", "wrapped");
        doThrow(new XMLStreamException("Test Exception")).when(originalXmlWriter).writeStartElement(anyString(), anyString());
        try {
            toXmlGenerator.startWrappedValue(wrapperName, wrappedName);
        } catch (Exception e) {
            assertNotNull(e);
        }
        assertNotNull(toXmlGenerator.getClass().getDeclaredField("_nextName").get(toXmlGenerator));
    }
}

package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.*;

class ToXmlGenerator_writeStartArray_27_2_Test {

    private ToXmlGenerator generator;

    private XMLStreamWriter2 xmlWriter;

    private XMLStreamWriter originalXmlWriter;

    private XmlNameProcessor nameProcessor;

    private IOContext ctxt;

    @BeforeEach
    void setUp() throws Exception {
        StringWriter stringWriter = new StringWriter();
        originalXmlWriter = mock(XMLStreamWriter.class);
        xmlWriter = Stax2WriterAdapter.wrapIfNecessary(originalXmlWriter);
        nameProcessor = mock(XmlNameProcessor.class);
        ctxt = mock(IOContext.class);
        when(ctxt.streamWriteConstraints()).thenReturn(mock(StreamWriteConstraints.class));
        generator = new ToXmlGenerator(ctxt, 0, 0, mock(ObjectCodec.class), xmlWriter, nameProcessor);
    }

    @Test
    void testWriteStartArray_noPrettyPrinter() throws Exception {
        generator.writeStartArray();
        verify(originalXmlWriter, never()).writeStartElement(anyString());
    }

    @Test
    void testWriteStartArray_withPrettyPrinter() throws Exception {
        XmlPrettyPrinter prettyPrinter = mock(XmlPrettyPrinter.class);
        generator.setPrettyPrinter(prettyPrinter);
        generator.writeStartArray();
        verify(prettyPrinter).writeStartArray(generator);
    }

    @Test
    void testWriteStartArray_verifyNestingDepth() throws Exception {
        StreamWriteConstraints constraints = mock(StreamWriteConstraints.class);
        when(ctxt.streamWriteConstraints()).thenReturn(constraints);
        when(generator.streamWriteConstraints()).thenReturn(constraints);
        generator.writeStartArray();
        verify(constraints).validateNestingDepth(getWriteContext().getNestingDepth());
    }

    @Test
    void testWriteStartArray_verifyValueWrite() throws Exception {
        setWriteContext(generator, mock(JsonWriteContext.class));
        when(getWriteContext().writeValue()).thenReturn(JsonWriteContext.STATUS_EXPECT_NAME);
        Exception exception = assertThrows(IOException.class, () -> {
            generator.writeStartArray();
        });
        String expectedMessage = "Can not start an array, expecting field name";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    private JsonWriteContext getWriteContext() throws Exception {
        Field field = GeneratorBase.class.getDeclaredField("_writeContext");
        field.setAccessible(true);
        return (JsonWriteContext) field.get(generator);
    }

    private void setWriteContext(ToXmlGenerator generator, JsonWriteContext writeContext) throws Exception {
        Field field = GeneratorBase.class.getDeclaredField("_writeContext");
        field.setAccessible(true);
        field.set(generator, writeContext);
    }
}

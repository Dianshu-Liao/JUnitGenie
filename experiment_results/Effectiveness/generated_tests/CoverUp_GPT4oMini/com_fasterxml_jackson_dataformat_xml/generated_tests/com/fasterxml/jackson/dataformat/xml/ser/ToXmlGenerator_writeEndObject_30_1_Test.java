package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamWriter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
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

class ToXmlGenerator_writeEndObject_30_1_Test {

    private ToXmlGenerator generator;

    private IOContext ioContext;

    private XMLStreamWriter xmlWriter;

    private XmlNameProcessor nameProcessor;

    @BeforeEach
    void setUp() {
        ioContext = mock(IOContext.class);
        xmlWriter = mock(XMLStreamWriter.class);
        nameProcessor = mock(XmlNameProcessor.class);
        generator = new ToXmlGenerator(ioContext, 0, 0, null, xmlWriter, nameProcessor);
    }

    private JsonWriteContext getWriteContext() throws Exception {
        Field field = GeneratorBase.class.getDeclaredField("_writeContext");
        field.setAccessible(true);
        return (JsonWriteContext) field.get(generator);
    }

    @Test
    void testWriteEndObjectThrowsExceptionWhenNotInObject() throws Exception {
        JsonWriteContext writeContext = mock(JsonWriteContext.class);
        setField(generator, "_writeContext", writeContext);
        when(writeContext.inObject()).thenReturn(false);
        when(writeContext.typeDesc()).thenReturn("Array");
        assertThrows(IOException.class, () -> generator.writeEndObject());
    }

    @Test
    void testWriteEndObjectCallsHandleEndObjectWhenPrettyPrinterIsNull() throws Exception {
        JsonWriteContext writeContext = mock(JsonWriteContext.class);
        setField(generator, "_writeContext", writeContext);
        when(writeContext.inObject()).thenReturn(true);
        when(writeContext.getParent()).thenReturn(mock(JsonWriteContext.class));
        generator.setNextName(new QName("test"));
        generator._elementNameStack.add(new QName("test"));
        generator.writeEndObject();
        verify(generator, times(1))._handleEndObject();
    }

    @Test
    void testWriteEndObjectCallsPrettyPrinterWhenPrettyPrinterIsSet() throws Exception {
        JsonWriteContext writeContext = mock(JsonWriteContext.class);
        setField(generator, "_writeContext", writeContext);
        when(writeContext.inObject()).thenReturn(true);
        when(writeContext.getParent()).thenReturn(mock(JsonWriteContext.class));
        when(writeContext.getEntryCount()).thenReturn(1);
        XmlPrettyPrinter prettyPrinter = mock(XmlPrettyPrinter.class);
        generator.setPrettyPrinter(prettyPrinter);
        generator.writeEndObject();
        verify(prettyPrinter, times(1)).writeEndObject(generator, 1);
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}

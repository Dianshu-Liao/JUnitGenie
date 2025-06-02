package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import javax.xml.XMLConstants;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

@ExtendWith(MockitoExtension.class)
class ToXmlGenerator__handleEndObject_32_2_Test {

    private ToXmlGenerator toXmlGenerator;

    private XMLStreamWriter2 mockXmlWriter;

    private IOContext mockIOContext;

    private ObjectCodec mockObjectCodec;

    private XmlNameProcessor mockNameProcessor;

    @BeforeEach
    void setUp() {
        mockXmlWriter = mock(XMLStreamWriter2.class);
        mockIOContext = mock(IOContext.class);
        mockObjectCodec = mock(ObjectCodec.class);
        mockNameProcessor = mock(XmlNameProcessor.class);
        toXmlGenerator = new ToXmlGenerator(mockIOContext, 0, 0, mockObjectCodec, mockXmlWriter, mockNameProcessor) {

            {
                _elementNameStack.push(new QName("root"));
            }
        };
    }

    @Test
    void testHandleEndObject_withOpenStartElement() throws Exception {
        toXmlGenerator._elementNameStack.push(new QName("child"));
        toXmlGenerator._handleEndObject();
        verify(mockXmlWriter).writeEndElement();
        assertTrue(toXmlGenerator._elementNameStack.isEmpty());
    }

    @Test
    void testHandleEndObject_withoutOpenStartElement() {
        toXmlGenerator._elementNameStack.clear();
        JsonGenerationException exception = assertThrows(JsonGenerationException.class, () -> {
            toXmlGenerator._handleEndObject();
        });
        assertEquals("Can not write END_ELEMENT without open START_ELEMENT", exception.getMessage());
    }

    @Test
    void testHandleEndObject_withPrettyPrinter() throws Exception {
        toXmlGenerator._elementNameStack.push(new QName("child"));
        XmlPrettyPrinter prettyPrinterMock = mock(XmlPrettyPrinter.class);
        toXmlGenerator.setPrettyPrinter(prettyPrinterMock);
        setField(toXmlGenerator, "_xmlPrettyPrinter", prettyPrinterMock);
        setField(toXmlGenerator, "_stax2Emulation", false);
        toXmlGenerator._handleEndObject();
        verify(mockXmlWriter).writeEndElement();
        verify(prettyPrinterMock).writePrologLinefeed(mockXmlWriter);
    }

    @Test
    void testHandleEndObject_XMLStreamException() throws Exception {
        toXmlGenerator._elementNameStack.push(new QName("child"));
        doThrow(new XMLStreamException("Stream exception")).when(mockXmlWriter).writeEndElement();
        Exception exception = assertThrows(JsonGenerationException.class, () -> {
            toXmlGenerator._handleEndObject();
        });
        assertTrue(exception.getCause() instanceof XMLStreamException);
        assertEquals("Stream exception", exception.getCause().getMessage());
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}

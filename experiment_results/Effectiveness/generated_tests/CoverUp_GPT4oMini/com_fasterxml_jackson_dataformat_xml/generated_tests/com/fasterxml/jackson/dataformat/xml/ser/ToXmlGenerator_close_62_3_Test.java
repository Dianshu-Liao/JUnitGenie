package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.namespace.QName;
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
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;

@ExtendWith(MockitoExtension.class)
class ToXmlGenerator_close_62_3_Test {

    private ToXmlGenerator toXmlGenerator;

    private XMLStreamWriter2 xmlStreamWriter;

    private XMLStreamWriter originalXmlWriter;

    @BeforeEach
    void setUp() throws Exception {
        StringWriter stringWriter = new StringWriter();
        originalXmlWriter = mock(XMLStreamWriter.class);
        xmlStreamWriter = Stax2WriterAdapter.wrapIfNecessary(originalXmlWriter);
        IOContext ioContext = mock(IOContext.class);
        when(ioContext.isResourceManaged()).thenReturn(true);
        toXmlGenerator = new ToXmlGenerator(ioContext, 0, 0, null, xmlStreamWriter, null);
    }

    @Test
    void testClose_withOpenContent() throws Exception {
        when(toXmlGenerator.getOutputContext().inArray()).thenReturn(true);
        toXmlGenerator.close();
        verify(originalXmlWriter).close();
    }

    @Test
    void testClose_withOpenObject() throws Exception {
        when(toXmlGenerator.getOutputContext().inObject()).thenReturn(true);
        toXmlGenerator.close();
        verify(originalXmlWriter).close();
    }

    @Test
    void testClose_whenExceptionThrown() throws Exception {
        doThrow(new XMLStreamException("Test Exception")).when(originalXmlWriter).close();
        assertThrows(JsonGenerationException.class, () -> {
            toXmlGenerator.close();
        });
    }

    @Test
    void testClose_whenAlreadyClosed() throws Exception {
        Method isClosedMethod = ToXmlGenerator.class.getDeclaredMethod("isClosed");
        isClosedMethod.setAccessible(true);
        when(isClosedMethod.invoke(toXmlGenerator)).thenReturn(true);
        toXmlGenerator.close();
        verify(originalXmlWriter, never()).close();
    }
}

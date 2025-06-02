package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamWriter;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
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

public class ToXmlGenerator_writeEndObject_30_0_Test {

    @Mock
    private XMLStreamWriter2 xmlWriter;

    @Mock
    private XMLStreamWriter originalXmlWriter;

    private ToXmlGenerator toXmlGenerator;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        // Initialize the ToXmlGenerator with mocked dependencies
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, originalXmlWriter, null);
        toXmlGenerator.setNextName(new QName("testName"));
        toXmlGenerator._elementNameStack.add(new QName("testElement"));
    }

    private void setProtectedField(String fieldName, Object value) throws Exception {
        Field field = ToXmlGenerator.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(toXmlGenerator, value);
    }

    @Test
    public void testWriteEndObject_WhenInObjectContext_ShouldCallHandleEndObject() throws IOException, Exception {
        JsonWriteContext writeContext = mock(JsonWriteContext.class);
        setProtectedField("_writeContext", writeContext);
        when(writeContext.inObject()).thenReturn(true);
        when(writeContext.getParent()).thenReturn(mock(JsonWriteContext.class));
        toXmlGenerator._elementNameStack.add(new QName("testElement"));
        // Call the method under test
        toXmlGenerator.writeEndObject();
        // Verify that _handleEndObject was called
        verify(toXmlGenerator, times(1))._handleEndObject();
    }

    @Test
    public void testWriteEndObject_WhenNotInObjectContext_ShouldReportError() throws Exception {
        JsonWriteContext writeContext = mock(JsonWriteContext.class);
        setProtectedField("_writeContext", writeContext);
        when(writeContext.inObject()).thenReturn(false);
        // Expect an exception to be thrown
        Exception exception = assertThrows(JsonGenerationException.class, () -> {
            toXmlGenerator.writeEndObject();
        });
        assertTrue(exception.getMessage().contains("Current context not Object"));
    }

    @Test
    public void testWriteEndObject_WhenPrettyPrinterIsNull_ShouldCallHandleEndObject() throws IOException, Exception {
        JsonWriteContext writeContext = mock(JsonWriteContext.class);
        setProtectedField("_writeContext", writeContext);
        when(writeContext.inObject()).thenReturn(true);
        when(writeContext.getParent()).thenReturn(mock(JsonWriteContext.class));
        setProtectedField("_cfgPrettyPrinter", null);
        // Call the method under test
        toXmlGenerator.writeEndObject();
        // Verify that _handleEndObject was called
        verify(toXmlGenerator, times(1))._handleEndObject();
    }
}

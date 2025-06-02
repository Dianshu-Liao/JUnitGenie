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

class ToXmlGenerator_writeNumber_53_0_Test {

    private XMLStreamWriter2 mockXmlWriter;

    private ToXmlGenerator toXmlGenerator;

    @BeforeEach
    void setUp() throws Exception {
        StringWriter stringWriter = new StringWriter();
        mockXmlWriter = mock(XMLStreamWriter2.class);
        XMLStreamWriter wrappedWriter = Stax2WriterAdapter.wrapIfNecessary(mockXmlWriter);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, wrappedWriter, null);
    }

    @Test
    void testWriteNumberWithMissingName() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            toXmlGenerator.writeNumber(42);
        });
        assertEquals("No element/attribute name specified when trying to output element", exception.getMessage());
    }

    @Test
    void testWriteNumberAsAttribute() throws Exception {
        QName name = new QName("namespace", "localPart");
        toXmlGenerator.setNextName(name);
        toXmlGenerator.setNextIsAttribute(true);
        toXmlGenerator.writeNumber(42);
        verify(mockXmlWriter).writeIntAttribute(null, "namespace", "localPart", 42);
    }

    @Test
    void testWriteNumberUnwrapped() throws Exception {
        QName name = new QName("namespace", "localPart");
        toXmlGenerator.setNextName(name);
        toXmlGenerator.setNextIsUnwrapped(true);
        toXmlGenerator.writeNumber(42);
        verify(mockXmlWriter).writeInt(42);
    }

    @Test
    void testWriteNumberAsElement() throws Exception {
        QName name = new QName("namespace", "localPart");
        toXmlGenerator.setNextName(name);
        toXmlGenerator.writeNumber(42);
        verify(mockXmlWriter).writeStartElement("namespace", "localPart");
        verify(mockXmlWriter).writeInt(42);
        verify(mockXmlWriter).writeEndElement();
    }

    @Test
    void testWriteNumberWithPrettyPrinter() throws Exception {
        QName name = new QName("namespace", "localPart");
        toXmlGenerator.setNextName(name);
        XmlPrettyPrinter prettyPrinter = mock(XmlPrettyPrinter.class);
        toXmlGenerator.setPrettyPrinter(prettyPrinter);
        toXmlGenerator.writeNumber(42);
        verify(prettyPrinter).writeLeafElement(mockXmlWriter, "namespace", "localPart", 42);
    }

    @Test
    void testWriteNumberHandlesXMLStreamException() throws Exception {
        QName name = new QName("namespace", "localPart");
        toXmlGenerator.setNextName(name);
        doThrow(new XMLStreamException("Test exception")).when(mockXmlWriter).writeStartElement(anyString(), anyString());
        Exception exception = assertThrows(IOException.class, () -> {
            toXmlGenerator.writeNumber(42);
        });
        assertTrue(exception.getMessage().contains("Test exception"));
    }
}

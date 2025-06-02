package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.namespace.QName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamWriter2;
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
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class ToXmlGenerator_writeNumber_54_1_Test {

    private XMLStreamWriter2 xmlWriter;

    private ToXmlGenerator toXmlGenerator;

    @BeforeEach
    public void setUp() throws Exception {
        xmlWriter = mock(XMLStreamWriter2.class);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, xmlWriter, null);
    }

    @Test
    public void testWriteNumber_WithValidNameAndValue() throws Exception {
        QName name = new QName("namespace", "element");
        toXmlGenerator.setNextName(name);
        long value = 12345;
        toXmlGenerator.writeNumber(value);
        verify(xmlWriter).writeStartElement(name.getNamespaceURI(), name.getLocalPart());
        verify(xmlWriter).writeLong(value);
        verify(xmlWriter).writeEndElement();
    }

    @Test
    public void testWriteNumber_WithAttribute() throws Exception {
        QName name = new QName("namespace", "attribute");
        toXmlGenerator.setNextName(name);
        toXmlGenerator.setNextIsAttribute(true);
        long value = 67890;
        toXmlGenerator.writeNumber(value);
        verify(xmlWriter).writeLongAttribute(null, name.getNamespaceURI(), name.getLocalPart(), value);
    }

    @Test
    public void testWriteNumber_WithUnwrapped() throws Exception {
        QName name = new QName("namespace", "unwrappedElement");
        toXmlGenerator.setNextName(name);
        toXmlGenerator.setNextIsUnwrapped(true);
        long value = 54321;
        toXmlGenerator.writeNumber(value);
        verify(xmlWriter).writeLong(value);
    }

    @Test
    public void testWriteNumber_ThrowsExceptionWhenNameMissing() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            toXmlGenerator.writeNumber(123);
        });
        assertEquals("No element/attribute name specified when trying to output element", exception.getMessage());
    }

    @Test
    public void testWriteNumber_HandlesXMLStreamException() throws Exception {
        QName name = new QName("namespace", "element");
        toXmlGenerator.setNextName(name);
        long value = 12345;
        doThrow(new XMLStreamException("Stream exception")).when(xmlWriter).writeLong(anyLong());
        Exception exception = assertThrows(JsonGenerationException.class, () -> {
            toXmlGenerator.writeNumber(value);
        });
        assertTrue(exception.getMessage().contains("Stream exception"));
    }
}

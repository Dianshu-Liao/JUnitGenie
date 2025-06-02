package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.namespace.QName;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamWriter;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class ToXmlGenerator_writeNumber_54_0_Test {

    private XMLStreamWriter2 xmlWriter;

    private ToXmlGenerator toXmlGenerator;

    @BeforeEach
    public void setUp() {
        xmlWriter = mock(XMLStreamWriter2.class);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, xmlWriter, null);
    }

    @Test
    public void testWriteNumber_WithMissingName_ShouldThrowException() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            toXmlGenerator.writeNumber(123);
        });
        assertEquals("No element/attribute name specified when trying to output element", exception.getMessage());
    }

    @Test
    public void testWriteNumber_WithAttribute_ShouldWriteLongAttribute() throws XMLStreamException, IOException {
        QName name = new QName("namespaceURI", "localPart");
        toXmlGenerator.setNextName(name);
        toXmlGenerator.setNextIsAttribute(true);
        toXmlGenerator.writeNumber(123);
        verify(xmlWriter).writeLongAttribute(null, name.getNamespaceURI(), name.getLocalPart(), 123);
    }

    @Test
    public void testWriteNumber_WithUnwrapped_ShouldWriteLong() throws XMLStreamException, IOException {
        QName name = new QName("namespaceURI", "localPart");
        toXmlGenerator.setNextName(name);
        toXmlGenerator.setNextIsUnwrapped(true);
        toXmlGenerator.writeNumber(123);
        verify(xmlWriter).writeLong(123);
    }

    @Test
    public void testWriteNumber_WithPrettyPrinter_ShouldWriteLeafElement() throws XMLStreamException, IOException {
        QName name = new QName("namespaceURI", "localPart");
        toXmlGenerator.setNextName(name);
        toXmlGenerator._xmlPrettyPrinter = mock(XmlPrettyPrinter.class);
        toXmlGenerator.writeNumber(123);
        verify(toXmlGenerator._xmlPrettyPrinter).writeLeafElement(xmlWriter, name.getNamespaceURI(), name.getLocalPart(), 123);
    }
}

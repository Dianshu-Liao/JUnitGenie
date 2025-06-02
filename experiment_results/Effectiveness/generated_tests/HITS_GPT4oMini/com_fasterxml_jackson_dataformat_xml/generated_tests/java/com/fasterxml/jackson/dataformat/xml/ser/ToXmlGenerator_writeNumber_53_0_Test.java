package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.namespace.QName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class ToXmlGenerator_writeNumber_53_0_Test {

    private XMLStreamWriter2 xmlWriter;

    private ToXmlGenerator toXmlGenerator;

    @BeforeEach
    public void setUp() throws Exception {
        XMLStreamWriter mockWriter = mock(XMLStreamWriter.class);
        xmlWriter = Stax2WriterAdapter.wrapIfNecessary(mockWriter);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, xmlWriter, null);
    }

    @Test
    public void testWriteNumber_WithNullNextName_ShouldThrowException() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            toXmlGenerator.writeNumber(42);
        });
        assertEquals("No element/attribute name specified when trying to output element", exception.getMessage());
    }

    @Test
    public void testWriteNumber_WithNextNameAsAttribute_ShouldWriteIntAttribute() throws Exception {
        QName name = new QName("namespace", "localPart");
        toXmlGenerator.setNextName(name);
        toXmlGenerator.setNextIsAttribute(true);
        toXmlGenerator.writeNumber(42);
        verify(xmlWriter).writeIntAttribute(null, "namespace", "localPart", 42);
    }

    @Test
    public void testWriteNumber_WithNextNameAndUnwrapped_ShouldWriteInt() throws Exception {
        QName name = new QName("namespace", "localPart");
        toXmlGenerator.setNextName(name);
        toXmlGenerator.setNextIsUnwrapped(true);
        toXmlGenerator.writeNumber(42);
        verify(xmlWriter).writeInt(42);
    }

    @Test
    public void testWriteNumber_WithNextName_ShouldWriteStartElementAndEndElement() throws Exception {
        QName name = new QName("namespace", "localPart");
        toXmlGenerator.setNextName(name);
        toXmlGenerator.writeNumber(42);
        verify(xmlWriter).writeStartElement("namespace", "localPart");
        verify(xmlWriter).writeInt(42);
        verify(xmlWriter).writeEndElement();
    }

    @Test
    public void testWriteNumber_WithPrettyPrinter_ShouldUsePrettyPrinter() throws Exception {
        QName name = new QName("namespace", "localPart");
        toXmlGenerator.setNextName(name);
        XmlPrettyPrinter prettyPrinter = mock(XmlPrettyPrinter.class);
        toXmlGenerator.setPrettyPrinter(prettyPrinter);
        toXmlGenerator.writeNumber(42);
        verify(prettyPrinter).writeLeafElement(xmlWriter, "namespace", "localPart", 42);
    }
}

package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import javax.xml.namespace.QName;
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
import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class ToXmlGenerator_writeBoolean_51_0_Test {

    private ToXmlGenerator toXmlGenerator;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() throws Exception {
        xmlStreamWriter = mock(XMLStreamWriter2.class);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, xmlStreamWriter, null);
    }

    @Test
    public void testWriteBoolean_WithMissingName_ShouldThrowException() {
        Exception exception = null;
        try {
            toXmlGenerator.writeBoolean(true);
        } catch (IOException e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalStateException);
        assertEquals("No element/attribute name specified when trying to output element", exception.getMessage());
    }

    @Test
    public void testWriteBoolean_WithAttribute() throws Exception {
        toXmlGenerator.setNextName(new QName("namespace", "attributeName"));
        toXmlGenerator.setNextIsAttribute(true);
        toXmlGenerator.writeBoolean(true);
        verify(xmlStreamWriter).writeBooleanAttribute(null, "namespace", "attributeName", true);
    }

    @Test
    public void testWriteBoolean_WithUnwrapped() throws Exception {
        toXmlGenerator.setNextName(new QName("namespace", "elementName"));
        toXmlGenerator.setNextIsUnwrapped(true);
        toXmlGenerator.writeBoolean(true);
        verify(xmlStreamWriter).writeBoolean(true);
    }

    @Test
    public void testWriteBoolean_WithPrettyPrinter() throws Exception {
        XmlPrettyPrinter prettyPrinter = mock(XmlPrettyPrinter.class);
        toXmlGenerator.setPrettyPrinter(prettyPrinter);
        toXmlGenerator.setNextName(new QName("namespace", "elementName"));
        toXmlGenerator.setNextIsUnwrapped(false);
        toXmlGenerator.writeBoolean(true);
        verify(prettyPrinter).writeLeafElement(xmlStreamWriter, "namespace", "elementName", true);
    }

    @Test
    public void testWriteBoolean_WithoutPrettyPrinter() throws Exception {
        toXmlGenerator.setNextName(new QName("namespace", "elementName"));
        toXmlGenerator.setNextIsUnwrapped(false);
        toXmlGenerator.writeBoolean(true);
        verify(xmlStreamWriter).writeStartElement("namespace", "elementName");
        verify(xmlStreamWriter).writeBoolean(true);
        verify(xmlStreamWriter).writeEndElement();
    }
}

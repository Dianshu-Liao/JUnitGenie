package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.codehaus.stax2.XMLStreamWriter2;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.XMLConstants;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.*;

public class ToXmlGenerator__handleEndObject_32_4_Test {

    private ToXmlGenerator generator;

    private XMLStreamWriter2 xmlWriter;

    private XmlPrettyPrinter prettyPrinter;

    private QName elementName;

    @BeforeEach
    public void setUp() throws Exception {
        xmlWriter = mock(XMLStreamWriter2.class);
        prettyPrinter = mock(XmlPrettyPrinter.class);
        IOContext ctxt = mock(IOContext.class);
        // Mock the abstract class
        XmlNameProcessor nameProcessor = mock(XmlNameProcessor.class);
        generator = new ToXmlGenerator(ctxt, 0, 0, null, xmlWriter, nameProcessor);
        generator.setPrettyPrinter(prettyPrinter);
        elementName = new QName("testElement");
        generator.setNextName(elementName);
        generator._elementNameStack.add(elementName);
    }

    @Test
    public void testHandleEndObjectWithOpenElement() throws Exception {
        generator._elementNameStack.add(elementName);
        generator._handleEndObject();
        verify(xmlWriter).writeEndElement();
        assertTrue(generator._elementNameStack.isEmpty());
    }

    @Test
    public void testHandleEndObjectThrowsExceptionWhenNoOpenElement() {
        generator._elementNameStack.clear();
        JsonGenerationException exception = assertThrows(JsonGenerationException.class, () -> {
            generator._handleEndObject();
        });
        assertEquals("Can not write END_ELEMENT without open START_ELEMENT", exception.getMessage());
    }

    @Test
    public void testHandleEndObjectWithPrettyPrinter() throws Exception {
        // Clear to test indentation logic
        generator._elementNameStack.clear();
        generator._xmlPrettyPrinter = prettyPrinter;
        generator._handleEndObject();
        verify(prettyPrinter).writePrologLinefeed(xmlWriter);
    }

    @Test
    public void testHandleEndObjectCatchesXMLStreamException() throws Exception {
        doThrow(new XMLStreamException("Test exception")).when(xmlWriter).writeEndElement();
        JsonGenerationException exception = assertThrows(JsonGenerationException.class, () -> {
            generator._handleEndObject();
        });
        assertEquals("Test exception", exception.getCause().getMessage());
    }
}

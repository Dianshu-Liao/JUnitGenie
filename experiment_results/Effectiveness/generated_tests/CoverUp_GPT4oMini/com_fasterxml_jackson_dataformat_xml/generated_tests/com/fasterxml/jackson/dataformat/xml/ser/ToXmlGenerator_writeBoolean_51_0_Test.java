package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import com.fasterxml.jackson.core.*;

public class ToXmlGenerator_writeBoolean_51_0_Test {

    private XMLStreamWriter2 mockXmlWriter;

    private ToXmlGenerator generator;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() throws Exception {
        stringWriter = new StringWriter();
        mockXmlWriter = mock(XMLStreamWriter2.class);
        // Use reflection to instantiate XmlNameProcessor
        Constructor<XmlNameProcessor> constructor = XmlNameProcessor.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        XmlNameProcessor nameProcessor = constructor.newInstance();
        generator = new ToXmlGenerator(null, 0, 0, null, mockXmlWriter, nameProcessor);
    }

    @Test
    public void testWriteBooleanElement() throws Exception {
        QName name = new QName("http://example.com", "testElement");
        generator.setNextName(name);
        generator.writeBoolean(true);
        verify(mockXmlWriter).writeStartElement(name.getNamespaceURI(), name.getLocalPart());
        verify(mockXmlWriter).writeBoolean(true);
        verify(mockXmlWriter).writeEndElement();
    }

    @Test
    public void testWriteBooleanAttribute() throws Exception {
        QName name = new QName("http://example.com", "testAttribute");
        generator.setNextName(name);
        generator.setNextIsAttribute(true);
        generator.writeBoolean(false);
        verify(mockXmlWriter).writeBooleanAttribute(null, name.getNamespaceURI(), name.getLocalPart(), false);
    }

    @Test
    public void testWriteBooleanUnwrapped() throws Exception {
        QName name = new QName("http://example.com", "testUnwrapped");
        generator.setNextName(name);
        generator.setNextIsUnwrapped(true);
        generator.writeBoolean(true);
        verify(mockXmlWriter).writeBoolean(true);
    }

    @Test
    public void testWriteBooleanMissingName() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            generator.writeBoolean(true);
        });
        assertEquals("No element/attribute name specified when trying to output element", exception.getMessage());
    }

    @Test
    public void testWriteBooleanWithPrettyPrinter() throws Exception {
        QName name = new QName("http://example.com", "prettyElement");
        generator.setNextName(name);
        generator.setPrettyPrinter(mock(XmlPrettyPrinter.class));
        generator.writeBoolean(true);
        verify(mockXmlWriter).writeStartElement(name.getNamespaceURI(), name.getLocalPart());
        verify(mockXmlWriter).writeBoolean(true);
        verify(mockXmlWriter).writeEndElement();
    }

    @Test
    public void testWriteBooleanThrowsXMLStreamException() throws Exception {
        QName name = new QName("http://example.com", "testElement");
        generator.setNextName(name);
        doThrow(new XMLStreamException("XML error")).when(mockXmlWriter).writeStartElement(anyString(), anyString());
        Exception exception = assertThrows(IOException.class, () -> {
            generator.writeBoolean(true);
        });
        assertEquals("XML error", exception.getCause().getMessage());
    }
}

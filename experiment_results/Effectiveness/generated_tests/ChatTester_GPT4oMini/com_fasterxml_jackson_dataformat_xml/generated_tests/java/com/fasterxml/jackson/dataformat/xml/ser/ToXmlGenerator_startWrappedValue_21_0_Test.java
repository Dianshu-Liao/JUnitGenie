package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.namespace.QName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
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
import java.util.*;
import com.fasterxml.jackson.core.*;

class ToXmlGenerator_startWrappedValue_21_0_Test {

    private ToXmlGenerator toXmlGenerator;

    private XMLStreamWriter xmlWriterMock;

    private XmlPrettyPrinter xmlPrettyPrinterMock;

    private QName wrapperName;

    private QName wrappedName;

    @BeforeEach
    void setUp() {
        xmlWriterMock = mock(XMLStreamWriter.class);
        xmlPrettyPrinterMock = mock(XmlPrettyPrinter.class);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, xmlWriterMock, null);
        // Set the pretty printer
        toXmlGenerator._xmlPrettyPrinter = xmlPrettyPrinterMock;
        wrapperName = new QName("namespace", "wrapper");
        wrappedName = new QName("namespace", "wrapped");
    }

    @Test
    void testStartWrappedValue_WithPrettyPrinter() throws Exception {
        toXmlGenerator.startWrappedValue(wrapperName, wrappedName);
        verify(xmlPrettyPrinterMock).writeStartElement(any(XMLStreamWriter2.class), eq(wrapperName.getNamespaceURI()), eq(wrapperName.getLocalPart()));
        assertEquals(wrappedName, getPrivateField(toXmlGenerator, "_nextName"));
    }

    @Test
    void testStartWrappedValue_WithoutPrettyPrinter() throws Exception {
        // Remove pretty printer
        toXmlGenerator._xmlPrettyPrinter = null;
        toXmlGenerator.startWrappedValue(wrapperName, wrappedName);
        verify(xmlWriterMock).writeStartElement(wrapperName.getNamespaceURI(), wrapperName.getLocalPart());
        assertEquals(wrappedName, getPrivateField(toXmlGenerator, "_nextName"));
    }

    @Test
    void testStartWrappedValue_WithException() throws Exception {
        doThrow(new XMLStreamException("Error")).when(xmlWriterMock).writeStartElement(anyString(), anyString());
        Exception exception = assertThrows(IOException.class, () -> {
            toXmlGenerator.startWrappedValue(wrapperName, wrappedName);
        });
        assertEquals("Error", exception.getMessage());
        assertEquals(wrappedName, getPrivateField(toXmlGenerator, "_nextName"));
    }

    private Object getPrivateField(Object obj, String fieldName) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}

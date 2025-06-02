package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamException;
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
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class ToXmlGenerator_finishWrappedValue_22_2_Test {

    private ToXmlGenerator toXmlGenerator;

    private XMLStreamWriter2 mockXmlWriter;

    private XmlPrettyPrinter mockXmlPrettyPrinter;

    @BeforeEach
    public void setUp() {
        mockXmlWriter = mock(XMLStreamWriter2.class);
        mockXmlPrettyPrinter = mock(XmlPrettyPrinter.class);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, mockXmlWriter, null);
        toXmlGenerator._xmlPrettyPrinter = mockXmlPrettyPrinter;
    }

    @Test
    public void testFinishWrappedValue_WithWrapperName_CallsWriteEndElement() throws Exception {
        QName wrapperName = new QName("wrapper");
        QName wrappedName = new QName("wrapped");
        toXmlGenerator.finishWrappedValue(wrapperName, wrappedName);
        verify(mockXmlPrettyPrinter).writeEndElement(mockXmlWriter, 0);
        verify(mockXmlWriter, never()).writeEndElement();
    }

    @Test
    public void testFinishWrappedValue_WithWrapperName_NoPrettyPrinter_CallsWriteEndElement() throws Exception {
        toXmlGenerator._xmlPrettyPrinter = null;
        QName wrapperName = new QName("wrapper");
        QName wrappedName = new QName("wrapped");
        toXmlGenerator.finishWrappedValue(wrapperName, wrappedName);
        verify(mockXmlWriter).writeEndElement();
    }

    @Test
    public void testFinishWrappedValue_NullWrapperName_DoesNotCallWriteEndElement() throws Exception {
        QName wrapperName = null;
        QName wrappedName = new QName("wrapped");
        toXmlGenerator.finishWrappedValue(wrapperName, wrappedName);
        verify(mockXmlWriter, never()).writeEndElement();
        verify(mockXmlPrettyPrinter, never()).writeEndElement(any(), anyInt());
    }

    @Test
    public void testFinishWrappedValue_WithWrapperName_ThrowsXMLStreamException() throws Exception {
        QName wrapperName = new QName("wrapper");
        QName wrappedName = new QName("wrapped");
        doThrow(new XMLStreamException()).when(mockXmlPrettyPrinter).writeEndElement(mockXmlWriter, 0);
        Exception exception = assertThrows(IOException.class, () -> {
            toXmlGenerator.finishWrappedValue(wrapperName, wrappedName);
        });
        assertNotNull(exception);
        assertTrue(exception.getCause() instanceof XMLStreamException);
    }
}

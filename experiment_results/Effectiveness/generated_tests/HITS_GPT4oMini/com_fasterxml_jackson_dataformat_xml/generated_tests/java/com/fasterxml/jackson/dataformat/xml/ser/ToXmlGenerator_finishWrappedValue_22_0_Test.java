package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import javax.xml.namespace.QName;
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
import javax.xml.stream.XMLStreamException;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

class ToXmlGenerator_finishWrappedValue_22_0_Test {

    private ToXmlGenerator generator;

    private XMLStreamWriter2 xmlStreamWriter;

    private IOContext ioContext;

    private ObjectCodec objectCodec;

    private XmlNameProcessor nameProcessor;

    @BeforeEach
    void setUp() {
        xmlStreamWriter = mock(XMLStreamWriter2.class);
        ioContext = mock(IOContext.class);
        objectCodec = mock(ObjectCodec.class);
        nameProcessor = mock(XmlNameProcessor.class);
        // Assuming the required parameters for the constructor
        generator = new ToXmlGenerator(ioContext, 0, 0, objectCodec, xmlStreamWriter, nameProcessor);
    }

    @Test
    void testFinishWrappedValue() throws Exception {
        QName wrapperName = new QName("http://example.com", "wrapper");
        QName wrappedName = new QName("http://example.com", "wrapped");
        // Call the method under test
        generator.finishWrappedValue(wrapperName, wrappedName);
        // Verify that the writeEndElement method was called
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    void testFinishWrappedValueWithNullWrapper() throws Exception {
        QName wrapperName = null;
        QName wrappedName = new QName("http://example.com", "wrapped");
        // Call the method under test
        generator.finishWrappedValue(wrapperName, wrappedName);
        // Verify that the writeEndElement method is not called when wrapperName is null
        verify(xmlStreamWriter, never()).writeEndElement();
    }
}

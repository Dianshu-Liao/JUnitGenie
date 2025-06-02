package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
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
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;

class ToXmlGenerator_finishWrappedValue_22_2_Test {

    private ToXmlGenerator toXmlGenerator;

    private XMLStreamWriter2 xmlWriter;

    private XmlNameProcessor nameProcessor;

    private IOContext ioContext;

    @BeforeEach
    void setUp() {
        xmlWriter = mock(XMLStreamWriter2.class);
        nameProcessor = mock(XmlNameProcessor.class);
        ioContext = mock(IOContext.class);
        toXmlGenerator = new ToXmlGenerator(ioContext, 0, 0, mock(ObjectCodec.class), xmlWriter, nameProcessor);
    }

    @Test
    void testFinishWrappedValueWithWrapperName() throws Exception {
        QName wrapperName = new QName("http://example.com", "wrapper");
        QName wrappedName = new QName("http://example.com", "wrapped");
        // Mocking the behavior of XMLStreamWriter
        doNothing().when(xmlWriter).writeEndElement();
        // Call the method under test
        toXmlGenerator.finishWrappedValue(wrapperName, wrappedName);
        // Verify that the writeEndElement method was called
        verify(xmlWriter, times(1)).writeEndElement();
    }

    @Test
    void testFinishWrappedValueWithWrapperNameAndPrettyPrinter() throws Exception {
        QName wrapperName = new QName("http://example.com", "wrapper");
        QName wrappedName = new QName("http://example.com", "wrapped");
        // Set up pretty printer
        toXmlGenerator.setPrettyPrinter(mock(XmlPrettyPrinter.class));
        // Mocking the behavior of the pretty printer
        XmlPrettyPrinter prettyPrinter = (XmlPrettyPrinter) toXmlGenerator.getPrettyPrinter();
        doNothing().when(prettyPrinter).writeEndElement(xmlWriter, 0);
        // Call the method under test
        toXmlGenerator.finishWrappedValue(wrapperName, wrappedName);
        // Verify that the pretty printer's writeEndElement method was called
        verify(prettyPrinter, times(1)).writeEndElement(xmlWriter, 0);
    }

    @Test
    void testFinishWrappedValueThrowsIOException() throws Exception {
        QName wrapperName = new QName("http://example.com", "wrapper");
        QName wrappedName = new QName("http://example.com", "wrapped");
        // Mock the XMLStreamWriter to throw an exception
        doThrow(new XMLStreamException("Test Exception")).when(xmlWriter).writeEndElement();
        // Call the method under test and expect an IOException
        try {
            toXmlGenerator.finishWrappedValue(wrapperName, wrappedName);
        } catch (IOException e) {
            // Verify that the exception was thrown
            assert (e.getCause() instanceof XMLStreamException);
            return;
        }
        // If we reach here, the exception was not thrown as expected
        fail("Expected IOException was not thrown");
    }
}

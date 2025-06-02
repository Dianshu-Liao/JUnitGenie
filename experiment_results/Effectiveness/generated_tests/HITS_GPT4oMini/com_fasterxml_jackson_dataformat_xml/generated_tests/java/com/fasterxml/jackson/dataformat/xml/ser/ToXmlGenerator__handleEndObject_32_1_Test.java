package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
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
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;

public class ToXmlGenerator__handleEndObject_32_1_Test {

    private ToXmlGenerator toXmlGenerator;

    private XMLStreamWriter2 xmlWriter;

    @BeforeEach
    public void setUp() {
        xmlWriter = Mockito.mock(XMLStreamWriter2.class);
        IOContext ioContext = Mockito.mock(IOContext.class);
        ObjectCodec objectCodec = Mockito.mock(ObjectCodec.class);
        XmlNameProcessor xmlNameProcessor = Mockito.mock(XmlNameProcessor.class);
        toXmlGenerator = new ToXmlGenerator(ioContext, 0, 0, objectCodec, xmlWriter, xmlNameProcessor);
        toXmlGenerator._elementNameStack = new LinkedList<>();
    }

    @Test
    public void testHandleEndObject_ThrowsException_WhenElementNameStackIsEmpty() {
        toXmlGenerator._elementNameStack.clear();
        assertThrows(JsonGenerationException.class, () -> {
            toXmlGenerator._handleEndObject();
        });
    }

    @Test
    public void testHandleEndObject_CallsWriteEndElement_WhenElementNameStackIsNotEmpty() throws XMLStreamException, IOException {
        toXmlGenerator._elementNameStack.push(new QName("testElement"));
        toXmlGenerator._handleEndObject();
        verify(xmlWriter, times(1)).writeEndElement();
    }

    @Test
    public void testHandleEndObject_InvokesWritePrologLinefeed_WhenStackIsEmptyAndPrettyPrinterIsNotNull() throws XMLStreamException, IOException {
        toXmlGenerator._xmlPrettyPrinter = mock(XmlPrettyPrinter.class);
        toXmlGenerator._elementNameStack.push(new QName("testElement"));
        toXmlGenerator._handleEndObject();
        verify(xmlWriter, times(1)).writeEndElement();
        verify(toXmlGenerator._xmlPrettyPrinter, times(1)).writePrologLinefeed(xmlWriter);
    }
}

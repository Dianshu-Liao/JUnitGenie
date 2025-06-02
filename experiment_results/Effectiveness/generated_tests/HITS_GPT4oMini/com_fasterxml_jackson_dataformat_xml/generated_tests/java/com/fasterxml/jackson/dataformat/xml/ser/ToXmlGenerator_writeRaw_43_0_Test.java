package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.codehaus.stax2.XMLStreamWriter2;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
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
import javax.xml.namespace.QName;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class ToXmlGenerator_writeRaw_43_0_Test {

    private ToXmlGenerator toXmlGenerator;

    private XMLStreamWriter2 xmlWriter;

    private ObjectCodec codec;

    private IOContext context;

    private XmlNameProcessor nameProcessor;

    @BeforeEach
    public void setUp() {
        xmlWriter = mock(XMLStreamWriter2.class);
        codec = mock(ObjectCodec.class);
        context = mock(IOContext.class);
        nameProcessor = mock(XmlNameProcessor.class);
        toXmlGenerator = new ToXmlGenerator(context, 0, 0, codec, xmlWriter, nameProcessor);
    }

    @Test
    public void testWriteRaw_ValidInput() throws XMLStreamException, IOException {
        String text = "Hello, World!";
        int offset = 0;
        int length = text.length();
        toXmlGenerator.writeRaw(text, offset, length);
        verify(xmlWriter).writeRaw(text, offset, length);
    }

    @Test
    public void testWriteRaw_ThrowsXMLStreamException() throws XMLStreamException {
        String text = "Hello, World!";
        int offset = 0;
        int length = text.length();
        doThrow(new XMLStreamException("Stream exception")).when(xmlWriter).writeRaw(text, offset, length);
        Exception exception = assertThrows(JsonGenerationException.class, () -> {
            toXmlGenerator.writeRaw(text, offset, length);
        });
        String expectedMessage = "Stream exception";
        String actualMessage = exception.getCause().getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testWriteRaw_Stax2Emulation() throws XMLStreamException {
        String text = "Hello, World!";
        int offset = 0;
        int length = text.length();
        // Set _stax2Emulation to true
        toXmlGenerator.setNextIsAttribute(true);
        Exception exception = assertThrows(JsonGenerationException.class, () -> {
            toXmlGenerator.writeRaw(text, offset, length);
        });
        String expectedMessage = "Underlying Stax XMLStreamWriter";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}

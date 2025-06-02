package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.codehaus.stax2.XMLStreamWriter2;
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
import javax.xml.namespace.QName;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;

public class ToXmlGenerator_writeRaw_44_0_Test {

    private XMLStreamWriter2 mockXmlWriter;

    private ToXmlGenerator toXmlGenerator;

    @BeforeEach
    public void setUp() {
        mockXmlWriter = mock(XMLStreamWriter2.class);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, mockXmlWriter, null);
    }

    @Test
    public void testWriteRawSuccessfully() throws XMLStreamException, IOException {
        char[] text = "Hello".toCharArray();
        int offset = 0;
        int len = text.length;
        toXmlGenerator.writeRaw(text, offset, len);
        verify(mockXmlWriter).writeRaw(text, offset, len);
    }

    @Test
    public void testWriteRawThrowsXMLStreamException() throws XMLStreamException {
        char[] text = "Hello".toCharArray();
        int offset = 0;
        int len = text.length;
        doThrow(new XMLStreamException("XMLStreamException occurred")).when(mockXmlWriter).writeRaw(text, offset, len);
        Exception exception = assertThrows(JsonGenerationException.class, () -> {
            toXmlGenerator.writeRaw(text, offset, len);
        });
        assertTrue(exception.getMessage().contains("XMLStreamException occurred"));
    }

    @Test
    public void testWriteRawWithStax2Emulation() throws XMLStreamException {
        // Set up the generator to use Stax2 emulation
        ToXmlGenerator generatorWithEmulation = new ToXmlGenerator(null, 0, 0, null, mockXmlWriter, null);
        generatorWithEmulation.setNextIsAttribute(true);
        char[] text = "Hello".toCharArray();
        int offset = 0;
        int len = text.length;
        Exception exception = assertThrows(JsonGenerationException.class, () -> {
            generatorWithEmulation.writeRaw(text, offset, len);
        });
        assertTrue(exception.getMessage().contains("Underlying Stax XMLStreamWriter"));
    }
}

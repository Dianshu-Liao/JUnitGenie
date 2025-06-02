package com.fasterxml.jackson.dataformat.xml.ser;

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
import javax.xml.namespace.QName;
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

class ToXmlGenerator_writeNumber_59_1_Test {

    private ToXmlGenerator toXmlGenerator;

    private XMLStreamWriter xmlStreamWriter;

    private XmlNameProcessor nameProcessor;

    @BeforeEach
    void setUp() {
        xmlStreamWriter = Mockito.mock(XMLStreamWriter.class);
        nameProcessor = Mockito.mock(XmlNameProcessor.class);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, xmlStreamWriter, nameProcessor);
    }

    @Test
    void testWriteNumber() throws IOException, XMLStreamException {
        String encodedValue = "123";
        // Mocking the writeString method which is called within writeNumber
        doNothing().when(xmlStreamWriter).writeCharacters(encodedValue);
        // Invoke the focal method
        toXmlGenerator.writeNumber(encodedValue);
        // Verify that writeString (writeCharacters in this case) was called with the correct argument
        verify(xmlStreamWriter, times(1)).writeCharacters(encodedValue);
    }

    @Test
    void testWriteNumberThrowsIOException() throws IOException, XMLStreamException {
        String encodedValue = "123";
        // Mocking the writeString method to throw IOException
        doThrow(new IOException("Write error")).when(xmlStreamWriter).writeCharacters(encodedValue);
        // Assert that IOException is thrown when writeNumber is called
        assertThrows(IOException.class, () -> toXmlGenerator.writeNumber(encodedValue));
    }

    @Test
    void testWriteNumberWithNullValue() throws IOException, XMLStreamException {
        String encodedValue = null;
        // Mocking the writeString method to handle null value
        doNothing().when(xmlStreamWriter).writeCharacters(encodedValue);
        // Invoke the focal method
        toXmlGenerator.writeNumber(encodedValue);
        // Verify that writeString (writeCharacters in this case) was called with null
        verify(xmlStreamWriter, times(1)).writeCharacters(encodedValue);
    }
}

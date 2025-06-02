package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class ToXmlGenerator_writeRaw_45_0_Test {

    private XMLStreamWriter mockXmlWriter;

    private ToXmlGenerator toXmlGenerator;

    @BeforeEach
    public void setUp() throws Exception {
        mockXmlWriter = Mockito.mock(XMLStreamWriter.class);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, mockXmlWriter, null);
    }

    @Test
    public void testWriteRaw_ValidCharacter() throws IOException, XMLStreamException {
        char inputChar = 'A';
        toXmlGenerator.writeRaw(inputChar);
        verify(mockXmlWriter, times(1)).writeCharacters("A");
    }

    @Test
    public void testWriteRaw_ValidCharacter_B() throws IOException, XMLStreamException {
        char inputChar = 'B';
        toXmlGenerator.writeRaw(inputChar);
        verify(mockXmlWriter, times(1)).writeCharacters("B");
    }

    @Test
    public void testWriteRaw_ThrowsIOException() throws IOException, XMLStreamException {
        char inputChar = 'C';
        doThrow(new XMLStreamException("XML Error")).when(mockXmlWriter).writeCharacters("C");
        IOException thrown = assertThrows(IOException.class, () -> {
            toXmlGenerator.writeRaw(inputChar);
        });
        verify(mockXmlWriter, times(1)).writeCharacters("C");
        assertEquals("XML Error", thrown.getCause().getMessage());
    }

    @Test
    public void testWriteRaw_EmptyCharacter() throws IOException, XMLStreamException {
        // Null character
        char inputChar = '\u0000';
        toXmlGenerator.writeRaw(inputChar);
        verify(mockXmlWriter, times(1)).writeCharacters("\u0000");
    }
}

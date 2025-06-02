package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.codehaus.stax2.XMLStreamWriter2;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamWriter;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class ToXmlGenerator_writeRaw_45_1_Test {

    private XMLStreamWriter2 mockXmlWriter;

    private ToXmlGenerator toXmlGenerator;

    @BeforeEach
    public void setUp() throws Exception {
        mockXmlWriter = mock(XMLStreamWriter2.class);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, mockXmlWriter, null);
    }

    @Test
    public void testWriteRaw_singleCharacter() throws Exception {
        char inputChar = 'A';
        String expectedOutput = String.valueOf(inputChar);
        toXmlGenerator.writeRaw(inputChar);
        verify(mockXmlWriter, times(1)).writeRaw(expectedOutput);
    }

    @Test
    public void testWriteRaw_specialCharacter() throws Exception {
        char inputChar = '&';
        String expectedOutput = String.valueOf(inputChar);
        toXmlGenerator.writeRaw(inputChar);
        verify(mockXmlWriter, times(1)).writeRaw(expectedOutput);
    }

    @Test
    public void testWriteRaw_numericCharacter() throws Exception {
        char inputChar = '1';
        String expectedOutput = String.valueOf(inputChar);
        toXmlGenerator.writeRaw(inputChar);
        verify(mockXmlWriter, times(1)).writeRaw(expectedOutput);
    }

    @Test
    public void testWriteRaw_emptyCharacter() throws Exception {
        // null character
        char inputChar = '\0';
        String expectedOutput = String.valueOf(inputChar);
        toXmlGenerator.writeRaw(inputChar);
        verify(mockXmlWriter, times(1)).writeRaw(expectedOutput);
    }

    @Test
    public void testWriteRaw_throwsXMLStreamException() throws Exception {
        char inputChar = 'B';
        String expectedOutput = String.valueOf(inputChar);
        doThrow(new XMLStreamException("Test Exception")).when(mockXmlWriter).writeRaw(expectedOutput);
        Exception exception = null;
        try {
            toXmlGenerator.writeRaw(inputChar);
        } catch (Exception e) {
            exception = e;
        }
        verify(mockXmlWriter, times(1)).writeRaw(expectedOutput);
        assertTrue(exception instanceof XMLStreamException);
    }
}

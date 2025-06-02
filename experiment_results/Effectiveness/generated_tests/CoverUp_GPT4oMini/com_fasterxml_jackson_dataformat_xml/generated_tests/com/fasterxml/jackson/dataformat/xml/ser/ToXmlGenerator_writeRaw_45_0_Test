package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
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
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class ToXmlGenerator_writeRaw_45_0_Test {

    private ToXmlGenerator generator;

    private XMLStreamWriter2 xmlWriterMock;

    private IOContext ioContextMock;

    private XmlNameProcessor nameProcessorMock;

    @BeforeEach
    public void setUp() throws Exception {
        StringWriter stringWriter = new StringWriter();
        xmlWriterMock = mock(XMLStreamWriter2.class);
        ioContextMock = mock(IOContext.class);
        nameProcessorMock = mock(XmlNameProcessor.class);
        when(ioContextMock.streamWriteConstraints()).thenReturn(null);
        generator = new ToXmlGenerator(ioContextMock, 0, 0, null, xmlWriterMock, nameProcessorMock);
    }

    @Test
    public void testWriteRawSingleCharacter() throws Exception {
        char inputChar = 'a';
        generator.writeRaw(inputChar);
        verify(xmlWriterMock).writeRaw("a");
    }

    @Test
    public void testWriteRawThrowsXMLStreamException() throws Exception {
        char inputChar = 'b';
        doThrow(new XMLStreamException("Test Exception")).when(xmlWriterMock).writeRaw("b");
        Exception exception = assertThrows(IOException.class, () -> {
            generator.writeRaw(inputChar);
        });
        assertEquals("Test Exception", exception.getMessage());
    }

    @Test
    public void testWriteRawMultipleCharacters() throws Exception {
        char inputChar = 'c';
        generator.writeRaw(inputChar);
        verify(xmlWriterMock).writeRaw("c");
    }

    @Test
    public void testWriteRawHandlesEmptyCharacter() throws Exception {
        // Null character
        char inputChar = '\0';
        generator.writeRaw(inputChar);
        verify(xmlWriterMock).writeRaw("\0");
    }
}

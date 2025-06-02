package com.fasterxml.jackson.dataformat.xml.util;

import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

class DefaultXmlPrettyPrinter_writeStartObject_10_0_Test {

    private DefaultXmlPrettyPrinter printer;

    private ToXmlGenerator jsonGenerator;

    @BeforeEach
    void setUp() {
        printer = new DefaultXmlPrettyPrinter();
        jsonGenerator = Mockito.mock(ToXmlGenerator.class);
    }

    @Test
    void testWriteStartObjectWithNestingZero() throws IOException {
        when(jsonGenerator.getStaxWriter()).thenReturn(mock(XMLStreamWriter2.class));
        // Act
        printer.writeStartObject(jsonGenerator);
        // Assert
        verify(jsonGenerator).writeStartObject();
        assertTrue(printer._justHadStartElement);
        assertEquals(1, printer._nesting);
    }

    @Test
    void testWriteStartObjectWithNestingGreaterThanZero() throws IOException {
        when(jsonGenerator.getStaxWriter()).thenReturn(mock(XMLStreamWriter2.class));
        // Simulate nesting > 0
        printer._nesting = 1;
        // Act
        printer.writeStartObject(jsonGenerator);
        // Assert
        verify(jsonGenerator).writeStartObject();
        assertTrue(printer._justHadStartElement);
        assertEquals(2, printer._nesting);
    }

    @Test
    void testWriteStartObjectWithInline() throws IOException {
        when(jsonGenerator.getStaxWriter()).thenReturn(mock(XMLStreamWriter2.class));
        // Act
        printer.writeStartObject(jsonGenerator);
        // Assert
        verify(jsonGenerator).writeStartObject();
        assertTrue(printer._justHadStartElement);
        assertEquals(1, printer._nesting);
    }
}

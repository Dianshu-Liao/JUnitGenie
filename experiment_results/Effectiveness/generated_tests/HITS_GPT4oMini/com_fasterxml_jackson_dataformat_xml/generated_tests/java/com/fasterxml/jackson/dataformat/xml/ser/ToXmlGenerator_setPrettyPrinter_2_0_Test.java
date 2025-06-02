package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
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
import javax.xml.stream.XMLStreamException;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class ToXmlGenerator_setPrettyPrinter_2_0_Test {

    private ToXmlGenerator toXmlGenerator;

    private IOContext ioContext;

    private XMLStreamWriter xmlStreamWriter;

    private XmlNameProcessor xmlNameProcessor;

    @BeforeEach
    public void setUp() {
        // Create mock objects for the constructor parameters
        ioContext = mock(IOContext.class);
        xmlStreamWriter = mock(XMLStreamWriter.class);
        xmlNameProcessor = mock(XmlNameProcessor.class);
        // Initialize the ToXmlGenerator with the required parameters
        toXmlGenerator = new ToXmlGenerator(ioContext, 0, 0, null, xmlStreamWriter, xmlNameProcessor);
    }

    @Test
    public void testSetPrettyPrinter_WithXmlPrettyPrinter() {
        // Arrange
        // Use a concrete implementation
        XmlPrettyPrinter prettyPrinter = new DefaultXmlPrettyPrinter();
        // Act
        toXmlGenerator.setPrettyPrinter(prettyPrinter);
        // Assert
        assertEquals(prettyPrinter, toXmlGenerator._xmlPrettyPrinter, "The pretty printer should be set correctly.");
    }

    @Test
    public void testSetPrettyPrinter_WithNonXmlPrettyPrinter() {
        // Arrange
        DefaultXmlPrettyPrinter prettyPrinter = new DefaultXmlPrettyPrinter();
        // Act
        toXmlGenerator.setPrettyPrinter(prettyPrinter);
        // Assert
        assertNull(toXmlGenerator._xmlPrettyPrinter, "The pretty printer should be null for non-XmlPrettyPrinter instances.");
    }
}

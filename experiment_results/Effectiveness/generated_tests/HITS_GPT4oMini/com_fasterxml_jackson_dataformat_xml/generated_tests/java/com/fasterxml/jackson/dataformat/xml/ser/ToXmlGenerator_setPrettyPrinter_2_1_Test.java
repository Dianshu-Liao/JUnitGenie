package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
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
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

@ExtendWith(MockitoExtension.class)
public class ToXmlGenerator_setPrettyPrinter_2_1_Test {

    private ToXmlGenerator toXmlGenerator;

    @Mock
    private XMLStreamWriter2 xmlStreamWriter;

    @Mock
    private IOContext ioContext;

    @Mock
    private ObjectCodec objectCodec;

    @Mock
    private XmlNameProcessor xmlNameProcessor;

    @BeforeEach
    public void setUp() {
        // Initialize the ToXmlGenerator with mock parameters
        this.toXmlGenerator = new ToXmlGenerator(ioContext, 0, 0, objectCodec, xmlStreamWriter, xmlNameProcessor);
    }

    @Test
    public void testSetPrettyPrinter_WithXmlPrettyPrinter() {
        XmlPrettyPrinter prettyPrinter = Mockito.mock(XmlPrettyPrinter.class);
        toXmlGenerator.setPrettyPrinter(prettyPrinter);
        // Assert that the pretty printer is set correctly
        assertEquals(prettyPrinter, toXmlGenerator._xmlPrettyPrinter);
    }

    @Test
    public void testSetPrettyPrinter_WithNonXmlPrettyPrinter() {
        DefaultXmlPrettyPrinter prettyPrinter = new DefaultXmlPrettyPrinter();
        toXmlGenerator.setPrettyPrinter(prettyPrinter);
        // Assert that the pretty printer is set to null since it's not an instance of XmlPrettyPrinter
        assertNull(toXmlGenerator._xmlPrettyPrinter);
    }

    @Test
    public void testSetPrettyPrinter_WithNull() {
        toXmlGenerator.setPrettyPrinter(null);
        // Assert that the pretty printer is set to null
        assertNull(toXmlGenerator._xmlPrettyPrinter);
    }

    @Test
    public void testSetPrettyPrinter_InitialState() {
        // Assert that the initial state of _xmlPrettyPrinter is null
        assertNull(toXmlGenerator._xmlPrettyPrinter);
    }
}

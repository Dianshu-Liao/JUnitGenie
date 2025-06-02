package com.fasterxml.jackson.dataformat.xml.ser;

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
import javax.xml.stream.XMLStreamException;
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

public class ToXmlGenerator_setPrettyPrinter_2_0_Test {

    private ToXmlGenerator toXmlGenerator;

    private XMLStreamWriter xmlWriter;

    private XmlNameProcessor nameProcessor;

    @BeforeEach
    public void setUp() {
        xmlWriter = Mockito.mock(XMLStreamWriter.class);
        nameProcessor = Mockito.mock(XmlNameProcessor.class);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, xmlWriter, nameProcessor);
    }

    @Test
    public void testSetPrettyPrinter_NullPrettyPrinter() {
        PrettyPrinter prettyPrinter = null;
        JsonGenerator result = toXmlGenerator.setPrettyPrinter(prettyPrinter);
        assertSame(toXmlGenerator, result);
        assertNull(toXmlGenerator._xmlPrettyPrinter);
    }

    @Test
    public void testSetPrettyPrinter_XmlPrettyPrinter() {
        PrettyPrinter prettyPrinter = Mockito.mock(XmlPrettyPrinter.class);
        JsonGenerator result = toXmlGenerator.setPrettyPrinter(prettyPrinter);
        assertSame(toXmlGenerator, result);
        assertNotNull(toXmlGenerator._xmlPrettyPrinter);
        assertEquals(prettyPrinter, toXmlGenerator._xmlPrettyPrinter);
    }

    @Test
    public void testSetPrettyPrinter_RegularPrettyPrinter() {
        PrettyPrinter prettyPrinter = Mockito.mock(PrettyPrinter.class);
        JsonGenerator result = toXmlGenerator.setPrettyPrinter(prettyPrinter);
        assertSame(toXmlGenerator, result);
        assertNull(toXmlGenerator._xmlPrettyPrinter);
    }
}

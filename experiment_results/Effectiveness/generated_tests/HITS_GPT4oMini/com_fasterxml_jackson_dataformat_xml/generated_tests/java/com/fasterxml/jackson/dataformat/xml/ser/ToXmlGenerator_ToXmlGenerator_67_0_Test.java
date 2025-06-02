package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamWriter;
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
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class ToXmlGenerator_ToXmlGenerator_67_0_Test {

    private IOContext ioContext;

    private int stdFeatures;

    private int xmlFeatures;

    private ObjectCodec codec;

    private XMLStreamWriter xmlStreamWriter;

    private XmlNameProcessor nameProcessor;

    @BeforeEach
    public void setUp() {
        ioContext = Mockito.mock(IOContext.class);
        // Default features
        stdFeatures = 0;
        // Default xml features
        xmlFeatures = 0;
        codec = Mockito.mock(ObjectCodec.class);
        xmlStreamWriter = Mockito.mock(XMLStreamWriter.class);
        nameProcessor = Mockito.mock(XmlNameProcessor.class);
    }

    @Test
    public void testConstructorInitialization() {
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, stdFeatures, xmlFeatures, codec, xmlStreamWriter, nameProcessor);
        assertNotNull(generator);
    }

    @Test
    public void testXmlWriterInitialization() {
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, stdFeatures, xmlFeatures, codec, xmlStreamWriter, nameProcessor);
        assertNotNull(generator._xmlWriter);
        assertEquals(generator._originalXmlWriter, xmlStreamWriter);
    }

    @Test
    public void testStax2Emulation() {
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, stdFeatures, xmlFeatures, codec, xmlStreamWriter, nameProcessor);
        assertFalse(generator._stax2Emulation);
        XMLStreamWriter differentWriter = Mockito.mock(XMLStreamWriter.class);
        ToXmlGenerator generatorWithDifferentWriter = new ToXmlGenerator(ioContext, stdFeatures, xmlFeatures, codec, differentWriter, nameProcessor);
        assertTrue(generatorWithDifferentWriter._stax2Emulation);
    }

    @Test
    public void testXmlPrettyPrinterInitialization() {
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, stdFeatures, xmlFeatures, codec, xmlStreamWriter, nameProcessor);
        assertNull(generator._xmlPrettyPrinter);
    }

    @Test
    public void testFormatFeaturesInitialization() {
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, stdFeatures, xmlFeatures, codec, xmlStreamWriter, nameProcessor);
        assertEquals(stdFeatures, generator._formatFeatures);
    }

    @Test
    public void testNameProcessorInitialization() {
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, stdFeatures, xmlFeatures, codec, xmlStreamWriter, nameProcessor);
        assertEquals(nameProcessor, generator._nameProcessor);
    }

    @Test
    public void testElementNameStackInitialization() {
        ToXmlGenerator generator = new ToXmlGenerator(ioContext, stdFeatures, xmlFeatures, codec, xmlStreamWriter, nameProcessor);
        assertNotNull(generator._elementNameStack);
        assertTrue(generator._elementNameStack.isEmpty());
    }
}

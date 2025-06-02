package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import javax.xml.namespace.QName;
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
import javax.xml.stream.XMLStreamException;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

class ToXmlGenerator_ToXmlGenerator_67_1_Test {

    private IOContext ioContext;

    private int stdFeatures;

    private int xmlFeatures;

    private ObjectCodec codec;

    private XMLStreamWriter xmlStreamWriter;

    private XmlNameProcessor nameProcessor;

    private ToXmlGenerator toXmlGenerator;

    @BeforeEach
    void setUp() {
        ioContext = mock(IOContext.class);
        stdFeatures = 0;
        xmlFeatures = 0;
        codec = mock(ObjectCodec.class);
        StringWriter stringWriter = new StringWriter();
        xmlStreamWriter = mock(XMLStreamWriter.class);
        nameProcessor = mock(XmlNameProcessor.class);
        toXmlGenerator = new ToXmlGenerator(ioContext, stdFeatures, xmlFeatures, codec, xmlStreamWriter, nameProcessor);
    }

    @Test
    void testConstructor() {
        assertNotNull(toXmlGenerator);
        assertEquals(xmlStreamWriter, toXmlGenerator.getStaxWriter());
        assertEquals(ioContext.streamWriteConstraints(), toXmlGenerator.getWriteCapabilities());
    }

    @Test
    void testSetNextIsAttribute() {
        toXmlGenerator.setNextIsAttribute(true);
        assertTrue(toXmlGenerator.setNextNameIfMissing(new QName("test")));
        assertFalse(toXmlGenerator.setNextNameIfMissing(new QName("test2")));
    }

    @Test
    void testSetNextIsUnwrapped() {
        toXmlGenerator.setNextIsUnwrapped(true);
        assertTrue(toXmlGenerator.setNextNameIfMissing(new QName("test")));
    }

    @Test
    void testSetNextIsCData() {
        toXmlGenerator.setNextIsCData(true);
        assertTrue(toXmlGenerator.setNextNameIfMissing(new QName("test")));
    }

    @Test
    void testSetNextName() {
        QName name = new QName("test");
        toXmlGenerator.setNextName(name);
        assertEquals(name, toXmlGenerator._nextName);
    }

    @Test
    void testSetNextNameIfMissing() {
        QName name1 = new QName("test1");
        QName name2 = new QName("test2");
        assertTrue(toXmlGenerator.setNextNameIfMissing(name1));
        assertFalse(toXmlGenerator.setNextNameIfMissing(name2));
        assertEquals(name1, toXmlGenerator._nextName);
    }
}

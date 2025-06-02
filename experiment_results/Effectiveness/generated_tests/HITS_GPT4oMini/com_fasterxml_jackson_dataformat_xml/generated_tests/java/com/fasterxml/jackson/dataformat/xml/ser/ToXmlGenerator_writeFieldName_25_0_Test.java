package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.*;

public class ToXmlGenerator_writeFieldName_25_0_Test {

    private ToXmlGenerator toXmlGenerator;

    private XMLStreamWriter xmlStreamWriter;

    // Subclass to expose protected members for testing
    private class TestableToXmlGenerator extends ToXmlGenerator {

        public TestableToXmlGenerator(IOContext ctxt, int stdFeatures, int xmlFeatures, ObjectCodec codec, XMLStreamWriter sw, XmlNameProcessor nameProcessor) {
            super(ctxt, stdFeatures, xmlFeatures, codec, sw, nameProcessor);
        }

        public void setWriteContext(JsonWriteContext context) {
            this._writeContext = context;
        }
    }

    @BeforeEach
    public void setUp() throws Exception {
        xmlStreamWriter = mock(XMLStreamWriter.class);
        toXmlGenerator = new TestableToXmlGenerator(null, 0, 0, null, xmlStreamWriter, null);
    }

    @Test
    public void testWriteFieldName_ValidName() throws Exception {
        String fieldName = "testField";
        toXmlGenerator.writeFieldName(fieldName);
        assertNotNull(toXmlGenerator._nextName);
        assertEquals(fieldName, toXmlGenerator._nextName.getLocalPart());
    }

    @Test
    public void testWriteFieldName_XsiType() throws Exception {
        toXmlGenerator._formatFeatures = ToXmlGenerator.Feature.AUTO_DETECT_XSI_TYPE.getMask();
        String fieldName = "xsi:type";
        toXmlGenerator.writeFieldName(fieldName);
        assertTrue(toXmlGenerator._nextIsAttribute);
        assertEquals(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, toXmlGenerator._nextName.getNamespaceURI());
        assertEquals("type", toXmlGenerator._nextName.getLocalPart());
    }
}

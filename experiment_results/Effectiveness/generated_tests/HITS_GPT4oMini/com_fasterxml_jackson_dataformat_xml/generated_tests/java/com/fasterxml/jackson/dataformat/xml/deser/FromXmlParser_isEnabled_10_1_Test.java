package com.fasterxml.jackson.dataformat.xml.deser;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import javax.xml.stream.XMLStreamReader;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.PackageVersion;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

@ExtendWith(MockitoExtension.class)
public class FromXmlParser_isEnabled_10_1_Test {

    private FromXmlParser parser;

    @Mock
    private IOContext ioContext;

    @Mock
    private ObjectCodec objectCodec;

    @Mock
    private XMLStreamReader xmlStreamReader;

    @Mock
    private XmlNameProcessor xmlNameProcessor;

    @BeforeEach
    public void setUp() throws IOException {
        // Assuming default values for the ints required by the constructor
        parser = new FromXmlParser(ioContext, 0, 0, objectCodec, xmlStreamReader, xmlNameProcessor);
    }

    @Test
    public void testIsEnabledFeatureEnabled() {
        // Set the feature to enabled
        parser._formatFeatures |= FromXmlParser.Feature.PROCESS_XSI_NIL.getMask();
        assertTrue(parser.isEnabled(FromXmlParser.Feature.PROCESS_XSI_NIL), "Feature PROCESS_XSI_NIL should be enabled");
    }

    @Test
    public void testIsEnabledFeatureDisabled() {
        // Ensure feature is not enabled
        parser._formatFeatures &= ~FromXmlParser.Feature.PROCESS_XSI_NIL.getMask();
        assertFalse(parser.isEnabled(FromXmlParser.Feature.PROCESS_XSI_NIL), "Feature PROCESS_XSI_NIL should be disabled");
    }

    @Test
    public void testIsEnabledMultipleFeatures() {
        // Enable multiple features
        parser._formatFeatures |= FromXmlParser.Feature.AUTO_DETECT_XSI_TYPE.getMask();
        parser._formatFeatures |= FromXmlParser.Feature.PROCESS_XSI_NIL.getMask();
        assertTrue(parser.isEnabled(FromXmlParser.Feature.AUTO_DETECT_XSI_TYPE), "Feature AUTO_DETECT_XSI_TYPE should be enabled");
        assertTrue(parser.isEnabled(FromXmlParser.Feature.PROCESS_XSI_NIL), "Feature PROCESS_XSI_NIL should be enabled");
    }

    @Test
    public void testIsEnabledFeatureNotSet() {
        // Ensure a feature that is not set returns false
        assertFalse(parser.isEnabled(FromXmlParser.Feature.EMPTY_ELEMENT_AS_NULL), "Feature EMPTY_ELEMENT_AS_NULL should be disabled");
    }
}

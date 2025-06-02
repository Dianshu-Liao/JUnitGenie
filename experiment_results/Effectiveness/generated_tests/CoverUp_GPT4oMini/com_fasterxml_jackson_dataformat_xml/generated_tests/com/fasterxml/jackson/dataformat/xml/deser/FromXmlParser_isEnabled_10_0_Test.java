package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext;
import com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream;
import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamReader;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.lang.reflect.Method;
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
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.PackageVersion;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class FromXmlParser_isEnabled_10_0_Test {

    private FromXmlParser parser;

    private IOContext ioContext;

    private ObjectCodec codec;

    private XMLStreamReader xmlReader;

    private XmlTokenStream xmlTokenStream;

    @BeforeEach
    public void setUp() throws Exception {
        ioContext = mock(IOContext.class);
        codec = mock(ObjectCodec.class);
        xmlReader = mock(XMLStreamReader.class);
        xmlTokenStream = mock(XmlTokenStream.class);
        parser = new FromXmlParser(ioContext, 0, 0, codec, xmlReader, null);
    }

    @Test
    public void testIsEnabledFeatureEnabled() throws Exception {
        setFormatFeatures(1);
        assertTrue(parser.isEnabled(FromXmlParser.Feature.PROCESS_XSI_NIL));
    }

    @Test
    public void testIsEnabledFeatureDisabled() throws Exception {
        setFormatFeatures(0);
        assertFalse(parser.isEnabled(FromXmlParser.Feature.PROCESS_XSI_NIL));
    }

    @Test
    public void testIsEnabledWithDifferentFeature() throws Exception {
        setFormatFeatures(2);
        assertTrue(parser.isEnabled(FromXmlParser.Feature.AUTO_DETECT_XSI_TYPE));
        assertFalse(parser.isEnabled(FromXmlParser.Feature.PROCESS_XSI_NIL));
    }

    @Test
    public void testIsEnabledWithNoFeaturesSet() throws Exception {
        setFormatFeatures(0);
        assertFalse(parser.isEnabled(FromXmlParser.Feature.AUTO_DETECT_XSI_TYPE));
        assertFalse(parser.isEnabled(FromXmlParser.Feature.PROCESS_XSI_NIL));
    }

    @Test
    public void testIsEnabledWithMultipleFeatures() throws Exception {
        int featureMask = FromXmlParser.Feature.PROCESS_XSI_NIL.getMask() | FromXmlParser.Feature.AUTO_DETECT_XSI_TYPE.getMask();
        setFormatFeatures(featureMask);
        assertTrue(parser.isEnabled(FromXmlParser.Feature.PROCESS_XSI_NIL));
        assertTrue(parser.isEnabled(FromXmlParser.Feature.AUTO_DETECT_XSI_TYPE));
    }

    private void setFormatFeatures(int featureMask) throws Exception {
        Method method = FromXmlParser.class.getDeclaredMethod("setFormatFeatures", int.class);
        method.setAccessible(true);
        method.invoke(parser, featureMask);
    }
}

package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

class FromXmlParser_addVirtualWrapping_15_0_Test {

    private FromXmlParser parser;

    private XmlReadContext context;

    private XmlTokenStream xmlTokenStream;

    @BeforeEach
    void setUp() throws Exception {
        // Mocking dependencies
        XMLStreamReader xmlReader = mock(XMLStreamReader.class);
        ObjectCodec codec = mock(ObjectCodec.class);
        context = new XmlReadContext(null, 0, 0, 0, 0);
        xmlTokenStream = new XmlTokenStream(xmlReader, null, 0, null);
        parser = new FromXmlParser(null, 0, 0, codec, xmlReader, null);
        setField(parser, "_parsingContext", context);
        setField(parser, "_xmlTokens", xmlTokenStream);
    }

    private void setField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    @Test
    void testAddVirtualWrapping_CaseSensitive() {
        Set<String> namesToWrap = new HashSet<>();
        namesToWrap.add("name");
        parser.addVirtualWrapping(namesToWrap, false);
        assertEquals(namesToWrap, parser.getParsingContext()._namesToWrap);
    }

    @Test
    void testAddVirtualWrapping_CaseInsensitive() {
        Set<String> namesToWrap = new HashSet<>();
        namesToWrap.add("NAME");
        parser.addVirtualWrapping(namesToWrap, true);
        assertEquals(namesToWrap, parser.getParsingContext()._namesToWrap);
        assertTrue(parser.getParsingContext()._namesToWrap instanceof CaseInsensitiveNameSet);
    }

    @Test
    void testAddVirtualWrapping_RepeatStartElement() throws Exception {
        Set<String> namesToWrap = new HashSet<>();
        namesToWrap.add("name");
        // Simulate the current local name as "name"
        when(xmlTokenStream.getLocalName()).thenReturn("name");
        context.setNamesToWrap(namesToWrap);
        parser.addVirtualWrapping(namesToWrap, false);
        assertEquals(namesToWrap, parser.getParsingContext()._namesToWrap);
    }

    @Test
    void testAddVirtualWrapping_NoRepeatStartElement() throws Exception {
        Set<String> namesToWrap = new HashSet<>();
        namesToWrap.add("name");
        // Simulate a different local name
        when(xmlTokenStream.getLocalName()).thenReturn("otherName");
        context.setNamesToWrap(namesToWrap);
        parser.addVirtualWrapping(namesToWrap, false);
        assertEquals(namesToWrap, parser.getParsingContext()._namesToWrap);
    }
}

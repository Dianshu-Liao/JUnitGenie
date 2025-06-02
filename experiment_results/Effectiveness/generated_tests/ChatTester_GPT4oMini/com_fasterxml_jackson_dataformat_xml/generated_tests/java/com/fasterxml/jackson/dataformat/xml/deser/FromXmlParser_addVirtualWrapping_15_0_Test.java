package com.fasterxml.jackson.dataformat.xml.deser;

import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
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
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class FromXmlParser_addVirtualWrapping_15_0_Test {

    private FromXmlParser parser;

    private IOContext ioContext;

    private XMLStreamReader xmlReader;

    private XmlTokenStream xmlTokenStream;

    private XmlReadContext parsingContext;

    private XmlNameProcessor tagProcessor;

    @BeforeEach
    public void setUp() throws IOException {
        ioContext = mock(IOContext.class);
        xmlReader = mock(XMLStreamReader.class);
        xmlTokenStream = mock(XmlTokenStream.class);
        parsingContext = mock(XmlReadContext.class);
        tagProcessor = mock(XmlNameProcessor.class);
        parser = new FromXmlParser(ioContext, 0, 0, null, xmlReader, tagProcessor);
        // Set up the mock context
        when(parser._parsingContext).thenReturn(parsingContext);
        when(parser._xmlTokens).thenReturn(xmlTokenStream);
    }

    @Test
    public void testAddVirtualWrapping_caseInsensitive() {
        Set<String> namesToWrap = new HashSet<>();
        namesToWrap.add("exampleName");
        when(parsingContext.inRoot()).thenReturn(false);
        when(parsingContext.getParent()).thenReturn(mock(XmlReadContext.class));
        when(parsingContext.getParent().inRoot()).thenReturn(false);
        when(xmlTokenStream.getLocalName()).thenReturn("exampleName");
        parser.addVirtualWrapping(namesToWrap, true);
        verify(parsingContext).setNamesToWrap(anySet());
        verify(xmlTokenStream).repeatStartElement();
    }

    @Test
    public void testAddVirtualWrapping_notCaseInsensitive() {
        Set<String> namesToWrap = new HashSet<>();
        namesToWrap.add("exampleName");
        when(parsingContext.inRoot()).thenReturn(false);
        when(parsingContext.getParent()).thenReturn(mock(XmlReadContext.class));
        when(parsingContext.getParent().inRoot()).thenReturn(false);
        when(xmlTokenStream.getLocalName()).thenReturn("exampleName");
        parser.addVirtualWrapping(namesToWrap, false);
        verify(parsingContext).setNamesToWrap(anySet());
        verify(xmlTokenStream).repeatStartElement();
    }

    @Test
    public void testAddVirtualWrapping_noRepeat() {
        Set<String> namesToWrap = new HashSet<>();
        namesToWrap.add("otherName");
        when(parsingContext.inRoot()).thenReturn(false);
        when(parsingContext.getParent()).thenReturn(mock(XmlReadContext.class));
        when(parsingContext.getParent().inRoot()).thenReturn(false);
        when(xmlTokenStream.getLocalName()).thenReturn("exampleName");
        parser.addVirtualWrapping(namesToWrap, true);
        verify(parsingContext).setNamesToWrap(anySet());
        verify(xmlTokenStream, never()).repeatStartElement();
    }

    @Test
    public void testAddVirtualWrapping_inRoot() {
        Set<String> namesToWrap = new HashSet<>();
        namesToWrap.add("exampleName");
        when(parsingContext.inRoot()).thenReturn(true);
        parser.addVirtualWrapping(namesToWrap, true);
        verify(parsingContext).setNamesToWrap(anySet());
        verify(xmlTokenStream, never()).repeatStartElement();
    }
}

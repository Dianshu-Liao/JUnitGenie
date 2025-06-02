package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import javax.xml.stream.*;
import org.codehaus.stax2.XMLInputFactory2;
import org.codehaus.stax2.io.Stax2ByteArraySource;
import org.codehaus.stax2.io.Stax2CharArraySource;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class XmlFactory_createParser_32_1_Test {

    private XmlFactory xmlFactory;

    @BeforeEach
    public void setUp() {
        xmlFactory = new XmlFactory();
    }

    @Test
    public void testCreateParser_ValidXml() throws IOException {
        String xmlContent = "<root><element>value</element></root>";
        JsonParser parser = xmlFactory.createParser((String) xmlContent);
        assertNotNull(parser);
        assertTrue(parser instanceof FromXmlParser);
    }

    @Test
    public void testCreateParser_EmptyXml() throws IOException {
        String xmlContent = "";
        JsonParser parser = xmlFactory.createParser((String) xmlContent);
        assertNotNull(parser);
        assertTrue(parser instanceof FromXmlParser);
    }

    @Test
    public void testCreateParser_NullInput() {
        assertThrows(IOException.class, () -> {
            xmlFactory.createParser((String) null);
        });
    }

    @Test
    public void testCreateParser_InvalidXml() {
        // Missing closing tag
        String invalidXmlContent = "<root><element>value</root>";
        assertThrows(IOException.class, () -> {
            xmlFactory.createParser(invalidXmlContent);
        });
    }

    @Test
    public void testCreateParser_WhitespaceOnly() throws IOException {
        String xmlContent = "   ";
        JsonParser parser = xmlFactory.createParser((String) xmlContent);
        assertNotNull(parser);
        assertTrue(parser instanceof FromXmlParser);
    }

    @Test
    public void testCreateParser_SpecialCharacters() throws IOException {
        String xmlContent = "<root><element>&lt;value&gt;</element></root>";
        JsonParser parser = xmlFactory.createParser((String) xmlContent);
        assertNotNull(parser);
        assertTrue(parser instanceof FromXmlParser);
    }
}

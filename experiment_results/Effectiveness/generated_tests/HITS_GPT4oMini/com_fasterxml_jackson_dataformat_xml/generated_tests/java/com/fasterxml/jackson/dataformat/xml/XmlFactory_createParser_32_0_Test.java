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

public class XmlFactory_createParser_32_0_Test {

    private XmlFactory xmlFactory;

    @BeforeEach
    public void setUp() {
        xmlFactory = new XmlFactory();
    }

    @Test
    public void testCreateParser_ValidXmlContent() throws IOException {
        // Arrange
        String validXml = "<root><element>value</element></root>";
        // Act
        JsonParser parser = xmlFactory.createParser(validXml);
        // Assert
        assertNotNull(parser);
        // Additional assertions to check if the parser works correctly can be added here
    }

    @Test
    public void testCreateParser_EmptyXmlContent() throws IOException {
        // Arrange
        String emptyXml = "";
        // Act
        JsonParser parser = xmlFactory.createParser(emptyXml);
        // Assert
        assertNotNull(parser);
        // Additional assertions to check if the parser can handle empty content can be added here
    }

    @Test
    public void testCreateParser_NullContent() {
        // Arrange
        String nullXml = null;
        // Act & Assert
        assertThrows(IOException.class, () -> {
            xmlFactory.createParser(nullXml);
        });
    }

    @Test
    public void testCreateParser_InvalidXmlContent() {
        // Arrange
        String invalidXml = "<root><element>value</element>";
        // Act & Assert
        assertThrows(IOException.class, () -> {
            xmlFactory.createParser(invalidXml);
        });
    }
}

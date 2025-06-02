package com.fasterxml.jackson.dataformat.xml.util;

import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLOutputFactory;
import java.io.StringWriter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;

public class DefaultXmlPrettyPrinter_writeStartObject_10_0_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private ToXmlGenerator toXmlGenerator;

    private StringWriter stringWriter;

    private XMLStreamWriter xmlStreamWriter;

    @BeforeEach
    public void setUp() throws Exception {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        stringWriter = new StringWriter();
        xmlStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(stringWriter);
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, xmlStreamWriter, null);
    }

    @Test
    public void testWriteStartObject_IncreasesNesting() throws Exception {
        // Initial nesting should be 0
        assertEquals(0, prettyPrinter._nesting);
        // Call the method under test
        prettyPrinter.writeStartObject(toXmlGenerator);
        // After calling, nesting should be 1
        assertEquals(1, prettyPrinter._nesting);
    }

    @Test
    public void testWriteStartObject_CallsHandleStartObject() throws Exception {
        // Mock the ToXmlGenerator to verify _handleStartObject is called
        toXmlGenerator.setNextName(new QName("testNamespace", "testElement"));
        prettyPrinter.writeStartObject(toXmlGenerator);
        // Verify that the output contains the start element
        String output = stringWriter.toString();
        assertTrue(output.contains("<testElement"));
    }

    @Test
    public void testWriteStartObject_IndentationWhenNestingGreaterThanZero() throws Exception {
        // Increase nesting by calling writeStartObject twice
        prettyPrinter.writeStartObject(toXmlGenerator);
        prettyPrinter.writeStartObject(toXmlGenerator);
        // Check output for indentation
        String output = stringWriter.toString();
        assertTrue(output.startsWith("  <testElement"), "Expected indentation for the nested element");
    }

    @Test
    public void testWriteStartObject_JustHadStartElementFlag() throws Exception {
        // Call the method under test
        prettyPrinter.writeStartObject(toXmlGenerator);
        // Check if _justHadStartElement is set to true
        assertTrue(prettyPrinter._justHadStartElement, "_justHadStartElement should be true after writing start object");
    }

    @Test
    public void testWriteStartObject_HandlesMultipleCalls() throws Exception {
        // Call writeStartObject multiple times
        prettyPrinter.writeStartObject(toXmlGenerator);
        prettyPrinter.writeStartObject(toXmlGenerator);
        prettyPrinter.writeStartObject(toXmlGenerator);
        // Ensure nesting is correctly tracked
        assertEquals(3, prettyPrinter._nesting);
    }
}

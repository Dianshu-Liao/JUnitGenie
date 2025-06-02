package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter.Indenter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

public class DefaultXmlPrettyPrinter_writeLeafNullElement_26_4_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = Mockito.mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafNullElement_WithNonInlineIndenter() throws XMLStreamException {
        // Arrange
        prettyPrinter._objectIndenter = new IndenterMock(false);
        String nsURI = "http://example.com/ns";
        String localName = "nullElement";
        // Act
        prettyPrinter.writeLeafNullElement(xmlStreamWriter, nsURI, localName);
        // Assert
        verify(xmlStreamWriter).writeEmptyElement(nsURI, localName);
    }

    @Test
    public void testWriteLeafNullElement_WithInlineIndenter() throws XMLStreamException {
        // Arrange
        prettyPrinter._objectIndenter = new IndenterMock(true);
        String nsURI = "http://example.com/ns";
        String localName = "inlineNullElement";
        // Act
        prettyPrinter.writeLeafNullElement(xmlStreamWriter, nsURI, localName);
        // Assert
        verify(xmlStreamWriter).writeEmptyElement(nsURI, localName);
    }

    @Test
    public void testWriteLeafNullElement_OnlyCallsWriteEmptyElement() throws XMLStreamException {
        // Arrange
        String nsURI = "http://example.com/ns";
        String localName = "anotherNullElement";
        // Act
        prettyPrinter.writeLeafNullElement(xmlStreamWriter, nsURI, localName);
        // Assert
        verify(xmlStreamWriter).writeEmptyElement(nsURI, localName);
    }

    private static class IndenterMock implements Indenter {

        private final boolean inline;

        public IndenterMock(boolean inline) {
            this.inline = inline;
        }

        @Override
        public boolean isInline() {
            return inline;
        }

        @Override
        public void writeIndentation(XMLStreamWriter2 sw, int nesting) throws XMLStreamException {
            if (!inline) {
                sw.writeCharacters("\n  ");
            }
        }

        @Override
        public void writeIndentation(JsonGenerator jg, int nesting) throws IOException {
            // This method is required by the Indenter interface but can be left empty for testing purposes.
        }
    }
}

package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import javax.xml.stream.XMLStreamException;
import static org.mockito.Mockito.*;

public class util_DefaultXmlPrettyPrinter_writeLeafElement_XMLStreamWriter2_String_String_char_____int_int_boolean_cfg_path_4_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;
    private XMLStreamWriter2 xmlStreamWriter;

    @Before
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
    }

    @Test(timeout = 4000)
    public void testWriteLeafElementWithCData() {
        char[] buffer = "test buffer".toCharArray();
        String nsURI = "http://example.com";
        String localName = "element";
        int offset = 0;
        int len = buffer.length;

        try {
            prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, buffer, offset, len, true);
            verify(xmlStreamWriter).writeStartElement(nsURI, localName);
            verify(xmlStreamWriter).writeCData(buffer, offset, len);
            verify(xmlStreamWriter).writeEndElement();
        } catch (XMLStreamException e) {
            e.printStackTrace();
            Assert.fail("XMLStreamException was thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testWriteLeafElementWithCharacters() {
        char[] buffer = "test buffer".toCharArray();
        String nsURI = "http://example.com";
        String localName = "element";
        int offset = 0;
        int len = buffer.length;

        try {
            prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, buffer, offset, len, false);
            verify(xmlStreamWriter).writeStartElement(nsURI, localName);
            verify(xmlStreamWriter).writeCharacters(buffer, offset, len);
            verify(xmlStreamWriter).writeEndElement();
        } catch (XMLStreamException e) {
            e.printStackTrace();
            Assert.fail("XMLStreamException was thrown: " + e.getMessage());
        }
    }


}
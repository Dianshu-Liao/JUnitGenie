package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import org.mockito.Mockito;
import javax.xml.stream.XMLStreamException;

public class util_DefaultXmlPrettyPrinter_writeLeafElement_XMLStreamWriter2_String_String_char_____int_int_boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWriteLeafElementWithCData() {
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        XMLStreamWriter2 mockWriter = Mockito.mock(XMLStreamWriter2.class);
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        char[] buffer = "exampleCData".toCharArray();
        int offset = 0;
        int len = buffer.length;
        boolean isCData = true;

        try {
            printer.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
            Mockito.verify(mockWriter).writeStartElement(nsURI, localName);
            Mockito.verify(mockWriter).writeCData(buffer, offset, len);
            Mockito.verify(mockWriter).writeEndElement();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteLeafElementWithoutCData() {
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        XMLStreamWriter2 mockWriter = Mockito.mock(XMLStreamWriter2.class);
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        char[] buffer = "exampleText".toCharArray();
        int offset = 0;
        int len = buffer.length;
        boolean isCData = false;

        try {
            printer.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
            Mockito.verify(mockWriter).writeStartElement(nsURI, localName);
            Mockito.verify(mockWriter).writeCharacters(buffer, offset, len);
            Mockito.verify(mockWriter).writeEndElement();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

}
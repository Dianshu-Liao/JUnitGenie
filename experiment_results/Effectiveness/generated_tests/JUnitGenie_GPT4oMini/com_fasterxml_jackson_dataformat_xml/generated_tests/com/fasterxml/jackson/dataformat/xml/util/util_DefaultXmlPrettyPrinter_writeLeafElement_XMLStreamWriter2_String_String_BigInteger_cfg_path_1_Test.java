package com.fasterxml.jackson.dataformat.xml.util;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import javax.xml.stream.XMLStreamException;
import java.math.BigInteger;

public class util_DefaultXmlPrettyPrinter_writeLeafElement_XMLStreamWriter2_String_String_BigInteger_cfg_path_1_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;
    private XMLStreamWriter2 mockWriter;

    @Before
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        mockWriter = mock(XMLStreamWriter2.class);
    }

    @Test(timeout = 4000)
    public void testWriteLeafElement() {
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        BigInteger value = BigInteger.valueOf(42);

        try {
            prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, value);
        } catch (XMLStreamException e) {
            // Handle exception if it occurs
            e.printStackTrace();
        }

        try {
            verify(mockWriter).writeStartElement(nsURI, localName);
            verify(mockWriter).writeInteger(value);
            verify(mockWriter).writeEndElement();
        } catch (XMLStreamException e) {
            // Handle exception if it occurs during verifications
            e.printStackTrace();
        }
    }

}
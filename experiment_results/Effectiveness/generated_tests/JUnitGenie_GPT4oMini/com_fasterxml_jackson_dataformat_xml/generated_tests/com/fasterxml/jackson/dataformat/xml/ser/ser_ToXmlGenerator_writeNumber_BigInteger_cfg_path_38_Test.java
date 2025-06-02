package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.math.BigInteger;
import java.io.IOException;
import javax.xml.namespace.QName;
import com.fasterxml.jackson.core.ObjectCodec;

public class ser_ToXmlGenerator_writeNumber_BigInteger_cfg_path_38_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter2 xmlWriter;
    private XmlNameProcessor xmlNameProcessor;


    @Test(timeout = 4000)
    public void testWriteNumber_ValidValue() {
        BigInteger value = BigInteger.valueOf(123);
        toXmlGenerator._nextName = new QName("namespaceURI", "localPart");
        toXmlGenerator._nextIsAttribute = false;
        toXmlGenerator._xmlPrettyPrinter = null;

        try {
            toXmlGenerator.writeNumber(value);
            // Verify that the writeInteger method was called with the correct value
            verify(xmlWriter).writeStartElement("namespaceURI", "localPart");
            verify(xmlWriter).writeInteger(value);
            verify(xmlWriter).writeEndElement();
        } catch (IOException | XMLStreamException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber_NullValue() {
        try {
            toXmlGenerator.writeNumber((BigInteger) null); // Specify the type explicitly
            // Verify that writeNull was called
            verify(toXmlGenerator).writeNull();
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber_ThrowsXMLStreamException() {
        BigInteger value = BigInteger.valueOf(123);
        toXmlGenerator._nextName = new QName("namespaceURI", "localPart");
        toXmlGenerator._nextIsAttribute = false;
        toXmlGenerator._xmlPrettyPrinter = null;

        try {
            doThrow(new XMLStreamException("Test Exception")).when(xmlWriter).writeStartElement(anyString(), anyString());
            toXmlGenerator.writeNumber(value);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        } catch (XMLStreamException e) {
            // Handle the XMLStreamException
            e.printStackTrace();
        }
    }


}

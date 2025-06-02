package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.IOException;
import java.math.BigInteger;
import static org.mockito.Mockito.*;

public class ser_ToXmlGenerator_writeNumber_BigInteger_cfg_path_9_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter xmlWriter;


    @Test(timeout = 4000)
    public void testWriteNumber() {
        BigInteger value = BigInteger.valueOf(123);

        try {
            toXmlGenerator.writeNumber(value);
            // Verify that the writeStartElement method was called on the xmlWriter
            verify(xmlWriter).writeStartElement("namespaceURI", "localPart");
            // Corrected method call to writeCharacters since XMLStreamWriter does not have writeInteger
            verify(xmlWriter).writeCharacters(value.toString());
            verify(xmlWriter).writeEndElement();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }


}

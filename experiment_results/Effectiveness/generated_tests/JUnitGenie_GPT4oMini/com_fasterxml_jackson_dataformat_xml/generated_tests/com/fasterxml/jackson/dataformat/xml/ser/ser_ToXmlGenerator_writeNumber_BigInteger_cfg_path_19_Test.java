package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.namespace.QName;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.math.BigInteger;
import java.io.IOException;

public class ser_ToXmlGenerator_writeNumber_BigInteger_cfg_path_19_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter xmlWriter;
    private XmlPrettyPrinter xmlPrettyPrinter;
    private QName nextName;

    @Before
    public void setUp() throws Exception {
        xmlWriter = mock(XMLStreamWriter.class);
        xmlPrettyPrinter = mock(XmlPrettyPrinter.class);
        nextName = new QName("namespaceURI", "localPart");
        toXmlGenerator = new ToXmlGenerator(mock(com.fasterxml.jackson.core.io.IOContext.class), 0, 0, null, xmlWriter, null);
        // Set protected fields using reflection
        setField(toXmlGenerator, "_nextName", nextName);
        setField(toXmlGenerator, "_nextIsAttribute", false);
        setField(toXmlGenerator, "_xmlPrettyPrinter", xmlPrettyPrinter);
    }

    private void setField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    @Test(timeout = 4000)
    public void testWriteNumber() {
        BigInteger value = BigInteger.valueOf(123);

        try {
            toXmlGenerator.writeNumber(value);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Verify that the correct methods were called on the xmlWriter
        try {
            verify(xmlWriter).writeStartElement(nextName.getNamespaceURI(), nextName.getLocalPart());
            // Corrected method call to writeCharacters instead of writeInteger
            verify(xmlWriter).writeCharacters(value.toString());
            verify(xmlWriter).writeEndElement();
        } catch (XMLStreamException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}
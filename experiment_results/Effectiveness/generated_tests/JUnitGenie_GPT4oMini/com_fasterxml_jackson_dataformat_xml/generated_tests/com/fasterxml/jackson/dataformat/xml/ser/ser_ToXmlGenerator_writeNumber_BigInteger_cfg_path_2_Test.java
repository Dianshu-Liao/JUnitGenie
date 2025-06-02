package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.junit.Before;
import org.junit.Test;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.namespace.QName;
import java.math.BigInteger;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class ser_ToXmlGenerator_writeNumber_BigInteger_cfg_path_2_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter xmlWriter;
    private QName qName;

    @Before
    public void setUp() throws Exception {
        xmlWriter = mock(XMLStreamWriter.class);
        qName = new QName("namespaceURI", "localPart");
        // Create a mock for the required context and other parameters
        // Replace Object with the actual IOContext type
        com.fasterxml.jackson.core.io.IOContext context = mock(com.fasterxml.jackson.core.io.IOContext.class);
        toXmlGenerator = new ToXmlGenerator(context, 0, 0, null, xmlWriter, null);
        // Set the protected fields using reflection
        setField(toXmlGenerator, "_nextName", qName);
        setField(toXmlGenerator, "_nextIsAttribute", false);
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
            verify(xmlWriter).writeStartElement(qName.getNamespaceURI(), qName.getLocalPart());
            // Corrected method call to writeCharacters instead of writeInteger
            verify(xmlWriter).writeCharacters(value.toString());
            verify(xmlWriter).writeEndElement();
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        } catch (XMLStreamException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }


}
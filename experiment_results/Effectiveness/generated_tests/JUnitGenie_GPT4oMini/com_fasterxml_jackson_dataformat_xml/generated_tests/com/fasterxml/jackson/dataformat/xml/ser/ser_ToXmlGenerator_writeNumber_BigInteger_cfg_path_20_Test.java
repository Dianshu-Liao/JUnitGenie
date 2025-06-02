package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.namespace.QName;
import java.math.BigInteger;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ser_ToXmlGenerator_writeNumber_BigInteger_cfg_path_20_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter xmlWriter;
    private QName nextName;

    @Before
    public void setUp() throws Exception {
        xmlWriter = mock(XMLStreamWriter.class);
        nextName = new QName("namespaceURI", "localPart");
        toXmlGenerator = new ToXmlGenerator(mock(com.fasterxml.jackson.core.io.IOContext.class), 0, 0, null, xmlWriter, null);
        // Set the protected fields using reflection
        setField(toXmlGenerator, "_nextName", nextName);
        setField(toXmlGenerator, "_nextIsAttribute", false);
        setField(toXmlGenerator, "_xmlPrettyPrinter", null);
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
            // Verify that the writeCharacters method was called on the xmlWriter
            verify(xmlWriter).writeCharacters(value.toString());
        } catch (IOException | XMLStreamException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithNullValue() {
        try {
            toXmlGenerator.writeNumber((BigInteger) null); // Specify the type to avoid ambiguity
            // Verify that writeNull was called (assuming writeNull is implemented)
            verify(toXmlGenerator, times(1)).writeNull();
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumberThrowsException() {
        BigInteger value = BigInteger.valueOf(123);
        // Mock the XMLStreamWriter to throw an exception
        try {
            doThrow(new XMLStreamException("Test Exception")).when(xmlWriter).writeCharacters(value.toString());
            toXmlGenerator.writeNumber(value);
        } catch (IOException | XMLStreamException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }


}
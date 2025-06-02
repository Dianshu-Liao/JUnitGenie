package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.junit.Before;
import org.junit.Test;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.namespace.QName;
import java.math.BigInteger;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class ser_ToXmlGenerator_writeNumber_BigInteger_cfg_path_75_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter xmlWriter;

    @Before
    public void setUp() throws Exception {
        xmlWriter = mock(XMLStreamWriter.class);
        toXmlGenerator = new ToXmlGenerator(mock(com.fasterxml.jackson.core.io.IOContext.class), 0, 0, null, xmlWriter, null);
        // Set the protected fields for testing
        setField(toXmlGenerator, "_nextName", new QName("number")); // Set a default QName
        setField(toXmlGenerator, "_nextIsAttribute", false);
        setField(toXmlGenerator, "_xmlPrettyPrinter", null);
    }

    private void setField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithValidValue() {
        BigInteger value = BigInteger.valueOf(123);
        try {
            toXmlGenerator.writeNumber(value);
            // Verify that the writeNumber method was called on the xmlWriter
            verify(xmlWriter).writeCharacters(value.toString());
        } catch (IOException | XMLStreamException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithNullValue() {
        try {
            toXmlGenerator.writeNumber((BigInteger) null); // Specify type to resolve ambiguity
            // Verify that writeNull was called
            verify(toXmlGenerator).writeNull();
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}
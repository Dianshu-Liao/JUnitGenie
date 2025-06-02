package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import java.math.BigInteger;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ser_ToXmlGenerator_writeNumber_BigInteger_cfg_path_71_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter2 xmlWriter;
    private QName nextName;

    @Before
    public void setUp() {
        xmlWriter = mock(XMLStreamWriter2.class);
        nextName = new QName("namespaceURI", "localPart");
        // Initialize ToXmlGenerator with a valid context and parameters
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, xmlWriter, null);
        // Set the protected fields using reflection
        setProtectedField(toXmlGenerator, "_nextName", nextName);
        setProtectedField(toXmlGenerator, "_nextIsAttribute", false);
    }

    private void setProtectedField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber() {
        BigInteger value = BigInteger.valueOf(123);

        try {
            toXmlGenerator.writeNumber(value);
            verify(xmlWriter).writeStartElement("namespaceURI", "localPart");
            verify(xmlWriter).writeInteger(value);
            verify(xmlWriter).writeEndElement();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            // Handle or log the exception if necessary
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithNullValue() {
        try {
            // Explicitly call the writeNumber method for BigInteger with null
            toXmlGenerator.writeNumber((BigInteger) null);
            verify(xmlWriter, never()).writeStartElement(anyString(), anyString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            // Handle or log the exception if necessary
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumberHandlesXMLStreamException() {
        BigInteger value = BigInteger.valueOf(123);
        try {
            doThrow(new XMLStreamException("Test Exception")).when(xmlWriter).writeInteger(value);
            toXmlGenerator.writeNumber(value);
        } catch (IOException e) {
            // Expected exception
        } catch (XMLStreamException e) {
            // Handle or log the exception if necessary
            e.printStackTrace();
        }
    }

}
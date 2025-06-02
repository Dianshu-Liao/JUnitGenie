package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;
import javax.xml.namespace.QName;

public class ser_ToXmlGenerator_writeBoolean_boolean_cfg_path_71_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter2 xmlWriter;

    @Before
    public void setUp() throws Exception {
        xmlWriter = mock(XMLStreamWriter2.class);
        toXmlGenerator = new ToXmlGenerator(mock(com.fasterxml.jackson.core.io.IOContext.class), 0, 0, null, xmlWriter, null);
        // Set the necessary fields to meet the constraints
        toXmlGenerator._nextName = new QName("testElement"); // Set a valid QName element name
        toXmlGenerator._nextIsAttribute = false; // This will ensure checkNextIsUnwrapped() returns false
        toXmlGenerator._xmlPrettyPrinter = null; // This will ensure we go through the else branch
    }

    @Test(timeout = 4000)
    public void testWriteBoolean() {
        boolean value = true; // Test with a boolean value

        try {
            toXmlGenerator.writeBoolean(value);
        } catch (IOException e) {
            // Handle the IOException
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteBooleanWithXMLStreamException() {
        boolean value = true; // Test with a boolean value

        // Mock the behavior to throw XMLStreamException
        try {
            doThrow(new XMLStreamException("Test Exception")).when(xmlWriter).writeStartElement(anyString(), anyString());
        } catch (XMLStreamException e) {
            // Handle the XMLStreamException
            e.printStackTrace();
        }

        try {
            toXmlGenerator.writeBoolean(value);
        } catch (IOException e) {
            // Handle the IOException
            e.printStackTrace();
        }
    }

}
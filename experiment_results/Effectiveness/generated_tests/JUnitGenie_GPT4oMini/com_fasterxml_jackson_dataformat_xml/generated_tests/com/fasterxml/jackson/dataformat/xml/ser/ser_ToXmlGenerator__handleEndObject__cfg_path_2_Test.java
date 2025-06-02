package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.JsonGenerationException;
import java.io.IOException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.namespace.QName;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ser_ToXmlGenerator__handleEndObject__cfg_path_2_Test {

    private ToXmlGenerator generator;
    private XMLStreamWriter xmlWriter;

    @Before
    public void setUp() {
        xmlWriter = mock(XMLStreamWriter.class);
        generator = new ToXmlGenerator(mock(com.fasterxml.jackson.core.io.IOContext.class), 0, 0, null, xmlWriter, null);
        // Initialize the _elementNameStack with a QName to avoid the JsonGenerationException
        generator._elementNameStack = new LinkedList<>(); // Ensure the stack is initialized
        generator._elementNameStack.add(new QName("testElement"));
    }

    @Test(timeout = 4000)
    public void testHandleEndObject() {
        try {
            generator._handleEndObject();
        } catch (IOException e) {
            // Handle the IOException if it occurs
            e.printStackTrace();
        }
    }

    @Test(expected = JsonGenerationException.class)
    public void testHandleEndObjectThrowsException() throws IOException {
        // Clear the _elementNameStack to trigger the exception
        generator._elementNameStack.clear();
        generator._handleEndObject();
    }

    @Test(timeout = 4000)
    public void testHandleEndObjectWithXMLStreamException() {
        try {
            // Mock the behavior of xmlWriter to throw XMLStreamException
            doThrow(new XMLStreamException("XML error")).when(xmlWriter).writeEndElement();
            generator._handleEndObject();
        } catch (IOException e) {
            // Handle the IOException if it occurs
            e.printStackTrace();
        } catch (XMLStreamException e) {
            // Handle the XMLStreamException if it occurs
            e.printStackTrace();
        }
    }


}
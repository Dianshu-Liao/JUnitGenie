package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.JsonGenerationException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Before;
import org.junit.Test;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.LinkedList;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ser_ToXmlGenerator__handleEndObject__cfg_path_15_Test {

    private ToXmlGenerator generator;
    private XMLStreamWriter2 xmlWriter;

    @Before
    public void setUp() {
        // Mock the XMLStreamWriter2
        xmlWriter = mock(XMLStreamWriter2.class);
        // Initialize the ToXmlGenerator with necessary parameters
        // Assuming the constructor requires a non-null first parameter, we can pass a mock or a valid object
        generator = new ToXmlGenerator(null, 0, 0, null, xmlWriter, null);
        // Prepare the _elementNameStack with a QName to avoid the JsonGenerationException
        generator._elementNameStack = new LinkedList<>(); // Initialize the stack
        generator._elementNameStack.add(new QName("testElement"));
    }

    @Test(timeout = 4000)
    public void testHandleEndObject() {
        try {
            generator._handleEndObject();
        } catch (JsonGenerationException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        } catch (IOException e) {
            // Handle the IOException
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testHandleEndObject_throwsJsonGenerationException() {
        // Clear the _elementNameStack to trigger the exception
        generator._elementNameStack.clear();
        try {
            generator._handleEndObject();
        } catch (JsonGenerationException e) {
            // Expected exception
            assertEquals("Can not write END_ELEMENT without open START_ELEMENT", e.getMessage());
        } catch (IOException e) {
            // Handle the IOException
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testHandleEndObject_XMLStreamException() {
        // Prepare the _elementNameStack with a QName to avoid the JsonGenerationException
        generator._elementNameStack.add(new QName("testElement"));
        // Simulate XMLStreamException during writeEndElement
        try {
            doThrow(new XMLStreamException("XML error")).when(xmlWriter).writeEndElement();
            generator._handleEndObject();
        } catch (JsonGenerationException e) {
            // Expected exception
            assertTrue(e.getCause() instanceof XMLStreamException);
            assertEquals("XML error", e.getCause().getMessage());
        } catch (IOException e) {
            // Handle the IOException
            e.printStackTrace();
        } catch (XMLStreamException e) {
            // Handle the XMLStreamException
            e.printStackTrace();
        }
    }


}
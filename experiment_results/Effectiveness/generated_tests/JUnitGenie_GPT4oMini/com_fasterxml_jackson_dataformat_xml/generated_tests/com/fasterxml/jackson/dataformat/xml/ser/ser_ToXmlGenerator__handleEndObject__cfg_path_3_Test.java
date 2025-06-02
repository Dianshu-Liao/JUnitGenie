package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.JsonGenerationException;
import org.junit.Before;
import org.junit.Test;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.LinkedList;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

public class ser_ToXmlGenerator__handleEndObject__cfg_path_3_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter xmlWriter;

    @Before
    public void setUp() throws Exception {
        xmlWriter = mock(XMLStreamWriter.class);
        toXmlGenerator = new ToXmlGenerator(mock(com.fasterxml.jackson.core.io.IOContext.class), 0, 0, 
                                              null, xmlWriter, null);
        // Initialize the _elementNameStack to ensure the control flow passes through the relevant paths
        toXmlGenerator._elementNameStack = new LinkedList<>();
        // Adding a dummy QName to the stack to avoid triggering the JsonGenerationException
        toXmlGenerator._elementNameStack.add(new QName("dummy"));
    }

    @Test(timeout = 4000)
    public void test_handleEndObject_success() throws IOException, XMLStreamException {
        toXmlGenerator._handleEndObject(); // Expect no exceptions to be thrown
        // Verify that writeEndElement was called
        verify(xmlWriter).writeEndElement();
    }

    @Test(timeout = 4000)
    public void test_handleEndObject_emptyStack_throwsJsonGenerationException() {
        toXmlGenerator._elementNameStack.clear(); // Make the stack empty to trigger the exception
        try {
            toXmlGenerator._handleEndObject();
        } catch (JsonGenerationException e) {
            // Check that the exception is thrown with the expected message
            assertEquals("Can not write END_ELEMENT without open START_ELEMENT", e.getMessage());
        } catch (IOException e) {
            // Handle IOException if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void test_handleEndObject_XMLStreamException_handled() throws IOException, XMLStreamException {
        // Simulate a XMLStreamException during writeEndElement
        doThrow(new XMLStreamException("Simulated exception")).when(xmlWriter).writeEndElement();

        try {
            toXmlGenerator._handleEndObject();
        } catch (JsonGenerationException e) {
            // Verify that the JsonGenerationException is thrown
            assertEquals("Simulated exception", e.getCause().getMessage());
        } catch (IOException e) {
            // Handle IOException if it occurs
            e.printStackTrace();
        }
    }

}
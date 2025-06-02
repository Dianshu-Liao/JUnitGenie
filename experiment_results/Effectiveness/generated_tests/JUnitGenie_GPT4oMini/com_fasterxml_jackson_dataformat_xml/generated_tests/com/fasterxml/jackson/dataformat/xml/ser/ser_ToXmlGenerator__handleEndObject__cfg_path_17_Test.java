package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.core.JsonGenerationException;
import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.LinkedList;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ser_ToXmlGenerator__handleEndObject__cfg_path_17_Test {
    
    private ToXmlGenerator toXmlGenerator;
    private LinkedList<QName> elementNameStack;
    private XMLStreamWriter2 xmlWriter;

    @Before
    public void setUp() throws Exception {
        xmlWriter = mock(XMLStreamWriter2.class);
        elementNameStack = new LinkedList<>();
        toXmlGenerator = new ToXmlGenerator(mock(com.fasterxml.jackson.core.io.IOContext.class), 0, 0, null, xmlWriter, null);
        // Initialize the internal state with a non-empty stack
        QName qName = new QName("element");
        elementNameStack.add(qName);
        // Accessing protected fields using reflection
        java.lang.reflect.Field field = ToXmlGenerator.class.getDeclaredField("_elementNameStack");
        field.setAccessible(true);
        field.set(toXmlGenerator, elementNameStack);
    }

    @Test(timeout = 4000)
    public void test_handleEndObject() {
        try {
            toXmlGenerator._handleEndObject();
            // Verify that the writeEndElement method is called
            verify(xmlWriter).writeEndElement();
        } catch (JsonGenerationException e) {
            fail("Expected no exceptions, but got: " + e.getMessage());
        } catch (IOException e) {
            fail("Expected no exceptions, but got: " + e.getMessage());
        } catch (XMLStreamException e) {
            fail("Expected no exceptions, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void test_handleEndObject_throwsJsonGenerationException() {
        // Ensure the stack is empty to trigger the exception
        elementNameStack.clear();

        try {
            toXmlGenerator._handleEndObject();
            fail("Expected JsonGenerationException was not thrown.");
        } catch (JsonGenerationException e) {
            assertEquals("Can not write END_ELEMENT without open START_ELEMENT", e.getMessage());
        } catch (Exception e) {
            fail("Expected JsonGenerationException, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void test_handleEndObject_catchesXMLStreamException() {
        // Prepare the stack with elements
        QName qName = new QName("element");
        elementNameStack.add(qName);
        
        // Mock the XMLStreamWriter2 to throw XMLStreamException
        try {
            doThrow(new XMLStreamException("Stream error")).when(xmlWriter).writeEndElement();

            toXmlGenerator._handleEndObject();
            fail("Expected JsonGenerationException was not thrown.");
        } catch (JsonGenerationException e) {
            assertTrue(e.getCause() instanceof XMLStreamException);
            assertEquals("Stream error", e.getCause().getMessage());
        } catch (Exception e) {
            fail("Expected JsonGenerationException, but got: " + e.getMessage());
        }
    }


}
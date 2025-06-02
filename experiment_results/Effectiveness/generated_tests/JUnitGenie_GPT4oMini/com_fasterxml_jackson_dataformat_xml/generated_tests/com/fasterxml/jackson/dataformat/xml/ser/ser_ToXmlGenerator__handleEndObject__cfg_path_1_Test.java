package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.junit.Test;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.LinkedList;
import static org.mockito.Mockito.mock;

public class ser_ToXmlGenerator__handleEndObject__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHandleEndObject_ThrowsJsonGenerationException_WhenElementNameStackIsEmpty() {
        // Arrange
        XMLStreamWriter xmlWriter = mock(XMLStreamWriter.class);
        ToXmlGenerator generator = new ToXmlGenerator(null, 0, 0, null, xmlWriter, null);
        
        // Set up the _elementNameStack to be empty
        LinkedList<QName> elementNameStack = new LinkedList<>();
        // Accessing the protected field using reflection
        try {
            java.lang.reflect.Field field = ToXmlGenerator.class.getDeclaredField("_elementNameStack");
            field.setAccessible(true);
            field.set(generator, elementNameStack);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Act
        try {
            generator._handleEndObject();
        } catch (JsonGenerationException e) {
            // Assert
            assert e.getMessage().equals("Can not write END_ELEMENT without open START_ELEMENT");
            return; // Test passes if exception is thrown
        } catch (IOException e) {
            // This should not happen in this case
            e.printStackTrace();
        }

        // If no exception was thrown, fail the test
        assert false : "Expected JsonGenerationException was not thrown.";
    }

}
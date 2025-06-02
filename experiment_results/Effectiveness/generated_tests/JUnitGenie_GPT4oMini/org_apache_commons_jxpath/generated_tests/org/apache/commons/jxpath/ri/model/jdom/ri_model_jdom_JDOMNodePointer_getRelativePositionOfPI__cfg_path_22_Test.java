package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.jdom.ProcessingInstruction;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_jdom_JDOMNodePointer_getRelativePositionOfPI__cfg_path_22_Test {

    @Test(timeout = 4000)
    public void testGetRelativePositionOfPI() {
        try {
            // Create a ProcessingInstruction and an Element to use as the node and parent
            ProcessingInstruction processingInstruction1 = new ProcessingInstruction("target", "data");
            ProcessingInstruction processingInstruction2 = new ProcessingInstruction("target", "data"); // Create a second instance
            Element parentElement = new Element("parent");
            parentElement.addContent(processingInstruction1);
            parentElement.addContent(processingInstruction2); // Add the second ProcessingInstruction

            // Create an instance of JDOMNodePointer with the node set to the first ProcessingInstruction
            JDOMNodePointer jdomNodePointer = new JDOMNodePointer(processingInstruction1, Locale.getDefault());
            // Use reflection to set the private final field 'node'
            java.lang.reflect.Field nodeField = JDOMNodePointer.class.getDeclaredField("node");
            nodeField.setAccessible(true);
            nodeField.set(jdomNodePointer, processingInstruction1);

            // Invoke the private method getRelativePositionOfPI using reflection
            Method method = JDOMNodePointer.class.getDeclaredMethod("getRelativePositionOfPI");
            method.setAccessible(true);
            int position = (int) method.invoke(jdomNodePointer);

            // Assert the expected position
            assertEquals(2, position); // Expecting 2 because there are two ProcessingInstructions

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.jdom.ProcessingInstruction;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_jdom_JDOMNodePointer_getRelativePositionOfPI__cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testGetRelativePositionOfPI() {
        // Setup
        HashMap<String, String> data = new HashMap<>(); // Create a map for the ProcessingInstruction constructor
        ProcessingInstruction processingInstruction = new ProcessingInstruction("target", data);
        Element parentElement = new Element("parent");
        parentElement.addContent(processingInstruction);
        parentElement.addContent(new ProcessingInstruction("target", data)); // Add another ProcessingInstruction for testing

        JDOMNodePointer nodePointer = new JDOMNodePointer(processingInstruction, Locale.getDefault());
        // Access the private field 'node' using reflection
        try {
            java.lang.reflect.Field field = JDOMNodePointer.class.getDeclaredField("node");
            field.setAccessible(true);
            field.set(nodePointer, processingInstruction); // Set the node to the ProcessingInstruction

            // Invoke the private method 'getRelativePositionOfPI' using reflection
            Method method = JDOMNodePointer.class.getDeclaredMethod("getRelativePositionOfPI");
            method.setAccessible(true);
            int result = (int) method.invoke(nodePointer);

            // Verify the result
            assertEquals(0, result); // Expecting 0 since the node is the first ProcessingInstruction

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
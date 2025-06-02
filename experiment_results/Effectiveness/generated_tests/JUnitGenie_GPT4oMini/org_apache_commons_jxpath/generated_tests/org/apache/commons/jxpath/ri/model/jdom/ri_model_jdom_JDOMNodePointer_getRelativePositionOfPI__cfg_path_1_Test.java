package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.jdom.ProcessingInstruction;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_jdom_JDOMNodePointer_getRelativePositionOfPI__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetRelativePositionOfPI() {
        // Setup
        HashMap<String, String> attributes = new HashMap<>(); // Create an empty map for attributes
        ProcessingInstruction processingInstruction = new ProcessingInstruction("target", attributes);
        Element parentElement = new Element("parent");
        parentElement.addContent(processingInstruction);
        parentElement.addContent(new ProcessingInstruction("target", attributes)); // Add another ProcessingInstruction for testing

        JDOMNodePointer nodePointer = new JDOMNodePointer(processingInstruction, Locale.getDefault());
        // Set the private final field 'node' using reflection
        try {
            java.lang.reflect.Field field = JDOMNodePointer.class.getDeclaredField("node");
            field.setAccessible(true);
            field.set(nodePointer, processingInstruction);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Invoke the private method using reflection
        try {
            Method method = JDOMNodePointer.class.getDeclaredMethod("getRelativePositionOfPI");
            method.setAccessible(true);
            int result = (int) method.invoke(nodePointer);

            // Verify the result
            assertEquals(1, result); // Expecting 1 since the processingInstruction is the first child
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
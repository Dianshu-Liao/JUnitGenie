package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.jdom.ProcessingInstruction;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_jdom_JDOMNodePointer_getRelativePositionOfPI__cfg_path_20_Test {

    @Test(timeout = 4000)
    public void testGetRelativePositionOfPI() {
        try {
            // Create a ProcessingInstruction and an Element to use as the node and parent
            HashMap<String, String> data = new HashMap<>(); // Create a map for the ProcessingInstruction
            ProcessingInstruction processingInstruction = new ProcessingInstruction("target", data);
            Element parentElement = new Element("parent");
            parentElement.addContent(processingInstruction);
            parentElement.addContent(new ProcessingInstruction("target", data)); // Add another ProcessingInstruction

            // Create an instance of JDOMNodePointer with the node
            JDOMNodePointer jdomNodePointer = new JDOMNodePointer(processingInstruction, Locale.getDefault());
            // Use reflection to access the private method
            Method method = JDOMNodePointer.class.getDeclaredMethod("getRelativePositionOfPI");
            method.setAccessible(true);

            // Set the private final field 'node' using reflection
            java.lang.reflect.Field field = JDOMNodePointer.class.getDeclaredField("node");
            field.setAccessible(true);
            field.set(jdomNodePointer, processingInstruction);

            // Call the method and assert the expected value
            int result = (int) method.invoke(jdomNodePointer);
            assertEquals(1, result); // Expecting 1 since there is one ProcessingInstruction before the current one

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
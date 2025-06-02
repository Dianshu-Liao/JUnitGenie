package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.jdom.ProcessingInstruction;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_jdom_JDOMNodePointer_getRelativePositionOfPI__cfg_path_21_Test {

    @Test(timeout = 4000)
    public void testGetRelativePositionOfPI() {
        try {
            // Create a ProcessingInstruction and an Element to use as the node and parent
            HashMap<String, String> attributes = new HashMap<>(); // Create an empty map for attributes
            ProcessingInstruction processingInstruction = new ProcessingInstruction("target", attributes);
            Element parentElement = new Element("parent");
            parentElement.addContent(processingInstruction);
            parentElement.addContent(new ProcessingInstruction("target", attributes)); // Add another ProcessingInstruction

            // Create an instance of JDOMNodePointer with the node set to the ProcessingInstruction
            JDOMNodePointer jdomNodePointer = new JDOMNodePointer(processingInstruction, Locale.getDefault());

            // Use reflection to access the private method
            Method method = JDOMNodePointer.class.getDeclaredMethod("getRelativePositionOfPI");
            method.setAccessible(true);

            // Invoke the method and get the result
            int result = (int) method.invoke(jdomNodePointer);

            // Assert the expected result
            assertEquals(1, result); // Expecting 1 since there is one ProcessingInstruction before the current one

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.jdom.ProcessingInstruction;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_jdom_JDOMNodePointer_getRelativePositionOfPI__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetRelativePositionOfPI() {
        try {
            // Create a ProcessingInstruction and its parent Element
            HashMap<String, String> data = new HashMap<>(); // Create a map for the ProcessingInstruction
            ProcessingInstruction processingInstruction = new ProcessingInstruction("target", data);
            Element parentElement = new Element("parent");
            parentElement.addContent(processingInstruction);
            parentElement.addContent(new ProcessingInstruction("target", data)); // Another ProcessingInstruction

            // Create an instance of JDOMNodePointer with the node set to the processingInstruction
            JDOMNodePointer jdomNodePointer = new JDOMNodePointer(processingInstruction, Locale.getDefault());

            // Access the private method using reflection
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
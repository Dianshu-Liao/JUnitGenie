package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.jdom.ProcessingInstruction;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_jdom_JDOMNodePointer_getRelativePositionOfPI__cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testGetRelativePositionOfPI() {
        try {
            // Create a mock ProcessingInstruction and its parent Element
            HashMap<String, String> attributes = new HashMap<>(); // Create an empty map for attributes
            ProcessingInstruction mockPI = new ProcessingInstruction("targetPI", attributes);
            Element mockParent = new Element("parent");
            mockParent.addContent(mockPI); // Add the mock ProcessingInstruction to the parent

            // Create an instance of JDOMNodePointer with the mock node
            JDOMNodePointer pointer = new JDOMNodePointer(mockPI, Locale.getDefault());

            // Use reflection to access the private method
            Method method = JDOMNodePointer.class.getDeclaredMethod("getRelativePositionOfPI");
            method.setAccessible(true);

            // Invoke the method and get the result
            int result = (int) method.invoke(pointer);

            // Assert the expected result
            assertEquals(0, result); // Since the mockPI is the first child, the position should be 0

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
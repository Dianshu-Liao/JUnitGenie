package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.jdom.ProcessingInstruction;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_jdom_JDOMNodePointer_getRelativePositionOfPI__cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testGetRelativePositionOfPI() {
        try {
            // Create a mock ProcessingInstruction and its parent Element
            ProcessingInstruction processingInstruction = new ProcessingInstruction("target", new HashMap<>());
            Element parentElement = new Element("parent");
            parentElement.addContent(new ProcessingInstruction("target", new HashMap<>()));
            parentElement.addContent(new ProcessingInstruction("other", new HashMap<>()));

            // Create an instance of JDOMNodePointer with the mock node
            JDOMNodePointer pointer = new JDOMNodePointer(processingInstruction, Locale.getDefault());

            // Use reflection to access the private method
            Method method = JDOMNodePointer.class.getDeclaredMethod("getRelativePositionOfPI");
            method.setAccessible(true);

            // Invoke the method and assert the expected result
            int result = (int) method.invoke(pointer);
            assertEquals(1, result); // Expecting 1 because the target matches the first ProcessingInstruction
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.jdom.ProcessingInstruction;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_jdom_JDOMNodePointer_getRelativePositionOfPI__cfg_path_18_Test {

    @Test(timeout = 4000)
    public void testGetRelativePositionOfPI() {
        try {
            // Create a ProcessingInstruction and its parent Element
            ProcessingInstruction processingInstruction = new ProcessingInstruction("target", "data");
            Element parentElement = new Element("parent");
            parentElement.addContent(processingInstruction);
            parentElement.addContent(new ProcessingInstruction("target", "data2"));
            
            // Create an instance of JDOMNodePointer
            JDOMNodePointer nodePointer = new JDOMNodePointer(processingInstruction, Locale.getDefault());

            // Access the private method using reflection
            Method method = JDOMNodePointer.class.getDeclaredMethod("getRelativePositionOfPI");
            method.setAccessible(true);
            
            // Set the private final field 'node' using reflection
            java.lang.reflect.Field field = JDOMNodePointer.class.getDeclaredField("node");
            field.setAccessible(true);
            field.set(nodePointer, processingInstruction);
            
            // Invoke the method and assert the expected result
            int result = (int) method.invoke(nodePointer);
            assertEquals(0, result); // Expecting 0 since it's the first ProcessingInstruction

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
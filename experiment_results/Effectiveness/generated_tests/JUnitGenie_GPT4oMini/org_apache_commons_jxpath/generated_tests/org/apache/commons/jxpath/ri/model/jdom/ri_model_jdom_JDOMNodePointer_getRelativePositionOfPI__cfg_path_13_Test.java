package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.jdom.ProcessingInstruction;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class ri_model_jdom_JDOMNodePointer_getRelativePositionOfPI__cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testGetRelativePositionOfPI() {
        try {
            // Create a ProcessingInstruction and its parent Element
            ProcessingInstruction processingInstruction1 = new ProcessingInstruction("target", "data");
            ProcessingInstruction processingInstruction2 = new ProcessingInstruction("target", "data2");
            Element parentElement = new Element("parent");
            parentElement.addContent(processingInstruction1);
            parentElement.addContent(processingInstruction2); // Adding a different ProcessingInstruction

            // Create an instance of JDOMNodePointer
            JDOMNodePointer nodePointer = new JDOMNodePointer(processingInstruction1, Locale.getDefault());

            // Access the private method using reflection
            Method method = JDOMNodePointer.class.getDeclaredMethod("getRelativePositionOfPI");
            method.setAccessible(true);

            // Invoke the method and get the result
            int result = (int) method.invoke(nodePointer);

            // Assert the expected result
            assertEquals(0, result); // The expected position of the processing instruction

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
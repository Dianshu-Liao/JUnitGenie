package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Locale;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ri_model_jdom_JDOMNodePointer_matchesQName_Element_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMatchesQName_withMatchingNamespace() {
        // Arrange
        Element element = new Element("testElement");
        JDOMNodePointer nodePointer = new JDOMNodePointer(element, Locale.getDefault());
        
        // Use reflection to access the private method
        try {
            Method method = JDOMNodePointer.class.getDeclaredMethod("matchesQName", Element.class);
            method.setAccessible(true);
            
            // Act
            boolean result = (boolean) method.invoke(nodePointer, element);

            // Assert
            assertTrue(result);
        } catch (Exception e) {
            // Handle exception if the method invocation fails
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMatchesQName_withNonMatchingNamespace() {
        // Arrange
        Element element = new Element("testElement");
        // Creating a JDOMNodePointer with a different initialized node to create a mismatch
        JDOMNodePointer nodePointer = new JDOMNodePointer(new Element("differentElement"), Locale.getDefault());

        // Use reflection to access the private method
        try {
            Method method = JDOMNodePointer.class.getDeclaredMethod("matchesQName", Element.class);
            method.setAccessible(true);
            
            // Act
            boolean result = (boolean) method.invoke(nodePointer, element);

            // Assert
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if the method invocation fails
            e.printStackTrace();
        }
    }


}
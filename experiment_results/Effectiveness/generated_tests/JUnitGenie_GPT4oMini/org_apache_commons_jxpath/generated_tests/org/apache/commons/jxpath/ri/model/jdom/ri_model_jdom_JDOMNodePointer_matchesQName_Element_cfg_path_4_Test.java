package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Locale;
import static org.junit.Assert.assertFalse;

public class ri_model_jdom_JDOMNodePointer_matchesQName_Element_cfg_path_4_Test {
    
    @Test(timeout = 4000)
    public void testMatchesQNameReturnsFalseForNullNamespaceURI() {
        try {
            // Create an instance of JDOMNodePointer
            JDOMNodePointer nodePointer = new JDOMNodePointer(new Object(), Locale.getDefault());

            // Prepare an Element which is an instance of org.jdom.Element
            Element element = new Element("testElement"); // Create a valid Element instance

            // Use reflection to access the private method `matchesQName`
            Method method = JDOMNodePointer.class.getDeclaredMethod("matchesQName", Element.class);
            method.setAccessible(true);

            // Invoke the private method and assert the expected result
            boolean result = (Boolean) method.invoke(nodePointer, element);
            assertFalse(result); // Expecting false since namespace URI is null
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
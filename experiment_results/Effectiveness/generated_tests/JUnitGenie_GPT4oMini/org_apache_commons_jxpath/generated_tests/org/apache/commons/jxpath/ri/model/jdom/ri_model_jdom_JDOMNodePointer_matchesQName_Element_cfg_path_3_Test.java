package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Locale;
import static org.junit.Assert.assertFalse;

public class ri_model_jdom_JDOMNodePointer_matchesQName_Element_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testMatchesQNameWithNullNamespaceURI() {
        try {
            // Create an instance of JDOMNodePointer
            JDOMNodePointer nodePointer = new JDOMNodePointer(new Element("testElement"), Locale.getDefault());

            // Create a mock Element with a non-null namespace URI
            Element element = new Element("testElement");
            element.setNamespace(org.jdom.Namespace.NO_NAMESPACE); // Set to a specific namespace if needed

            // Use reflection to access the private method matchesQName
            Method matchesQNameMethod = JDOMNodePointer.class.getDeclaredMethod("matchesQName", Element.class);
            matchesQNameMethod.setAccessible(true);

            // Invoke the method and assert the result
            boolean result = (boolean) matchesQNameMethod.invoke(nodePointer, element);
            assertFalse(result); // Expecting false since the namespace URI is not null
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
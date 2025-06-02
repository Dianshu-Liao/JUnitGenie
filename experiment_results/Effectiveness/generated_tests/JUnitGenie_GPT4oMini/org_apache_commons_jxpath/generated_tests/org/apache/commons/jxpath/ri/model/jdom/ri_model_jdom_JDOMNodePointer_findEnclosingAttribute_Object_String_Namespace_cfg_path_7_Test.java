package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Element;
import org.jdom.Namespace;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import java.lang.reflect.Method;

public class ri_model_jdom_JDOMNodePointer_findEnclosingAttribute_Object_String_Namespace_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testFindEnclosingAttribute_NonElementParent() {
        try {
            // Prepare test inputs
            Object nonElementNode = new Object(); // This should not be an instance of Element
            String attrName = "testAttribute";
            Namespace ns = Namespace.NO_NAMESPACE;

            // Access the protected static method using reflection
            Method method = JDOMNodePointer.class.getDeclaredMethod("findEnclosingAttribute", Object.class, String.class, Namespace.class);
            method.setAccessible(true);

            // Invoke the method
            String result = (String) method.invoke(null, nonElementNode, attrName, ns);

            // Assert that the result is null since the input is not an Element
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
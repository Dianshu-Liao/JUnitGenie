package org.apache.commons.jxpath.ri.model.jdom;
import org.apache.commons.jxpath.ri.model.jdom.JDOMNodePointer;
import org.jdom.Namespace;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNull;

public class ri_model_jdom_JDOMNodePointer_findEnclosingAttribute_Object_String_Namespace_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testFindEnclosingAttribute_NullNode() {
        try {
            // Prepare parameters
            Object n = null; // This will trigger the null check
            String attrName = "someAttribute";
            Namespace ns = Namespace.NO_NAMESPACE; // Using default namespace

            // Access the protected static method using reflection
            Method method = JDOMNodePointer.class.getDeclaredMethod("findEnclosingAttribute", Object.class, String.class, Namespace.class);
            method.setAccessible(true); // Make the method accessible

            // Invoke the method and assert the result
            String result = (String) method.invoke(null, n, attrName, ns);
            assertNull(result); // Expecting null since the node is null
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception
        }
    }

}
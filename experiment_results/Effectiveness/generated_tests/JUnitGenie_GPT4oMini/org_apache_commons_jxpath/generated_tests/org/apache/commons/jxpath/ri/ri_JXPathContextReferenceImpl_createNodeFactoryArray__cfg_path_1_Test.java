package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Vector;
import static org.junit.Assert.assertNotNull;

public class ri_JXPathContextReferenceImpl_createNodeFactoryArray__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCreateNodeFactoryArray() {
        try {
            // Access the private static method using reflection
            Method method = JXPathContextReferenceImpl.class.getDeclaredMethod("createNodeFactoryArray");
            method.setAccessible(true);

            // Create an instance of the class to invoke the static method
            JXPathContextReferenceImpl instance = new JXPathContextReferenceImpl(null, new Object());

            // Invoke the method
            method.invoke(null); // Static method, so pass null

            // Verify that nodeFactoryArray is initialized
            NodePointerFactory[] nodeFactoryArray = (NodePointerFactory[]) JXPathContextReferenceImpl.class.getDeclaredField("nodeFactoryArray").get(null);
            assertNotNull("nodeFactoryArray should not be null after method invocation", nodeFactoryArray);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception as per rule 4
        }
    }

}
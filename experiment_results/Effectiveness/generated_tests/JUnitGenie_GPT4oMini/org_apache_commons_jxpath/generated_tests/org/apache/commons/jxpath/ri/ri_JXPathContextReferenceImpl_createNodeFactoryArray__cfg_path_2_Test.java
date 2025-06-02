package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNull;

public class ri_JXPathContextReferenceImpl_createNodeFactoryArray__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCreateNodeFactoryArray() {
        // Arrange
        JXPathContextReferenceImpl context = new JXPathContextReferenceImpl(null, null);
        
        // Act
        try {
            Method method = JXPathContextReferenceImpl.class.getDeclaredMethod("createNodeFactoryArray");
            method.setAccessible(true);
            method.invoke(null); // invoke the static method

            // Assert
            // Use reflection to access the private nodeFactoryArray field
            Method getNodeFactoryArrayMethod = JXPathContextReferenceImpl.class.getDeclaredMethod("getNodeFactoryArray");
            getNodeFactoryArrayMethod.setAccessible(true);
            Object nodeFactoryArray = getNodeFactoryArrayMethod.invoke(null); // invoke the static method to get the value

            assertNull("nodeFactoryArray should be null", nodeFactoryArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}